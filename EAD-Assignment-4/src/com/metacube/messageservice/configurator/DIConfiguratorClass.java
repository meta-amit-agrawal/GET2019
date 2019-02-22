package com.metacube.messageservice.configurator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.messageservice.EmailService;
import com.metacube.messageservice.TwitterService;

@Configuration
public class DIConfiguratorClass {
	
	//It will create the object of email service
	@Bean
	public EmailService email()
	{
		return (new EmailService());
	}
	
	//It will create the object of twitter service
	@Bean
	public TwitterService twitter()
	{
		return (new TwitterService());
	}
	
}
