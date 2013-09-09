package com.appwx.sdk.demo.poppyview;

import com.appwx.sdk.demo.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class PoppyViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.poppyview_main);

		findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(PoppyViewActivity.this, ListViewActivity.class));
			}
		});
		findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(PoppyViewActivity.this, ScrollViewActivity.class));
			}
		});
	}

}
