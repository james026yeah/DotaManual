package com.james.dotaman;

import com.james.dotaman.utils.HeroIconRes;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import cn.domob.android.ads.DomobAdEventListener;
import cn.domob.android.ads.DomobAdManager.ErrorCode;
import cn.domob.android.ads.DomobAdView;

public class TavernInnerActivity extends Activity {

	private Intent mToDetailIntent;
	private int mCurrentTavernId;
	private int mLayoutId;
	private RelativeLayout mAdContainer;
	private DomobAdView adView320x50;
//	private SQLiteDatabase mHeroDatabase;
//	private Cursor mCurrentCursor;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.tavern_inner_layout);
		mCurrentTavernId = getIntent().getIntExtra("tavernnum", 0);
//		mHeroDatabase = this.openOrCreateDatabase("test.db", MODE_PRIVATE, null);
//		mCurrentCursor = mHeroDatabase.rawQuery("select * from heros", null);
		mAdContainer = (RelativeLayout) findViewById(R.id.adcontainer);
        adView320x50 = new DomobAdView(this, "56OJyM1ouMGoaSnvCK", DomobAdView.INLINE_SIZE_320X50);
        adView320x50.setKeyword("game");
        adView320x50.setUserGender("male");
        adView320x50.setAdEventListener(new DomobAdEventListener() {
			
			@Override
			public void onDomobLeaveApplication(DomobAdView arg0) {
				// TODO Auto-generated method stub
				mAdContainer.setVisibility(View.GONE);
			}
			
			@Override
			public void onDomobAdReturned(DomobAdView arg0) {
				// TODO Auto-generated method stub
				mAdContainer.setVisibility(View.VISIBLE);
			}
			
			@Override
			public void onDomobAdOverlayPresented(DomobAdView arg0) {
				// TODO Auto-generated method stub
				mAdContainer.setVisibility(View.GONE);
			}
			
			@Override
			public void onDomobAdOverlayDismissed(DomobAdView arg0) {
				// TODO Auto-generated method stub
				mAdContainer.setVisibility(View.GONE);
			}
			
			@Override
			public void onDomobAdFailed(DomobAdView arg0, ErrorCode arg1) {
				// TODO Auto-generated method stub
				mAdContainer.setVisibility(View.GONE);
			}
			
			@Override
			public void onDomobAdClicked(DomobAdView arg0) {
				// TODO Auto-generated method stub
				mAdContainer.setVisibility(View.GONE);
			}
		});
        mAdContainer.addView(adView320x50);
        initHeroIcon();
        setHeroIcon();
	}

	public void setHeroIcon() {
//		if (mCurrentCursor != null) {
//			if (mCurrentCursor.moveToFirst()) {
//				String iconname = mCurrentCursor.getString(mCurrentCursor.getColumnIndex("icon"));
//				if (iconname != null) {
//					String icon = "R.id." + iconname;
					mHeroIcon1.setImageResource(HeroIconRes.IconID[(mCurrentTavernId - 1) * 24 + 1]);
//					mHeroIcon2.setImageResource(HeroIconRes.IconID[(mCurrentTavernId - 1) * 24 + 2]);
					mHeroIcon2.setImageResource(HeroIconRes.IconID[(mCurrentTavernId - 1) * 24 + 2]);
					mHeroIcon3.setImageResource(HeroIconRes.IconID[(mCurrentTavernId - 1) * 24 + 3]);
					mHeroIcon4.setImageResource(HeroIconRes.IconID[(mCurrentTavernId - 1) * 24 + 4]);
					mHeroIcon5.setImageResource(HeroIconRes.IconID[(mCurrentTavernId - 1) * 24 + 5]);
					mHeroIcon6.setImageResource(HeroIconRes.IconID[(mCurrentTavernId - 1) * 24 + 6]);
					mHeroIcon7.setImageResource(HeroIconRes.IconID[(mCurrentTavernId - 1) * 24 + 7]);
					mHeroIcon8.setImageResource(HeroIconRes.IconID[(mCurrentTavernId - 1) * 24 + 8]);
					mHeroIcon9.setImageResource(HeroIconRes.IconID[(mCurrentTavernId - 1) * 24 + 9]);
					mHeroIcon10.setImageResource(HeroIconRes.IconID[(mCurrentTavernId - 1) * 24 + 10]);
					mHeroIcon11.setImageResource(HeroIconRes.IconID[(mCurrentTavernId - 1) * 24 + 11]);
					mHeroIcon12.setImageResource(HeroIconRes.IconID[(mCurrentTavernId - 1) * 24 + 12]);
					mHeroIcon13.setImageResource(HeroIconRes.IconID[(mCurrentTavernId - 1) * 24 + 13]);
					mHeroIcon14.setImageResource(HeroIconRes.IconID[(mCurrentTavernId - 1) * 24 + 14]);
					mHeroIcon15.setImageResource(HeroIconRes.IconID[(mCurrentTavernId - 1) * 24 + 15]);
					mHeroIcon16.setImageResource(HeroIconRes.IconID[(mCurrentTavernId - 1) * 24 + 16]);
//					Log.d("james",iconname);
//				}
//			}
//		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tavern_list, menu);
		return true;
	}

	public int getLayoutId() {
		switch (getIntent().getExtras().getInt("tavernnum")) {
		case 1: {
			mLayoutId = R.layout.tavern_inner_layout;
			break;
		}
		case 2: {
		    mLayoutId = R.layout.tavern_chocolate_inner_layout;
			break;
		}
		case 3:{
		    mLayoutId = R.layout.tavern_green_inner_layout;
		    break;
		}
		case 4:{
		    mLayoutId = R.layout.tavern_darkgreen_inner_layout;
		    break;
		}
		case 5:{
		    mLayoutId = R.layout.tavern_blue_inner_layout;
		    break;
		}
		case 6:{
		    mLayoutId = R.layout.tavern_grey_inner_layout;
		    break;
		}
		default:{
		    mLayoutId = R.layout.tavern_red_inner_layout;
		    break;
		}
		}
		
		return mLayoutId;
	}
	public void doClick(View view) {
		mToDetailIntent = new Intent();
		mToDetailIntent.setClass(getApplicationContext(), HeroDetailActivity.class);
    	switch (view.getId()) {
    	case R.id.num_1:{
    		mToDetailIntent.putExtra("heroid", (mCurrentTavernId - 1) * 24 + 1);
    		break;
    	}
    	case R.id.num_2:{
    		mToDetailIntent.putExtra("heroid", (mCurrentTavernId - 1) * 24 + 2);
    		break;
    	}
    	case R.id.num_3:{
    		mToDetailIntent.putExtra("heroid", (mCurrentTavernId - 1) * 24 + 3);
    		break;
    	}
    	case R.id.num_4:{
    		mToDetailIntent.putExtra("heroid", (mCurrentTavernId - 1) * 24 + 4);
    		break;
    	}
    	case R.id.num_5:{
    		mToDetailIntent.putExtra("heroid", (mCurrentTavernId - 1) * 24 + 5);
    		break;
    	}
    	}
    	startActivity(mToDetailIntent);
    }
	
	private ImageView mHeroIcon1;
	private ImageView mHeroIcon2;
	private ImageView mHeroIcon3;
	private ImageView mHeroIcon4;
	private ImageView mHeroIcon5;
	private ImageView mHeroIcon6;
	private ImageView mHeroIcon7;
	private ImageView mHeroIcon8;
	private ImageView mHeroIcon9;
	private ImageView mHeroIcon10;
	private ImageView mHeroIcon11;
	private ImageView mHeroIcon12;
	private ImageView mHeroIcon13;
	private ImageView mHeroIcon14;
	private ImageView mHeroIcon15;
	private ImageView mHeroIcon16;
	private ImageView mHeroIcon17;
	private ImageView mHeroIcon18;
	private ImageView mHeroIcon19;
	private ImageView mHeroIcon20;
	private ImageView mHeroIcon21;
	private ImageView mHeroIcon22;
	private ImageView mHeroIcon23;
	private ImageView mHeroIcon24;
	public void initHeroIcon() {
		mHeroIcon1 = (ImageView) findViewById(R.id.num_1);
		mHeroIcon2 = (ImageView) findViewById(R.id.num_2);
		mHeroIcon3 = (ImageView) findViewById(R.id.num_3);
		mHeroIcon4 = (ImageView) findViewById(R.id.num_4);
		mHeroIcon5 = (ImageView) findViewById(R.id.num_5);
		mHeroIcon6 = (ImageView) findViewById(R.id.num_6);
		mHeroIcon7 = (ImageView) findViewById(R.id.num_7);
		mHeroIcon8 = (ImageView) findViewById(R.id.num_8);
		mHeroIcon9 = (ImageView) findViewById(R.id.num_9);
		mHeroIcon10 = (ImageView) findViewById(R.id.num_10);
		mHeroIcon11 = (ImageView) findViewById(R.id.num_11);
		mHeroIcon12 = (ImageView) findViewById(R.id.num_12);
		mHeroIcon13 = (ImageView) findViewById(R.id.num_13);
		mHeroIcon14 = (ImageView) findViewById(R.id.num_14);
		mHeroIcon15 = (ImageView) findViewById(R.id.num_15);
		mHeroIcon16 = (ImageView) findViewById(R.id.num_16);
		mHeroIcon17 = (ImageView) findViewById(R.id.num_17);
		mHeroIcon18 = (ImageView) findViewById(R.id.num_18);
		mHeroIcon19 = (ImageView) findViewById(R.id.num_19);
		mHeroIcon20 = (ImageView) findViewById(R.id.num_20);
		mHeroIcon21 = (ImageView) findViewById(R.id.num_21);
		mHeroIcon22 = (ImageView) findViewById(R.id.num_22);
		mHeroIcon23 = (ImageView) findViewById(R.id.num_23);
		mHeroIcon24 = (ImageView) findViewById(R.id.num_24);
	}
}
