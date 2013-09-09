package com.appwx.sdk.demo.poppyview;

import com.appwx.sdk.demo.R;
import com.appwx.sdk.poppyview.PoppyViewHelper;
import com.appwx.sdk.poppyview.PoppyViewHelper.PoppyViewPosition;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class ScrollViewActivity extends Activity {

	private PoppyViewHelper mPoppyViewHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.poppyview_scrollview);

		mPoppyViewHelper = new PoppyViewHelper(this, PoppyViewPosition.TOP);
		View poppyView = mPoppyViewHelper.createPoppyViewOnScrollView(R.id.scrollView, R.layout.poppyview_item);

		poppyView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(ScrollViewActivity.this, "Click me!", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
