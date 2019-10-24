package edu.srh.is.constants;

public enum StandardPort {

	FTP("FTP", 21),
	FTPS("FTPS or SFTP", 22),
	HTTP("HTTP", 80),
	HTTPS("HTTPS", 443),
	MSSQL("MSSQL", 1433),
	ORACLE_DB("Oracle DB", 1521),
	MYSQL("MySQL", 3306),
	ANGULAR_APP("Angular App", 4200),
	TOMCAT("Tomcat", 8080),
	NODE_SERVER("Node Server", 8888),
	MONGO_DB("Mongo DB", 27017);

	StandardPort(String portName, int portNumber) {
		this.portName = portName;
		this.portNumber = portNumber;
	}

	StandardPort(String portName, int portNumber, String protocol) {
		this.portName = portName;
		this.portNumber = portNumber;
	}

	private String portName;
	private int portNumber;

	public String getPortName() {
		return portName;
	}
	public void setPortName(String portName) {
		this.portName = portName;
	}

	public int getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}

}
