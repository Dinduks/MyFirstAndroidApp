package com.dinduks.todolist;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 *
 * @author dinduks
 */
public class EditTaskActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taskform);

        Bundle bundle = this.getIntent().getExtras();
        final int taskIndex = bundle.getInt("taskIndex");
        Task task = StorageSingleton.get().getTasks().get(taskIndex);
        
        final EditText title = (EditText) findViewById(R.id.taskTitle);
        final EditText description = (EditText) findViewById(R.id.taskDescription);
        
        title.setText(task.getTitle());
        description.setText(task.getDescription());

        Button saveButton = (Button) findViewById(R.id.submit);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titleText = title.getText().toString();
                String descriptionText = description.getText().toString();
                StorageSingleton.get().editTask(taskIndex, titleText, descriptionText);
                buildSuccessDialog(taskIndex).show();
            }
        });

        final Button cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(EditTaskActivity.this, ShowTaskActivity.class);
                intent.putExtra("taskIndex", taskIndex);
                startActivity(intent);
            }
        });
    }

    private AlertDialog buildSuccessDialog(final int taskIndex) {
        AlertDialog.Builder builder = new AlertDialog.Builder(EditTaskActivity.this);
        builder.setMessage("The task was successfully edited!")
                .setCancelable(false)
                .setNeutralButton("Go back to the homepage", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(EditTaskActivity.this, ShowTaskActivity.class);
                        intent.putExtra("taskIndex", taskIndex);
                        startActivity(intent);
                    }
                });
        return builder.create();
    }
}