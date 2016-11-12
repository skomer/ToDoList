package com.example.user.todolist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ToDoItemTest {

    ToDoItem getAJob;
    ToDoItem cleanFlat;
    ToDoItem makeCushion;

    @Before
    public void before() {
        getAJob = new ToDoItem("Get a job", "Figure out what kind of job I would like and tailor CV.", 2);
        cleanFlat = new ToDoItem("Clean the flat", "Wash the floors because they are sticky", 1);
        makeCushion = new ToDoItem("Make cushion", "Keep piecing the shapes and think about the layout", 0);
    }

    @Test
    public void testItemHasTitle() {
        assertEquals("Clean the flat", cleanFlat.getTitle());
    }

    @Test
    public void testCanSetItemTitle() {
        cleanFlat.setTitle("Clean my flat");
        assertEquals("Clean my flat", cleanFlat.getTitle());
    }

    @Test
    public void testItemHasDescription() {
        assertEquals("Wash the floors because they are sticky", cleanFlat.getDescription());
    }

    @Test
    public void testCanSetItemDescription() {
        makeCushion.setDescription("Make hexagons");
        assertEquals("Make hexagons", makeCushion.getDescription());
    }

    @Test
    public void testItemHasCategory() {
        assertEquals("high", getAJob.getCategory());
    }

    @Test
    public void testCanSetCategory() {
        cleanFlat.setCategory(0);
        assertEquals("low", cleanFlat.getCategory());
    }

}
