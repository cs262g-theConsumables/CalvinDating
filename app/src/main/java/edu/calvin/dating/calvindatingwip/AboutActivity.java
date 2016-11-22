package edu.calvin.dating.calvindatingwip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

    /*  AboutActivity
     *  Creates an about page accessible through the menu.
     *
     *  @authors:   Drew VL
     *              Logan VP
     */
public class AboutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        // Change the title to recflect the new activity
        setTitle("About the app");
    }
}
