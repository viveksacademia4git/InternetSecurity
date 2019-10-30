package edu.srh.is;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ScanWEPTest {

	@Test
	void test() {
		assertNotNull(ScanWEP.scanWep("xyz"));
	}

}
