package com.metacube.messageservice;

public interface MessageService 
{
	//sends the message to the receiver with the given message
	public void sendMessage(String message , String receiver);
}
