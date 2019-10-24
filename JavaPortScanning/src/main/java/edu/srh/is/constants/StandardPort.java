package edu.srh.is.constants;

public enum StandardPort {

	HTTP("HTTP", 80),
	ANGULAR_APP("Angular App", 4200);

	StandardPort(String portName, int portNumber) {
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
