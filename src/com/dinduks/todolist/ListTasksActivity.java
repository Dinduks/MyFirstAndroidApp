package com.dinduks.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

//import static java.lang.String.valueOf;

/**
 *
 * @author dinduks
 */
public class ListTasksActivity extends Activity {
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.listtasks);

        LinearLayout layout = (LinearLayout) findViewById(R.id.listTasksLayout);

        List<Task> tasks = StorageSingleton.get().getTasks();
        for (Task task: tasks) {
            final int taskIndex = tasks.indexOf(task);

            // TODO: Add a line return to each TextView
            TextView text = new TextView(this);
            text.setText(task.getTitle());
            text.setClickable(true);

            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.w(String.valueOf(taskIndex), String.valueOf(taskIndex));
                    Intent intent = new Intent(ListTasksActivity.this, ShowTaskActivity.class);
                    intent.putExtra("taskIndex'", taskIndex);
                    startActivity(intent);
                }
            });

            layout.addView(text);
        }

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