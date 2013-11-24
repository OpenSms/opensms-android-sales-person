package org.opensms.android.fragment.adapter;

import org.opensms.android.CardFragmentGenerator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ItemFragmentPager extends FragmentPagerAdapter {

	String TITLES[] = new String[] { "Items ", "To-Do List",
			"Qucik Reports" };

	public ItemFragmentPager(FragmentManager fm) {
		super(fm);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return TITLES[position];
	}

	@Override
	public int getCount() {
		return TITLES.length;
	}

	@Override
	public Fragment getItem(int position) {

		return CardFragmentGenerator.newInstance(position);
	}

}
