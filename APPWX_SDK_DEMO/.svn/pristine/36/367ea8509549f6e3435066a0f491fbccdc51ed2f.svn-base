package com.appwx.sdk.demo.refreshlistview;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.appwx.sdk.common.Loger;
import com.appwx.sdk.demo.R;
import com.appwx.sdk.refreshlistview.RefreshListView;
import com.appwx.sdk.refreshlistview.RefreshListView.OnRefreshListener;

public class PullRefreshListview extends Activity {

	private static final String TAG = "PullRefreshListview";

	private List<String> listStrings;
	private RefreshListView listRefreshListView;
	private ArrayAdapter<String> adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_refreshlistview);
		
		listStrings = getlistStrings();

		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listStrings);

		listRefreshListView = (RefreshListView) findViewById(R.id.refreshListView);
		listRefreshListView.setAdapter(adapter);
		listRefreshListView.setEnabledDate(true, new Date());
		listRefreshListView.setRefreshListener(new OnRefreshListener() {
			@Override
			public void onRefresh(RefreshListView listView) {
				new DataRetriever().execute();
			}
		});

		listRefreshListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(PullRefreshListview.this, "Position: " + position, Toast.LENGTH_SHORT).show();
			}

		});
	}
	
	private class DataRetriever extends AsyncTask<Void, Void, String> {

		@Override
		protected String doInBackground(Void... params) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				Loger.log(TAG, e.getMessage());
			}

			return "New API 18 - Jeremie Martinez";
		}

		@Override
		protected void onPostExecute(String newApi) {
			if (newApi != null) {
				listStrings.add(0, newApi);
				// Notify adapter, data changed
				adapter.notifyDataSetChanged();
			} else {
				// Error case
				listRefreshListView.errorInRefresh("堤賸渣賸");
			}
			// call on RefreshListView to hide header and notify the listview, refreshing is done
			listRefreshListView.finishRefreshing();
		}
	}
	
	private List<String> getlistStrings() {
		listStrings = new ArrayList<String>();
		listStrings.add("Android 1.5 Cupcake (API level 3)");
		listStrings.add("Android 1.6 Donut (API level 4)");
		listStrings.add("Android 2.0 Eclair (API level 5)");
		listStrings.add("Android 2.0.1 Eclair (API level 6)");
		listStrings.add("Android 2.1 Eclair (API level 7)");
		listStrings.add("Android 2.2每2.2.3 Froyo (API level 8)");
		listStrings.add("Android 2.3每2.3.2 Gingerbread (API level 9)");
		listStrings.add("Android 2.3.3每2.3.7 Gingerbread (API level 10)");
		listStrings.add("Android 3.0 Honeycomb (API level 11)");
		listStrings.add("Android 3.1 Honeycomb (API level 12)");
		listStrings.add("Android 3.2 Honeycomb (API level 13)");
		listStrings.add("Android 4.0每4.0.2 Ice Cream Sandwich (API level 14)");
		listStrings.add("Android 4.0.3每4.0.4 Ice Cream Sandwich (API level 15)");
		listStrings.add("Android 4.1 Jelly Bean (API level 16)");
		listStrings.add("Android 4.2 Jelly Bean (API level 17)");
		return listStrings;
	}
}
