package com.friends.client;

import javax.ws.rs.core.MediaType;

import com.friends.util.CodecUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {
	
	//============================Save User in Provider DB=================================
		public static String connectToProviderToSaveUser(String json){
			String url="http://localhost:8084/FriendsProvider/rest/userService/saveUser";
			String msg=null;
			try {
				Client c=Client.create();
				WebResource r=c.resource(url);
				ClientResponse cr=r.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, json);
				msg=cr.getEntity(String.class);

			   } catch (Exception e) {e.printStackTrace();}
			return msg;
		  }
	//===============================Update User in Friends Provider DB============================
			public static String connectToProviderToUpdateUser(String json){
				String url="http://localhost:8084/FriendsProvider/rest/userService/updateUser";
				String msg=null;
				try {
					Client c=Client.create();
					WebResource r=c.resource(url);
					ClientResponse cr=r.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, json);
					msg=cr.getEntity(String.class);

				   } catch (Exception e) {e.printStackTrace();}
				return msg;
			  }
	
	//============================Login User into Friends Provider DB===============================
			public static String connectToProviderToLoginUser(String userEmail,String Pwd){
				String url="http://localhost:8084/FriendsProvider/rest/userService/loginUser";
				String un=userEmail;
				String pwd=Pwd;
				String json=null;
				try {
					Client c=Client.create();
					WebResource r=c.resource(url);

					ClientResponse cr=r.type(MediaType.APPLICATION_JSON)
										.header("username",un)
										.header("password", CodecUtil.doEncode(pwd))
										.post(ClientResponse.class);
					json=cr.getEntity(String.class);
				   } catch (Exception e) {
					e.printStackTrace();
				   }
				return json;
			  }
			
}
