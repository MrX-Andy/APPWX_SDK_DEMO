/*
 * Copyright (C) 2013 Antonio Leiva
 * Copyright (C) 2013 Manuel Peinado
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.appwx.sdk.demo.fadingactionbar;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.appwx.sdk.demo.R;
import com.appwx.sdk.demo.fadingactionbar.navigationdrawercompat.ActionBarDrawerToggleCompat;

public class NavigationDrawerActivity extends SherlockFragmentActivity
		implements AdapterView.OnItemClickListener {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggleCompat mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	private String[] mCityNames;
	private int[] mCityImages;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigation_drawer);

		mTitle = mDrawerTitle = getTitle();
		mCityNames = getResources().getStringArray(R.array.drawer_items);
		TypedArray typedArray = getResources().obtainTypedArray(
				R.array.city_images);
		mCityImages = new int[typedArray.length()];
		for (int i = 0; i < typedArray.length(); ++i) {
			mCityImages[i] = typedArray.getResourceId(i, 0);
		}
		typedArray.recycle();
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// drawer打开时,显示一个带阴影覆盖view在内容上
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		// 设置drawer列表项和监听
		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, mCityNames));
		mDrawerList.setOnItemClickListener(this);

		// 启用ActionBar的icon和drawer切换
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		// ActionBarDrawer的属性设定
		// drawer和actionbar icon、title之间的切换
		mDrawerToggle = new ActionBarDrawerToggleCompat(this, /* host Activity */
		mDrawerLayout, /* DrawerLayout object */
		R.drawable.ic_drawer, /* actionbar drawer icon */
		R.string.drawer_open, /* 打开drawer */
		R.string.drawer_close /* "关闭drawer */
		) {
			public void onDrawerClosed(View view) {
				getSupportActionBar().setTitle(mTitle);
			}

			public void onDrawerOpened(View drawerView) {
				getSupportActionBar().setTitle(mDrawerTitle);
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			selectItem(0);
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// onRestoreInstanceState发生后，同步切换状态.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// 通过任何配置更改的抽屉切换
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return mDrawerToggle.onOptionsItemSelected(item)
				|| super.onOptionsItemSelected(item);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		selectItem(position);
	}

	private void selectItem(int position) {
		// update the main content by replacing fragments
		Fragment fragment = new SampleFragment();
		Bundle args = new Bundle();
		args.putInt(SampleFragment.ARG_IMAGE_RES, mCityImages[position]);
		args.putInt(SampleFragment.ARG_ACTION_BG_RES, R.drawable.ab_background);
		fragment.setArguments(args);

		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment).commit();

		// update selected item and title, then close the drawer
		mDrawerList.setItemChecked(position, true);
		setTitle(mCityNames[position]);
		mDrawerLayout.closeDrawer(mDrawerList);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getSupportActionBar().setTitle(mTitle);
	}
}
