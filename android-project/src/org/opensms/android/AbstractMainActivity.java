package org.opensms.android;

import org.opensms.android.fragment.adapter.CustomerFragmentPager;
import org.opensms.android.fragment.adapter.ItemFragmentPager;
import org.opensms.android.fragment.adapter.SalesPersonsFragmentPager;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.astuetz.viewpager.extensions.PagerSlidingTabStrip;
import com.darvds.ribbonmenu.RibbonMenuView;
import com.darvds.ribbonmenu.iRibbonMenuCallback;

public class AbstractMainActivity extends SherlockFragmentActivity implements
		iRibbonMenuCallback{
	
	
	private static AbstractMainActivity activity;
	/** Called when the activity is first created. */
	private RibbonMenuView rbmView;
	private PagerSlidingTabStrip tabs;
	private ViewPager pager;
	private FragmentPagerAdapter adapter;


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
		adapter = new SalesPersonsFragmentPager(getSupportFragmentManager());
		pager.setAdapter(adapter);

		final int pageMargin = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
						.getDisplayMetrics());
		pager.setPageMargin(pageMargin);

		tabs.setViewPager(pager);

		getSupportActionBar().setHomeButtonEnabled(true);
		
		if(activity==null){
			activity=AbstractMainActivity.this;
		}

	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			rbmView.toggleMenu();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private Handler handler = new Handler();

	/**
	 * Ribbon menu item click listner
	 * 
	 */
	@Override
	public void RibbonMenuItemClick(int itemId) {
		Log.i("Working 82", itemId+"");

		FragmentPagerAdapter pagerAdapter = null;

		switch (itemId) {
		case R.id.ribbon_menu_home:

		{

			pagerAdapter = new SalesPersonsFragmentPager(getSupportFragmentManager());
			
		}

			break;
		case R.id.ribbon_menu_home2:

		{
			pagerAdapter = new CustomerFragmentPager(getSupportFragmentManager());
			
		}

			break;

		case R.id.ribbon_menu_home3:

		{
			pagerAdapter = new ItemFragmentPager(getSupportFragmentManager());
		}

			break;

		default:
			break;
		}

		updatePager(pagerAdapter);
		

	}
	
	private void updatePager(final FragmentPagerAdapter adapter){
		this.adapter=adapter;
		this.adapter.notifyDataSetChanged();
		handler.post(new Runnable() {

			@Override
			public void run() {
				
				pager.setAdapter(AbstractMainActivity.this.adapter);
			
				tabs.setViewPager(pager);

			}
		});
	}

	

}
