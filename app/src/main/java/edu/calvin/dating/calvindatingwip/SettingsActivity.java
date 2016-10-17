package edu.calvin.dating.calvindatingwip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setTitle("Settings:");
        //links preferences to activity
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment() )
                .commit();
    }
}
