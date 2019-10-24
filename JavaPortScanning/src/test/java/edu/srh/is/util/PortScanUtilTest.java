package edu.srh.is.util;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO - Need to write test cases for exception conditions.
//        >> Unable to do so because of the time crunch
class PortScanUtilTest {

	private static final Logger logger = LoggerFactory.getLogger(PortScanUtilTest.class);

	public static final String URL = "scanme.nmap.org";

	static {
		logger.info(PortScanUtilTest.class + ": Unit Test begins...");
	}

	@Test
	void testScanStandardPorts() {
		JSONArray testResult = PortScanUtil.scanStandardPorts(URL);
		logger.info(testResult.toString());
		assertTrue(testResult.length()>0);
	}

	/**
	 * Scan given (passed as parameter) ports of the given URL
	 */
	@Test
	void testScanPorts() {
		JSONArray testResult = PortScanUtil.scanPorts(URL, 22, 80, 443);
		logger.info(testResult.toString());
		assertTrue(testResult.length()>0);
	}

	/**
	 * Scan the given range of ports of the given URL
	 */
	@Test
	void testScanPortRange() {
		JSONArray testResult = PortScanUtil.scanPortRange(URL, 80, 90);
		logger.info(testResult.toString());
		assertTrue(testResult.length()>0);
	}

	/**
	 * Scan all ports of the given URL <br/>
	 * (*) Warning: Intensive Scan, hence time consuming
	 */
	@Test
	void testScanAllPorts() {
		JSONArray testResult = PortScanUtil.scanAllPorts(URL);
		logger.error(testResult.toString());
		assertTrue(testResult.length()>0);
	}


}
