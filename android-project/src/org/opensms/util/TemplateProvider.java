package org.opensms.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.opensms.db.entity.Category;
import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import android.util.Log;

public class TemplateProvider {

	private static final String TAG = TemplateProvider.class.getCanonicalName();

	public void connect(String base_url) {
		final String url = base_url + "/category/all";

		// Populate the HTTP Basic Authentitcation header with the username and
		// password
		HttpAuthentication authHeader = new HttpBasicAuthentication("e3e344mp3",
				"pass");
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAuthorization(authHeader);
		requestHeaders.setAccept(Collections
				.singletonList(MediaType.APPLICATION_JSON));

		// Create a new RestTemplate instance

		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());

		try {
			// Make the network request
			Log.d(TAG, url);
			
			Map<String, String> urlVariables=new HashMap<String, String>(); 
			urlVariables.put("hint", "s");
			
			ResponseEntity<Category[]> response = restTemplate.getForEntity(url, Category[].class, urlVariables);

			Log.i(TAG, response.getBody().length+"");

		} catch (HttpClientErrorException e) {
			Log.e(TAG, e.getLocalizedMessage(), e);

		} catch (ResourceAccessException e) {
			Log.e(TAG, e.getLocalizedMessage(), e);

		}

	}

}
