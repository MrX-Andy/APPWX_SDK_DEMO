package com.appwx.sdk.demo.slidinguppanel;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.appwx.sdk.demo.R;
import com.appwx.sdk.slidinguppanel.SlidingUpPanelLayout;
import com.appwx.sdk.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener;

public class SlidingUpPanelActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		setContentView(R.layout.activity_slidinguppanel);
		
		SlidingUpPanelLayout layout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        layout.setShadowDrawable(getResources().getDrawable(R.drawable.above_shadow));
        layout.setPanelSlideListener(new PanelSlideListener() {

            @Override
            public void onPanelSlide(View panel, float slideOffset) {
//                if (slideOffset < 0.2) {
//                    if (getActionBar().isShowing()) {
//                        getActionBar().hide();
//                    }
//                } else {
//                    if (!getActionBar().isShowing()) {
//                        getActionBar().show();
//                    }
//                }
            }

            @Override
            public void onPanelExpanded(View panel) {


            }

            @Override
            public void onPanelCollapsed(View panel) {


            }
        });
        TextView t = (TextView) findViewById(R.id.brought_by);
        t.setMovementMethod(LinkMovementMethod.getInstance());
	}
	
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.activity_menu, menu);
	        return true;
	    }
}
