package org.opensms.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.opensms.android.R;
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

public class TodoListController extends AsyncTask<String, Void, TripData>{
	
	private static String TAG=TodoListController.class.getName();
	private static String url="/todo/";
	private Context context;
	
	public TodoListController(Context context){
		this.context = context;
		
	}
	

	public TripData getTripData(String emp_id) {
		
		String url=context.getString(R.string.server_url)+this.url+"list";
		
		
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
			// Make the network request
			
			
			
			
			Log.d(TAG, url);

			Map<String, String> urlVariables = new HashMap<String, String>();
			urlVariables.put("sales_person", emp_id);

			
			
		
			UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(url).queryParam("sales_person", emp_id);
			
			HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
			

			// Make the HTTP GET request, marshaling the response to a String
			ResponseEntity<TripData> response = restTemplate.exchange(uriComponentsBuilder.build().toUri(), HttpMethod.GET,requestEntity, TripData.class);
			
			
			//TripData response = restTemplate.getForObject(uriComponentsBuilder.build().toUri(), TripData.class);
			
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
	protected TripData doInBackground(String... params) {
		return getTripData(params[0]);
	}

}
