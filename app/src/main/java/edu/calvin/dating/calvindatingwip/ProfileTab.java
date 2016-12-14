package edu.calvin.dating.calvindatingwip;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
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

import static android.app.Activity.RESULT_OK;
import static edu.calvin.dating.calvindatingwip.R.xml.check_box_pref;

public class ProfileTab extends Fragment{

    private SharedPreferences myPrefs;
    private TextView myName;
    private ImageView myImage;
    private Button chooseImage;
    private Button editProfile;
    private static int RESULT_LOAD_IMG;
    private String imgDecodableString;
    private View view;
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //inflate the layout for this fragment
        view =inflater.inflate(R.layout.activity_profile_tab, container, false);
        context = getActivity();

        RESULT_LOAD_IMG = 1;
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
                // Create intent to Open Image applications like Gallery, Google Photos
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // Start the Intent
                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = context.getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                ImageView imgView = (ImageView) view.findViewById(R.id.user_profile_photo);
                // Set the Image in ImageView after decoding the String
                imgView.setImageBitmap(BitmapFactory
                        .decodeFile(imgDecodableString));

            } else {
                Toast.makeText(context, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }
}
