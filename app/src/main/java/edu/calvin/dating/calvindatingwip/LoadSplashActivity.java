package edu.calvin.dating.calvindatingwip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


/**
 * Created by Loganvp on 12/9/2016.
 *
 * Picture found here: http://www.bestyard.com/wp-content/uploads/2016/02/unnamed.jpg
 *
 * Idea from here: http://stackoverflow.com/questions/5486789/how-do-i-make-a-splash-screen
 *
 * Animation idea: https://www.tutorialspoint.com/android/android_animations.htm
 */



public class LoadSplashActivity extends AppCompatActivity{
    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 5000;

    @Override

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_load_splash);

        //This animation sequence makes the heart beat
        //Heart from here: http://globe-views.com/dcim/dreams/heart/heart-04.jpg
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.growlogo);
        ImageView image = (ImageView)findViewById(R.id.imageView);
        image.startAnimation(animation);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent loginIntent = new Intent(getBaseContext(),LoginActivity.class);
                LoadSplashActivity.this.startActivity(loginIntent);
                LoadSplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
