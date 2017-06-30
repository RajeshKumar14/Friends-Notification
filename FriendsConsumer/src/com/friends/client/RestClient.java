package com.friends.client;

import javax.ws.rs.core.MediaType;

import com.friends.util.CodecUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {
	
	//============================Save Seller in Vendor DB=================================
		public static String connectToProviderToSaveSeller(String json){
			String url="http://localhost:8084/Online_Shopping_Cart/rest/sellerService/saveSeller";
			String msg=null;
			try {
				Client c=Client.create();
				WebResource r=c.resource(url);

				ClientResponse cr=r.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, json);
				msg=cr.getEntity(String.class);

			   } catch (Exception e) {e.printStackTrace();}
			return msg;
		  }
	//===============================Update Seller in Vendor DB============================
			public static String connectToProviderToUpdateSeller(String json){
				String url="http://localhost:8084/Online_Shopping_Cart/rest/sellerService/updateSeller";
				String msg=null;
				try {
					Client c=Client.create();
					WebResource r=c.resource(url);
					ClientResponse cr=r.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, json);
					msg=cr.getEntity(String.class);

				   } catch (Exception e) {e.printStackTrace();}
				return msg;
			  }
	
	//============================Login Seller in Vendor DB===============================
			public static String connectToProviderToLoginSeller(String sellerEmail,String Pwd){
				String url="http://localhost:8084/Online_Shopping_Cart/rest/sellerService/loginSeller";
				String un=sellerEmail;
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
