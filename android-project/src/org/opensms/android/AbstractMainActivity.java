package org.opensms.android;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.astuetz.viewpager.extensions.PagerSlidingTabStrip;
import com.darvds.ribbonmenu.RibbonMenuView;
import com.darvds.ribbonmenu.iRibbonMenuCallback;

public class AbstractMainActivity extends SherlockFragmentActivity implements
		iRibbonMenuCallback {
	/** Called when the activity is first created. */

	private RibbonMenuView rbmView;

	private PagerSlidingTabStrip tabs;

	private ViewPager pager;

	private MyPagerAdapter adapter;
	
	private final String[] TITLES ;
	
	
	
	

	public AbstractMainActivity(String[] tITLES) {
		TITLES = tITLES;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// setTheme(R.style.Theme_Sherlock); // Used for theme switching in
		// samples
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		rbmView = (RibbonMenuView) findViewById(R.id.ribbonMenuView1);
		rbmView.setMenuClickCallback(this);
		rbmView.setMenuItems(R.menu.ribbon_menu);

		
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);

		pager = (ViewPager) findViewById(R.id.pager);
		adapter = new MyPagerAdapter(getSupportFragmentManager());

		pager.setAdapter(adapter);

		final int pageMargin = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
						.getDisplayMetrics());
		pager.setPageMargin(pageMargin);

		tabs.setViewPager(pager);

		getSupportActionBar().setHomeButtonEnabled(true);
		
		
		
		

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Used to put dark icons on light action bar
		// boolean isLight = SampleList.THEME == R.style.Theme_Sherlock_Light;

		MenuItem item = menu.add("Save");
		item.setIcon(R.drawable.ic_launcher);
		item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);


		

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			
			TITLES[1]="ABS";
			
			adapter = new MyPagerAdapter(getSupportFragmentManager());

			
			pager.setAdapter(adapter);
			
			pager.refreshDrawableState();
			
			rbmView.toggleMenu();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public class MyPagerAdapter extends FragmentPagerAdapter {

	

		public MyPagerAdapter(FragmentManager fm) {
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

	@Override
	public void RibbonMenuItemClick(int itemId) {
		// TODO Auto-generated method stub

	}

}
