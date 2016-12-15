package edu.calvin.dating.calvindatingwip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

    /*  HelpActivity
     *  Creates an about page accessible through the menu.
     *
     *  @authors:   Logan VP
     *              Carol Schott
     */

public class HelpPageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        // Change the title to recflect the new activity
        setTitle("Help Page");
    }
}
