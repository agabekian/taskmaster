package com.armasconi.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.armasconi.taskmaster.R;


public class MainActivity extends AppCompatActivity {
    public static final String TASK_NAME = "DUDE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button submitBtn = MainActivity.this.findViewById(R.id.btnAdd);     //1. get an UI element by id

        submitBtn.setOnClickListener(view -> {                              //2. event listener
            Context context = getApplicationContext();
            CharSequence text = "Submitted!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            //3. Callback fn()
//                Log.v("", "Very Verbose");
//                Log.d("", "Debug");
//                Log.i("", "Information");
//                Log.w("", "Warning");
//                Log.e("", "Error");
//                Log.wtf("", "What a terrible failure");
            TextView greeting = MainActivity.this.findViewById(R.id.btnAdd);
        });
        setupBtns();
        setupGreeting();
    }

    public void setupGreeting() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = preferences.getString(Settings.USERNAME_TAG, "No username");
        ((TextView) findViewById(R.id.MainTVTasksGreeting)).setText(username + "'s Tasks");
    }

    public void setupBtns() {
        Button goToSettingsBtn = MainActivity.this.findViewById(R.id.btnSettings);
        Button goToAllTasksBtn = MainActivity.this.findViewById(R.id.btnMainActivity_Tasks);
//        Button btnDisplayTask1 = MainActivity.this.findViewById(R.id.btnTask1);
//        Button btnDisplayTask2 = MainActivity.this.findViewById(R.id.btnTask2);
//        Button btnDisplayTask3 = MainActivity.this.findViewById(R.id.btnTask3);
        goToSettingsBtn.setOnClickListener(view -> {
            Intent goToSettings = new Intent(this, Settings.class);
            startActivity(goToSettings);
        });

        goToAllTasksBtn.setOnClickListener(view -> {
            Button btnAllTasks = findViewById(R.id.btnMainActivity_Tasks);
            Intent goToTasks = new Intent(this, MyTasksActivity.class);
                startActivity(goToTasks);
        });
            //TODO: send extra
        // set up the intent (Current context.this, class to go to Class.class)
//        Intent goDisplayTask1 = new Intent(this, TaskDetails.class);
//        btnDisplayTask1.setOnClickListener(view -> {
//            goDisplayTask1.putExtra(TASK_NAME, btnDisplayTask1.getText().toString());
        // launch the intent
//            startActivity(goDisplayTask1);
//
//        });
//        Intent goDisplayTask2 = new Intent(this, TaskDetails.class);
//        btnDisplayTask2.setOnClickListener(view -> {
//            goDisplayTask2.putExtra(TASK_NAME, btnDisplayTask2.getText().toString());
//            startActivity(goDisplayTask2);
//        });
//
//        Intent goDisplayTask3 = new Intent(this, TaskDetails.class);
//        btnDisplayTask3.setOnClickListener(view -> {
//            goDisplayTask3.putExtra(TASK_NAME, btnDisplayTask3.getText().toString());
//            startActivity(goDisplayTask3);
//        });
//        // setting up routing logic with intents. Intents are the highway between activities


    }
}