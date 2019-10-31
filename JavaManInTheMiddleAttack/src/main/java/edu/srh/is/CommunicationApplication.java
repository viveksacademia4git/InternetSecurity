package edu.srh.is;

import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.srh.is.constant.LogMarker;
import edu.srh.is.operation.Communicator;
import edu.srh.is.victim.Victim;

public class CommunicationApplication {

	private static final Logger logger = LoggerFactory.getLogger(CommunicationApplication.class);

	public static void startCommunication(Victim victim1, Victim victim2, Queue<String> messageQueue) {
		Communicator communicator = new Communicator(victim1, victim2);
		for(String message : messageQueue) {
			victim1.sendMessage(communicator, message);
			logger.info(LogMarker.COMMUNICATION_MESSAGE, victim2.receiveMessage(communicator));
		}
	}

}
