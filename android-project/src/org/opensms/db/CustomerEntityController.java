package org.opensms.db;

import org.opensms.android.R;
import org.opensms.db.entity.Customer;
import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.content.Context;
import android.os.AsyncTask;

public class CustomerEntityController{
	
	

	

	private static String TAG=TodoListController.class.getName();
	private static String url="/customer/";
	private Context context;
	
	public CustomerEntityController(Context context){
		this.context = context;		
	}
	
	
	public CustomerEntityController.CustomerSave getCustomerSave(){
		return new CustomerSave();
	}
	
	
	public class CustomerSave extends AsyncTask<Customer, Void, Void>{
		
		private CustomerSave(){
			
		}

		@Override
		protected Void doInBackground(Customer... params) {
			
			HttpBasicAuthentication authentication=new HttpBasicAuthentication("Yaka", "pass");
			HttpHeaders httpHeaders=new HttpHeaders();
			httpHeaders.setAuthorization(authentication);
			httpHeaders.set("Connection", "Close");
			
			
			Customer customer=params[0];
			String url=context.getString(R.string.server_url)+CustomerEntityController.url+"save";	
			RestTemplate restTemplate = new RestTemplate();	
			
			
			restTemplate.getMessageConverters().add(
					new MappingJacksonHttpMessageConverter());		
			restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
			
			 HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(customer, httpHeaders);
			
			restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Void.class);	
			
			
			return null;
		}
		
		
	}
	
	

}
