package org.opensms.android.fragment.salesperson;

import org.opensms.android.R;
import org.opensms.android.fragment.AbstractPageFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Dash board view Controller
 * 
 * @author dewmal
 *
 */
public class DashBoard extends AbstractPageFragment{
	/**
	 * Logging
	 */
	private static final String TAG = DashBoard.class.getName();
	
	
	

	public DashBoard() {
		super();	
		setFragment_name("Dash Board");
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
		View view = inflater.inflate(R.layout.salesperson_dashboard_layout,container, false);
		TextView tvTitle= (TextView) view.findViewById(R.id.salesperson_view_title);
		tvTitle.setText("I am dashboard");		
		
		
		FragmentActivity activity = getActivity();
		Log.i(TAG, activity+" ");
		return view;
	}
	
	
	
	

}
