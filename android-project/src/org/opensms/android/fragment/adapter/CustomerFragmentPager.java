package org.opensms.android.fragment.adapter;

import org.opensms.android.fragment.salesperson.DashBoard;

import android.support.v4.app.FragmentManager;

public class CustomerFragmentPager extends AbstractFragmentPager {

	public CustomerFragmentPager(FragmentManager fm) {
		super(fm);
		getFragments().add(new DashBoard());

	}

}
