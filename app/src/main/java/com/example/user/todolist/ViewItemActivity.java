package com.example.user.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ViewItemActivity extends AppCompatActivity {

    EditText mItemTitle;
    EditText mItemDescription;
    Button mSaveButton;
    ToDoItem mSelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);
        mItemTitle = (EditText) findViewById(R.id.view_item_title);
        mItemDescription = (EditText) findViewById(R.id.view_item_description);
        //mPriorityDisplay = (TextView) findViewById(R.id.//go and get the priority)
        mSaveButton = (Button) findViewById(R.id.save_button);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int itemId = extras.getInt("id");

        DatabaseHandler dbHandler = new DatabaseHandler(this);
        mSelectedItem = dbHandler.getItem(itemId);

        String title = mSelectedItem.title;
        String description = mSelectedItem.description;

        mItemTitle.setText(title);
        mItemDescription.setText(description);


        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("ToDoList", "'save item' button clicked");
                String newTitle = mItemTitle.getText().toString();
                String newDescription = mItemDescription.getText().toString();

                mSelectedItem.setTitle(newTitle);
                mSelectedItem.setDescription(newDescription);

                //ToDoItem newItem = new ToDoItem(newTitle, newDescription, mPriority);
                DatabaseHandler dbHandler = new DatabaseHandler(ViewItemActivity.this);
                dbHandler.updateItem(mSelectedItem);

                Intent intent = new Intent(ViewItemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });






    }

}
