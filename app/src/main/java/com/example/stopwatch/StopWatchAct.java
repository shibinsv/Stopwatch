package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchAct extends AppCompatActivity {

    Button btnstart,btnstop;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timerHere;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart=findViewById(R.id.btnget);
        btnstop=findViewById(R.id.finish);
        timerHere=findViewById(R.id.timerHere);
        icanchor=findViewById(R.id.icanchor);


        //create optional animation
        btnstop.setAlpha(0);

        //Load animations
        roundingalone= AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        //Importing font
        Typeface MMedium =Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");

        //Customizing font
        btnstart.setTypeface(MMedium);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Passing animation
                icanchor.startAnimation(roundingalone);
                btnstart.animate().alpha(0).setDuration(300).start();
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();

                //start time
                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.start();

            }

        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ending animation
                icanchor.clearAnimation();
                btnstart.animate().alpha(1).setDuration(300).start();

                //stop time
                timerHere.stop();

                //To be executed after 1 sec

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        //Jump to next activity
                        openSuccess();
                    }

                },1000);

            }
        });

    }

    public void openSuccess(){

        startActivity(new Intent(StopWatchAct.this,Success.class));

    }
}