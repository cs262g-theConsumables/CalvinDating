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

        username = (TextView) findViewById(R.id.user_profile_name);
        username.setText(getIntent().getStringExtra("PROFILE_NAME"));

        shortBio = (TextView) findViewById(R.id.user_profile_short_bio);
        shortBio.setText(getIntent().getStringExtra("PROFILE_BIO"));
    }
}
