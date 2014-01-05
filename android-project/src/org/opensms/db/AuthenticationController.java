package org.opensms.db;

import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpHeaders;

public class AuthenticationController {
	
	/**
	 * Get authentication for requests
	 * 
	 * @return
	 */
	public static HttpHeaders getAuthentication(){
		HttpBasicAuthentication authentication=new HttpBasicAuthentication("Yaka", "pass");
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.setAuthorization(authentication);
		httpHeaders.set("Connection", "Close");		
		return httpHeaders;
	}

}
