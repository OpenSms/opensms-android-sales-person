package org.opensms.android.fragment.salesperson;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.opensms.android.R;
import org.opensms.android.fragment.AbstractPageFragment;
import org.opensms.android.fragment.salesperson.view.CustomerSelectListner;
import org.opensms.android.fragment.salesperson.view.SelectCustomerDialog;
import org.opensms.db.PreOrderListController;
import org.opensms.db.entity.Customer;
import org.opensms.db.entity.PreOrder;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

public class GsrOrderCtrl extends AbstractPageFragment implements CustomerSelectListner{

	private static final String TAG = GsrOrderCtrl.class.getName();
	
	

	private List<PreOrder> preOrders;
	
	
	private SelectCustomerDialog customerDialog;
	private PreOrderListController preOrderListController;
	private Customer customer;
	
	
	private Button btAddCustomer;
	private ListView listView;

	
	
	
	
	public GsrOrderCtrl() {
		super();
		setFragment_name("Gsr Order");
	}


	/**
	 * 
	 * Create sales persons dash-board view
	 * 
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {	
		
		preOrderListController=new PreOrderListController(getActivity());
		Log.d(TAG, "load dashboard view");
		View view = inflater.inflate(R.layout.salesperson_gsr_order,container, false);
		
		btAddCustomer=(Button) view.findViewById(R.id.btSalesperson_gsr_order_addCustomer);		
		btAddCustomer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				onAddCustomer(view);
				
			}
		});
	
		
		
		return view;
	}
	

	public void onAddCustomer(View view){		
		customerDialog=new SelectCustomerDialog(getActivity(),this);
		customerDialog.show();	
		
	}


	@Override
	public void setCustomer(Customer customer) {		
		this.customer = customer;
		customerDialog.dismiss();
		PreOrder[] preOrders2 = null;
		try {
			preOrders2 = preOrderListController.execute(customer.getUser_id()+"").get();			
			preOrders=Arrays.asList(preOrders2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Log.i(TAG, preOrders2+"");
		
	}

}
