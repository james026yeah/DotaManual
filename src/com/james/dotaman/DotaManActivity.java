
package com.james.dotaman;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
    ImageView mChocolateTavern;
    ImageView mGreenTavern;
    ImageView mDarkGreenTavern;
    ImageView mBlueTavern;
    ImageView mGreyTavern;
    private int mCurrentPage;
    private SQLiteDatabase mSQLiteDatabase = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mSQLiteDatabase = this.openOrCreateDatabase("hero.db", MODE_PRIVATE, null);
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
                    mChocolateTavern = (ImageView) findViewById(R.id.chocolate);
                    mGreenTavern = (ImageView) findViewById(R.id.green);
                    mDarkGreenTavern = (ImageView) findViewById(R.id.darkgreen);
                    mBlueTavern = (ImageView) findViewById(R.id.blue);
                    mGreyTavern = (ImageView) findViewById(R.id.grey);
                    
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
