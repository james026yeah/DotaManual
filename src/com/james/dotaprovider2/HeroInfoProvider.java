package com.james.dotaprovider2;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class HeroInfoProvider extends ContentProvider {

	private static final String DATABASE_NAME = "hero_info.db";
	
	private static final int DATABASE_VERSION = 1;
	
	private HeroInfoDatabaseHelper mOpenHelper;
	
	private static final UriMatcher sUriMatcher;
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		mOpenHelper = new HeroInfoDatabaseHelper(getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	static {
		sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	}
	
	static class HeroInfoDatabaseHelper extends SQLiteOpenHelper {

		public HeroInfoDatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub.
//			db.execSQL("CREATE TABLE IF NOT EXISTS `hero` ( `id` int(11) NOT NULL PRIMARY KEY, `zh_name` varchar(16) DEFAULT NULL, `zh_short` varchar(16) DEFAULT NULL, `en_name` varchar(32) DEFAULT NULL, `en_short` varchar(16) DEFAULT NULL, `avatar` varchar(32) DEFAULT NULL, `display` varchar(32) DEFAULT NULL, `tavern` char(4) DEFAULT NULL, `camp` char(2) DEFAULT NULL, `skilled_at` varchar(8) DEFAULT NULL, `complex_rate` varchar(2) DEFAULT NULL, `tags` varchar(64) DEFAULT NULL, `init_hp` int(11) DEFAULT NULL, `init_mp` int(11) DEFAULT NULL, `init_min_damage` int(11) DEFAULT NULL, `init_max_damage` int(11) DEFAULT NULL, `attack_range` int(11) DEFAULT NULL, `attack_speed` float(4,2) DEFAULT NULL, `attack_pre_anim` float(2,1) DEFAULT NULL, `attack_post_anim` float(2,1) DEFAULT NULL, `move_speed` int(11) DEFAULT NULL, `init_armor` int(11) DEFAULT NULL, `major_attr` varchar(3) DEFAULT NULL, `init_strenth` int(11) DEFAULT NULL, `init_agile` int(11) DEFAULT NULL, `init_intelligence` int(11) DEFAULT NULL, `inc_strenth` float(2,1) DEFAULT NULL, `inc_agile` float(2,1) DEFAULT NULL, `inc_intelligence` float(2,1) DEFAULT NULL, `dps_rank` int(11) DEFAULT NULL, `push_rank` int(11) DEFAULT NULL, `gank_rank` int(11) DEFAULT NULL, `support_rank` int(11) DEFAULT NULL, `tank_rank` int(11) DEFAULT NULL, `desc` varchar(512) DEFAULT NULL )");
			db.execSQL("CREATE TABLE " + DotaHeroData.HeroInfo.TABLE_NAME + " ("
                   + DotaHeroData.HeroInfo._ID + " INTEGER PRIMARY KEY,"
                   + DotaHeroData.HeroInfo.COLUMN_HERO_NAME_ZH + " TEXT,"
                   + DotaHeroData.HeroInfo.COLUMN_HERO_NAME_EN + " TEXT,"
                   + DotaHeroData.HeroInfo.COLUMN_LOCATED_TAVERN+ " INTEGER,"
                   + ");");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
