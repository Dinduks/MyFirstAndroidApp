package com.dinduks.todolist;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author dinduks
 */
public class ShowTaskActivity extends Activity {

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.showtask);

        Bundle bundle = this.getIntent().getExtras();
        final int taskIndex = bundle.getInt("taskIndex");

        Task task = StorageSingleton.get().getTasks().get(taskIndex);

        TextView title = (TextView) findViewById(R.id.title);
        TextView description = (TextView) findViewById(R.id.description);

        title.setText(task.getTitle());
        description.setText(task.getDescription());

        Button deleteTaskButton = (Button) findViewById(R.id.deleteTask);
        deleteTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StorageSingleton.get().deleteTask(taskIndex);
                buildDeleteSuccessDialog().show();
            }
        });

        Button editTaskButton = (Button) findViewById(R.id.editTask);
        editTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowTaskActivity.this, EditTaskActivity.class);
                intent.putExtra("taskIndex", taskIndex);
                startActivity(intent);
            }
        });
    }

    private AlertDialog buildDeleteSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ShowTaskActivity.this);
        builder.setMessage("The task was successfully removed!")
               .setCancelable(false)
               .setNeutralButton("Continue", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       Intent intent = new Intent(ShowTaskActivity.this, HomepageActivity.class);
                       startActivity(intent);
                   }
               });
        return builder.create();
    }

}