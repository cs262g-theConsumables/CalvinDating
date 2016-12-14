package edu.calvin.dating.calvindatingwip;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.widget.Toast;
import android.util.Log;

import java.lang.Object;

import static edu.calvin.dating.calvindatingwip.R.xml.check_box_pref;

public class ProfileTab extends Fragment{

    private SharedPreferences myPrefs;
    private TextView myName;
    private ImageView myImage;
    private Button chooseImage;
    private Button editProfile;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //inflate the layout for this fragment
        View view =inflater.inflate(R.layout.activity_profile_tab, container, false);
        Context context = getActivity();

        myPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        //create references to widgets
        myName = (TextView) view.findViewById(R.id.user_profile_name);
        setMyName();

        editProfile = (Button) view.findViewById(R.id.editProfile);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent = new Intent(getActivity(), EditProfileActivity.class);
                ((MainActivity) getActivity()).startActivity(aboutIntent);

            }
        });

        chooseImage = (Button) view.findViewById(R.id.choosePhoto);
        chooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent , 1);
            }
        });
        return view;
    }

    public void setMyName() {
        if (!myPrefs.getBoolean("pref_username", false)) {
            myName.setText(getResources().getString(R.string.my_name));
            Log.d("TAG", "Change occurred");
        } else {
            myName.setText(getResources().getString(R.string.user_name));
            Log.d("TAG", "Change occurred");
        }
    }
}
