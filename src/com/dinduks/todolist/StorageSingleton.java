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

    public void deleteTask(int taskIndex) {
        tasks.remove(taskIndex);
    }
    
    public void editTask(int taskIndex, String title, String description) {
        Task task = tasks.get(taskIndex);
        task.setTitle(title);
        task.setDescription(description);
        tasks.set(taskIndex, task);
    }

}