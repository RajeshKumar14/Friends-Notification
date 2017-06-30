package com.friends.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.friends.client.RestClient;
import com.friends.model.User;
import com.friends.service.IUserService;
import com.friends.util.JsonUtil;

@Service
public class UserServiceImpl implements IUserService{

	@Override
	public String saveUser(User user) {
		//1.convert obj to json
		 String json=JsonUtil.convertObjToJson(user);
		//2.get response msg back
		  return RestClient.connectToProviderToSaveUser(json);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserById(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		  String json=null;
		//1.convert obj to json
		 if(user!=null){
		  json=JsonUtil.convertObjToJson(user);
		//2.get response msg back
		  RestClient.connectToProviderToUpdateUser(json);
		 }
		
	}

	@Override
	public User getUserObByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUmailAndPwd(String userEmail, String pwd) {
		//get response msg back
		User userObj=null;
		String json= RestClient.connectToProviderToLoginUser(userEmail, pwd);
		if(json!=null)
		userObj=(User)JsonUtil.convertJsonToObj(json, User.class);
	  return userObj;
	}
	

}
