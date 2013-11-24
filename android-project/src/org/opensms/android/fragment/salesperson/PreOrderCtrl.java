package org.opensms.android.fragment.salesperson;

import org.opensms.android.AbstractMainActivity;
import org.opensms.android.R;
import org.opensms.android.fragment.AbstractPageFragment;
import org.opensms.android.fragment.FragmentAccess;
import org.opensms.android.fragment.ViewHolder;
import org.opensms.android.fragment.salesperson.view.SelectItemDialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PreOrderCtrl extends AbstractPageFragment{

	/**
	 * Logging
	 */
	private static final String TAG = PreOrderCtrl.class.getName();
	
	
	

	public PreOrderCtrl() {
		super();	
		setFragment_name("Preorder");
		
		

	}




	/**
	 * 
	 * Create sales persons dash-board view
	 * 
	 */
	@Override
	public View onCreateView(final LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {	
		Log.d(TAG, "load dashboard view");
		View view = inflater.inflate(R.layout.salesperson_preorder_layout,container, false);
		TextView tvTitle= (TextView) view.findViewById(R.id.salesperson_view_title);
		tvTitle.setText("I am dashboard");		
		
		
		Button button = (Button) view.findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				SelectItemDialog dialog=new SelectItemDialog(getActivity());
				dialog.show();
				
			}
		});
	
	//	
		
		return view;
	}
	
	
}
