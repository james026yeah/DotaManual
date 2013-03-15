package com.james.dotaman;

import cn.domob.android.ads.DomobAdEventListener;
import cn.domob.android.ads.DomobAdView;
import cn.domob.android.ads.DomobSplashAd;
import cn.domob.android.ads.DomobAdManager.ErrorCode;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class GoodDetailActivity extends Activity {

	RelativeLayout mAdContainer;
	DomobAdView adView320x50;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.goods_item_activity);
        mAdContainer = (RelativeLayout) findViewById(R.id.adcontainer);
        adView320x50 = new DomobAdView(this, "56OJyM1ouMGoaSnvCK", DomobAdView.INLINE_SIZE_320X50);
        adView320x50.setKeyword("game");
        adView320x50.setUserGender("male");
        adView320x50.setAdEventListener(new DomobAdEventListener() {
			
			@Override
			public void onDomobLeaveApplication(DomobAdView arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onDomobAdReturned(DomobAdView arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onDomobAdOverlayPresented(DomobAdView arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onDomobAdOverlayDismissed(DomobAdView arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onDomobAdFailed(DomobAdView arg0, ErrorCode arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onDomobAdClicked(DomobAdView arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        mAdContainer.addView(adView320x50);
    }

    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tavern_list, menu);
        return true;
    }
}
