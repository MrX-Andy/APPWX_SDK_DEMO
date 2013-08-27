package com.appwx.sdk.demo.menudrawer;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.appwx.sdk.demo.R;

public class MenuDrawerActivity extends ListActivity{

	 private MenuDrawerAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		mAdapter = new MenuDrawerAdapter();

        mAdapter.addHeader("侧滑菜单");
        mAdapter.addSample("左侧滑", "只有在内容区域拖动.", LeftDrawerSample.class);
        mAdapter.addSample("右侧滑", "只有在内容区域拖动", RightDrawerSample.class);
        mAdapter.addSample("顶侧滑", "从上向下滑动", TopDrawerSample.class);
        mAdapter.addSample("底侧滑", "从下向上滑动", BottomDrawerSample.class);
        mAdapter.addSample("ListActivity sample", "演示如何使用抽屉与ListActivity的.",ListActivitySample.class);
        mAdapter.addSample("Window sample", "全屏滑动.", WindowSample.class);
        mAdapter.addSample("ViewPager","只能拖开时ViewPager是在第一页上的一个左抽屉",ViewPagerSample.class);
        mAdapter.addSample("Layout xml", "在XML中定义的抽屉，其菜单和内容", LayoutSample.class);
        mAdapter.addSample("Fragments", "Fragments使用的内容片段", FragmentSample.class);
        mAdapter.addSample("ActionBarSherlock sample", "使用ActionBarSherlock展示柜的抽屉.",ActionBarSherlockSample.class);

        mAdapter.addHeader("Static drawer");
        mAdapter.addSample("Static drawer", "抽屉总是可见", StaticDrawerSample.class);

        mAdapter.addHeader("覆盖view");
        mAdapter.addSample("Left overlay", "抽屉可以从左边拖动.",LeftOverlaySample.class);
        mAdapter.addSample("Top overlay", "抽屉可以从顶部拖动.",TopOverlaySample.class);
        mAdapter.addSample("Right overlay", "抽屉可以从右边拖.", RightOverlaySample.class);
        mAdapter.addSample("Bottom overlay", "抽屉可以从底部边拖.",BottomOverlaySample.class);

        setListAdapter(mAdapter);
	}
	
	@Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
		MenuDrawerItem sample = (MenuDrawerItem) mAdapter.getItem(position);
        Intent i = new Intent(this, sample.mClazz);
        startActivity(i);
    }

    private static class Header {

        String mTitle;

        public Header(String title) {
            mTitle = title;
        }
    }

    private static class MenuDrawerItem {

        String mTitle;
        String mSummary;
        Class mClazz;

        public MenuDrawerItem(String title, String summary, Class clazz) {
            mTitle = title;
            mSummary = summary;
            mClazz = clazz;
        }
    }
	
	public class MenuDrawerAdapter extends BaseAdapter {

        private List<Object> mItems = new ArrayList<Object>();

        public void addHeader(String title) {
            mItems.add(new Header(title));
        }

        public void addSample(String title, String summary, Class clazz) {
            mItems.add(new MenuDrawerItem(title, summary, clazz));
        }

        @Override
        public int getCount() {
            return mItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getItemViewType(int position) {
            return getItem(position) instanceof Header ? 0 : 1;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (getItemViewType(position) == 0) {
                TextView v = (TextView) convertView;
                if (v == null) {
                    v = (TextView) getLayoutInflater().inflate(R.layout.list_row_sample_header, parent, false);
                }

                v.setText(((Header) getItem(position)).mTitle);

                return v;

            } else {
            	MenuDrawerItem sample = (MenuDrawerItem) getItem(position);

                View v = convertView;
                if (v == null) {
                    v = getLayoutInflater().inflate(R.layout.list_row_sample, parent, false);
                }

                ((TextView) v.findViewById(R.id.title)).setText(sample.mTitle);
                ((TextView) v.findViewById(R.id.summary)).setText(sample.mSummary);

                return v;
            }
        }
    }
}
