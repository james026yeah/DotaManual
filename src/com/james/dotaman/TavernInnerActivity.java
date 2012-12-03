package com.james.dotaman;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;

public class TavernInnerActivity extends Activity {

	private Intent mToDetailIntent;
	private String mWhichTavern;
	private int mLayoutId;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(getLayoutId());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tavern_list, menu);
		return true;
	}

	public int getLayoutId() {
		switch (getIntent().getExtras().getInt("tavernnum")) {
		case 1: {
			mLayoutId = R.layout.tavern_red_inner_layout;
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
