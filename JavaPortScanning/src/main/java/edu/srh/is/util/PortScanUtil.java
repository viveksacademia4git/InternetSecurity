package edu.srh.is.util;

import static edu.srh.is.constants.StandardPort.*;
import static edu.srh.is.util.Common.*;

import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.srh.is.constants.StandardPort;

public class PortScanUtil {

	private static final Logger logger = LoggerFactory.getLogger(PortScanUtil.class);

	public static final int PORTS = 65535;

	public static final StandardPort[] STANDARD_PORTS = { HTTP , ANGULAR_APP };



	/**
	 * Scan all ports
	 * @param url {@link String}
	 * @return jsonArrayMessages {@link JSONArray}
	 */
	public static JSONArray scanAllPorts(String url) {
		JSONArray jsonArray = new JSONArray();
		for (int portNumber = 1; PORTS >= portNumber; portNumber++) {
			try {
				Socket socket = new Socket();
				socket.connect(new InetSocketAddress(url, portNumber), 1000);
				socket.close();
				// Message
				String message = append("Port ", portNumber, " is open");
				jsonArray.put(message);
			}
			catch (ConnectException ex) {
				// Connection Exception Message
				logger.error(append(ExceptionMessages.EXCEPTION_MESSAGE_CONNECTION_PORT_NOT_OPEN, portNumber));
			}
			catch (Exception ex) {
				// Exception Message
				String message = append(ExceptionMessages.EXCEPTION_MESSAGE_GENERIC, portNumber);
				jsonArray.put(message);
				logger.error(message, ex);
			}
		}
		return jsonArray;
	}



	/**
	 * Scan all the given ports
	 * @param url {@link String}
	 * @param ports {@link Integer} (vargs)
	 * @return jsonArrayMessages {@link JSONArray}
	 */
	public static JSONArray scanPorts(String url, int...ports) {
		if(ports==null)
			throw new NullPointerException("No ports defined");
		JSONArray jsonArray = new JSONArray();
		for (int portNumber : ports) {
			try {
				Socket socket = new Socket();
				socket.connect(new InetSocketAddress(url, portNumber), 1000);
				socket.close();
				// Message
				String message = append("Port ", portNumber, " is open");
				jsonArray.put(message);
			}
			catch (ConnectException ex) {
				// Connection Exception Message
				logger.error(append(ExceptionMessages.EXCEPTION_MESSAGE_CONNECTION_PORT_NOT_OPEN, portNumber));
			}
			catch (Exception ex) {
				// Exception Message
				String message = append(ExceptionMessages.EXCEPTION_MESSAGE_GENERIC, portNumber);
				jsonArray.put(message);
				logger.error(message, ex);
			}
		}
		return jsonArray;
	}



	/**
	 * Scan all the given ports
	 * @param url {@link String}
	 * @param rangeStart {@link Integer}
	 * @param rangeEnd {@link Integer}
	 * @return jsonArrayMessages {@link JSONArray}
	 */
	public static JSONArray scanPortRange(String url, int rangeStart, int rangeEnd) {
		if(rangeStart<1)
			throw new IllegalArgumentException("Invalid Starting Port Range");
		if(rangeEnd>PORTS)
			throw new IllegalArgumentException("Invalid Ending Port Range");

		JSONArray jsonArray = new JSONArray();
		for (int portNumber = rangeStart; rangeEnd >= portNumber; portNumber++) {
			try {
				Socket socket = new Socket();
				socket.connect(new InetSocketAddress(url, portNumber), 1000);
				socket.close();
				// Message
				String message = append("Port ", portNumber, " is open");
				jsonArray.put(message);
			}
			catch (ConnectException ex) {
				// Connection Exception Message
				logger.error(append(ExceptionMessages.EXCEPTION_MESSAGE_CONNECTION_PORT_NOT_OPEN, portNumber));
			}
			catch (Exception ex) {
				// Exception Message
				String message = append(ExceptionMessages.EXCEPTION_MESSAGE_GENERIC, portNumber);
				jsonArray.put(message);
				logger.error(message, ex);
			}
		}
		return jsonArray;
	}



	/**
	 * Scan standard ports
	 * @param url {@link String}
	 * @return jsonArrayMessages {@link JSONArray}
	 */
	public static JSONArray scanStandardPorts(String url) {
		JSONArray jsonArray = new JSONArray();
		for (StandardPort standardPort : STANDARD_PORTS) {
			int portNumber = standardPort.getPortNumber();
			try {
				Socket socket = new Socket();
				socket.connect(new InetSocketAddress(url, portNumber), 1000);
				socket.close();
				// Message
				String message = append(standardPort.getPortName(), " Port ", portNumber, " is open");
				jsonArray.put(message);
			}
			catch (ConnectException ex) {
				// Connection Exception Message
				logger.error(append(ExceptionMessages.EXCEPTION_MESSAGE_CONNECTION_PORT_NOT_OPEN, portNumber));
			}
			catch (Exception ex) {
				// Exception Message
				String message = append(ExceptionMessages.EXCEPTION_MESSAGE_GENERIC, portNumber);
				jsonArray.put(message);
				logger.error(message, ex);
			}
		}
		return jsonArray;
	}


	/**
	 * Messages for Utility Class
	 * @author Vivek Yadav
	 */
	public final class Messages {

		private Messages() {}

		public static final String MESSAGE_SCAN_STANDARD_PORTS = "All standard ports scanned successfully";

		public static final String MESSAGE_SCAN_ALL_PORTS = "All ports scanned successfully";
	}


	/**
	 * Exception Messages for Utility Class
	 * @author Vivek Yadav
	 */
	public final class ExceptionMessages {

		private ExceptionMessages() {}

		public static final String EXCEPTION_MESSAGE_GENERIC = "Error occurred while scanning the port: ";

		public static final String EXCEPTION_MESSAGE_CONNECTION_PORT_NOT_OPEN = "Port is not open: ";
	}
}
