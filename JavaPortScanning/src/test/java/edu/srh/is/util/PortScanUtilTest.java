package edu.srh.is.util;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PortScanUtilTest {

	private static final Logger logger = LoggerFactory.getLogger(PortScanUtilTest.class);

	public static final String URL = "localhost";

	@Test
	void testScanAllPorts() {
		JSONArray testResult = PortScanUtil.scanAllPorts(URL);
		logger.info(testResult.toString());
		assertTrue(testResult.length()>0);
	}

	@Test
	void testScanStandardPorts() {
		JSONArray testResult = PortScanUtil.scanStandardPorts(URL);
		logger.info(testResult.toString());
		assertTrue(testResult.length()>0);
	}

	@Test
	void testScanPortRange() {
		JSONArray testResult = PortScanUtil.scanPortRange(URL, 4000, 4500);
		logger.info(testResult.toString());
		assertTrue(testResult.length()>0);
	}

	@Test
	void testScanPorts() {
		JSONArray testResult = PortScanUtil.scanPorts(URL, 4000, 4200, 4500);
		logger.info(testResult.toString());
		assertTrue(testResult.length()>0);
	}

}
