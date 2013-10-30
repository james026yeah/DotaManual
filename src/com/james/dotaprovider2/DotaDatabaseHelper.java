
package com.james.dotaprovider2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DotaDatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_HEROS_INFO = "heros_info";
    public static final String TABLE_GOODS_INFO = "goods_info";
    
    private Context mContext;

    public DotaDatabaseHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createHerosInfoTable(db);
        createGoodsInfoTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void createHerosInfoTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_HEROS_INFO + " (" +
                "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name" + " TEXT" + ");");
    }

    private void createGoodsInfoTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_GOODS_INFO + " (" +
                "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name" + " TEXT" + ");");
    }

}
