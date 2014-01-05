package org.opensms.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.opensms.android.R;
import org.opensms.db.entity.PreOrder;
import org.opensms.db.entity.TripData;
import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class PreOrderListController extends AsyncTask<String, Void, PreOrder[]>{
	
	private static String TAG=PreOrderListController.class.getName();
	private static String url="/preorder/";
	private Context context;
	
	public PreOrderListController(Context context){
		this.context = context;
		
	}
	

	public PreOrder[] getPreOrders(String customer_id) {
		
		String url=context.getString(R.string.server_url)+this.url+"all/customer";
		
		
		// Populate the HTTP Basic Authentitcation header with the username and
		// password
		HttpAuthentication authHeader = new HttpBasicAuthentication("Yaka",
				"pass");
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAuthorization(authHeader);
		requestHeaders.setAccept(Collections
				.singletonList(MediaType.APPLICATION_JSON));

		

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJacksonHttpMessageConverter());

		try {
			Log.d(TAG, url);
			UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(url).
					queryParam("customerid", customer_id);
			
			HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
			

			// Make the HTTP GET request, marshaling the response to a String
			ResponseEntity<PreOrder[]> response = restTemplate.exchange(uriComponentsBuilder.build().toUri(), HttpMethod.GET,requestEntity, PreOrder[].class);
			
			Log.d(TAG, response+"");			
			return response.getBody();
			

		} catch (HttpClientErrorException e) {
			Log.e(TAG, e.getLocalizedMessage(), e);

		} catch (ResourceAccessException e) {
			Log.e(TAG, e.getLocalizedMessage(), e);

		}
		
		return null;

	}


	@Override
	protected PreOrder[] doInBackground(String... params) {
		return getPreOrders(params[0]);
	}

}
