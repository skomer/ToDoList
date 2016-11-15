package com.example.user.todolist;

import java.util.Date;


public class ToDoItem {

    public int id;
    public String title;
    public String description;
    public String whenCompleted;
    public int categoryIndex;

    public static final String[] categories = {"low", "medium", "high"};

    public ToDoItem() {}

    public ToDoItem(String title, String description, int categoryIndex) {
        this.title = title;
        this.description = description;
        this.categoryIndex = categoryIndex;
        this.whenCompleted = null;
    }

    public ToDoItem(int id, String title, String description, String whenCompleted, int categoryIndex) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.whenCompleted = whenCompleted;
        this.categoryIndex = categoryIndex;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int newID) {
        this.id = newID;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public int getCategoryIndex() {
        return this.categoryIndex;
    }

    public String getCategory() {
        return categories[this.categoryIndex];
    }

    public void setCategory(int newCategoryIndex) {
        this.categoryIndex = newCategoryIndex;
    }

    public String getWhenCompleted() {
        return this.whenCompleted;
    }

    public void setWhenCompleted() {
        Date dateNow = new Date();
        this.whenCompleted = dateNow.toString();
    }

}
