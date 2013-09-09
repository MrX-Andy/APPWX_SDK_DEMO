package com.appwx.sdk.demo.poppyview;

import com.appwx.sdk.demo.R;
import com.appwx.sdk.poppyview.PoppyViewHelper;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class ListViewActivity extends Activity {

	private String[] songs = this.getResources().getStringArray(R.array.countries);

	private PoppyViewHelper mPoppyViewHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.poppyview_listview);

		mPoppyViewHelper = new PoppyViewHelper(this);
		View poppyView = mPoppyViewHelper.createPoppyViewOnListView(
				R.id.listView1, R.layout.poppyview_item,
				new AbsListView.OnScrollListener() {
					@Override
					public void onScrollStateChanged(AbsListView view,
							int scrollState) {
						Log.d("ListViewActivity", "onScrollStateChanged");
					}

					@Override
					public void onScroll(AbsListView view,
							int firstVisibleItem, int visibleItemCount,
							int totalItemCount) {
						Log.d("ListViewActivity", "onScroll");
					}
				});

		poppyView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(ListViewActivity.this, "Click me!",
						Toast.LENGTH_SHORT).show();
			}
		});

		final ListView listView1 = (ListView) findViewById(R.id.listView1);
		listView1.setAdapter(new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				if (convertView == null) {
					convertView = getLayoutInflater().inflate(
							R.layout.poppyview_listview_item, null);
				}
				((TextView) convertView).setText(getItem(position));
				return convertView;
			}

			@Override
			public long getItemId(int position) {
				return songs[position].hashCode();
			}

			@Override
			public String getItem(int position) {
				return songs[position];
			}

			@Override
			public int getCount() {
				return songs.length;
			}
		});
	}

}
