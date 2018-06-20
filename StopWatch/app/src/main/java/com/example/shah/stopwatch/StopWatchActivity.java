package com.example.shah.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StopWatchActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running = false;
    private boolean was_running = false;
    private boolean stop = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        if(savedInstanceState!= null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            was_running = savedInstanceState.getBoolean("was_running");
        }
        runTimer();
    }

    @Override
    protected void onStop(){
        super.onStop();
        was_running = running;
        running = false;

    }

    @Override
    protected void onStart(){
        super.onStart();
        if(was_running){
            running = true;
        }

    }

    @Override
    protected void onPause(){
        super.onPause();
        was_running = running;
        running = false;

    }

    @Override
    protected void onResume(){
        super.onResume();
        if(was_running){
            running = true;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
        savedInstanceState.putBoolean("was_running",was_running);
    }

    public void onClickStart(View view){
        //stop = false;
        running = true;


    }
    public void onClickStop(View view){
        //stop = true;
        running = false;

    }
    public void onClickReset(View view){
        running = false;
        seconds = 0;
    }



    private void runTimer(){
        final TextView timerView = (TextView)findViewById(R.id.timerView);
        final Handler handler = new Handler();
        handler.post(new Runnable(){
           @Override
            public void run(){
               int hours = seconds/3600;
               int minutes = seconds%3600/60;
               int secs = seconds%60;


               String time = String.format("%d:%02d:%02d",hours,minutes,secs);
               timerView.setText(time);
               if(running) {
                   seconds++;
               }
               //if(stop){
                   //handler.postDelayed(this,);
               //}
               //else {
                   handler.postDelayed(this, 1000);
               //}
           }
        });
    }

}
