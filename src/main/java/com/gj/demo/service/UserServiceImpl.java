package com.gj.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gj.demo.framework.annotation.UsePage;
import com.gj.demo.mapper.UserMapper;
import com.gj.demo.model.User;

@Component
@Transactional()
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper mapper;
	
	@Override
	public User getUserByID(Integer userId) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(userId);
	}

	@Override
	@UsePage
	public List<User> findAllUser(Integer pageNum, Integer pageSize) {
        return mapper.selectAllUser();
	}

}
