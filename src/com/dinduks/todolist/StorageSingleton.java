package com.dinduks.todolist;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dinduks
 */
public class StorageSingleton {

    private static StorageSingleton instance;
    private List<Task> tasks = new ArrayList<Task>();

    private StorageSingleton() {

    }

    public static StorageSingleton get() {
        if (instance == null)
            instance = new StorageSingleton();
        return instance;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

}
