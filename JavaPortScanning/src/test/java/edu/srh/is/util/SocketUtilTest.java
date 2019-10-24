package edu.srh.is.util;

import static edu.srh.is.util.Common.append;
import static org.junit.jupiter.api.Assertions.*;

import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.srh.is.constants.StandardPort;
import edu.srh.is.util.PortScanUtil.ExceptionMessages;

class SocketUtilTest {

	private static final Logger logger = LoggerFactory.getLogger(SocketUtilTest.class);

	static final String URL = "scanme.nmap.org";
	static final StandardPort standardPort = StandardPort.HTTP;

	private static Socket mockSocket;

	static {
		logger.info(SocketUtilTest.class + ": Unit Test begins...");
	}


	/**
	 * Create Mock Socket for the Unit Tests
	 */
	@BeforeAll
	static void initTest() {
		// Mocking the Socket through the HTTP Port 
		int portNumber = standardPort.getPortNumber();
		try {
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress(URL, portNumber), 1000);
			mockSocket = socket;
			// Message
			String message = append(standardPort.getPortName(), " Port ", portNumber, " is open");
			logger.info(message);
			logger.info(SocketUtilTest.class + ": Mock Successful");
		}
		catch (ConnectException ex) {
			// Connection Exception Message
			logger.error(append(ExceptionMessages.EXCEPTION_MESSAGE_CONNECTION_PORT_NOT_OPEN, portNumber));
			logger.error(SocketUtilTest.class + ": Mock ConnectException");
			System.exit(0);
		}
		catch (Exception ex) {
			// Exception Message
			String message = append(ExceptionMessages.EXCEPTION_MESSAGE_GENERIC, portNumber);
			logger.error(message, ex);
			logger.error(SocketUtilTest.class + ": Mock Exception");
			System.exit(0);
		}
	}


	/**
	 * Close the Mock Socket (Being a Resource) after the Unit Tests
	 */
	@AfterAll
	static void endTest() {
		int portNumber = standardPort.getPortNumber();
		try {
			mockSocket.close();
			String message = append(standardPort.getPortName(), " Port ", portNumber, " was open for Mock is closed successfully");
			logger.info(message);
		}
		catch (ConnectException ex) {
			logger.error(SocketUtilTest.class + ": Mock ConnectException");
			System.exit(0);
		}
		catch (Exception ex) {
			logger.error(SocketUtilTest.class + ": Mock Exception");
			System.exit(0);
		}
	}


	@Test
	void testGetSocketDataJSON() {
		JSONObject jsonObject = SocketUtil.getSocketDataJSON(mockSocket, "");
		logger.info(jsonObject.toString());
		assertNotNull(jsonObject);
	}

}
