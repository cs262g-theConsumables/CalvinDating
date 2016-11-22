package edu.calvin.dating.calvindatingwip;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        buildList();
        profilesListView = (ListView) view.findViewById(R.id.profileListView);

        int resource = R.layout.user_find_layout;
        String[] from = new String[] {"name", "bio"};
        int[] to = new int[] {R.id.nameTextView, R.id.bioTextView};

        //The following is code I (dmv34) could not get to run
        //This is suppose to display the array onto the list view

        adapter = new SimpleAdapter(getActivity(), profilesArray, resource, from, to);

        profilesListView.setAdapter(adapter);


//        profilesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> a, View v, int i, long l) {
//                openProfile(profilesArray, i);
//            }
//        });


        return view;
    }

    public void buildList(){
        ArrayList<String> names = new ArrayList<>();
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
        ArrayList<String> bios = new ArrayList<>();
        bios.add("Pain in the ass but a good friend");
        bios.add("Willing to try new things");
        bios.add("Loyal and stylish");
        bios.add("Hot headed but I have a soft side");
        bios.add("Short and love bear skin rugs");
        bios.add("Sweat and never sour");
        bios.add("Not worried about your looks");
        bios.add("Kind but in grieving period");
        bios.add("Honest or terrible liar, your choice");
        bios.add("I own a nice brick house");

        for(int i = 0; i < names.size(); i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("name", names.get(i));
            map.put("bio", bios.get(i));
            profilesArray.add(map);
        }

    }

    /*Opens the profile of the person in array names at given position
 *@params:  names - array of names, currently hardcoded but will eventually be from DB
 *          pos - Position of the person that whos profile will be opend with
 *@authors: Drew VL
 *          Logan VP
 */
    public void openProfile(ArrayList<HashMap<String, String>> profiles, int pos){

    }
}
