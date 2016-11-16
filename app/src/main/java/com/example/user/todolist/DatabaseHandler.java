package com.example.user.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "toDoList";
    private static final String TABLE_ITEMS = "items";

    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_WHEN_COMPLETED = "whenCompleted";
    private static final String KEY_CATEGORY_INDEX = "categoryIndex";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ITEMS_TABLE =
                "CREATE TABLE " + TABLE_ITEMS + "(" +
                        KEY_ID + " INTEGER PRIMARY KEY," +
                        KEY_TITLE + " VARCHAR(255)," +
                        KEY_DESCRIPTION + " TEXT," +
                        KEY_WHEN_COMPLETED + " TIMESTAMP," +
                        KEY_CATEGORY_INDEX + " INTEGER" +
                        ")";
        db.execSQL(CREATE_ITEMS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        onCreate(db);
    }


    // CRUD operations

    public void addToDoItem(ToDoItem item) {

        SQLiteDatabase write_db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, item.getTitle());
        values.put(KEY_DESCRIPTION, item.getDescription());
        values.put(KEY_WHEN_COMPLETED, item.getWhenCompleted());
        values.put(KEY_CATEGORY_INDEX, item.getCategoryIndex());

        write_db.insert(TABLE_ITEMS, null, values);
        write_db.close();
    }

    public ToDoItem getItem(int id) {

        SQLiteDatabase read_db = this.getReadableDatabase();

        Cursor cursor = read_db.query(
                TABLE_ITEMS, new String[] {
                        KEY_ID,
                        KEY_TITLE,
                        KEY_DESCRIPTION,
                        KEY_WHEN_COMPLETED,
                        KEY_CATEGORY_INDEX
                },
                KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null
        );
        if (cursor != null)
            cursor.moveToFirst();

        ToDoItem item = new ToDoItem(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                Integer.parseInt(cursor.getString(4))
        );

        read_db.close();
        return item;

    }

    public ArrayList<ToDoItem> getAllItems() {

        SQLiteDatabase write_db = this.getWritableDatabase();
        ArrayList<ToDoItem> toDoList = new ArrayList<ToDoItem>();
        String selectQuery = "SELECT * FROM " + TABLE_ITEMS;
        Cursor cursor = write_db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ToDoItem item = new ToDoItem();
                item.setID(Integer.parseInt(cursor.getString(0)));
                item.setTitle(cursor.getString(1));
                item.setDescription(cursor.getString(2));
                item.setWhenCompleted();
                item.setCategory(Integer.parseInt(cursor.getString(4)));
                toDoList.add(item);
            } while (cursor.moveToNext());
        }

        write_db.close();
        return toDoList;

    }

    public int updateItem(ToDoItem item) {

        SQLiteDatabase write_db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, item.getTitle());
        values.put(KEY_DESCRIPTION, item.getDescription());
        values.put(KEY_WHEN_COMPLETED, item.getWhenCompleted());
        values.put(KEY_CATEGORY_INDEX, item.getCategoryIndex());

        int newID = write_db.update(TABLE_ITEMS, values, KEY_ID + " = ?", new String[] { String.valueOf(item.getID()) });
        write_db.close();
        return newID;
    }

    public void deleteItem(ToDoItem item) {

        SQLiteDatabase write_db = this.getWritableDatabase();

        write_db.delete(TABLE_ITEMS, KEY_ID + " = ?", new String[] { String.valueOf(item.getID()) });
        write_db.close();

    }

}



