package com.example.user.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class ViewItemActivity extends AppCompatActivity {

    TextView mItemTitle;
    TextView mItemDescription;
    TextView mPriorityDisplay;
    Button mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);
        mItemTitle = (TextView) findViewById(R.id.view_item_title);
        mItemDescription = (TextView) findViewById(R.id.view_item_description);
        //mPriorityDisplay = (TextView) findViewById(R.id.//go and get the priority)
        //mSaveButton = (Button) findViewById(R.id.save_button);


    }



}
