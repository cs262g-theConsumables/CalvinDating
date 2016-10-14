package com.example.cak37.calvindatingwip;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Loganvp on 10/14/2016.
 *
 * Used this as a "guide" for help
 * https://www.youtube.com/watch?v=XwOuTjUFexE
 *
 * This is the initial start page
 */

public class Splash extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

        ProgressDialog progress = new ProgressDialog(this);
        progress.setIndeterminate(true);
        progress.setProgress(0);
        progress.show();


        final ImageView logo = (ImageView) findViewById(R.id.imageView);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(), R.anim.growlogo);

        logo.startAnimation(an);

        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                Intent i = new Intent(getBaseContext(), Login.class);
                startActivity(i);
                Toast.makeText(getBaseContext(), "I offer my Heart.",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
