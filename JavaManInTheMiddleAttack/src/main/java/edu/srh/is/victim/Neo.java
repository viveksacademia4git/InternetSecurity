package edu.srh.is.victim;

import edu.srh.is.operation.Communicator;

public class Neo extends Victim {


	public Neo() {
		super("Neo");	
	}


	@Override
	public String sendMessage(Communicator communicator, String message) {
		return communicator.sendMessage(message);
	}


	@Override
	public String receiveMessage(Communicator communicator, String encryptedMessage) {
		return communicator.receiveMessage(encryptedMessage);
	}

}
