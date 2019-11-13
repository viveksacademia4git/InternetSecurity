package net.guides.springboot2.jdbc;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import net.guides.springboot2.jdbc.logger.LogMarker;
import net.guides.springboot2.jdbc.repository.EmployeeJDBCRepository;

@SpringBootApplication
@ComponentScan("net.guides.springboot2.jdbc")
public class Application implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(Application.class);

	public static final boolean INITIALIZED;

	static {
		INITIALIZED = true;
	}
	
	
	@Autowired
	private EmployeeJDBCRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", employeeRepository.findAll());
	}

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/sqlinjection");
		SpringApplication.run(Application.class, args);
		logger.info(LogMarker.INIT, "Application Initialization");
	}
}
