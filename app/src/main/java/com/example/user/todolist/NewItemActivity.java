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
import android.widget.Toast;


public class NewItemActivity extends AppCompatActivity {

    TextView mNewItem;
    Button mSaveButton;
    EditText mTitleTextBox;
    EditText mDescriptionTextBox;
    int mCategoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);
        mNewItem = (TextView) findViewById(R.id.item_title_text);
        mSaveButton = (Button) findViewById(R.id.save_button);
        mTitleTextBox = (EditText) findViewById(R.id.item_title_edit);
        mDescriptionTextBox = (EditText) findViewById(R.id.item_description_edit);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ToDoList", "'save item' button clicked");
                String newTitle = mTitleTextBox.getText().toString();
                String newDescription = mDescriptionTextBox.getText().toString();

                ToDoItem newItem = new ToDoItem(newTitle, newDescription, mCategoryIndex);
                DatabaseHandler databaseHandler = new DatabaseHandler(NewItemActivity.this);
                databaseHandler.addToDoItem(newItem);

                Toast toast = Toast.makeText(NewItemActivity.this, R.string.item_save, Toast.LENGTH_SHORT);
                toast.show();

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
                    mCategoryIndex = 2;
                break;
            case R.id.radio_medium:
                if (selected)
                    mCategoryIndex = 1;
                break;
            case R.id.radio_low:
                if (selected)
                    mCategoryIndex = 0;
                break;
        }
    }

}
