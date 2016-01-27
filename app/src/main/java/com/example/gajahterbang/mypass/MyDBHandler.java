package com.example.gajahterbang.mypass;

/**
 * Created by gajahterbang on 1/27/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "passwordDB.db";
    private static final String TABLE_NAME= "passwords";

    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_IP = "IPADDRESS";
    public static final String COLUMN_NAMA = "NAMASERVER";
    public static final String COLUMN_USERNAME= "USERNAME";
    public static final String COLUMN_PASSWORD= "PASSWORD";
    public static final String COLUMN_KETERANGAN = "KETERANGAN";

    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PASSWORD = "CREATE TABLE " +
                TABLE_NAME+ "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,NAMA TEXT,USERNAME TEXT,PASSWORD TEXT,KETERANGAN TEXT)";
        db.execSQL(CREATE_PASSWORD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String ip,String nama,String username,String password,String keterangan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_IP, ip);
        values.put(COLUMN_NAMA, nama);
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);
        values.put(COLUMN_KETERANGAN, keterangan);
        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1 )
            return false;
        else
            return true;
    }
//
//    public Password findPassword(String ip) {
//        String query = "Select * FROM " + TABLE_PASSWORDS+ " WHERE " + COLUMN_IP+ " =  \"" + ip + "\"";
//
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        Cursor cursor = db.rawQuery(query, null);
//
//        Password password = new Password();
//
//        if (cursor.moveToFirst()) {
//            cursor.moveToFirst();
//            password.setID(Integer.parseInt(cursor.getString(0)));
//            password.setIP(cursor.getString(1));
//            cursor.close();
//        } else {
//            password = null;
//        }
//        db.close();
//        return password;
//    }
//
//    public boolean deletePassword(String ip) {
//
//        boolean result = false;
//
//        String query = "Select * FROM " + TABLE_PASSWORDS+ " WHERE " + COLUMN_IP+ " =  \"" + ip+ "\"";
//
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        Cursor cursor = db.rawQuery(query, null);
//
//        Password password= new Password();
//
//        if (cursor.moveToFirst()) {
//            password.setID(Integer.parseInt(cursor.getString(0)));
//            db.delete(TABLE_PASSWORDS, COLUMN_ID + " = ?",
//                    new String[] { String.valueOf(password.getID()) });
//            cursor.close();
//            result = true;
//        }
//        db.close();
//        return result;
//    }
}
