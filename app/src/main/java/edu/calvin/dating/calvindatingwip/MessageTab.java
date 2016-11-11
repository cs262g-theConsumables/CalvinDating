package edu.calvin.dating.calvindatingwip;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;

public class MessageTab extends Fragment {

    private ArrayList<String> names;
    private ListView usersListView;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_message_tab, container, false);
        names = new ArrayList<>();
        buildList();

        usersListView = (ListView) view.findViewById(R.id.usersListView);
        ArrayAdapter namesArrayAdapter = new ArrayAdapter<>(getActivity(),
                R.layout.user_list_item, names);
        usersListView.setAdapter(namesArrayAdapter);

        usersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int i, long l) {
                Intent intent = new Intent(getActivity().getBaseContext(), PersonalMessageTab.class);
                startActivity(intent);
                //openConversation(names, i);
            }
        });

        return view;
    }

    /*Opens the conversation with the person in array names at given position
     *@params:  names - array of names, currently hardcoded but will eventually be from DB
     *          pos - Position of the person that conversation will be opend with
     *@authors: Drew VL
     *          Logan VP
     */
    public void openConversation(ArrayList<String> names, int pos) {

    }



    public void buildList(){
        names.add("Donkey");
        names.add("Fiona");
        names.add("Puss in Boots");
        names.add("Dragon");
        names.add("Farquaad");
        names.add("Gingerbread Man");
        names.add("Blind Mice #1");
        names.add("Baby Bear");
        names.add("Pinocchio");
        names.add("Pig #3");



    }
}
