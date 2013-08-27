package com.appwx.sdk.demo.satellitemenu;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import com.appwx.sdk.satellitemenu.SatelliteMenu;
import com.appwx.sdk.satellitemenu.SatelliteMenu.SateliteClickedListener;
import com.appwx.sdk.satellitemenu.SatelliteMenuItem;
import com.appwx.sdk.common.Loger;
import com.appwx.sdk.demo.R;

public class SatelliteMenuActivity extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.satellitemenu_main);
        
        SatelliteMenu menu = (SatelliteMenu) findViewById(R.id.menu);
        
//		  Set from XML, possible to programmatically set        
//        float distance = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 170, getResources().getDisplayMetrics());
//        menu.setSatelliteDistance((int) distance);
//        menu.setExpandDuration(500);
//        menu.setCloseItemsOnClick(false);
//        menu.setTotalSpacingDegree(60);
        
        List<SatelliteMenuItem> items = new ArrayList<SatelliteMenuItem>();
        items.add(new SatelliteMenuItem(1, R.drawable.ic_1));
        items.add(new SatelliteMenuItem(2, R.drawable.ic_2));
        items.add(new SatelliteMenuItem(3, R.drawable.ic_3));
        items.add(new SatelliteMenuItem(4, R.drawable.ic_4));
        items.add(new SatelliteMenuItem(5, R.drawable.ic_5));
        items.add(new SatelliteMenuItem(6, R.drawable.ic_6));
        menu.addItems(items);  
        menu.setOnItemClickedListener(new SateliteClickedListener() {
			
			public void eventOccured(int id) {
				Loger.log("sat", "Clicked on " + id);
			}
		});
    }
}