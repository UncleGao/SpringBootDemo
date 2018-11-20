package com.gj.demo.service;

import java.util.List;

import com.gj.demo.model.User;

public interface UserService {

	public User getUserByID(Integer userId);

	public List<User> findAllUser(Integer pageNum, Integer pageSize);

}
