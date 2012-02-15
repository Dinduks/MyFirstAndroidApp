package com.dinduks.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.dinduks.todolist.models.Task;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dinduks
 */
public class ListTasksActivity extends Activity {

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.listtasks);

        // Create a list of the tasks' titles
        List<Task> tasks = StorageSingleton.get().getTasks();
        List<String> tasksNames = new ArrayList<String>();
        for (Task task: tasks) {
            tasksNames.add(task.getTitle());
        }

        ListView lv = new ListView(this);
        // Create an adapter using the XML list and the list of the tasks' titles
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listtasks_list, tasksNames);
        lv.setAdapter(adapter);
        // Set an OnClick event on the list's elements
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int taskIndex, long l) {
                Intent intent = new Intent(ListTasksActivity.this, ShowTaskActivity.class);
                intent.putExtra(ShowTaskActivity.TASK_INDEX, taskIndex);
                startActivity(intent);
            }
        });

        LinearLayout layout = (LinearLayout) findViewById(R.id.listTasksLayout);
        layout.addView(lv);

        final Button goBackButton = (Button) findViewById(R.id.goBackButton);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListTasksActivity.this, HomepageActivity.class);
                startActivity(intent);
            }
        });
    }

}
