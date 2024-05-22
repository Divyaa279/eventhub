package com.example.eventhub;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "UserDB";
    private static final String TABLE_NAME = "users";
    private static final String COL_ID = "ID";
    private static final String COL_FULLNAME = "FullName";
    private static final String COL_EMAIL = "Email";
    private static final String COL_PASSWORD = "Password";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COL_FULLNAME + " TEXT," +
            COL_EMAIL + " TEXT," +
            COL_PASSWORD + " TEXT)";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String fullname, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_FULLNAME, fullname);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_PASSWORD, password);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public boolean updateData(String id, String fullname, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_FULLNAME, fullname);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_PASSWORD, password);
        int result = db.update(TABLE_NAME, contentValues, COL_ID + "=?", new String[]{id});
        return result > 0;
    }

    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COL_ID + "=?", new String[]{id});
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COL_ID};
        String selection = COL_FULLNAME + " = ?" + " AND " + COL_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }

}
