package edu.calvin.dating.calvindatingwip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SurveyActivity extends AppCompatActivity {

    private Button _Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        // Change the title to reflect the new activity
        setTitle("Fill out the survey");

        _Button = (Button) findViewById(R.id.ButtonSendFeedback);
        _Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), EditProfileActivity.class);
                startActivity(i);
                SurveyActivity.this.finish();
                Toast.makeText(getBaseContext(), "Survey Complete!", Toast.LENGTH_LONG).show();
            }
        });

    }
}
