package com.example.m0z.alarmclock.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBTableHelper extends SQLiteOpenHelper{

    public static final String DB_NAME         = "alarm.db";       //DBの名前
    public static final String DB_TABLE        = "alarmTable";     //テーブル名
    public static final int DB_VERSION         = 1;                //バージョン名

    //カラム名
    public static final String COL_ID           = "_id";        // ID
    public static final String COL_HOUR         = "hour";       // 時間
    public static final String COL_MINUTE       = "minute";     // 分
    public static final String COL_SNOOZE       = "snooze";     // スヌーズ
    public static final String COL_ENABLED      = "enabled";    // 有効or無効
    public static final String COL_SUNDAY       = "sunday";     // Sunday
    public static final String COL_MONDAY       = "monday";     // Monday
    public static final String COL_TUESDAY      = "tuesday";    // Tuesday
    public static final String COL_WEDNESDAY    = "wednesday";  // Wednesday
    public static final String COL_THURSDAY     = "thursday";   // Thursday
    public static final String COL_FRIDAY       = "friday";     // Friday
    public static final String COL_SATURDAY     = "saturday";   // Saturday


    /**
     * コンストラクタ
     * @param context
     */
    public DBTableHelper(Context context){
        // 1 : コンテキスト
        // 2 : DB Name
        // 3 : factory -> nullで良い
        // 4 : DB Version
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create Table
        String createTabel = "CREATE TABLE " + DB_TABLE + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_HOUR + " INTEGER NOT NULL,"
                + COL_MINUTE + " INTEGER NOT NULL,"
                + COL_SNOOZE + " INTEGER,"
                + COL_ENABLED + " INTEGER NOT NULL,"
                + COL_SUNDAY + " INTEGER,"
                + COL_MONDAY + " INTEGER,"
                + COL_TUESDAY + " INTEGER,"
                + COL_WEDNESDAY + " INTEGER,"
                + COL_THURSDAY + " INTEGER,"
                + COL_FRIDAY + " INTEGER,"
                + COL_SATURDAY + " INTEGER"
                + ");";

        db.execSQL(createTabel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
