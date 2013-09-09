package com.appwx.sdk.demo.imageview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.appwx.sdk.appmsg.AppMsg;
import com.appwx.sdk.common.Loger;
import com.appwx.sdk.demo.R;
import com.appwx.sdk.imageview.SmartImageTask;
import com.appwx.sdk.imageview.SmartImageView;
import com.appwx.sdk.imageview.WebImageCache;

public class SmartImageViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.smartimageview_main);

		SmartImageView smartImageView = (SmartImageView) findViewById(R.id.smartImage);

		smartImageView
				.setImageUrl(
						"http://www.zhaoshang800.com/images/yuanqu/pic/201305301548322877.jpg",
						R.drawable.main, R.drawable.ic_launcher,
						new SmartImageTask.OnCompleteListener() {

							@Override
							public void onComplete() {
								Loger.log("加载完成");

							}
						});

		findViewById(R.id.clearCache).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new WebImageCache(SmartImageViewActivity.this).clear();
				AppMsg.makeText(SmartImageViewActivity.this, "清除成功",
						AppMsg.STYLE_INFO).show();
			}
		});

	}

}
