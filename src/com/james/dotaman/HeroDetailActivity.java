package com.james.dotaman;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;

public class HeroDetailActivity extends Activity {


	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tavern_list, menu);
        return true;
    }
}
