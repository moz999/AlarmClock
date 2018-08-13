package com.example.m0z.alarmclock.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {

    private SQLiteDatabase db;
    private Context context;
    private DBTableHelper DBHelper;

    /**
     * コンストラクタ
     * @param context
     */
    public DBAdapter(Context context){
        this.context = context;
        DBHelper = new DBTableHelper(context);
    }

    /**
     * DBの読み書き
     * @return this 自身のオブジェクト
     */
    public DBAdapter openDB(){
        db = DBHelper.getWritableDatabase();
        return this;
    }

    /**
     * DBの読み込み
     * @return this 自身のオブジェクト
     */
    public DBAdapter readDB(){
        db = DBHelper.getReadableDatabase();
        return this;
    }

    /**
     * DBを閉じる
     */
    public void closeDB(){
        db.close();
        db = null;
    }

    /**
     * DBへの登録
     * @param hour
     * @param minute
     * @param snooze
     * @param enabled
     * @param sunday
     * @param monday
     * @param tuesday
     * @param wednesday
     * @param thursday
     * @param friday
     * @param saturday
     */
    public void savedDB(int hour,
                        int minute,
                        int snooze,
                        int enabled,
                        int sunday,
                        int monday,
                        int tuesday,
                        int wednesday,
                        int thursday,
                        int friday,
                        int saturday){

        db.beginTransaction(); // トランザクション開始

        try{
            ContentValues values = new ContentValues();
            values.put(DBHelper.COL_HOUR, hour);
            values.put(DBHelper.COL_MINUTE, minute);
            values.put(DBHelper.COL_SNOOZE, snooze);
            values.put(DBHelper.COL_ENABLED, enabled);
            values.put(DBHelper.COL_SUNDAY, sunday);
            values.put(DBHelper.COL_MONDAY, monday);
            values.put(DBHelper.COL_TUESDAY, tuesday);
            values.put(DBHelper.COL_WEDNESDAY, wednesday);
            values.put(DBHelper.COL_THURSDAY, thursday);
            values.put(DBHelper.COL_FRIDAY, friday);
            values.put(DBHelper.COL_SATURDAY, saturday);

            //insertメソッド
            db.insert(DBHelper.DB_TABLE, null, values);

            //トランザクションの成功
            db.setTransactionSuccessful();

        }catch(Exception e){
            e.printStackTrace();

        }finally{
            //トランザクションの処理は行わず、トランザクションを終了させる
            db.endTransaction();
        }
    }

    /**
     * DBの情報を取得する
     * @param columns
     * @return
     */
    public Cursor getDB(String[] columns){
        //queryメソッド
        // 1 : テーブル名
        // 2 : 取得するカラム名
        // 3 : WHERE句
        // 4 : 3で？を使用した場合に使用
        // 5 : GROUP BY
        // 6 : HAVING
        // 7 : ORDER BY
        return db.query(DBHelper.DB_TABLE, columns, null, null, null, null, null);
    }

    /**
     * DBの検索したデータを取得
     * @param columns
     * @param column
     * @param name
     * @return
     */
    public Cursor searchDB(String[] columns, String column, String name[]){
        return db.query(DBHelper.DB_NAME, columns, column + " like ?", name, null, null, null);
    }

    /**
     * DBのレコードを1行削除する
     * @param position WHERE句で検索するID
     */
    public void selectDelete(String position){
        db.beginTransaction();

        try{
            db.delete(DBHelper.DB_TABLE, DBHelper.COL_ID + " = ?", new String[]{position});

            db.setTransactionSuccessful();

        }catch (Exception e){
            e.printStackTrace();

        }finally{
            db.endTransaction();

        }
    }


}
