package edu.srh.is.util;

import static edu.srh.is.util.Common.*;

import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.srh.is.constants.JsonKeys;
import edu.srh.is.constants.JsonValues;
import edu.srh.is.constants.StandardPort;

public final class PortScanUtil {

	private static final Logger logger = LoggerFactory.getLogger(PortScanUtil.class);

	public static final int PORTS = 65535;

	public static final StandardPort[] STANDARD_PORTS; //= { SSH, HTTP , ANGULAR_APP };


	static {
		// Get all the StandardPort (enum) values
		Enum<StandardPort> enumValue = (Enum<StandardPort>) StandardPort.HTTP;
		Object[] possibleValues = enumValue.getDeclaringClass().getEnumConstants();
		// Copy all the StandardPort (enum) values to >> STANDARD_PORTS (array)
		int length = possibleValues.length;
		STANDARD_PORTS = new StandardPort[length];	
		System.arraycopy(possibleValues, 0, STANDARD_PORTS, 0, possibleValues.length);
	}


	private static JSONObject connect(String url, int portNumber, String portMessage) {
		String message;
		try (Socket socket = new Socket();) {
			socket.connect(new InetSocketAddress(url, portNumber), 1000);
			return SocketUtil.getSocketDataJSON(socket, append(portMessage));
		}
		catch (ConnectException ex) {
			// Connection Exception Message
			message = append(ExceptionMessages.EXCEPTION_MESSAGE_CONNECTION_PORT_NOT_OPEN, portNumber);
//			logger.error(message);
		}
		catch (Exception ex) {
			// Exception Message
			message = append(ExceptionMessages.EXCEPTION_MESSAGE_GENERIC, portNumber);
//			logger.error(message, ex);
		}
		return new JSONObject().put(JsonKeys.STATUS, JsonValues.SUCCESS).put(JsonKeys.MESSAGE, message);
	}


	private static JSONObject connectPort(String url, int portNumber, String portName) {
		String portMessage = append("Port [", portNumber, "] for [", portName, "] is open");
		return connect(url, portNumber, portMessage);
	}


	private static JSONObject connectPort(String url, int portNumber) {
		String portMessage = append("Port [", portNumber, "] is open");
		return connect(url, portNumber, portMessage);
	}


	/**
	 * Scan all ports
	 * @param url {@link String}
	 * @return jsonArrayMessages {@link JSONArray}
	 */
	public static JSONArray scanAllPorts(String url) {
		if(Common.nullOrEmpty(url))
			throw new NullPointerException(ExceptionMessages.EXCEPTION_MESSAGE_URL_UNDEFINED);

		JSONArray jsonArray = new JSONArray();
		
		int portMultiple = 50;
		int loopCount = (PORTS - 35) / portMultiple ; // 65535 - 35 = 65500 / 50 = 1310

		for (int portTimes = 0; loopCount > portTimes; portTimes++) {
			for(int i=1; i<=portMultiple; i++) {
				// Port till (1309 * 50) = 65450 + 50 = 65500
				int portNumber = portTimes * portMultiple + i ;
				Runnable runPortScan = () -> {
					JSONObject jsonSocket = connectPort(url, portNumber);
					jsonArray.put(jsonSocket);	
				};
				new Thread(runPortScan).start();
			}
		}

		for (int portNumber = 65501; PORTS >= portNumber; portNumber++) {
			JSONObject jsonSocket = connectPort(url, portNumber);
			jsonArray.put(jsonSocket);
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
		if(Common.nullOrEmpty(url))
			throw new NullPointerException(ExceptionMessages.EXCEPTION_MESSAGE_URL_UNDEFINED);

		if(ports==null || ports.length<1)
			throw new NullPointerException("No ports are defined");

		if(ports.length>10)
			throw new NullPointerException("Ports limit is 10");

		JSONArray jsonArray = new JSONArray();
		for (int portNumber : ports) {
			JSONObject jsonSocket = connectPort(url, portNumber);
			jsonArray.put(jsonSocket);
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
		if(Common.nullOrEmpty(url))
			throw new NullPointerException(ExceptionMessages.EXCEPTION_MESSAGE_URL_UNDEFINED);

		if(rangeStart<1)
			throw new IllegalArgumentException("Invalid Starting Port Range");
		if(rangeEnd>PORTS)
			throw new IllegalArgumentException("Invalid Ending Port Range");
		if( rangeEnd - rangeStart > 50)
			throw new IllegalArgumentException("Ports range must be 50");

		JSONArray jsonArray = new JSONArray();
		for (int portNumber = rangeStart; rangeEnd >= portNumber; portNumber++) {
			JSONObject jsonSocket = connectPort(url, portNumber);
			jsonArray.put(jsonSocket);
		}
		return jsonArray;
	}



	/**
	 * Scan standard ports
	 * @param url {@link String}
	 * @return jsonArrayMessages {@link JSONArray}
	 */
	public static JSONArray scanStandardPorts(String url) {
		if(Common.nullOrEmpty(url))
			throw new NullPointerException(ExceptionMessages.EXCEPTION_MESSAGE_URL_UNDEFINED);

		JSONArray jsonArray = new JSONArray();
		for (StandardPort standardPort : STANDARD_PORTS) {
			JSONObject jsonSocket = connectPort(url, standardPort.getPortNumber(), standardPort.getPortName());
			jsonArray.put(jsonSocket);
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

		public static final String EXCEPTION_MESSAGE_URL_UNDEFINED = "URL is undefined";
	}

}
