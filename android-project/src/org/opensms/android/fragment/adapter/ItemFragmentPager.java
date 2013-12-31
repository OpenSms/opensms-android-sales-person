package org.opensms.android.fragment.adapter;

import org.opensms.android.fragment.salesperson.DashBoard;

import android.support.v4.app.FragmentManager;

public class ItemFragmentPager extends AbstractFragmentPager {

	public ItemFragmentPager(FragmentManager fm) {
		super(fm);
		getFragments().add(new DashBoard());
	}

}
