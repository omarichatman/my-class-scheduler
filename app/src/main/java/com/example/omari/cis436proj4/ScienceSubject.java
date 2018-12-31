package com.example.omari.cis436proj4;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ScienceSubject extends AppCompatActivity {

    NotificationHelper notificationHelper;
    EditText classLoc;
    EditText profName;
    EditText minutesAway;
    Button setAlarm;
    Intent intent;
    int myClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.science_class);

        classLoc = findViewById(R.id.classLocationScience);
        profName = findViewById(R.id.profNameScience);
        minutesAway = findViewById(R.id.classMinutesScience);
        setAlarm = findViewById(R.id.classAlarmScience);

        profName.setEnabled(false);
        minutesAway.setEnabled(false);
        setAlarm.setEnabled(false);

        classLoc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkLocInput(classLoc);
            }
        });

        profName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkNameInput(profName);
            }
        });

        minutesAway.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkMinutesInput();
            }
        });

        setAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minutes = Integer.parseInt(minutesAway.getText().toString());
                intent = getIntent();
                myClass = intent.getIntExtra("class" ,0);

                new CountDownTimer(minutes * 60 * 1000, 1000) {
                    public void onTick(long millisUntilFinished) {

                    }

                    public void onFinish() {
                        if (notificationHelper == null) { // if no color added make note
                            notificationHelper.createNotification("Class Alarm", "Science Class in " + classLoc.getText().toString() + " with Professor " + profName.getText().toString(), ScienceSubject.this, myClass);
                        }
                        notificationHelper.notifyMe();
                    }}.start();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.class_menu, menu);
        return true;
    }

    public void checkLocInput(EditText editText) {
        if(!(editText.getText().toString().equals(""))) {
            profName.setEnabled(true);
        }
    }

    public void checkNameInput(EditText editText) {
        if(!(editText.getText().toString().equals(""))) {
            minutesAway.setEnabled(true);
        }
    }

    public void checkMinutesInput() {
        if(Integer.parseInt(minutesAway.getText().toString()) > 0 && Integer.parseInt(minutesAway.getText().toString()) <= 60) {
            setAlarm.setEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Change the notifcation Text Color

        int red = ContextCompat.getColor(ScienceSubject.this, R.color.red);
        int blue = ContextCompat.getColor(ScienceSubject.this, R.color.blue);
        int yellow = ContextCompat.getColor(ScienceSubject.this, R.color.yellow);

        if(item.getItemId() == R.id.alarmColor0) {
            if(notificationHelper == null) {
                notificationHelper.createNotification("Class Alarm", "Science Class in " + classLoc.getText().toString() + " with Professor " + profName.getText().toString(), ScienceSubject.this, myClass, red);
            }
        }
        else if(item.getItemId() == R.id.alarmColor1) {
            if(notificationHelper == null) {
                notificationHelper.createNotification("Class Alarm", "Science Class in " + classLoc.getText().toString() + " with Professor " + profName.getText().toString(), ScienceSubject.this, myClass, blue);
            }
        }
        else if(item.getItemId() == R.id.alarmColor2) {
            if(notificationHelper == null) {
                notificationHelper.createNotification("Class Alarm", "Science Class in " + classLoc.getText().toString() + " with Professor " + profName.getText().toString(), ScienceSubject.this, myClass, yellow);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
