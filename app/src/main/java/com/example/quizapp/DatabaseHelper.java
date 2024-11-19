package com.example.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class DatabaseHelper extends SQLiteOpenHelper {

    private final Context context;
    private static final String DATABASE_NAME = "ScoreBoard.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "ScoreBoard";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_UserName = "user_name";
    private static final String COLUMN_Marks = "marks";

    DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_UserName + " TEXT, " +
                COLUMN_Marks + " INTEGER "+ ");";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean adduser(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        boolean success=false;
        boolean userFound = false;

        cv.put(COLUMN_UserName, username);
        cv.put(COLUMN_Marks, 0);

        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()) {
                do {
                    String user = cursor.getString(cursor.getColumnIndexOrThrow("user_name"));
                    if(user.equals(username)){
                        userFound=true;
                    }
                } while (cursor.moveToNext());
            }

            cursor.close();


            if(!userFound){
                long result = db.insert(TABLE_NAME,null, cv);
                if(result == -1){
                    Toast.makeText(context, "Internal Error!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
                    success=true;
                }
            }else{
                Toast.makeText(context, "Username already taken!", Toast.LENGTH_SHORT).show();
            }
            db.close();
        }
        return success;
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

//    void updateData(String row_id, String title, String author, String pages){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put(COLUMN_TITLE, title);
//        cv.put(COLUMN_AUTHOR, author);
//        cv.put(COLUMN_PAGES, pages);
//
//        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
//        if(result == -1){
//            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
//        }
//
//    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

}
