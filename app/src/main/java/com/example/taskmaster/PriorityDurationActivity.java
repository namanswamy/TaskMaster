package com.example.taskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class PriorityDurationActivity extends AppCompatActivity {

    private EditText taskDuration1, taskDuration2, taskDuration3, taskDuration4, taskDuration5;
    private Spinner prioritySpinner, prioritySpinner2, prioritySpinner3, prioritySpinner4, prioritySpinner5;
    private Button displayTasksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priority_duration);

        taskDuration1 = findViewById(R.id.taskDuration1);
        taskDuration2 = findViewById(R.id.taskDuration2);
        taskDuration3 = findViewById(R.id.taskDuration3);
        taskDuration4 = findViewById(R.id.taskDuration4);
        taskDuration5 = findViewById(R.id.taskDuration5);

        prioritySpinner = findViewById(R.id.prioritySpinner);
        prioritySpinner2 = findViewById(R.id.prioritySpinner2);
        prioritySpinner3 = findViewById(R.id.prioritySpinner3);
        prioritySpinner4 = findViewById(R.id.prioritySpinner4);
        prioritySpinner5 = findViewById(R.id.prioritySpinner5);

        displayTasksButton = findViewById(R.id.displayTasksButton);

        displayTasksButton.setOnClickListener(v -> {
            calculateAndDisplayTasks();
        });
    }

    private void calculateAndDisplayTasks() {
        int[] priorities = {
                Integer.parseInt(prioritySpinner.getSelectedItem().toString()),
                Integer.parseInt(prioritySpinner2.getSelectedItem().toString()),
                Integer.parseInt(prioritySpinner3.getSelectedItem().toString()),
                Integer.parseInt(prioritySpinner4.getSelectedItem().toString()),
                Integer.parseInt(prioritySpinner5.getSelectedItem().toString())
        };

        int[] durations = {
                Integer.parseInt(taskDuration1.getText().toString()),
                Integer.parseInt(taskDuration2.getText().toString()),
                Integer.parseInt(taskDuration3.getText().toString()),
                Integer.parseInt(taskDuration4.getText().toString()),
                Integer.parseInt(taskDuration5.getText().toString())
        };

        double[] ratios = new double[5];
        for (int i = 0; i < 5; i++) {
            ratios[i] = (double) priorities[i] / (double) durations[i];
        }

        // Start DisplayTasksActivity and pass the data
        Intent intent = new Intent(PriorityDurationActivity.this,DisplayTasksActivity.class);
        intent.putExtra("task1", getIntent().getStringExtra("task1"));
        intent.putExtra("task2", getIntent().getStringExtra("task2"));
        intent.putExtra("task3", getIntent().getStringExtra("task3"));
        intent.putExtra("task4", getIntent().getStringExtra("task4"));
        intent.putExtra("task5", getIntent().getStringExtra("task5"));
        intent.putExtra("priority1", priorities[0]);
        intent.putExtra("priority2", priorities[1]);
        intent.putExtra("priority3", priorities[2]);
        intent.putExtra("priority4", priorities[3]);
        intent.putExtra("priority5", priorities[4]);
        intent.putExtra("duration1", durations[0]);
        intent.putExtra("duration2", durations[1]);
        intent.putExtra("duration3", durations[2]);
        intent.putExtra("duration4", durations[3]);
        intent.putExtra("duration5", durations[4]);
        startActivity(intent);
    }
}

