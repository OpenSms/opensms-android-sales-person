package org.opensms.android;

import org.opensms.android.fragment.FragmentAccess;
import org.opensms.android.fragment.adapter.CustomerFragmentPager;
import org.opensms.android.fragment.adapter.ItemFragmentPager;
import org.opensms.android.fragment.adapter.SalesPersonsFragmentPager;

import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.os.Handler;
import android.provider.BaseColumns;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.CursorAdapter;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.SearchView;
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

		// FragmentPagerAdapter pagerAdapter = null;

		switch (itemId) {
		case R.id.ribbon_menu_home:

		{

			adapter = new SalesPersonsFragmentPager(getSupportFragmentManager());
		}

			break;
		case R.id.ribbon_menu_home2:

		{
			adapter = new CustomerFragmentPager(getSupportFragmentManager());
		}

			break;

		case R.id.ribbon_menu_home3:

		{
			adapter = new ItemFragmentPager(getSupportFragmentManager());
		}

			break;

		default:
			break;
		}

		handler.post(new Runnable() {

			@Override
			public void run() {
				// adapter = pagerAdapter;
				pager.setAdapter(adapter);
				tabs.setViewPager(pager);

			}
		});

	}

	

}
