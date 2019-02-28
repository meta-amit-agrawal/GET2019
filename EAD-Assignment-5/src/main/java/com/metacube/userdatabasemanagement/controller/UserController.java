package com.metacube.userdatabasemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.userdatabasemanagement.model.User;
import com.metacube.userdatabasemanagement.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String add() 
	{
		return "user/addUser";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String add(User user)
	{
		userService.add(user);
		return "redirect:/user/allUser";
	}
	
	@RequestMapping(value = "/edit/{id}" ,  method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") int id)
	{
		User user = userService.getUserByID(id);
		return new ModelAndView("user/updateUser" , "user" , user);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(User user)
	{
		userService.update(user);
		return "redirect:/user/allUser";
	}
	
	@RequestMapping(value = "/allUser" , method = RequestMethod.GET)
	public ModelAndView getAll()
	{
		List<User> userList = userService.getAll();
		return new ModelAndView("user/allUser", "users", userList);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("Id") int id) {
		userService.delete(id);
		return "redirect:/user/allUser";
	}
}
