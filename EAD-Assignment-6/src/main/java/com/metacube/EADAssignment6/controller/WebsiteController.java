package com.metacube.EADAssignment6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.metacube.EADAssignment6.model.Login;
import com.metacube.EADAssignment6.service.implementation.AdminServiceImplementation;

@Controller
public class WebsiteController {
	
	@Autowired
	AdminServiceImplementation adminServiceImplementation;
	
	  /** 
	   * Maps the request with all url starting with /
	   * @redirects to the login.jsp page
	   */
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public String login()
	  {
	      return "login";
	  }
	  
	  /**
	   * Maps the request if login is successful
	   * @redirects to welcome.jsp page 
	   */
	  @RequestMapping(value = "/welcome", method = RequestMethod.GET)
	  public String home()
	  {
		  return "welcome";
	  }
	  
	  //checks the login details and redirects to welcome page
	  @RequestMapping(value = "/loginadmin", method = RequestMethod.GET)
	  public String loginAdmin(Login login)
	  {
		  if(adminServiceImplementation.getAdmin(login))
		  {
			  return "redirect://welcome";
		  }
		return "redirect:/";
	  }	
	  
	  //send the uri request to to forgot.jsp page
	  @RequestMapping(value = "/forgot", method = RequestMethod.GET)
	  public String forgot()
	  {
		  return "forgot";
	  }
	  
	  /**
	   * Maps the request from forgot password to update in database
	   * @param login to update in database
	   * @redirects to login page
	   */
	  @RequestMapping(value = "/update", method = RequestMethod.POST)
	  public String forgotPassword(Login login)
	  {
		  adminServiceImplementation.updatePassword(login);
		  return "redirect:/";
	  }
	  
	  

}
