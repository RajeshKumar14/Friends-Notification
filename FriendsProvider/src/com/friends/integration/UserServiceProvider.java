package com.friends.integration;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.friends.model.User;
import com.friends.service.IUserService;
import com.friends.util.CodeUtil;
import com.friends.util.CodecUtil;
import com.friends.util.CommonUtil;
import com.friends.util.JsonUtil;
import com.friends.validator.UserValidator;

@Path("/userService")
@Component
public class UserServiceProvider {
@Autowired
		private IUserService service;
		@Autowired
		private CodeUtil codeUtil;
		@Autowired
		private CodecUtil codecUtil;
		@Autowired
		private CommonUtil commonUtil;
		@Autowired
		private UserValidator validator;
		@Autowired
		private JsonUtil jsonUtil;
		
	//==============================User Registration=========================
		@POST
		@Path("/saveUser")
		public String saveUser(String json)
		  {
			    //1.convert json to class object
			  User userObj=(User)jsonUtil.convertJsonToObj(json, User.class);
			    if(userObj==null)
				   return "No User details found";

			   //2.generate pwd and token
			  String Pwd=codeUtil.getPwd();
			  String Token=codeUtil.getToken();
			
			   //3.convert above data to encoded format
			  String encPwd=codecUtil.doEncode(Pwd);
			  String encToken=codecUtil.doEncode(Token);
			
			   //4.set encoded pwd,tocken to seller obj
			  userObj.setToken(codecUtil.doEncode(encToken));
			  userObj.setPwd(codecUtil.doEncode(encPwd));
			
			      //check data with validator 
		      String msg=validator.doValidateUserEmail(userObj.getUserEmail());
			    if(msg!=null){
		            //data has error
		           return msg;
			     }
			    else
			      {
		        //save data-no error
			    //5.save data to d
		      int userId=service.saveUser(userObj);
			    //6.send email
			    if(userId!=0)
			       {
		   String subject="Hello Mr/Ms/Mrs. "+userObj.getUserName()+".This is regarding registration to User.";
		   String message="You are Successfully registered as a User.Your Password is: "+Pwd+" and accessToken is: "+Token +"  User Name is :"+userObj.getUserEmail();
			  commonUtil.sendEmail(userObj.getUserEmail(), subject, message);
			       }
			    //7.send message to UI
			  if(userId!=0)
				return "User saved with Id:"+userId;
			   else
				return "User not saved..";
		         }
	        }	
   //===========Login Consumer in  DB=============      
		@POST
		@Path("/loginUser")
		public String loginUser(
				@HeaderParam("username")String un,
				@HeaderParam("password")String pwd){
			
			  String json=null;
			//user name should not be empty or null
			  if(un==null || "".equals(un.trim()))
				return json;
			// encode the user password
			   String encPwd=codecUtil.doEncode(pwd);
		     User user=service.getUserByUmailAndPwd(un, encPwd);
		     if(user!=null)
		        {
		    	//1.convert obj to json
			        json=jsonUtil.convertObjToJson(user);
		    	return  json; 
		        }
		     return json;
		   }
	}
