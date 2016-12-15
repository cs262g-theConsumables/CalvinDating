package edu.calvin.dating.calvindatingwip;

import android.app.SearchManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    public List<JavaCalls.Student> studentArray = new ArrayList<>();
    public String currentUser;


    @Override
    //Initialization
    protected void onCreate(Bundle savedInstanceState) {
        //Show the app as it was last time
        super.onCreate(savedInstanceState);
        //Display the app
        currentUser = getIntent().getStringExtra("USERNAME");
        Log.d(TAG, currentUser);
        new GetAllStudentsTask().execute(createURL(currentUser));

    }

    //creates the menu in the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

// Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default

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
            case R.id.survey:
                //opens the new activity (survey page)
                Intent surveyIntent = new Intent(this, SurveyActivity.class);
                startActivity(surveyIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
    }

    /**
     * Inner class for GETing the player list from the course server asynchronously
     */
    private class GetAllStudentsTask extends AsyncTask<URL, Void, JSONArray> {

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
                    Log.d(TAG, jsonText.toString());
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
                Log.d(TAG, "Unable to connect to server");
            } else if (student.length() == 0) {
                Log.d(TAG, "Unable to connect to server");
            } else {
                convertJSONtoStrings(student);
            }
            updateDisplay();
        }
    }

    /**
     * Converts the JSON player data to an arraylist suitable for a getting the info
     *
     * @param students JSON array of player objects
     *
     * sets the variables dbCalvinID, dbUsername, dbPassword.
     */
    private void convertJSONtoStrings(JSONArray students) {
        try {
            for (int i = 0; i < students.length(); i++) {
                JSONObject student = students.getJSONObject(i);
                studentArray.add(new JavaCalls.Student(
                        student.getString("CalvinID"),
                        student.getString("password"),
                        student.getString("picture"),
                        student.getString("first"),
                        student.getString("last"),
                        student.getString("username"),
                        student.getString("classYear"),
                        student.getString("birthday"),
                        student.getString("homeCity"),
                        student.getString("homeState"),
                        student.getString("homeCountry"),
                        student.getString("major"),
                        student.getString("majorDepartment"),
                        student.getString("majorNumber"),
                        student.getString("gender"),
                        student.getString("genderWant"),
                        student.getString("religion"),
                        student.getString("mbti"),
                        student.getBoolean("hasJob"),
                        student.getString("job"),
                        student.getBoolean("tulip"),
                        student.getString("hangout"),
                        student.getInt("hateHope"),
                        student.getString("bQuiv"),
                        student.getString("diningPreference"),
                        student.getString("sports"),
                        student.getInt("bunHate"),
                        student.getString("studySpot"),
                        student.getString("chapelDay"),
                        student.getString("loft").charAt(0),
                        student.getInt("height"),
                        student.getString("nationality"),
                        student.getString("vocation"),
                        student.getString("aboutMe"),
                        student.getString("status")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
            urlString += "/students";

            return new URL(urlString);
        } catch (Exception e) {
            //Toast.makeText(this, getString(R.string.connection_error), Toast.LENGTH_SHORT).show();
        }

        return null;
    }
    private void updateDisplay(){
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Profile"));
        tabLayout.addTab(tabLayout.newTab().setText("Find"));
        tabLayout.addTab(tabLayout.newTab().setText("Message"));
        tabLayout.addTab(tabLayout.newTab().setText("Dates"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);



        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}

