package com.example.user.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button mNewButton;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNewButton = (Button)findViewById(R.id.new_button);

        mNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ToDoList", "'new item' button clicked");
                Intent intent = new Intent(MainActivity.this, NewItemActivity.class);
                startActivity(intent);
            }
        });

        mListView = (ListView)findViewById(R.id.todo_listview);


        ToDoItemsAdapter adapter =
                new ToDoItemsAdapter(
                        this,
                        setUpToDoItemObjectsList()
                );

        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToDoItem selected = (ToDoItem)mListView.getItemAtPosition(position);
                Log.d("ListView:", selected + " selected");
                Intent intent = new Intent(MainActivity.this, ViewItemActivity.class);
                intent.putExtra("id", selected.id);
                startActivity(intent);
            }
        });
    }

    private ArrayList<ToDoItem> setUpToDoItemObjectsList() {

        DatabaseHandler dbHandler = new DatabaseHandler(MainActivity.this);
        ArrayList<ToDoItem> allItems = dbHandler.getAllItems();
        return allItems;

    }


}