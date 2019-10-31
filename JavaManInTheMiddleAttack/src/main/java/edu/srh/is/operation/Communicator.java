package edu.srh.is.operation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.srh.is.constant.LogMarker;
import edu.srh.is.util.Common;
import edu.srh.is.util.MessageUtil;
import edu.srh.is.victim.Victim;

public class Communicator {

	private static final Logger logger = LoggerFactory.getLogger(Communicator.class);

	Victim victim1;
	Victim victim2;
	
	public Communicator(Victim victim1, Victim victim2) {
		this.victim1 = victim1;
		this.victim2 = victim2;
	}

	/**
	 * Send encrypted message
	 * @param message {@link String}
	 * @return encryptedMessage {@link String}
	 */
	public String sendMessage(String message) {
		try {
			// TODO Send Message
			String encryptedMessage = MessageUtil.encryptMessage(message);
			if(Common.nullOrEmpty(encryptedMessage)) {
				logger.error(LogMarker.COMMUNICATION_PROCESS, "Unable to perform the communication encryption process.");
				return null;
			}
			return encryptedMessage;
		}
		catch (Exception ex) {
			String err = Common.append("An error occurred while performing communication encryption process: ",ex.getMessage());
			logger.error(LogMarker.COMMUNICATION_PROCESS, err);
			return null;
		}
	}

	/**
	 * Receive Decrypted Message
	 * @param encryptedMessage {@link String}
	 * @return decryptedMessage {@link String}
	 */
	public String receiveMessage(String encryptedMessage) {
		try {
			// TODO Send Message
			String decryptedMessage = MessageUtil.encryptMessage(encryptedMessage);
			if(Common.nullOrEmpty(encryptedMessage)) {
				logger.error(LogMarker.COMMUNICATION_PROCESS, "Unable to perform the communication decryption process.");
				return null;
			}
			return decryptedMessage;
		}
		catch (Exception ex) {
			String err = Common.append("An error occurred while performing communication decryption process: ",ex.getMessage());
			logger.error(LogMarker.COMMUNICATION_PROCESS, err);
			return null;
		}
	}

	
}
