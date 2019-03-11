package com.metacube.restful.model;

/**
 * Response class used as a model class to send the messages in the URI with defined properties
 * @author admin
 *
 */
public class Response {

	private String message;
	private boolean status;
	private int code;
	
	
	//sets the code of the message
	public void setCode(int code) {
		this.code = code;
	}

	//sets the status of the message
	public void setStatus(boolean status) {
		this.status = status;
	}

	//sets the message of the message
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
