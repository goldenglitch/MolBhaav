package com.ecommerce.molbhaav.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.ecommerce.molbhaav.Activities.LoginActivity;
import com.ecommerce.molbhaav.R;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener{
    ImageView iv;
    Animation myanimation;
    private static int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv =(ImageView)findViewById(R.id.imageView);
        iv.setImageResource(R.drawable.e);
        myanimation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);

        myanimation.setAnimationListener(this);
        iv.setVisibility(View.VISIBLE);
        iv.startAnimation(myanimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {


    }
    @Override
    public void onAnimationRepeat(Animation animation) {

    }

}