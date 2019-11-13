package net.guides.springboot2.jdbc.logger;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public final class LogMarker {

	private LogMarker() { }

	public static final Marker INIT = MarkerFactory.getMarker("Initialization");

}
