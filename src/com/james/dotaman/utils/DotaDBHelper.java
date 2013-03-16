package com.james.dotaman.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DotaDBHelper {

	private final Context mContext;
	private DatabaseHelper dh;
	SQLiteDatabase db;
	AssetManager assets = null;
	String[] databaseexe;

	public DotaDBHelper(Context context) {
		Log.d("james","in");
		mContext = context;
		assets = mContext.getAssets();
		dh = new DatabaseHelper(mContext);
		db = get();
		int position = 0;
		try {
			databaseexe = assets.list("");
			for (int i = 0;i < databaseexe.length-1; i++) {
				Log.d("james",databaseexe[i]);
				if (databaseexe[i].equals("hero.me")) {
					position = i;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStream assetFile = null;
		try {
			assetFile = assets.open(databaseexe[position]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		StringBuilder sb = new StringBuilder();
		String command;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(assetFile, "UTF-8"));
			 while ((command = reader.readLine()) != null) {
				 Log.d("james",command);
				 db.execSQL(command);
				 }
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				assetFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
//		Log.d("james",command);
		
		
//		db.execSQL("CREATE TABLE IF NOT EXISTS `hero` ( `id` int(11) NOT NULL PRIMARY KEY, `zh_name` varchar(16) DEFAULT NULL, `zh_short` varchar(16) DEFAULT NULL, `en_name` varchar(32) DEFAULT NULL, `en_short` varchar(16) DEFAULT NULL, `avatar` varchar(32) DEFAULT NULL, `display` varchar(32) DEFAULT NULL, `tavern` char(4) DEFAULT NULL, `camp` char(2) DEFAULT NULL, `skilled_at` varchar(8) DEFAULT NULL, `complex_rate` varchar(2) DEFAULT NULL, `tags` varchar(64) DEFAULT NULL, `init_hp` int(11) DEFAULT NULL, `init_mp` int(11) DEFAULT NULL, `init_min_damage` int(11) DEFAULT NULL, `init_max_damage` int(11) DEFAULT NULL, `attack_range` int(11) DEFAULT NULL, `attack_speed` float(4,2) DEFAULT NULL, `attack_pre_anim` float(2,1) DEFAULT NULL, `attack_post_anim` float(2,1) DEFAULT NULL, `move_speed` int(11) DEFAULT NULL, `init_armor` int(11) DEFAULT NULL, `major_attr` varchar(3) DEFAULT NULL, `init_strenth` int(11) DEFAULT NULL, `init_agile` int(11) DEFAULT NULL, `init_intelligence` int(11) DEFAULT NULL, `inc_strenth` float(2,1) DEFAULT NULL, `inc_agile` float(2,1) DEFAULT NULL, `inc_intelligence` float(2,1) DEFAULT NULL, `dps_rank` int(11) DEFAULT NULL, `push_rank` int(11) DEFAULT NULL, `gank_rank` int(11) DEFAULT NULL, `support_rank` int(11) DEFAULT NULL, `tank_rank` int(11) DEFAULT NULL, `desc` varchar(512) DEFAULT NULL )");
	}

	public SQLiteDatabase get() {
		return dh.getWritableDatabase();
	}
	
	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, "test.db", null, 1);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// db.execSQL(DATABASE_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS titles");
			onCreate(db);
		}
	}
}
