package org.opensms.android.fragment.salesperson.view;

import java.util.concurrent.ExecutionException;

import org.opensms.android.R;
import org.opensms.db.CustomerEntityController;
import org.opensms.db.CustomerEntityController.CustomerGet;
import org.opensms.db.entity.Customer;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class SelectCustomerDialog extends Dialog {

	
	private CustomerEntityController customerEntityController;
	private TextView tvSuggestion;
	private Button btAddCustomer;
	private String TAG;
	private CustomerSelectListner customerSelectListner;

	public SelectCustomerDialog(Context context,CustomerSelectListner customerSelectListner) {
		super(context);
		this.customerSelectListner = customerSelectListner;
		customerEntityController=new CustomerEntityController(context);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.salesperson_gsr_order_select_customer);

		tvSuggestion = (TextView) findViewById(R.id.etSalesperson_gsr_order_select_customer_username);
		btAddCustomer=(Button) findViewById(R.id.btSalesperson_gsr_order_select_customer_search);
		

		btAddCustomer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
			onSearchSelect(view);
			}
		});
	}
	
	public void onSearchSelect(View view){		
		String username = tvSuggestion.getText().toString();		
		CustomerGet customerGet = customerEntityController.getCustomerGet();		
		Customer customer = null;
		try {
			customer = customerGet.execute(username).get();
			customerSelectListner.setCustomer(customer);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		Log.i(TAG,customer+"");
		
	}
	
	
	
	
	
	
	

}
