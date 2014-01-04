package org.opensms.android.fragment.adapter;

import org.opensms.android.fragment.customer.CustomerList;
import org.opensms.android.fragment.customer.RegisterCustomer;

import android.support.v4.app.FragmentManager;

public class CustomerFragmentPager extends AbstractFragmentPager {

	public CustomerFragmentPager(FragmentManager fm) {
		super(fm);
		getFragments().add(new RegisterCustomer());
		getFragments().add(new CustomerList());
	}

}
