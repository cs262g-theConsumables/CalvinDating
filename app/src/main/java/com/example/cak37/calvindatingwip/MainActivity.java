package com.example.cak37.calvindatingwip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//This will eventually be the entire dating app.
public class MainActivity extends AppCompatActivity {

    @Override
    //Initialization
    protected void onCreate(Bundle savedInstanceState) {
        //Show the app as it was last time
        super.onCreate(savedInstanceState);
        //Display the app
        setContentView(R.layout.activity_main);
    }
}
