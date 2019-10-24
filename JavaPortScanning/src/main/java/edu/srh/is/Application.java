package edu.srh.is;

public class Application {

	public final static String MESSAGE = "Hello World";
	public final static String NULL_MESSAGE = "Argument is NULL";

	public static void main(String[] args) {
		if(args==null)
			throw new NullPointerException(Application.NULL_MESSAGE);
		args[0] = Application.MESSAGE;
	}
}
