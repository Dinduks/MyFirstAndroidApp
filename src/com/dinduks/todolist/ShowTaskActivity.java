package com.dinduks.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 *
 * @author dinduks
 */
public class ShowTaskActivity extends Activity {
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.showtask);
        
        Bundle bundle = this.getIntent().getExtras();
        int taskIndex = bundle.getInt("taskIndex");
        
        Task task = StorageSingleton.get().getTasks().get(taskIndex);

        TextView title = (TextView) findViewById(R.id.title);
        TextView description = (TextView) findViewById(R.id.description);

        // TODO: Add a line return to the title
        title.setText(task.getTitle());
        description.setText(task.getDescription());
        
        final Button goBackButton = (Button) findViewById(R.id.goBackButton);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowTaskActivity.this, ListTasksActivity.class);
                startActivity(intent);
            }
        });
    }
}