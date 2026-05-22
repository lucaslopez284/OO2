package ejercicio01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class SingleThreadTCPServer {

    public abstract void handleMessage(String message, PrintWriter out);

    public final void startLoop(String[] args, String end) {
        checkArguments(args);

        int portNumber = Integer.parseInt(args[0]);

    
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            displaySocketInformation(portNumber);
            while (true) {
                Socket clientSocket = acceptAndDisplaySocket(serverSocket);
                handleClient(clientSocket, end);
            }
        } catch (IOException e) {
            displayAndExit(portNumber);
        }
    }

    protected void displayAndExit(int portNumber) {
        System.err.println("Could not listen on port " + portNumber);
        System.exit(-1);
    }

    protected Socket acceptAndDisplaySocket(ServerSocket serverSocket) throws IOException {
        Socket clientSocket = serverSocket.accept();
        displaySocketData(clientSocket);
        return clientSocket;
    }

    protected void displaySocketData(Socket clientSocket) {
        System.out.println("Client connected from: " + clientSocket.getInetAddress().getHostAddress() + ":"
                + clientSocket.getPort());
    }

    protected void displaySocketInformation(int portNumber) {
        System.out.println(this.getClass().getName() + " server listening on port: " + portNumber);
    }

    protected void checkArguments(String[] args) {
        if (args.length != 1) {
            displayUsage();
            System.exit(1);
        }
    }

    protected void displayUsage() {
        System.err.println("Usage: java"+this.getClass().getName() +"<port number>");
    }

    

    private final void handleClient(Socket clientSocket, String end) {  
        try (
                PrintWriter out = this.newPrintWriter(clientSocket);
                BufferedReader in = this.newBufferedReader(clientSocket);) {
            String inputLine;
            while (this.continueLoop(inputLine = in.readLine())) {
                this.beforeCommunication(clientSocket, inputLine);
                if (this.shouldCloseConnection(inputLine, end)) {
                    break; // Client requested to close the connection
                }
                handleMessage(inputLine, out);
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

