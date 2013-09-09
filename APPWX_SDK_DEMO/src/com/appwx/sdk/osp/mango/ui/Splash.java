package com.appwx.sdk.osp.mango.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.appwx.sdk.demo.R;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final View view = View.inflate(this, R.layout.mango_splash, null);
		setContentView(view);
		
		//����չʾ������
		AlphaAnimation aa = new AlphaAnimation(0.3f,1.0f);
		aa.setDuration(3000);
		view.startAnimation(aa);
		aa.setAnimationListener(new AnimationListener()
		{
			@Override
			public void onAnimationEnd(Animation arg0) {
				redirectTo();
			}
			@Override
			public void onAnimationRepeat(Animation animation) {}
			@Override
			public void onAnimationStart(Animation animation) {}
			
		});
		
	}
	
	/**
     * ��ת��...
     */
    private void redirectTo(){        
        Intent intent = new Intent(Splash.this,Register.class);
        startActivity(intent);
        finish();
    }
}
