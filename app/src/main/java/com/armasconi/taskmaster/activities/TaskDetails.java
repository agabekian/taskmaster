package com.armasconi.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.armasconi.taskmaster.R;
import com.armasconi.taskmaster.adapter.TaskRecyclerViewAdapter;

public class TaskDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        displayTaskName();
        displayTaskBody();
    }

    public void displayTaskName() {
        Intent callingIntent = getIntent();
        String textStarter = null;
        if (callingIntent != null) {
            textStarter = callingIntent.getStringExtra(MyTasksActivity.MY_TASK_NAME);
        }
        TextView taskTextView = findViewById(R.id.taskTextView);
        if (textStarter != null) {
            taskTextView.setText(textStarter);
        } else {
            taskTextView.setText("Nada");
        }
    }

    public void displayTaskBody() {
        Intent callingIntent = getIntent();
        String textBody = null;

        if (callingIntent != null) {
            textBody = callingIntent.getStringExtra(MyTasksActivity.MY_TASK_BODY);
        }
        TextView textBodyView = findViewById(R.id.taskTextView2);
        if (textBody != null) {
            textBodyView.setText(textBody);
        } else {
            textBodyView.setText("No body");
        }
    }

//    public void displayTaskStatus() { //finish passing boolean
//        Intent callingIntent = getIntent();
//        Boolean status = false;
//        if (callingIntent != null) {
//            status = callingIntent.getBooleanExtra("statuS", MyTasksActivity.MY_TASK_STATE);
//        }
//        TextView statusView = findViewById(R.id.taskStatusView);
//        if (status != null) {
//            statusView.setText((status);
//        }
//
//    }
}