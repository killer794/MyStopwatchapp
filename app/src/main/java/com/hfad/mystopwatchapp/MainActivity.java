package com.hfad.mystopwatchapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends Activity {

    private int seconds = 0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTime();
    }

    //start the stop watch when the start button is cilcked
    public void onClickStart(View view) {
        running = true;
    }

    //stop the stopwatch when the stop button is clicked
    public void onClickStop(View view) {
        running = false;
    }

    //reset the stop watch he reset button is clicked
    public void onClickReset(View view) {
        running = false;//stop the watch and
        seconds = 0;     //set it to zero
    }

    //set the no of second on timer
    private void runTime () {
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler() ;
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/36000;
                int minutes = (seconds%36000)/60;
                int secs = (seconds%600)/10;
                int milisec = seconds%10;
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d:%01d", hours, minutes, secs, milisec);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 100);
            }
        });
    }

}



