package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2;
    ImageView ivsplash;
    Button btnget;
    Animation atg,btgone,btgtwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaration
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        btnget=findViewById(R.id.btnget);
        ivsplash=findViewById(R.id.ivSplash);

        //Load animation
        atg= AnimationUtils.loadAnimation(this, R.anim.atg);
        btgone=AnimationUtils.loadAnimation(this,R.anim.btgone);
        btgtwo=AnimationUtils.loadAnimation(this,R.anim.btgtwo);


        //Passing animation
        ivsplash.startAnimation(atg);
        t1.startAnimation(btgone);
        t2.startAnimation(btgone);
        btnget.startAnimation(btgtwo);

        //passing event
        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a=new Intent(MainActivity.this,StopWatchAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


        //Importing font
        Typeface MLight =Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        Typeface MMedium =Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        Typeface MRegular =Typeface.createFromAsset(getAssets(),"fonts/MRegular.ttf");

        //customise font
        t1.setTypeface(MRegular);
        t2.setTypeface(MLight);
        btnget.setTypeface(MMedium);
    }
}