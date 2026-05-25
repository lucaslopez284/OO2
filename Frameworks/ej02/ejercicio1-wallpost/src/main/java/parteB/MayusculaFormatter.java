package parteB;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MayusculaFormatter extends Formatter {

	public String format(LogRecord record) {
		return record.getLevel() + ": " +
	               record.getMessage().toUpperCase() + "\n";
	}

}
