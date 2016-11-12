package com.example.user.todolist;

import java.util.Date;


public class ToDoItem {

    public String title;
    public String description;
    public Date whenCompleted;
    public int categoryIndex;

    public static final String[] categories = {"low", "medium", "high"};

    public ToDoItem(String title, String description, int categoryIndex) {
        this.title = title;
        this.description = description;
        this.categoryIndex = categoryIndex;
        this.whenCompleted = null;
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

    public String getCategory() {
        return categories[this.categoryIndex];
    }

    public void setCategory(int newCategoryIndex) {
        this.categoryIndex = newCategoryIndex;
    }

    public Date getWhenCompleted() {
        return this.whenCompleted;
    }

    public void setWhenCompleted() {
        Date dateNow = new Date();
        this.whenCompleted = dateNow;
    }







}
