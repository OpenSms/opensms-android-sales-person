package org.opensms.android.fragment.salesperson;

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

public class ToDoListCtrl extends AbstractPageFragment{
	
	private List<PreOrder> preOrders=new ArrayList<PreOrder>();
	
	private ExpandableListView expListView;
	
	
	/**
	 * Logging
	 */
	private static final String TAG = ToDoListCtrl.class.getName();
	
	
	

	public ToDoListCtrl() {
		super();	
		setFragment_name("To Do List");
		
		
		preOrders=new ArrayList<PreOrder>();
			
		preOrders.add(new PreOrder("H1","Horana"));
		preOrders.add(new PreOrder("H2","Colombo"));
		preOrders.add(new PreOrder("H3","Horana"));
		preOrders.add(new PreOrder("A1","Horana"));
		preOrders.add(new PreOrder("A2","Colombo"));
		preOrders.add(new PreOrder("A3","Colombo"));
		
		
		
		
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
		
		final TodoListAdapter listAdapter=new TodoListAdapter(getActivity(), preOrders);
		
		expListView.setAdapter(listAdapter);
		
		
		
		
		return view;
	}
	
	
	

}
