package edu.srh.is.util;

import java.net.Socket;
import java.net.SocketException;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.srh.is.constants.ExceptionString;
import edu.srh.is.constants.JsonKeys;
import edu.srh.is.constants.JsonValues;

/**
 * Utility for functions related to Sockets
 * @author vivek
 */
public final class SocketUtil {


	private static final Logger logger = LoggerFactory.getLogger(SocketUtil.class);


	public static final String PORT = "port";
	public static final String LOCAL_PORT = "local_port";
	public static final String TIMEOUT = "timeout";
	public static final String INET_ADDRESS = "inet_address";
	public static final String LOCAL_ADDRESS = "local_address";
	public static final String LOCAL_SOCKET_ADDRESS = "local_socket_address";
	public static final String REMOTE_SOCKET_ADDRESS = "remote_socket_address";


	public static JSONObject getSocketDataJSON(Socket socket, String message) {

		JSONObject jsonObject = new JSONObject();
		try {
			if(socket==null)
				return jsonObject.put(JsonKeys.STATUS, ExceptionString.IS_NULL);
	
			if(socket.isClosed())
				return jsonObject.put(JsonKeys.STATUS, ExceptionString.IS_CLOSED);

			jsonObject.put(PORT, socket.getPort());
			jsonObject.put(LOCAL_PORT, socket.getLocalPort());
			jsonObject.put(TIMEOUT, socket.getSoTimeout());
			jsonObject.put(INET_ADDRESS, socket.getInetAddress());
			jsonObject.put(LOCAL_ADDRESS, socket.getLocalAddress());
			jsonObject.put(LOCAL_SOCKET_ADDRESS, socket.getLocalSocketAddress());
			jsonObject.put(REMOTE_SOCKET_ADDRESS, socket.getRemoteSocketAddress());
			jsonObject.put(JsonKeys.MESSAGE, message);
		}
		catch (JSONException ex) {
			logger.error(ExceptionMessages.EXCEPTION_MESSAGE_JSON, ex);
		}
		catch (SocketException ex) {
			logger.error(ExceptionMessages.EXCEPTION_MESSAGE_GENERIC, ex);
		}

		return jsonObject.put(JsonKeys.STATUS, JsonValues.SUCCESS);
	}


	/**
	 * Exception Messages for Utility Class
	 * @author Vivek Yadav
	 */
	public final class ExceptionMessages {

		private ExceptionMessages() {}

		public static final String EXCEPTION_MESSAGE_JSON = "Error occurred while scanning the port: ";

		public static final String EXCEPTION_MESSAGE_GENERIC = "Error occurred while scanning the socket";

	}
}
