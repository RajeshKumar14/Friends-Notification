package com.friends.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.friends.dao.IUserDao;
import com.friends.model.User;
@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveUser(User user) {
		return (Integer)ht.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return ht.loadAll(User.class);
	}

	@Override
	public void deleteUserById(int userId) {
		ht.delete(new User(userId));	
	}

	@Override
	public User getUserById(int userId) {
		return ht.get(User.class, userId);
	}

	@Override
	public void updateUser(User user) {
		ht.update(user);
		
	}

	@Override
	public boolean isUserExist(String userEmail) {
		boolean flag=false;
		String hql="select count(UserId) from "+User.class.getName()
				+" where userEmail=?";
		@SuppressWarnings("unchecked")
		List<Long>dataList=ht.find(hql,userEmail);
		
		if(dataList!=null && !dataList.isEmpty()){
			long count=dataList.get(0);
			if(count>0) flag=true;
		     }
		return flag;
	}
	
	@Override
	public User getUserObByEmailId(String emailId)
	{
		User  frnds=null;
		String hql="from "+User.class.getName()
				+" where userEmail=?";
		@SuppressWarnings("unchecked")
		List<User> frndsList=ht.find(hql,emailId);
		if(frndsList!=null && !frndsList.isEmpty()){
			frnds=frndsList.get(0);
		}
		return frnds;
	}

	@Override
	public User getUserByUmailAndPwd(String userEmail, String pwd) {
		User user=null;
		String hql="from "+ User.class.getName()+" where userEmail=? and Pwd=?";
		@SuppressWarnings("unchecked")
		List<User> userList=ht.find(hql, userEmail,pwd);
		if(userList!=null && !userList.isEmpty()){
			user=userList.get(0);
		}
		return user;
	}	
	
	
}
