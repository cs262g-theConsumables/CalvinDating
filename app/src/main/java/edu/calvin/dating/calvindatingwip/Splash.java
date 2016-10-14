package edu.calvin.dating.calvindatingwip;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

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

        //sets the default screen as the splash screen
        setContentView(edu.calvin.dating.calvindatingwip.R.layout.splash);

        //spins the loading dial
        ProgressDialog progress = new ProgressDialog(this);
        progress.setIndeterminate(true);
        progress.setProgress(0);
        progress.show();

        //this should show a logo and make it grow
        final ImageView logo = (ImageView) findViewById(edu.calvin.dating.calvindatingwip.R.id.imageView);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(), edu.calvin.dating.calvindatingwip.R.anim.growlogo);
        logo.startAnimation(an);

        //once the animation is done, it moves onto the login screen
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                Intent i = new Intent(getBaseContext(), Login.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) { }
        });

    }
}
