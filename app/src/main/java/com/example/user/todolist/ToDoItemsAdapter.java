package com.example.user.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// Developed following the tutorial here: https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView
public class ToDoItemsAdapter extends ArrayAdapter<ToDoItem> {

    public ToDoItemsAdapter(Context context, ArrayList<ToDoItem> toDoItems) {
        super(context, 0, toDoItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ToDoItem toDoItem = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_todoitem, parent, false);
        }
        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(toDoItem.title);

        TextView categoryTV = (TextView) convertView.findViewById(R.id.category);
        categoryTV.setText(toDoItem.getCategory());

        return convertView;
    }


}
