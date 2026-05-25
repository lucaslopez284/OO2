package parteB;

import java.util.logging.Handler;
import java.util.*;
import java.util.logging.LogRecord;

public class FiltroHandler extends Handler {
	
	private List<String> palabrasProhibidas;
	private Handler handlerDestino;
	
	public FiltroHandler(Handler handlerDestino, List<String> palabrasProhibidas) {
		this.handlerDestino = handlerDestino;
		this.palabrasProhibidas = palabrasProhibidas;
	}

	@Override
	public void publish(LogRecord record) {
		String mensaje = record.getMessage();
		for (String palabra : palabrasProhibidas) {
			mensaje.replace(palabra, "***");
		}
		LogRecord nuevoRecord = new LogRecord(record.getLevel(), mensaje);
        handlerDestino.publish(nuevoRecord);
	}

	@Override
	public void flush() {
		this.handlerDestino.flush();
	}

	@Override
	public void close() throws SecurityException {
		this.handlerDestino.close();
	}

}
