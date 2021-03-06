package edu.calvin.dating.calvindatingwip;

/**
 * Created by Loganvp on 11/2/2016.
 *
 * Based on the tutorial found here: http://sourcey.com/beautiful-android-login-and-signup-screens-with-material-design/
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*  SignupActivity
 *  Creates a Signup screen. Uses username, email and password. Also has a
 *  link to the login screen.
 *
 *  @authors:   Drew VL
 *              Logan VP
 */
public class SignupActivity extends AppCompatActivity {

    private EditText _nameText;
    private EditText _emailText;
    private EditText _passwordText;
    private Button _signupButton;
    private TextView _loginLink;

    /*  OnCreate
     *  Creates view for signup.
     *
     *  @param:    savedInstanceState
     *  @authors:   Logan VP
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        _nameText = (EditText) findViewById(R.id.input_name);
        _emailText = (EditText) findViewById(R.id.input_email);
        _passwordText = (EditText) findViewById(R.id.input_password);
        _signupButton = (Button) findViewById(R.id.btn_signup);
        _loginLink = (TextView) findViewById(R.id.link_login);


        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
    }

    /*  signup - Authenticates the user's credentials with the database
     *  and handles if the signup succeeded or failed.
     *
     *  @return:     onSignupFailed  does this to inform the user
     *                              of failed attempt.
     *  @authors:   Logan VP
     */
    public void signup() {
        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    /*  onSignupSuccess - activates the button only when signup was
     *                   successful.
     *
     *  @authors:   Logan VP
     */
    public void onSignupSuccess() {
        //Save the password and username for future logins
        SharedPreferences userDetails = getBaseContext().getSharedPreferences("userdetails", MODE_PRIVATE);
        SharedPreferences.Editor edit = userDetails.edit();
        edit.clear();
        edit.putString("username", _nameText.getText().toString().trim());
        edit.putString("password", _passwordText.getText().toString().trim());
        edit.commit();
        Toast.makeText(getBaseContext(), "Login details are saved..", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        Intent i = new Intent(getBaseContext(), SurveyActivity.class);
        startActivity(i);
        finish();
    }

    /*  onSignupFailed - sends a message for failed signup. And
     *                  doesn't finish.
     *
     *  @authors:   Logan VP
     */
    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    /*  validate - checks for empty inputs and sends error if not valid.
     *
     *  @return:    valid   set to false if empty. True otherwise.
     *  @authors:   Logan VP
     */
    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (email.isEmpty() || !email.matches("jsk01@students.calvin.edu")) {
            _emailText.setError("enter a valid Calvin email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
}