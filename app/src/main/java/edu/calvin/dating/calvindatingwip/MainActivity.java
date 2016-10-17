package edu.calvin.dating.calvindatingwip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;




//This will eventually be the entire dating app.
public class MainActivity extends AppCompatActivity {

    private SharedPreferences myPrefs;

    @Override
    //Initialization
    protected void onCreate(Bundle savedInstanceState) {
        //Show the app as it was last time
        super.onCreate(savedInstanceState);
        //Display the app
        setContentView(edu.calvin.dating.calvindatingwip.R.layout.activity_main);

        //This is supposed to get the user name and show it on the mainactivity
        String username = getIntent().getStringExtra("USERNAME");
        TextView view = (TextView) findViewById(edu.calvin.dating.calvindatingwip.R.id.nameTextView);
        view.setText(username);

    }

    //creates the menu in the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    // method is run when an Item is selected in the menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Determines what item was selected
        switch (item.getItemId()) {
            case R.id.show_about:
                //opens the new activity (about page)
                Intent aboutIntent = new Intent(this, AboutActivity.class);
                startActivity(aboutIntent);
                return true;

            case R.id.settings:     //opens settings tab
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingsIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

