package edu.srh.is;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.srh.is.attacker.AgentSmith;
import edu.srh.is.operation.CommunicationLink;
import edu.srh.is.victim.Morpheus;
import edu.srh.is.victim.Neo;
import edu.srh.is.victim.Victim;

public class CommunicationApplication {

	private static final Logger logger = LoggerFactory.getLogger(CommunicationApplication.class);


	public static boolean communicationMITM(boolean breached, CommunicationLink... communicationLinks) throws Exception {

		if(communicationLinks==null || communicationLinks.length<1) {
			communicationLinks = new CommunicationLink[] {
				new CommunicationLink(new Neo(), new Morpheus(), "Test")
			};
		}

		for(CommunicationLink communicationLink : communicationLinks) {
			// Start Communication
			Victim person1 = communicationLink.getVictim1(); //Input is security parameter.
			person1.startEncryptedCommunication();
	
			// Start Communication With
			Victim person2 = communicationLink.getVictim2();
	
			AgentSmith E = new AgentSmith();
			E.eavsdrop(person1, person2);
			System.out.println("\n---------------------------------------------------------------------------------------");
			System.out.println("---------------------------------------------------------------------------------------\n");
			System.out.println("EAV Key "+person1.getVictimName()+": " + E.getKeyA());
			System.out.println(person1.getVictimName()+" key: " + person1.getKey());
			System.out.println("EAV Key "+person2.getVictimName()+": "  + E.getKeyB());
			System.out.println(person2.getVictimName()+" key: " + person2.getKey());
			try {
				person1.sendMessageToUser(person2, E, communicationLink.getMessage());
			}
			catch (Exception e) {
				e.printStackTrace();
			}

		}
		return true;
	}

}
