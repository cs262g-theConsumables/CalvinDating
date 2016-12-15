package edu.calvin.dating.calvindatingwip;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/*  SurveyActivity
 *  Creates the page to show the Matching Survey page.
 *  It implements an onclick listener that will bring the user to the EditProfile and
 *  submit the results to the server.
 *
 *  @return:    view    page viewer that inflates its own context.
 *  @authors:   Drew VL
 *              Logan VP
 */
public class SurveyActivity extends AppCompatActivity {

    private Button _Button;
    private TextView _MBTILink;
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

        //Link for the MBTI survey
        _MBTILink = (TextView) findViewById(R.id.linkButton);

    }
}
