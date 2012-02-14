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
public class AddATaskActivity extends Activity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.addatask);

        final Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final EditText taskTitle = (EditText) findViewById(R.id.taskTitle);
                final EditText taskDescription = (EditText) findViewById(R.id.taskDescription);

                saveTask(taskTitle.getText().toString(), taskDescription.getText().toString());

                buildSuccessDialog().show();
            }
        });
    }

    private void saveTask(String title, String description) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        StorageSingleton.get().addTask(task);
    }

    private AlertDialog buildSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AddATaskActivity.this);
        builder.setMessage("The task was successfully saved!")
                .setCancelable(false)
                .setNeutralButton("Go back to the homepage", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(AddATaskActivity.this, HomepageActivity.class);
                        startActivity(intent);
                    }
                });
        return builder.create();
    }

}
