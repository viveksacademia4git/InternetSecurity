package edu.srh.is.attacker;

import edu.srh.is.operation.Communicator;
import edu.srh.is.victim.Victim;

public class Morpheus extends Victim {

	public Morpheus(String Morpheus) {
		super(Morpheus);
	}
	@Override
	public boolean sendMessage(Communicator communicator, String message) {
		
		return communicator.sendMessage(message);
	}
	@Override
	public String receiveMessage(Communicator communicator) {
		
		return communicator.receiveMessage();
	}

}


