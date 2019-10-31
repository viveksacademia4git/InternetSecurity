package edu.srh.is;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public final static String MESSAGE = "Hello World";
	public final static String NULL_MESSAGE = "Argument is NULL";

	public static void main(String[] args) {
		if(args==null)
			throw new NullPointerException(Application.NULL_MESSAGE);
		args[0] = Application.MESSAGE;

	}
}
