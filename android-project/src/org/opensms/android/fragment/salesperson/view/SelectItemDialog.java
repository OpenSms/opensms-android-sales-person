package org.opensms.android.fragment.salesperson.view;

import org.opensms.android.R;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SelectItemDialog extends Dialog{

	public SelectItemDialog(Context context) {
		super(context);
	}
	
	private ListView itemListView;
	private TextView tvSuggestion;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.salesperson_preorder_item_search);
		
		itemListView=(ListView) findViewById(R.id.salesperson_item_search_item_list_view);
		tvSuggestion=(TextView) findViewById(R.id.salesperson_item_search_item_name);
		
		adapter=new ArrayAdapter<String>(this.getContext(),
				android.R.layout.simple_list_item_1, android.R.id.text1, new String[]{"AB","XY"});
		
		
		
		itemListView.setAdapter(adapter);
		
		
		tvSuggestion.addTextChangedListener(new TextWatcher() {
		     
		    @Override
		    public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
		        // When user changed the Text
		      adapter.getFilter().filter(cs);   
		    }
		     
		    @Override
		    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
		            int arg3) {
		        // TODO Auto-generated method stub
		         
		    }
		     
		    @Override
		    public void afterTextChanged(Editable arg0) {
		        // TODO Auto-generated method stub                          
		    }
		});
	}
	
	
	

}
