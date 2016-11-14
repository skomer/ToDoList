package com.example.user.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.todo_listview);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        setUpToDoItemList()
                );

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String)mListView.getItemAtPosition(position);
                Log.d("ListView:", selected + " selected");
            }
        });
    }

    private ArrayList<String> setUpToDoItemList() {
        ArrayList<String> toDoItemList = new ArrayList<String>();

        String[] strings = {
                "string1",
                "string2",
                "string3",
                "string4",
                "string5",
                "string6",
        };

        for (int i = 0; i < strings.length; i++) {
            toDoItemList.add(strings[i]);
        }

        return toDoItemList;
    }

}