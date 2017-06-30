package com.friends.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friends.dao.IUserDao;
import com.friends.model.User;
import com.friends.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao dao;
	
	@Override
	public int saveUser(User user) {
		return dao.saveUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return dao.getAllUser();
	}

	@Override
	public void deleteUserById(int userId) {
		dao.deleteUserById(userId);	
	}

	@Override
	public User getUserById(int userId) {
		return dao.getUserById(userId);
	}

	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
	}

	@Override
	public boolean isUserExist(String userEmail) {
		return dao.isUserExist(userEmail);
	}

	@Override
	public User getUserObByEmailId(String emailId) {
		return dao.getUserObByEmailId(emailId);
	}

	@Override
	public User getUserByUmailAndPwd(String userEmail, String pwd) {
		return dao.getUserByUmailAndPwd(userEmail, pwd);
	}

}
