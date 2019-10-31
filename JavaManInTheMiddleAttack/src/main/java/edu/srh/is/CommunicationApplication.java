package edu.srh.is;

import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.srh.is.constant.LogMarker;
import edu.srh.is.operation.Communicator;
import edu.srh.is.util.Common;
import edu.srh.is.victim.Victim;

public class CommunicationApplication {

	private static final Logger logger = LoggerFactory.getLogger(CommunicationApplication.class);


	public static boolean communicate(Victim victim1, Victim victim2, String... messageQueue) {
		Communicator communicator = new Communicator(victim1, victim2);
		for(String message : messageQueue) {
			String encryptedMessage = victim1.sendMessage(communicator, message);
			if(Common.nullOrEmpty(encryptedMessage)) {
				logger.error(LogMarker.COMMUNICATION_MESSAGE, "Unable to send the message");
				return false;
			}
			else
				logger.info(LogMarker.COMMUNICATION_MESSAGE, victim2.receiveMessage(communicator, encryptedMessage));
		}
		return true;
	}



	public static boolean communicationMITM(Victim victim1, Victim victim2, String... messageQueue) {
		boolean breached = false;
		// TODO Implement introduce MITM attacker - Agent Smith, breaching the communication
		return breached;
	}

}
