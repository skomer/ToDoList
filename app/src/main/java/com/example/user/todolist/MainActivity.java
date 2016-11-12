package com.example.user.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

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

        mListView.setOnItemClickListener();



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
