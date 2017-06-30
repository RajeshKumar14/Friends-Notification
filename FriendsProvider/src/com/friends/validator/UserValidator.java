package com.friends.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.friends.model.User;
import com.friends.service.IUserService;
import com.friends.util.CodecUtil;

@Component
public class UserValidator {
	
	@Autowired
	private CodecUtil codecUtil;
	@Autowired
	private IUserService service;
	
	public String doValidateUserEmail(String userEmail){
		String msg=null;
		if(service.isUserExist(userEmail)){
			msg="'"+userEmail+"' already exist";
		}
		return msg;
	}
	
	/*
	 * This method will check request pwd and token
	 * values with DB encoded values (pwd,token) after decoding
	 */
	private boolean isValidPwdandToken(String reqPwd,String reqToken,User user){
		boolean flag=false;
		//read db values
		String ePwd=user.getPwd();
		String eToken=user.getToken();
		//decode them
		String dbPwd=codecUtil.doDecode(ePwd);
		String dbToekn=codecUtil.doDecode(eToken);
		//compare with req values
		if(dbPwd.equals(reqPwd) && dbToekn.equals(reqToken))
		{
			flag=true;
		}
		return flag;
	}
	
	//It returns true for non-select operations
			//of type Consumer-non select
			public boolean isValidConsForItemView(String reqPwd,String reqToken,User user){
			 boolean status=false;
		     if(isValidPwdandToken(reqPwd, reqToken, user)){ status=true;}	
				return status;
			}
			
			/*
			 * This method will check request pwd 
			 * values with DB encoded values (pwd) after decoding
			 */
	   public boolean isValidPwd(String reqPwd,User user){
				boolean flag=false;
				//read db values
				String ePwd=user.getPwd();
				//decode them
				String dbPwd=codecUtil.doDecode(ePwd);
				//compare with req values
				if(dbPwd.equals(reqPwd))
				{
					flag=true;
				}
				return flag;
			}
}
