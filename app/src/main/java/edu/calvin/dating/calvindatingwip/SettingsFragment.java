package edu.calvin.dating.calvindatingwip;

/**
 * Created by Drew on 10/17/2016.
 */

import android.os.Bundle;
import android.preference.PreferenceFragment;


public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.check_box_pref);
    }
}