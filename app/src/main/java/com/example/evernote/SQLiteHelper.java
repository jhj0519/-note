package com.example.evernote;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper {
    private static final String dbName = "MemoTest";
    private static final String table1 = "MemoTable";
    private static final int dbVersion = 1;

    private  OperHelper opener;
    private SQLiteDatabase db;

    private Context context;

    public SQLiteHelper(Context context){
        this.context = context;
        this.opener = new OperHelper(context,dbName,null,dbVersion);
        db = opener.getWritableDatabase();
    }

    private class OperHelper extends SQLiteOpenHelper{

        public OperHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version){
            super(context, name, factory, version);
        }


        public void onCreate(SQLiteDatabase db) {
            String create = "CREATE TABLE " + table1 + "("+
                    "seq integer PRIMARY KEY AUTOINCREMENT, " + "maintext text," +
                    "subtext text," + "indone integer)";
                db.execSQL(create);
            db.execSQL(create);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+table1);
            onCreate(db);
        }
//        @Override
//        public void onCreate(SQLiteDatabase sqLiteDatabase){
//            String create = "CREATE TABLE" + table1 + "("+
//                    "seq integer PRIMARY KEY AUTOINCREMENT, " + "maintext," +
//                    "subtext text," + "indone integer)";
//            sqLiteDatabase.execSQL(create);
//        }
//
//        public void  onUpgrade(SQLiteDatabase sqLiteDatabase, int i , int i1){
//
//        }
        public void insertMemo(Memo memo){
            // INSERT INTO MemoTable VALUES(NULL, 'TITLE', 'TEXT',0); 쿼리문 원래 모양
            String sql = "INSERT INTO " + table1 + "VALUES(NULL, '" + memo.title+"', '" + memo.text+"', " +memo.getIndone() + ");";
            db.execSQL(sql);
        }

        //MemoTable의 0번쨰 데이터를 삭제
        //DELETE FROM MemoTable WHERE seq = 0;
        public void  deleteMemo(int position){
            String sql = "DELLTE FROM " + table1 + "WHERE seq = " +position + ";";
            db.execSQL(sql);
        }

        //SELECT * FROM MemoTable;
        public ArrayList<Memo> selectAll(){
            String sql = "SELECT * FROM "+ table1;

            ArrayList<Memo> list = new ArrayList<>();

            Cursor results = db.rawQuery(sql, null);
            results.moveToFirst();

            while (!results.isAfterLast()){
                Memo memo = new Memo(results.getInt(0) ,results.getString(1),results.getString(2),results.getInt(3));
                list.add(memo);
                results.moveToNext();
            }
            results.close();
            return list;

        }
    }


}
