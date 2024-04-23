package com.example.taskmaster;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayTasksActivity extends AppCompatActivity {

    private TextView task1TextView, task2TextView, task3TextView, task4TextView, task5TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        task1TextView = findViewById(R.id.task1TextView);
        task2TextView = findViewById(R.id.task2TextView);
        task3TextView = findViewById(R.id.task3TextView);
        task4TextView = findViewById(R.id.task4TextView);
        task5TextView = findViewById(R.id.task5TextView);

        String[] tasks = {
                getIntent().getStringExtra("task1"),
                getIntent().getStringExtra("task2"),
                getIntent().getStringExtra("task3"),
                getIntent().getStringExtra("task4"),
                getIntent().getStringExtra("task5")
        };

        int[] priorities = {
                getIntent().getIntExtra("priority1", 1),
                getIntent().getIntExtra("priority2", 1),
                getIntent().getIntExtra("priority3", 1),
                getIntent().getIntExtra("priority4", 1),
                getIntent().getIntExtra("priority5", 1)
        };

        int[] durations = {
                getIntent().getIntExtra("duration1", 0),
                getIntent().getIntExtra("duration2", 0),
                getIntent().getIntExtra("duration3", 0),
                getIntent().getIntExtra("duration4", 0),
                getIntent().getIntExtra("duration5", 0)
        };

        double[] ratios = new double[5];
        for (int i = 0; i < 5; i++) {
            ratios[i] = (double) priorities[i] / (double) durations[i];
        }

        mergeSort(ratios, tasks, 0, 4);

        task1TextView.setText(tasks[4]);
        task2TextView.setText(tasks[3]);
        task3TextView.setText(tasks[2]);
        task4TextView.setText(tasks[1]);
        task5TextView.setText(tasks[0]);
    }

    private void mergeSort(double[] ratios, String[] tasks, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(ratios, tasks, left, mid);
            mergeSort(ratios, tasks, mid + 1, right);
            merge(ratios, tasks, left, mid, right);
        }
    }

    private void merge(double[] ratios, String[] tasks, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] L = new double[n1];
        double[] R = new double[n2];
        String[] LTask = new String[n1];
        String[] RTask = new String[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = ratios[left + i];
            LTask[i] = tasks[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = ratios[mid + 1 + j];
            RTask[j] = tasks[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                ratios[k] = L[i];
                tasks[k] = LTask[i];
                i++;
            } else {
                ratios[k] = R[j];
                tasks[k] = RTask[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            ratios[k] = L[i];
            tasks[k] = LTask[i];
            i++;
            k++;
        }

        while (j < n2) {
            ratios[k] = R[j];
            tasks[k] = RTask[j];
            j++;
            k++;
        }
    }
}
