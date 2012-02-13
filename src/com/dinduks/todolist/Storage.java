package com.dinduks.todolist;

import java.util.ArrayList;
import java.util.List;

import com.dinduks.todolist.Task;

/**
 * Created by IntelliJ IDEA.
 * User: dinduks
 * Date: 13/02/12
 * Time: 19:19
 * To change this template use File | Settings | File Templates.
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
