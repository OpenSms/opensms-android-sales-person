package org.opensms.android.activity;

import java.util.concurrent.ExecutionException;

import org.opensms.android.AbstractMainActivity;
import org.opensms.android.R;
import org.opensms.android.fragment.FragmentAccess;
import org.opensms.android.fragment.ViewHolder;
import org.opensms.db.TodoListController;
import org.opensms.db.entity.TripData;
import org.opensms.util.TemplateProvider;

import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.BaseColumns;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.SearchView;
import com.activeandroid.util.Log;

public class OpenSmsActivity extends AbstractMainActivity implements
		SearchView.OnQueryTextListener, FragmentAccess,
		SearchView.OnSuggestionListener {

	private SuggestionsAdapter mSuggestionsAdapter;
	private static final String[] COLUMNS = { BaseColumns._ID,
			SearchManager.SUGGEST_COLUMN_TEXT_1, };

	public OpenSmsActivity() {
		super();
		// ViewHolder.getViewHolder().setAccess(this);

	}

	Handler handler = new Handler();
	private SearchView searchItemView;
	private MenuItem miSearch;
	private static final String tag = OpenSmsActivity.class.getName();

	public void updateView(final String text) {

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewHolder.getViewHolder().setAccess(this);

		TodoListController todoListController = new TodoListController(this);
		AsyncTask<String, Void, TripData> tripData = todoListController.execute("86");
		
		 	
		try {
			tripData.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.i(tag, tripData+"");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Used to put dark icons on light action bar
		// boolean isLight = SampleList.THEME == R.style.Theme_Sherlock_Light;

		MenuItem item = menu.add("Save");

		item.setIcon(R.drawable.ic_launcher);
		item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

		// Create the search view
		searchItemView = new SearchView(getSupportActionBar()
				.getThemedContext());
		searchItemView.setQueryHint("Item or customer…");
		searchItemView.setOnQueryTextListener(this);
		searchItemView.setOnSuggestionListener(this);

		if (mSuggestionsAdapter == null) {
			MatrixCursor cursor = new MatrixCursor(COLUMNS);
			cursor.addRow(new String[] { "1", "'Murica" });
			cursor.addRow(new String[] { "2", "Canada" });
			cursor.addRow(new String[] { "3", "Denmark" });
			mSuggestionsAdapter = new SuggestionsAdapter(getSupportActionBar()
					.getThemedContext(), cursor);
		}

		searchItemView.setSuggestionsAdapter(mSuggestionsAdapter);

		miSearch = menu.add("Search");
		miSearch.setIcon(R.drawable.abs__ic_search);
		miSearch.setActionView(searchItemView);
		miSearch.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM
				| MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
		miSearch.setVisible(true);

		return true;
	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		Toast.makeText(this, "You searched for: " + query, Toast.LENGTH_LONG)
				.show();
		return true;
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		return false;
	}

	@Override
	public boolean onSuggestionSelect(int position) {
		return false;
	}

	@Override
	public boolean onSuggestionClick(int position) {
		Cursor c = (Cursor) mSuggestionsAdapter.getItem(position);
		String query = c.getString(c
				.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1));
		Toast.makeText(this, "Suggestion clicked: " + query, Toast.LENGTH_LONG)
				.show();
		return true;
	}

	private class SuggestionsAdapter extends CursorAdapter {

		public SuggestionsAdapter(Context context, Cursor c) {
			super(context, c, 0);
		}

		@Override
		public View newView(Context context, Cursor cursor, ViewGroup parent) {
			LayoutInflater inflater = LayoutInflater.from(context);
			View v = inflater.inflate(android.R.layout.simple_list_item_1,
					parent, false);
			return v;
		}

		@Override
		public void bindView(View view, Context context, Cursor cursor) {
			TextView tv = (TextView) view;
			final int textIndex = cursor
					.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1);
			tv.setText(cursor.getString(textIndex));
		}
	}

}
