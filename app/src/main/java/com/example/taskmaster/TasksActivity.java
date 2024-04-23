package com.example.taskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class TasksActivity extends AppCompatActivity {

    private EditText edt1, edt2, edt3, edt4, edt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        edt4 = findViewById(R.id.edt4);
        edt5 = findViewById(R.id.edt5);

        findViewById(R.id.nextButton).setOnClickListener(v -> {
            moveToPriorityDurationActivity();
        });
    }

    private void moveToPriorityDurationActivity() {
        Intent intent = new Intent(TasksActivity.this, PriorityDurationActivity.class);
        intent.putExtra("task1", edt1.getText().toString());
        intent.putExtra("task2", edt2.getText().toString());
        intent.putExtra("task3", edt3.getText().toString());
        intent.putExtra("task4", edt4.getText().toString());
        intent.putExtra("task5", edt5.getText().toString());
        startActivity(intent);
    }
}
