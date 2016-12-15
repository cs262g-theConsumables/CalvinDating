package edu.calvin.dating.calvindatingwip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/*  SearchTab class - creates view which displays date suggestions and search results.
 *
 *  @author: Drew VL, Logan VP
 */

public class SearchTab extends Fragment {

    private ArrayList<HashMap<String, String>> profilesArray;
    private ListView profilesListView;
    SimpleAdapter adapter;
    public MainActivity mainActivity;


    /*  onCreateView method - called to create the view for the tab
     *
     *  @params: inflater, container, savedInstanceState
     *  @return:   view - the view of the tab
     *  @authors: Drew VL, Logan VP
     *
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_search_tab, container, false);
        profilesArray = new ArrayList<>();
        mainActivity = (MainActivity) getActivity();

        buildList();
        profilesListView = (ListView) view.findViewById(R.id.profileListView);

        int resource = R.layout.user_find_layout;
        String[] from = new String[] {"name", "bio"};
        int[] to = new int[] {R.id.nameTextView, R.id.bioTextView};

        //The following is code I (dmv34) could not get to run
        //This is suppose to display the array onto the list view

        adapter = new SimpleAdapter(getActivity(), profilesArray, resource, from, to);

        profilesListView.setAdapter(adapter);


        profilesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int i, long l) {
                openProfile(profilesArray, i);
            }
        });


                return view;
    }

    public void buildList(){
        for(JavaCalls.Student item : mainActivity.studentArray){
            HashMap<String, String> map = new HashMap<String, String>();
            if(!item.getCalvinID().equals(mainActivity.currentUser)){
                String fullName = item.getFirst() + " " + item.getLast();
                map.put("name", fullName);
                map.put("bio", item.getAboutMe());
                map.put("calvinID", item.getCalvinID());
                profilesArray.add(map);
            }
        }

    }

    /*Opens the profile of the person in array names at given position
 *@params:  names - array of names, currently hardcoded but will eventually be from DB
 *          pos - Position of the person that whos profile will be opend with
 *@authors: Drew VL
 *          Logan VP
 */
    public void openProfile(ArrayList<HashMap<String, String>> profiles, int pos){
        String calvinID = profiles.get(pos).get("calvinID").toString();
        int myProfileIndex = 0;
        for(int i = 0; i < mainActivity.studentArray.size(); i++){
            if(mainActivity.studentArray.get(i).getCalvinID().equals(calvinID)){
                myProfileIndex = i;
            }
        }
        String fullName = mainActivity.studentArray.get(myProfileIndex).getFirst() + " " +
                mainActivity.studentArray.get(myProfileIndex).getLast();

        Intent intent = new Intent(getActivity().getBaseContext(), OtherProfile.class);
        intent.putExtra("NAME", fullName);
        intent.putExtra("BIO",mainActivity.studentArray.get(myProfileIndex).getAboutMe() );
        intent.putExtra("LOOKING_FOR",mainActivity.studentArray.get(myProfileIndex).getGenderWant() );
        intent.putExtra("ACTIVITIES",mainActivity.studentArray.get(myProfileIndex).getStudySpot() );
        intent.putExtra("VOCATION",mainActivity.studentArray.get(myProfileIndex).getVocation() );
        intent.putExtra("HOME_COUNTRY",mainActivity.studentArray.get(myProfileIndex).getHomeCountry() );
        intent.putExtra("MAJOR",mainActivity.studentArray.get(myProfileIndex).getMajor() );
        startActivity(intent);
    }
}
