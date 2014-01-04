package org.opensms.android.fragment.customer;

import java.util.concurrent.ExecutionException;

import org.opensms.android.R;
import org.opensms.android.fragment.AbstractPageFragment;
import org.opensms.db.CustomerEntityController;
import org.opensms.db.entity.Customer;
import org.opensms.db.entity.Location;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * 
 * Register new customer on database
 * 
 * @author dewmal
 *
 */
public class RegisterCustomer extends AbstractPageFragment{
	
	/**
	 * Logging
	 */
	private static final String TAG = RegisterCustomer.class.getName();
	
	
	

	public RegisterCustomer() {
		super();	
		setFragment_name("Register");
	}


	
	private EditText etFristName;
	private EditText etContactNumber;
	private EditText etEmail;
	private EditText etUserName;
	private EditText etNic;
	private EditText etStreetAddress;
	private EditText etCity;
	private EditText etPostalCode;
	private EditText etProvince;
	
	
	private Button btClear;
	private Button btSave;
	
	
	
	private void saveCustomer(){
		//Get Data from feilds
		String firstName = etFristName.getText().toString();
		String contactNumber = etContactNumber.getText().toString();
		String email = etEmail.getText().toString();
		String username = etUserName.getText().toString();
		String nicNumber = etNic.getText().toString();
		
		String streetAddress = etContactNumber.getText().toString();
		String city = etEmail.getText().toString();
		String province = etUserName.getText().toString();
		String postalcode = etNic.getText().toString();
		
		//Create Customer Object
		Customer customer=new Customer();
		customer.setContactNumber(contactNumber);
		customer.setEmail(email);
		customer.setFirstName(firstName);
		customer.setUsername(username);
		customer.setNicNumber(nicNumber);
		
		Location location=new Location();
		location.setCity(city);
		location.setPostalcode(postalcode);
		location.setProvince(province);
		location.setStreet(streetAddress);
		
		customer.setLocation(location);
		
	
		
		
		//Save Customer
		
		
		
		CustomerEntityController controller=new CustomerEntityController(getActivity());
		try {
			controller.getCustomerSave().execute(customer).get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void clearAllFeilds(){
		
		etFristName.setText("");
		etContactNumber.setText("");
		etEmail.setText("");
		etUserName.setText("");
		etNic.setText("");
		
		etStreetAddress.setText("");
		etCity.setText("");
		etProvince.setText("");
		etPostalCode.setText("");
		
		
		
	}


	/**
	 * 
	 * Create sales persons dash-board view
	 * 
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {	
		Log.d(TAG, "load customer register view");
		View view = inflater.inflate(R.layout.customer_register_layout,container, false);
		//Initializing ui
		etFristName=(EditText) view.findViewById(R.id.et_customer_register_name);
		etContactNumber=(EditText) view.findViewById(R.id.et_customer_register_contact_number);
		etEmail=(EditText) view.findViewById(R.id.et_customer_register_email);
		etUserName=(EditText) view.findViewById(R.id.et_customer_register_user_name);
		etNic=(EditText) view.findViewById(R.id.et_customer_register_nic);
		
		etStreetAddress=(EditText) view.findViewById(R.id.et_customer_register_location_street);
		etCity=(EditText) view.findViewById(R.id.et_customer_register_location_city);
		etProvince=(EditText) view.findViewById(R.id.et_customer_register_location_province);
		etPostalCode=(EditText) view.findViewById(R.id.et_customer_register_location_postalcode);
		
		btClear=(Button) view.findViewById(R.id.bt_customer_register_reset);
		btSave=(Button) view.findViewById(R.id.bt_customer_register_save);
		
		btSave.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				saveCustomer();				
			}
		});
		
		btClear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				clearAllFeilds();
				
			}
		});
		
	
		return view;
	}
	
	
	
	
	
	

}
