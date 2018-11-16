package com.gj.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gj.demo.model.User;
import com.gj.demo.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET) 
	public User list(@PathVariable(value="id")Integer userId) {
		User user = userService.getUserByID(userId);
		return user;
	}
}
