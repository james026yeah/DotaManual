package com.james.dotaman;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

public class DotaManActivity extends Activity {

	ArrayList<View> mViewPagerDetail;
	private static final int NUM_PAGES = 2;
	private ViewPager mViewPager;
	private PagerAdapter mPagerAdaper;
	ImageView mRedTavern;
	private int mCurrentPage;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_layout);
        initViewPager();
    }

    private void initViewPager() {
    	mViewPager = (ViewPager) findViewById(R.id.container);
    	LayoutInflater inflater = getLayoutInflater();
    	mViewPagerDetail = new ArrayList<View>();
    	
    	View tavernView = inflater.inflate(R.layout.activity_tavern, null);
    	mViewPagerDetail.add(tavernView);
    	
    	View goodsView = inflater.inflate(R.layout.activity_goods, null);
    	mViewPagerDetail.add(goodsView);
    	
    	mPagerAdaper = new ViewPagerAdapter(mViewPagerDetail);
    	mViewPager.setAdapter(mPagerAdaper);
    	
    	mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				mCurrentPage = position;
				if (mCurrentPage == 0) {
					mRedTavern = (ImageView) findViewById(R.id.red);
					mRedTavern.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Intent	 intent = new Intent();
							intent.setClass(getApplicationContext(), TavernInnerActivity.class);
							startActivityForResult(intent, 0);
						}
					});
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    }
    
    public class ViewPagerAdapter extends PagerAdapter {

    	private ArrayList<View> list;
    	
    	public ViewPagerAdapter(ArrayList<View> views) {
    		list = views;
    	}
    	
		@Override
		public int getItemPosition(Object object) {
			// TODO Auto-generated method stub
			return POSITION_NONE;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			// TODO Auto-generated method stub
			((ViewPager) container).removeView(list.get(position));
		}
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			((ViewPager) container).addView(list.get(position),0);
			return list.get(position);
		}
    	
		
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tavern_list, menu);
        return true;
    }
}
