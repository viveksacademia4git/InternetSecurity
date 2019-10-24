package edu.srh.is;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ApplicationTest {


	@Test 
	void testMain_Null() {
		Throwable exception = assertThrows(NullPointerException.class, () -> {
			Application.main(null);
        });
        assertEquals(exception.getMessage(), Application.NULL_MESSAGE);
	}

	@Test
	void testMain_Value() {
		String[] args = { "Hello" };
		Application.main(args);
		assertEquals( Application.MESSAGE , args[0]);
	}

}
