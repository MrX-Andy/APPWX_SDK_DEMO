package com.appwx.sdk.demo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.appwx.sdk.demo.R;
import com.appwx.sdk.demo.animator.ActivityAnimatorActivity;
import com.appwx.sdk.demo.appmsg.AppMsgActivity;
import com.appwx.sdk.demo.fadingactionbar.HomeActivity;
import com.appwx.sdk.demo.imageview.SmartImageViewActivity;
import com.appwx.sdk.demo.menu.arcandray.ArcAndRayActivity;
import com.appwx.sdk.demo.menudrawer.MenuDrawerActivity;
import com.appwx.sdk.demo.pla.WaterFallActivity;
import com.appwx.sdk.demo.poppyview.PoppyViewActivity;
import com.appwx.sdk.demo.radialmenu.MainMenu;
import com.appwx.sdk.demo.refreshlistview.PullRefreshListview;
import com.appwx.sdk.demo.satellitemenu.SatelliteMenuActivity;
import com.appwx.sdk.demo.slidinguppanel.SlidingUpPanelActivity;
import com.appwx.sdk.demo.stickylistview.StickyListViewActivity;
import com.appwx.sdk.demo.viewpager.JazzyViewPagerActivity;
import com.appwx.sdk.demo.wheel.WheelActivity;
import com.appwx.sdk.demo.wheelmenu.WheelMenuActivity;

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

	String mStrDemos[] = { "�໬�˵�(silder menu)", "app��Ϣ����(app message)",
			"google���ֿؼ�(google wheel)", "Բ�̲˵�(circle menu)",
			"listview����title����(staellitemview)",
			"���뵭��ActionBar(fade ActionBae)", "����˵�(Radial Menu)",
			"Path�˵�(Satellite Menu)", "���κ�����ص��˵�(Arc and Ray)",
			"�Զ���imageview(ͼƬ����)", "�ٲ���(PLA -PinterestLikeAdapterView)",
			"listview����ˢ��(pull down refersh listview)",
			"ViewPager������Ч(3D JazzyViewPager)", "Activity����(ActivityAnimator)",
			"����Ч��(SlidingUpPanel)" ,"������ͼ�����͵ײ���������(scorll view for scorll and list view)",
			"��Դ��Ŀ(Open Source Project)"};

	Class<?> mActivities[] = { MenuDrawerActivity.class, AppMsgActivity.class,
			WheelActivity.class, WheelMenuActivity.class,
			StickyListViewActivity.class, HomeActivity.class, MainMenu.class,
			SatelliteMenuActivity.class, ArcAndRayActivity.class,
			SmartImageViewActivity.class, WaterFallActivity.class,
			PullRefreshListview.class, JazzyViewPagerActivity.class,
			ActivityAnimatorActivity.class, SlidingUpPanelActivity.class,
			PoppyViewActivity.class,
			com.appwx.sdk.osp.MainActivity.class};
}
