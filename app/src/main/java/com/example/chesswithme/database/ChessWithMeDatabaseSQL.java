package com.example.chesswithme.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ChessWithMeDatabaseSQL {

//    private static final String DB_NAME = "users.db";
//    private static final String TABLE_NAME = "Users";
//
//    private static final String COLUMN_EMAIL = "email";
//    private static final String COLUMN_PASSWORD = "password";
//    private static final String COLUMN_JOIN_DATE = "join_date";
//
//    public ChessWithMeDatabaseSQL(Context context) {
//        super(context, DB_NAME, null, 1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COLUMN_EMAIL + " TEXT, " + COLUMN_PASSWORD + " INTEGER, " + COLUMN_JOIN_DATE + " TEXT" + ");");
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE " + TABLE_NAME + ";");
//        onCreate(db);
//    }
//
//    @Override
//    public void save(User user) {
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_EMAIL, user.email);
//        values.put(COLUMN_PASSWORD, user.password);
//        values.put(COLUMN_JOIN_DATE, user.join_date);
//        db.insert(TABLE_NAME, null, values);
//    }
//
//    @Override
//    public User get(int password) {
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
//        cursor.moveToPosition(password);
//        int emailIndex = cursor.getColumnIndex(COLUMN_EMAIL);
//        int join_dateIndex = cursor.getColumnIndex(COLUMN_JOIN_DATE);
//        String email = cursor.getString(emailIndex);
//        String join_date = cursor.getString(join_dateIndex);
//        cursor.close();
//        return new User(email, password, join_date);
//    }
//
//    @Override
//    public List<User> getAll() {
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
//        List<User> list = new ArrayList<>();
//        if (cursor.moveToFirst()) {
//            do {
//                int emailIndex = cursor.getColumnIndex(COLUMN_EMAIL);
//                int join_dateIndex = cursor.getColumnIndex(COLUMN_JOIN_DATE);
//                int passwordIndex = cursor.getColumnIndex(COLUMN_PASSWORD);
//                String email = cursor.getString(emailIndex);
//                String join_date = cursor.getString(join_dateIndex);
//                int password = cursor.getInt(passwordIndex);
//                list.add(new User(email, password, join_date));
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        return list;
//    }
}
