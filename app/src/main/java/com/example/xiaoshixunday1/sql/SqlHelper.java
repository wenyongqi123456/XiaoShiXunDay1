package com.example.xiaoshixunday1.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.xiaoshixunday1.bean.DbBean;

import java.util.ArrayList;

public class SqlHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    //创建库
    public SqlHelper(Context context) {
        super(context, "xiao.db", null, 1);
    }

    //创建表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table xiaoe(name varchar(11),age int)");

    }

    //数据库的升级
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    //添加数据
    public void insertXiao(DbBean dbBean) {
        db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", dbBean.getName());
        values.put("age", dbBean.getAge());


        db.insert("xiaoe", null, values);
    }

    //删除
    public void deleteXiao(String name) {
        db.delete("xiaoe", "name=?", new String[]{"张三"});
    }

    //修改
    public void updata(String oldName, String newName) {
        ContentValues values = new ContentValues();
        values.put("name", newName);

        db.update("xiaoe", values, "name=?", new String[]{oldName});
    }

    //查询所有数据
    public ArrayList<DbBean> query() {

        Cursor cursor = db.query("xiaoe", null, null, null, null, null, null);
        ArrayList<DbBean> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int age = cursor.getInt(cursor.getColumnIndex("age"));
            list.add(new DbBean(name, age));
        }
        return list;

    }

    //条件查询数据
    public ArrayList<DbBean> queryCondition(String name) {
        //第二个参数：需要 查询的列
        //selection:条件，"name=?",
        // selectionArgs:条件参数，new String[]{oldName}
        //groupby：分组
        //orderBy：排序

        Cursor cursor = db.query("xiaoe", null, "name=?",
                new String[]{name}, null, null, null);
        ArrayList<DbBean> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            String name1 = cursor.getString(cursor.getColumnIndex("name"));
            int age = cursor.getInt(cursor.getColumnIndex("age"));
            list.add(new DbBean(name1, age));
        }
        return list;
    }


}
