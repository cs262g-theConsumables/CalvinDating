package edu.calvin.dating.calvindatingwip;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/*  SearchableActivity - it should find a person in the list of people.
 *
 *  @authors: Drew VL
 */
public class SearchableActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Intent intent1 = new Intent(getBaseContext(), SearchTab.class);
        startActivity(intent1);

        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }



    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow

            Intent intent1 = new Intent(getBaseContext(), SearchTab.class);
            startActivity(intent1);
        }
    }

}
