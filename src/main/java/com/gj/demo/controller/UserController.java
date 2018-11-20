package com.gj.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gj.demo.base.BaseController;
import com.gj.demo.model.User;
import com.gj.demo.service.UserService;

@RestController
@RequestMapping("/")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET) 
	public User user(@PathVariable(value="id")Integer userId) {
		User user = userService.getUserByID(userId);
		return user;
	}
	
	@RequestMapping(value="/user/list/{pageNum}/{pageSize}")
	public List<User> list(@PathVariable(value="pageNum")Integer pageNum,@PathVariable(value="pageSize")Integer pageSize){
		List<User> users = userService.findAllUser(pageNum,pageSize);
		return users;
	}
}
