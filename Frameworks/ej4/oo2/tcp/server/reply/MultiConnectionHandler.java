package tcp.server.reply;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiConnectionHandler implements IConnectionHandler {
    private IMessageHandler messageHandler;
    //private EndSessionPolicy endSessionPolicy;
    


    public MultiConnectionHandler(IMessageHandler messageHandler/*, EndSessionPolicy endSessionPolicy */) {
        this.messageHandler = messageHandler;
        //this.endSessionPolicy = endSessionPolicy;
    }

    private Socket acceptAndDisplaySocket(ServerSocket serverSocket) throws IOException {
        Socket clientSocket = serverSocket.accept();
        displaySocketData(clientSocket);
        return clientSocket;
    }

    private void displaySocketData(Socket clientSocket) {
        System.out.println("Client connected from: " + clientSocket.getInetAddress().getHostAddress() + ":"
                + clientSocket.getPort());
    }

    public void handleConnection(ServerSocket serverSocket) throws IOException {
        Socket clientSocket = acceptAndDisplaySocket(serverSocket);
        new SocketWorker(clientSocket).start();

    }

    private class SocketWorker extends Thread {
        private Socket clientSocket;

        public SocketWorker(Socket socket) {
            this.clientSocket = socket;
        }

        public void run(String end) {
            try (
                    PrintWriter out = this.newPrintWriter(clientSocket);
                    BufferedReader in = this.newBufferedReader(clientSocket);) {
                String inputLine;
                while (this.continueLoop(inputLine = in.readLine())) {
                    this.beforeCommunication(clientSocket, inputLine);

                    if (this.shouldCloseConnection(inputLine, end)) {
                        break; // Client requested to close the connection
                    }
                    messageHandler.handleMessage(inputLine, out);
                }

                this.closeConnectionMessagge(clientSocket);
            } catch (IOException e) {
                this.communicationProblem(e);
            } 
            this.closeConnection(clientSocket);
        }
        
        protected boolean continueLoop(String inputLine) throws IOException {
        	return inputLine != null;
        }
        
        protected void beforeCommunication(Socket clientSocket, String inputLine) {
        	 System.out.println("Received message: " + inputLine + " from "
                     + clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort());
        }
        
        protected boolean shouldCloseConnection(String inputLine, String end) {
        	return inputLine.equalsIgnoreCase(end);
        }
        
        protected void closeConnectionMessagge(Socket clientSocket) {
        	System.out.println("Connection closed with " + clientSocket.getInetAddress().getHostAddress() + ":"
                    + clientSocket.getPort());
        }
        
        protected PrintWriter newPrintWriter(Socket clientSocket) throws IOException{
        	return new PrintWriter(clientSocket.getOutputStream(), true);
        }
        
        protected BufferedReader newBufferedReader (Socket clientSocket) throws IOException{
        	return new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }
        
        protected void communicationProblem(IOException e){
        	System.err.println("Problem with communication with client: " + e.getMessage());
        }
        
        protected void closeProblem(IOException e){
        	System.err.println("Error closing socket: " + e.getMessage());
        }
        
        protected void closeConnection(Socket clientSocket) {
        	try {
        		clientSocket.close();
        	}
            catch (IOException e) {
            	this.closeConnectionMessagge(clientSocket);
            }
        }

    }

}