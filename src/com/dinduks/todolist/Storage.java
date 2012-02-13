package com.dinduks.todolist;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dinduks
 */
public class Storage {

    public static ArrayList<Task> tasks = new ArrayList<Task>();

    public static List getTasks() {
        return tasks;
    }

    public static void addTask(Task task) {
        tasks.add(task);
    }

}
