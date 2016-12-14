package edu.calvin.dating.calvindatingwip;

import android.content.SharedPreferences;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/*  LoginActivity
 *  Creates a Login screen. Uses email and password. Also has a
 *  link to the registration screen.
 *
 *  @authors:   Drew VL
 *              Logan VP
 */
public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    private EditText _usernameText;
    private EditText _passwordText;
    private Button _loginButton;
    private TextView _signupLink;

    private String dbCalvinID;
    private String dbUsername;
    private String dbPassword;
    private ListView itemsListView;


    /*  OnCreate
     *  Creates view for login.
     *
     *  @param:    savedInstanceState
     *  @authors:   Logan VP
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //fetch
        SharedPreferences userDetails = getBaseContext().getSharedPreferences("userdetails", MODE_PRIVATE);
        String usernamePreference = userDetails.getString("username", "");
        String passwordPreference = userDetails.getString("password", "");

        _usernameText = (EditText) findViewById(R.id.input_username);
        _passwordText = (EditText) findViewById(R.id.input_password);
        _loginButton = (Button) findViewById(R.id.btn_login);
        _signupLink = (TextView) findViewById(R.id.link_signup);

        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getBaseContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);

            }
        });
    }

    /*  Login - Authenticates the user's credentials with the database
     *  and handles if the login succeeded or failed.
     *
     *  @return:     onLoginFailed  does this to inform the user
     *                              of failed attempt.
     *  @authors:   Logan VP
     */
    public void login() {

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String username = _usernameText.getText().toString();
        String password = _passwordText.getText().toString();

        new GetLoginTask().execute(createURL(username));

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    /*  OnActivityResult - Implements successful signup logic
     *  and checks the request codes and result returns.
     *
     *  @param:    requestCode  to check if a signup was actually requested
     *             resultCode   if the validation was true
     *             data
     *  @authors:   Logan VP
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    /*  onBackPressed - disable going back to the MainActivity
     *  @authors:   Logan VP
     */
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    /*  onLoginSuccess - activates the button only when login was
     *                   successful.
     *  @authors:   Logan VP
     */
    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        Intent i = new Intent(getBaseContext(), MainActivity.class);
        startActivity(i);
        finish();

    }

    /*  onLoginFailed - sends a message for failed login. And
     *                  doesn't finish.
     *  @authors:   Logan VP
     */
    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }

    /*  validate - checks for empty inputs and sends error if not valid.
     *
     *  @return:    valid   set to false if empty. True otherwise.
     *  @authors:   Logan VP
     */
    public boolean validate() {
        boolean valid = true;

        String email = _usernameText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _usernameText.setError("enter a valid email");
            valid = false;
        } else {
            _usernameText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

    /**
     * Formats a URL for the webservice specified in the string resources.
     *
     * @param id string version of the desired ID (or BLANK for all players)
     * @return URL formatted for the course monopoly server
     */
    private URL createURL(String id) {
        try {
            String urlString = getString(R.string.web_service_url);
            urlString += "/student/" + id;

            return new URL(urlString);
        } catch (Exception e) {
            Toast.makeText(this, getString(R.string.connection_error), Toast.LENGTH_SHORT).show();
        }

        return null;
    }

    /**
     * Inner class for GETing the player list from the course server asynchronously
     */
    private class GetLoginTask extends AsyncTask<URL, Void, JSONArray> {

        @Override
        protected JSONArray doInBackground(URL... params) {
            HttpURLConnection connection = null;
            StringBuilder jsonText = new StringBuilder();
            JSONArray result = null;
            try {
                connection = (HttpURLConnection) params[0].openConnection();
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        jsonText.append(line);
                    }
                    if (jsonText.charAt(0) == '[') {
                        result = new JSONArray(jsonText.toString());
                    } else if (jsonText.toString().equals("null")) {
                        result = new JSONArray();
                    } else {
                        result = new JSONArray().put(new JSONObject(jsonText.toString()));
                    }
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
            return result;
        }

        @Override
        protected void onPostExecute(JSONArray student) {
            if (student == null) {
                Toast.makeText(LoginActivity.this, getString(R.string.connection_error), Toast.LENGTH_SHORT).show();
            } else if (student.length() == 0) {
                Toast.makeText(LoginActivity.this, getString(R.string.connection_error), Toast.LENGTH_SHORT).show();
            } else {
                convertJSONtoStrings(student);
            }
            //LoginActivity.this.updateDisplay();
        }
    }

    /**
     * Converts the JSON player data to an arraylist suitable for a listview adapter
     *
     * @param student JSON array of player objects
     *
     * sets the variables dbCalvinID, dbUsername, dbPassword.
     */
    private void convertJSONtoStrings(JSONArray student) {
        try {
            for (int i = 0; i < student.length(); i++) {
                JSONObject studentOb = student.getJSONObject(i);
                dbCalvinID = studentOb.getString("CalvinID");
                dbUsername = studentOb.getString("username");
                dbPassword = studentOb.getString("password");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

