package com.example.evernote;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public  DBHelper(Context context){
        super(context, "memodb", null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db){
       //table명 memoSQL // 칼럼 _id, title, content
        String memoSQL = "create table tb_memo "+
                "(_id integer primary key autoincrement," + "title, " + "content)";
        db.execSQL(memoSQL);

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        if(newVersion == DATABASE_VERSION){
            db.execSQL("drop table tb_memo");
            onCreate(db);
        }
    }//

}
