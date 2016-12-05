package edu.calvin.dating.calvindatingwip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class EditProfileActivity extends AppCompatActivity {
    private Button _Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        // Change the title to reflect the new activity
        setTitle("Fill out the survey");

        _Button = (Button) findViewById(R.id.ButtonSendFeedback);
        _Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
                Toast.makeText(getBaseContext(), "Profile Updated!", Toast.LENGTH_LONG).show();
            }
        });

    }
}
