package org.opensms.android.fragment.adapter;

import org.opensms.android.fragment.salesperson.PreOrderCtrl;
import org.opensms.android.fragment.salesperson.ToDoListCtrl;

import android.support.v4.app.FragmentManager;

public class SalesPersonsFragmentPager extends AbstractFragmentPager {

	public SalesPersonsFragmentPager(FragmentManager fm) {
		super(fm);
		
		getFragments().add(new ToDoListCtrl());
		getFragments().add(new PreOrderCtrl());
	}

	

}
