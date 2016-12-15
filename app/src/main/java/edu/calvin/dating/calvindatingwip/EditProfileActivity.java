package edu.calvin.dating.calvindatingwip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*  EditProfileActivity
 *  Creates the page to show the edit profile page.
 *  It implements an onclick listener that will bring the user back to the MainActivity and
 *  submit the results to the server.
 *
 *  @return:    view    page viewer that inflates its own context.
 *  @authors:   Drew VL
 *              Logan VP
 */
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
                EditProfileActivity.this.finish();
                Toast.makeText(getBaseContext(), "Profile Updated!", Toast.LENGTH_LONG).show();
            }
        });

    }
}
