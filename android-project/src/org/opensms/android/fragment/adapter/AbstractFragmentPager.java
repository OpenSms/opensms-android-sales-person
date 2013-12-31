package org.opensms.android.fragment.adapter;

import java.util.ArrayList;
import java.util.List;

import org.opensms.android.fragment.AbstractPageFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public abstract class AbstractFragmentPager extends FragmentPagerAdapter {

	private List<AbstractPageFragment> FRAGMENTS = null;

	public AbstractFragmentPager(FragmentManager fm) {
		super(fm);
		if(fm.getFragments()!=null){
			fm.getFragments().clear();
		}
		FRAGMENTS = new ArrayList<AbstractPageFragment>();
		FRAGMENTS.clear();

	}

	public List<AbstractPageFragment> getFragments() {
		return FRAGMENTS;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return FRAGMENTS.get(position).getFragment_name();
	}

	@Override
	public int getCount() {
		Log.i("item count", FRAGMENTS.size()+"");
		return FRAGMENTS.size();
	}

	@Override
	public Fragment getItem(int position) {
		return FRAGMENTS.get(position);
	}
}
