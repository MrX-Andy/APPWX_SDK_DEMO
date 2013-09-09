package com.appwx.sdk.osp;

import java.util.ArrayList;
import java.util.List;

import com.appwx.sdk.demo.R;
import com.appwx.sdk.osp.mango.ui.Splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	ListView mListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mListView = (ListView) findViewById(R.id.mainList);

		List<String> data = new ArrayList<String>();

		for (int i = 0; i < mStrDemos.length; i++) {
			data.add(mStrDemos[i]);
		}

		mListView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data));

		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View covertView,
					int position, long id) {
				if (position < 0 || position >= mActivities.length + 1)
					return;
				startActivity(new Intent(MainActivity.this,
						mActivities[position]));
			}

		});
	}
	
	String mStrDemos[] = {"¿ªÐÄÃ¢¹û(Mango)"};

	Class<?> mActivities[] = {Splash.class};
}
