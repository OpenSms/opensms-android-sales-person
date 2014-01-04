package org.opensms.android.fragment.customer;

import java.util.ArrayList;
import java.util.List;

import org.opensms.android.R;
import org.opensms.android.fragment.AbstractPageFragment;
import org.opensms.android.fragment.salesperson.view.TodoListAdapter;
import org.opensms.db.entity.PreOrder;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class CustomerList extends AbstractPageFragment{
	
	
	private ExpandableListView expListView;
	
	
	/**
	 * Logging
	 */
	private static final String TAG = CustomerList.class.getName();
	
	
	

	public CustomerList() {
		super();	
		setFragment_name("To Do List");
		
		
	
			

		
		
		
		
	}




	/**
	 * 
	 * Create sales persons dash-board view
	 * 
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {	
		Log.d(TAG, "load dashboard view");
		View view = inflater.inflate(R.layout.salesperson_todolist_layout,container, false);
		TextView tvTitle= (TextView) view.findViewById(R.id.salesperson_view_title);
		tvTitle.setText("I am To do list");	
		
		expListView=(ExpandableListView) view.findViewById(R.id.salesperson_todolist_view);		
		
		return view;
	}
	
	
	

}
