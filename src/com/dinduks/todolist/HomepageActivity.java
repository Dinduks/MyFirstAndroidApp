package com.dinduks.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

/**
 *
 * @author dinduks
 */
public class HomepageActivity extends Activity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.homepage);

        final Button addATaskButton = (Button)findViewById(R.id.addATaskButton);
        addATaskButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, AddATaskActivity.class);
                startActivity(intent);
            }
        });

        final Button viewAllTheTasksButton = (Button)findViewById(R.id.viewAllTheTasksButton);
        viewAllTheTasksButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, ListTasksActivity.class);
                startActivity(intent);
            }
        });
    }

}