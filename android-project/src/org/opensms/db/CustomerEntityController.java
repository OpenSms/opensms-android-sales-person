package org.opensms.db;

import org.opensms.android.R;
import org.opensms.db.entity.Customer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import android.content.Context;
import android.os.AsyncTask;

public class CustomerEntityController {

	private final static String TAG = TodoListController.class.getName();
	private static String url = "/customer/";
	private Context context;

	public CustomerEntityController(Context context) {
		this.context = context;
	}

	public CustomerEntityController.CustomerSave getCustomerSave() {
		return new CustomerSave();
	}
	
	public CustomerEntityController.CustomerGet getCustomerGet() {
		return new CustomerGet();
	}

	public class CustomerGet extends AsyncTask<String, Void, Customer> {

		@Override
		protected Customer doInBackground(String... params) {
			HttpHeaders httpHeaders = AuthenticationController
					.getAuthentication();
			String url = context.getString(R.string.server_url)
					+ CustomerEntityController.url + "get_view";
			RestTemplate restTemplate = new RestTemplate();

			restTemplate.getMessageConverters().add(
					new MappingJacksonHttpMessageConverter());

			String emp_id = params[0];
			
			UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
					.fromUriString(url).queryParam("query", emp_id);

			HttpEntity<?> requestEntity = new HttpEntity<Object>(httpHeaders);
			// Make the HTTP GET request, marshaling the response to a String
			ResponseEntity<Customer> response = restTemplate.exchange(
					uriComponentsBuilder.build().toUri(), HttpMethod.GET,
					requestEntity, Customer.class);

			return response.getBody();
		}

	}

	public class CustomerSave extends AsyncTask<Customer, Void, Void> {

		private CustomerSave() {

		}

		@Override
		protected Void doInBackground(Customer... params) {

			HttpHeaders httpHeaders = AuthenticationController
					.getAuthentication();

			Customer customer = params[0];
			String url = context.getString(R.string.server_url)
					+ CustomerEntityController.url + "save";
			RestTemplate restTemplate = new RestTemplate();

			restTemplate.getMessageConverters().add(
					new MappingJacksonHttpMessageConverter());
			restTemplate
					.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

			HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(
					customer, httpHeaders);

			restTemplate.exchange(url, HttpMethod.PUT, requestEntity,
					Void.class);

			return null;
		}

	}

	private RestTemplate createRestTemplate(String url_suf) {
		String url = context.getString(R.string.server_url)
				+ CustomerEntityController.url + "save";
		RestTemplate restTemplate = new RestTemplate();

		restTemplate.getMessageConverters().add(
				new MappingJacksonHttpMessageConverter());
		return restTemplate;
	}

}
