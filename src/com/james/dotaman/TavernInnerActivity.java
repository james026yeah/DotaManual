package com.james.dotaman;

import cn.domob.android.ads.DomobAdEventListener;
import cn.domob.android.ads.DomobAdView;
import cn.domob.android.ads.DomobAdManager.ErrorCode;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

public class TavernInnerActivity extends Activity {

	private Intent mToDetailIntent;
	private int mCurrentTavernId;
	private int mLayoutId;
	private RelativeLayout mAdContainer;
	private DomobAdView adView320x50;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.tavern_inner_layout);
		mCurrentTavernId = getIntent().getIntExtra("tavernnum", 0);
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
	}

	public void initHero() {
		
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
    	switch (view.getId()) {
    	case R.id.mum_1:{
    		mToDetailIntent = new Intent();
    		mToDetailIntent.setClass(getApplicationContext(), HeroDetailActivity.class);
    		mToDetailIntent.putExtra("which", 1);
    		startActivity(mToDetailIntent);
    		break;
    	}
    	}
    }
}
