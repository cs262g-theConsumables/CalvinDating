package edu.calvin.dating.calvindatingwip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class OtherProfile extends AppCompatActivity {

    private TextView username;
    private TextView shortBio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_other_profile);
        TextView name = (TextView) findViewById(R.id.user_profile_name);
        name.setText(getIntent().getStringExtra("NAME"));

        TextView shortBio = (TextView) findViewById(R.id.user_profile_short_bio);
        shortBio.setText(getIntent().getStringExtra("BIO"));

        TextView lookingFor = (TextView) findViewById(R.id.looking_for);
        lookingFor.setText("Looking for: " + getIntent().getStringExtra("LOOKING_FOR"));

        TextView activities = (TextView) findViewById(R.id.activities);
        activities.setText("Favorite study spot: " + getIntent().getStringExtra("ACTIVITIES"));

        TextView vocation = (TextView) findViewById(R.id.fun_facts);
        vocation.setText(getIntent().getStringExtra("VOCATION"));

        TextView homeCountry = (TextView) findViewById(R.id.hangout_spot);
        homeCountry.setText("Home Planet: " + getIntent().getStringExtra("HOME_COUNTRY"));

        TextView major = (TextView) findViewById(R.id.major_minor);
        major.setText("Major: " + getIntent().getStringExtra("MAJOR"));
    }
}
