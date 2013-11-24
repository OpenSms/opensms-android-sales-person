package org.opensms.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class AbstractPageFragment extends Fragment{
	
	
	protected String fragment_name;
	
	
	



	public String getFragment_name() {
		return fragment_name;
	}






	protected void setFragment_name(String fragment_name) {
		this.fragment_name = fragment_name;
	}






	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
	}

}
