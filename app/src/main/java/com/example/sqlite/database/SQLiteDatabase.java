package com.example.sqlite.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDatabase extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "learn_sqlite_2";
    private final static String TODO_TABLE_NAME = "todos";
    private final static String TODO_CREATE_TABLE_QUERY = "CREATE TABLE " + TODO_TABLE_NAME + " " +
            "(name VARCHAR(120))";

    public SQLiteDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(android.database.sqlite.SQLiteDatabase db) {
        db.execSQL(TODO_CREATE_TABLE_QUERY);
        db.execSQL("INSERT INTO " + TODO_TABLE_NAME + " VALUES('Quiz CPEN6098')");
    }

    public Cursor getAllTodos() {
        android.database.sqlite.SQLiteDatabase db = getWritableDatabase();
        Cursor allTodosCursor = db.rawQuery("SELECT * FROM todos", null);

        return allTodosCursor;
    }

    public boolean insertTodo(String todoName) {
        android.database.sqlite.SQLiteDatabase db = getWritableDatabase();

        try {
            db.execSQL("INSERT INTO " + TODO_TABLE_NAME + " VALUES('" + todoName + "')");
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean deleteTodo(String todoName) {
        android.database.sqlite.SQLiteDatabase db = getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + TODO_TABLE_NAME + " WHERE name = '" + todoName + "'");
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean updateTodo(String currentName, String updateName) {
        android.database.sqlite.SQLiteDatabase db = getWritableDatabase();

        try {
            db.execSQL("UPDATE " + TODO_TABLE_NAME + " SET name = '" + updateName + "' WHERE name =  '" + currentName+ "'");
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public synchronized void close() {
        super.close();
    }
}
