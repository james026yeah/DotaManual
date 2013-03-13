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
		return false;
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
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DotaData.HeroInfo.TABLE_NAME + " ("
                   + DotaData.HeroInfo._ID + " INTEGER PRIMARY KEY,"
                   + DotaData.HeroInfo.COLUMN_HERO_NAME_ZH + " TEXT,"
                   + DotaData.HeroInfo.COLUMN_HERO_NAME_EN + " TEXT,"
                   + DotaData.HeroInfo.COLUMN_LOCATED_TAVERN+ " INTEGER,"
                   + ");");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
