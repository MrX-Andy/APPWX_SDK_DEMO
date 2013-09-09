package com.appwx.sdk.demo.wheelmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.appwx.sdk.demo.R;
import com.appwx.sdk.wheel.wheelmenu.WheelMenu;

public class WheelMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wheelmenu);

		ImageView wheel_image = (ImageView) findViewById(R.id.wheel);

		/*
		 * Initialize new wheel menu with constructor of form :
		 * 
		 * new WheelMenu(Context, no_of_divisions_in_your_menu,
		 * drawable_to_use_as_wheel_img, imageview_for_the_wheel,
		 * flag_to_set_snap_to_center_option)
		 * 
		 * note: default option for snap_to_center flag is true
		 */
		final WheelMenu wm = new WheelMenu(WheelMenuActivity.this, 12,
				R.drawable.wheel, wheel_image, true);

		// button that shows the currently selected division in the wheel
		Button show_selected = (Button) findViewById(R.id.show_selected_button);

		show_selected.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				// use WheelMenu.getSelected() method to get the selected
				// division
				Toast.makeText(WheelMenuActivity.this,
						"selected: " + wm.getSelected(), Toast.LENGTH_SHORT)
						.show();
			}
		});

	}
}
