
package com.james.dotaman;

import java.util.ArrayList;

import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
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
import android.widget.TextView;

public class DotaManActivity extends Activity {

    ArrayList<View> mViewPagerDetail;

    private static final int NUM_PAGES = 2;

    private ViewPager mViewPager;

    private PagerAdapter mPagerAdaper;

    ImageView mRedTavern;
    ImageView mChocolateTavern;
    ImageView mGreenTavern;
    ImageView mDarkGreenTavern;
    ImageView mBlueTavern;
    ImageView mGreyTavern;
    ImageView mShop1;
    private int mCurrentPage;
    private SQLiteDatabase mSQLiteDatabase = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        mSQLiteDatabase = this.openOrCreateDatabase("hero.db", MODE_PRIVATE, null);
        setContentView(R.layout.main_layout);
        initViewPager();
    }

    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.container);
        LayoutInflater inflater = getLayoutInflater();
        mViewPagerDetail = new ArrayList<View>();

        View tavernView = inflater.inflate(R.layout.activity_tavern, null);
        mRedTavern = (ImageView) tavernView.findViewById(R.id.red);
        mChocolateTavern = (ImageView) tavernView.findViewById(R.id.chocolate);
        mGreenTavern = (ImageView) tavernView.findViewById(R.id.green);
        mDarkGreenTavern = (ImageView) tavernView.findViewById(R.id.darkgreen);
        mBlueTavern = (ImageView) tavernView.findViewById(R.id.blue);
        mGreyTavern = (ImageView) tavernView.findViewById(R.id.grey);
        InitTavernList();
        mViewPagerDetail.add(tavernView);

        View goodsView = inflater.inflate(R.layout.activity_shop, null);
        mShop1 = (ImageView) goodsView.findViewById(R.id.shop1);
        InitShopList();
        mViewPagerDetail.add(goodsView);

        mPagerAdaper = new ViewPagerAdapter(mViewPagerDetail);
        mViewPager.setAdapter(mPagerAdaper);
        mViewPager.setCurrentItem(0);

        mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                mCurrentPage = position;
                TextView mHeroTitle = (TextView)findViewById(R.id.herotitle);
                mHeroTitle.setTextColor(Color.WHITE);
                TextView mGoodsTitle = (TextView)findViewById(R.id.goodstitle);
                mGoodsTitle.setTextColor(Color.WHITE);
                View mHeroIndicator = findViewById(R.id.heroindicator);
                mHeroIndicator.setBackgroundColor(Color.TRANSPARENT);
                View mGoodsIndicator = findViewById(R.id.goodsindicator);
                mGoodsIndicator.setBackgroundColor(Color.TRANSPARENT);
                if (mCurrentPage == 0) {
                	mHeroTitle.setTextColor(Color.YELLOW);
                	mHeroIndicator.setBackgroundColor(Color.GREEN);
                } else if (mCurrentPage == 1) {
                	mGoodsTitle.setTextColor(Color.YELLOW);
                	mGoodsIndicator.setBackgroundColor(Color.GREEN);
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

    public void InitTavernList() {
    	
        
        mRedTavern.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), TavernInnerActivity.class);
                intent.putExtra("tavernnum", 1);
                startActivityForResult(intent, 0);
            }
        });
        mChocolateTavern.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), TavernInnerActivity.class);
                intent.putExtra("tavernnum", 2);
                startActivityForResult(intent, 0);
            }
        });
        mGreenTavern.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), TavernInnerActivity.class);
                intent.putExtra("tavernnum", 3);
                startActivityForResult(intent, 0);
            }
        });
        mDarkGreenTavern.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), TavernInnerActivity.class);
                intent.putExtra("tavernnum", 4);
                startActivityForResult(intent, 0);
            }
        });
        mBlueTavern.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), TavernInnerActivity.class);
                intent.putExtra("tavernnum", 5);
                startActivityForResult(intent, 0);
            }
        });
        mGreyTavern.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), TavernInnerActivity.class);
                intent.putExtra("tavernnum", 6);
                startActivityForResult(intent, 0);
            }
        });
    }
    
    public void InitShopList() {
    	mShop1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
                intent.setClass(getApplicationContext(), ShopInnerActivity.class);
                intent.putExtra("tavernnum", 6);
                startActivityForResult(intent, 0);
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
            ((ViewPager) container).addView(list.get(position), 0);
            return list.get(position);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tavern_list, menu);
        return true;
    }
}
