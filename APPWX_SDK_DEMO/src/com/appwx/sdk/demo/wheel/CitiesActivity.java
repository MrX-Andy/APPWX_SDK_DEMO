package com.appwx.sdk.demo.wheel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.appwx.sdk.demo.R;
import com.appwx.sdk.wheel.OnWheelChangedListener;
import com.appwx.sdk.wheel.OnWheelScrollListener;
import com.appwx.sdk.wheel.WheelView;
import com.appwx.sdk.wheel.adapter.AbstractWheelTextAdapter;
import com.appwx.sdk.wheel.adapter.ArrayWheelAdapter;

public class CitiesActivity extends Activity {
    // Scrolling flag
    private boolean scrolling = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cities_layout);
               
        final WheelView country = (WheelView) findViewById(R.id.country);
        country.setVisibleItems(3);
        country.setViewAdapter(new CountryAdapter(this));

        final String cities[][] = new String[][] {
                        new String[] {"纽约","华盛顿","芝加哥","亚特兰大","奥兰多"},
                        new String[] {"渥太华","温哥华","多伦多","温莎","蒙特利尔"},
                        new String[] {"基辅","第聂伯河","利沃夫","哈尔科夫"},
                        new String[] {"巴黎","波尔多"},
                        };
       
        final WheelView city = (WheelView) findViewById(R.id.city);
        city.setVisibleItems(5);

        country.addChangingListener(new OnWheelChangedListener() {
                        public void onChanged(WheelView wheel, int oldValue, int newValue) {
                            if (!scrolling) {
                                updateCities(city, cities, newValue);
                            }
                        }
                });
       
        country.addScrollingListener( new OnWheelScrollListener() {
            public void onScrollingStarted(WheelView wheel) {
                scrolling = true;
            }
            public void onScrollingFinished(WheelView wheel) {
                scrolling = false;
                updateCities(city, cities, country.getCurrentItem());
            }
        });

        country.setCurrentItem(1);
    }
   
    /**
     * Updates the city wheel
     */
    private void updateCities(WheelView city, String cities[][], int index) {
        ArrayWheelAdapter<String> adapter =
            new ArrayWheelAdapter<String>(this, cities[index]);
        adapter.setTextSize(18);
        city.setViewAdapter(adapter);
        city.setCurrentItem(cities[index].length / 2);        
    }
   
    /**
     * Adapter for countries
     */
    private class CountryAdapter extends AbstractWheelTextAdapter {
        // Countries names
        private String countries[] =
            new String[] {"美国","加拿大","乌克兰","法国"};
        // Countries flags
        private int flags[] =
            new int[] {R.drawable.usa, R.drawable.canada, R.drawable.ukraine, R.drawable.france};
       
        /**
         * Constructor
         */
        protected CountryAdapter(Context context) {
            super(context, R.layout.country_layout, NO_RESOURCE);
           
            setItemTextResource(R.id.country_name);
        }

        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            View view = super.getItem(index, cachedView, parent);
            ImageView img = (ImageView) view.findViewById(R.id.flag);
            img.setImageResource(flags[index]);
            return view;
        }
       
        @Override
        public int getItemsCount() {
            return countries.length;
        }
       
        @Override
        protected CharSequence getItemText(int index) {
            return countries[index];
        }
    }
}

