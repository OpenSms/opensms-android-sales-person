package org.opensms.android.fragment.adapter;

import java.util.ArrayList;
import java.util.List;

import org.opensms.android.fragment.AbstractPageFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public abstract class AbstractFragmentPager extends FragmentPagerAdapter {
	
	private static final List<AbstractPageFragment> FRAGMENTS=new ArrayList<AbstractPageFragment>();

	public AbstractFragmentPager(FragmentManager fm) {
		super(fm);

		FRAGMENTS.clear();
	}
	
	

	public static List<AbstractPageFragment> getFragments() {
		return FRAGMENTS;
	}



	@Override
	public CharSequence getPageTitle(int position) {
		return FRAGMENTS.get(position).getFragment_name();
	}

	@Override
	public int getCount() {
		return FRAGMENTS.size();
	}

	@Override
	public Fragment getItem(int position) {
		return FRAGMENTS.get(position);
	}
}
