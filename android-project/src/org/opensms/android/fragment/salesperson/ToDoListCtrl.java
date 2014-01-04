package org.opensms.android.fragment.salesperson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.opensms.android.R;
import org.opensms.android.fragment.AbstractPageFragment;
import org.opensms.android.fragment.salesperson.view.TodoListAdapter;
import org.opensms.db.TodoListController;
import org.opensms.db.entity.PreOrder;
import org.opensms.db.entity.ToDo;
import org.opensms.db.entity.TripData;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class ToDoListCtrl extends AbstractPageFragment {

	private ExpandableListView expListView;

	private TripData tripData;

	/**
	 * Logging
	 */
	private static final String TAG = ToDoListCtrl.class.getName();

	public ToDoListCtrl() {
		super();
		setFragment_name("To Do List");

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		tripData = new TripData();

		TodoListController todoListController = new TodoListController(
				getActivity());
		AsyncTask<String, Void, TripData> tripData = todoListController
				.execute("86");
		try {
			this.tripData = tripData.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		View view = inflater.inflate(R.layout.salesperson_todolist_layout,
				container, false);
		TextView tvTitle = (TextView) view
				.findViewById(R.id.salesperson_view_title);
		tvTitle.setText("I am To do list");

		expListView = (ExpandableListView) view
				.findViewById(R.id.salesperson_todolist_view);

		final TodoListAdapter listAdapter = new TodoListAdapter(getActivity(),
				tripData.getPreOrders(), tripData.getCustomers());

		expListView.setAdapter(listAdapter);

		return view;
	}

}
