package com.friends.service;

import java.util.List;
import com.friends.model.User;

public interface IUserService {
	
	public String saveUser(User user);
	
	public List<User> getAllUser();
	
    public void deleteUserById(int userId);
    
	public User getUserById(int userId);
	
	public void updateUser(User user);
	
	public User getUserObByEmailId(String emailId);
	
	public User getUserByUmailAndPwd(String userEmail,String pwd);
}
