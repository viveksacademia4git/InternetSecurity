package edu.srh.is;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.srh.is.victim.Morpheus;
import edu.srh.is.victim.Neo;

class CommunicationApplicationTest {
	

	@Test
	void testStartCommunication() {
		assertTrue(CommunicationApplication.communicate(new Neo(), new Morpheus(), "Hello"));
	}

	@Test
	void testCommunicationMITM() {
		assertTrue(CommunicationApplication.communicationMITM(new Neo(), new Morpheus(), "Hello"));
	}

}
