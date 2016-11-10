package edu.calvin.dating.calvindatingwip;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class CalendarTab extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_calendar_tab, container, false);

        Button button = (Button) view.findViewById(R.id.linkButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent = new Intent(getActivity(), WebViewActivity.class);
                ((MainActivity) getActivity()).startActivity(aboutIntent);
            }
        });
        return view;
    }

}