package com.example.cak37.calvindatingwip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

//This will eventually be the entire dating app.
public class MainActivity extends AppCompatActivity {

    @Override
    //Initialization
    protected void onCreate(Bundle savedInstanceState) {
        //Show the app as it was last time
        super.onCreate(savedInstanceState);
        //Display the app
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "My heart I offer to you, promptly and sincerely.", Toast.LENGTH_SHORT).show();
    }
}
