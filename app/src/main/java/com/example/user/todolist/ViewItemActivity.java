package com.example.user.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class ViewItemActivity extends AppCompatActivity {

    EditText mItemTitle;
    EditText mItemDescription;
    Button mSaveButton;
    ToDoItem mSelectedItem;
    RadioButton mRadioButton;
    CheckBox mCompletedCheckBox;
//    CheckBox whenCompletedCheckBox;
    String mWhenCompletedInsert;
    int mCategoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);
        mItemTitle = (EditText) findViewById(R.id.item_title_edit);
        mItemDescription = (EditText) findViewById(R.id.item_description_edit);

        mSaveButton = (Button) findViewById(R.id.save_button);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int itemId = extras.getInt("id");

        DatabaseHandler dbHandler = new DatabaseHandler(this);
        mSelectedItem = dbHandler.getItem(itemId);


//        Set up title and description area
        String title = mSelectedItem.title;
        String description = mSelectedItem.description;
        mItemTitle.setText(title);
        mItemDescription.setText(description);


//        Set up category/priority radio buttons
        int categoryIndex = mSelectedItem.categoryIndex;
        if (categoryIndex == 0) {
            mRadioButton = (RadioButton) findViewById(R.id.radio_low);
        } else if (categoryIndex == 1) {
            mRadioButton = (RadioButton) findViewById(R.id.radio_medium);
        } else if (categoryIndex == 2) {
            mRadioButton = (RadioButton) findViewById(R.id.radio_high);
        }
        mRadioButton.setChecked(true);

//        Set up whenCompleted checkbox
        String whenCompleted = mSelectedItem.whenCompleted;
        if (whenCompleted != null) {
            mCompletedCheckBox = (CheckBox) findViewById(R.id.checkbox_box);
            mCompletedCheckBox.setChecked(true);
            mWhenCompletedInsert = mSelectedItem.getWhenCompleted();
            TextView whenCompletedInsert = (TextView) findViewById(R.id.when_completed_insert);
            whenCompletedInsert.setText(mWhenCompletedInsert);

        }


        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newTitle = mItemTitle.getText().toString();
                String newDescription = mItemDescription.getText().toString();

                mSelectedItem.setTitle(newTitle);
                mSelectedItem.setDescription(newDescription);
                mSelectedItem.setCategory(mCategoryIndex);

                DatabaseHandler dbHandler = new DatabaseHandler(ViewItemActivity.this);
                dbHandler.updateItem(mSelectedItem);

                Toast toast = Toast.makeText(ViewItemActivity.this, R.string.item_save, Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(ViewItemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onRadioButtonClicked(View view) {
        boolean selected = ((RadioButton) view).isChecked();
        switch (view.getId()) {
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



//    mCompletedCheckBox.setOnClickListener(new View.OnClickListener() {
//
//
//        public void addListenerOnCheckBox() {
//
//            mCompletedCheckBox = (CheckBox) findViewById(R.id.checkbox_box);
//            mCompletedCheckBox.setOnClickListener(new View.OnClickListener() {
//
//                public void onCheckboxClicked(View view) {
//
//                    String dateCompleted;
//                    if (((CheckBox) view).isChecked()) {
//                        mSelectedItem.setWhenCompleted();
//                        dateCompleted = mSelectedItem.getWhenCompleted();
//                        TextView whenCompletedInsert = (TextView) findViewById(R.id.when_completed_insert);
//                        whenCompletedInsert.setText(dateCompleted);
//                    }
//                }
//
//            });
//
//        }
//
//
//    })



    public void onCheckboxClicked(View view) {

        String dateCompleted;
        if (((CheckBox) view).isChecked()) {
            mSelectedItem.setWhenCompleted();
            dateCompleted = mSelectedItem.getWhenCompleted();
            TextView whenCompletedInsert = (TextView) findViewById(R.id.when_completed_insert);
            whenCompletedInsert.setText(dateCompleted);
        } else {
            mSelectedItem.clearWhenCompleted();
        }
    }


//    public void addListenerOnCheckBox() {
//
//        whenCompletedCheckBox = (CheckBox) findViewById(R.id.checkbox_box);
//
//        whenCompletedCheckBox.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                String dateCompleted;
//                if (((CheckBox) view).isChecked()) {
//                    mSelectedItem.setWhenCompleted();
//                    dateCompleted = mSelectedItem.getWhenCompleted();
//                    TextView whenCompletedInsert = (TextView) findViewById(R.id.when_completed_insert);
//                    whenCompletedInsert.setText(dateCompleted);
//                }
//            }
//        });
//    }

}
