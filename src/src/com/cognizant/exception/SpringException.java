package com.cognizant.exception;

public class SpringException extends RuntimeException {
	
	private String exceptionMsg;

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public SpringException(String exceptionMsg) {
		super();
		this.exceptionMsg = exceptionMsg;
	}
 
	
}
