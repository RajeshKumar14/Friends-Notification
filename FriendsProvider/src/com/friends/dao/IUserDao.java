package com.friends.dao;

import java.util.List;

import com.friends.model.User;

public interface IUserDao {
	   
	    public int saveUser(User frnd);
		
		public List<User> getAllUser();
		
		public void deleteUserById(int userId);
		
		public User getUserById(int userId);
		
		public void updateUser(User user);
		
		public boolean isUserExist(String userEmail);
		
		public User getUserObByEmailId(String emailId);
		
		public User getUserByUmailAndPwd(String userEmail,String pwd);
}
