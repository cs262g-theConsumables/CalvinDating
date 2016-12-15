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

    /*  MessageTab class - creates a view list of all the people the user can message
     *
     *  @authors: Drew VL, Logan VP
     */
public class MessageTab extends Fragment {

    private ArrayList<String> names;
    private ListView usersListView;
        public MainActivity mainActivity;

    /*  onCreateView method - called to create the view for the tab
     *
     *  @params: inflater, container, savedInstanceState
     *  @return:   view - the view of the tab
     *  @authors: Drew VL, Logan VP
     */
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_message_tab, container, false);
        names = new ArrayList<>();
        mainActivity = (MainActivity) getActivity();
        buildList();

        usersListView = (ListView) view.findViewById(R.id.usersListView);
        ArrayAdapter namesArrayAdapter = new ArrayAdapter<>(getActivity(),
                R.layout.user_list_item, names);
        usersListView.setAdapter(namesArrayAdapter);

        usersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int i, long l) {
                openConversation(names, i);
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
    public void openConversation(ArrayList<String> nameList, int pos) {
        String name = nameList.get(pos);
        Intent intent = new Intent(getActivity().getBaseContext(), PersonalMessageTab.class);
        intent.putExtra("MESSAGE_TO",name);
        startActivity(intent);
    }



    public void buildList(){
        for(JavaCalls.Student item : mainActivity.studentArray){
            if(!item.getCalvinID().equals(mainActivity.currentUser)){
                String fullName = item.getFirst() + " " + item.getLast();
                names.add(fullName);
            }
        }



    }
}
