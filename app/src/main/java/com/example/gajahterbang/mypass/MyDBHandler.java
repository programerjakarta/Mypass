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
    private static final String TABLE_PASSWORDS= "passwords";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_IP = "ip";

    public MyDBHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_PASSWORDS+ "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_IP
                + " TEXT" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PASSWORDS);
        onCreate(db);
    }

    public void addPassword(Password password) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_IP, password.getIP());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_PASSWORDS, null, values);
        db.close();
    }

    public Password findPassword(String ip) {
        String query = "Select * FROM " + TABLE_PASSWORDS+ " WHERE " + COLUMN_IP+ " =  \"" + ip + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Password password = new Password();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            password.setID(Integer.parseInt(cursor.getString(0)));
            password.setIP(cursor.getString(1));
            cursor.close();
        } else {
            password = null;
        }
        db.close();
        return password;
    }

    public boolean deletePassword(String ip) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_PASSWORDS+ " WHERE " + COLUMN_IP+ " =  \"" + ip+ "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Password password= new Password();

        if (cursor.moveToFirst()) {
            password.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_PASSWORDS, COLUMN_ID + " = ?",
                    new String[] { String.valueOf(password.getID()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
}
