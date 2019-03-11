package com.metacube.messageservice.test;


import org.junit.Test;

import com.metacube.messageservice.consumer.MyApplication;
import com.metacube.messageservice.consumer.MyXMLApplication;

public class TestCases 
{
	
	MyApplication myApplication = new MyApplication();
	MyXMLApplication myXMLApplication = new MyXMLApplication();
	
	@Test
	public void testEmailWithXML()
	{
		myXMLApplication.sendMessage("email", "email with xml", "Amit");
	}
	
	@Test
	public void testEmailWithAnnotations() 
	{
		myApplication.sendMessage("email", "email with annotations", "Akshat");
	}
	
	@Test
	public void testTwitterWithXML() 
	{
		myXMLApplication.sendMessage("twitter", "twitter with XML", "Chintu");
	}
	
	@Test
	public void testTwitterWithAnnotations() 
	{
		myApplication.sendMessage("twitter", "twitter with annotations", "Vijay");
	}
	
	
	
}
