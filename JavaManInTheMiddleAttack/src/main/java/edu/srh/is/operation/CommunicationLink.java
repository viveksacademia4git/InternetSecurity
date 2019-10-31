package edu.srh.is.operation;

import edu.srh.is.victim.Victim;

public class CommunicationLink {
	Victim victim1;
	Victim victim2;
	String message;


	public CommunicationLink(Victim victim1, Victim victim2, String message) {
		this.victim1 = victim1;
		this.victim2 = victim2;
		this.message = message;
	}

	public Victim getVictim1() {
		return victim1;
	}

	public Victim getVictim2() {
		return victim2;
	}

	public String getMessage() {
		return message;
	}
}
