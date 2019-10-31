package edu.srh.is;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.srh.is.operation.CommunicationLink;
import edu.srh.is.victim.Morpheus;
import edu.srh.is.victim.Neo;
import edu.srh.is.victim.Trinity;

class CommunicationApplicationTest {
	

	@Test
	void testCommunicationMITM() throws Exception {
		CommunicationLink[] communicationLinks = {
			new CommunicationLink(new Neo(), new Morpheus(), "Neo >> Morpheus"),
			new CommunicationLink(new Morpheus(), new Neo(), "Morpheus >> Neo"),
			new CommunicationLink(new Neo(), new Trinity(), "Neo >> Trinity")
		};
		assertTrue(CommunicationApplication.communicationMITM(true, communicationLinks));
	}

}
