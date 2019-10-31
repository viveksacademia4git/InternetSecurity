package edu.srh.is.attacker;

import edu.srh.is.operation.Communicator;
import edu.srh.is.victim.Victim;

public class Neo extends Victim {

	public Neo(String Neo) {
		super(Neo);	
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
