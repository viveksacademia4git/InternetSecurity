package edu.srh.is;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.srh.is.constants.StandardPort;

public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public final static String MESSAGE = "Hello World";
	public final static String NULL_MESSAGE = "Argument is NULL";

	public static void main(String[] args) {
		if(args==null)
			throw new NullPointerException(Application.NULL_MESSAGE);
		args[0] = Application.MESSAGE;

		Enum<StandardPort> enumValue = (Enum<StandardPort>) StandardPort.HTTP;
		Object[] possibleValues = enumValue.getDeclaringClass().getEnumConstants();
		int length = possibleValues.length;
		StandardPort[] STANDARD_PORTS = new StandardPort[length];	
		System.arraycopy(possibleValues, 0, STANDARD_PORTS, 0, possibleValues.length);

		for(StandardPort standardPort : STANDARD_PORTS) {
			logger.info(standardPort.getPortName());
		}

	}
}
