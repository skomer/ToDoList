package com.example.user.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class NewItemActivity extends AppCompatActivity {

    TextView mNewItem;
    Button mSaveButton;
    EditText mTitleTextBox;
    EditText mDescriptionTextBox;
    int mPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);
        mNewItem = (TextView) findViewById(R.id.new_item);
        mSaveButton = (Button) findViewById(R.id.save_button);
        mTitleTextBox = (EditText) findViewById(R.id.new_item_title);
        mDescriptionTextBox = (EditText) findViewById(R.id.new_item_description);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ToDoList", "'save item' button clicked");
                String newTitle = mTitleTextBox.getText().toString();
                String newDescription = mDescriptionTextBox.getText().toString();

                ToDoItem newItem = new ToDoItem(newTitle, newDescription, mPriority);
                DatabaseHandler databaseHandler = new DatabaseHandler(NewItemActivity.this);
                databaseHandler.addToDoItem(newItem);

                Intent intent = new Intent(NewItemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean selected = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radio_high:
                if (selected)
                    mPriority = 2;
                break;
            case R.id.radio_medium:
                if (selected)
                    mPriority = 1;
                break;
            case R.id.radio_low:
                if (selected)
                    mPriority = 0;
                break;
        }
    }

}