package edu.calvin.dating.calvindatingwip;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/*  PersonalMessageActivity
 *  Creates an personal message page accessible through the clicking a name.
 *  We were not able to do anything further with this activity due to complexity
 *  and time constraints
 *
 *  @authors:   Logan VP
 *
 */
public class PersonalMessageTab extends ListActivity {

    private ArrayList<String> list = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private TextView messageName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** Setting a custom layout for the list activity */
        setContentView(R.layout.activity_private_messages);

        /** Reference to the button of the layout main.xml */
        Button btn = (Button) findViewById(R.id.btnAdd);

        messageName = (TextView) findViewById(R.id.messageTo);
        messageName.setText(getIntent().getStringExtra("MESSAGE_TO"));


        /** Defining the ArrayAdapter to set items to ListView */
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        /** Defining a click event listener for the button "Add" */
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit = (EditText) findViewById(R.id.txtItem);
                list.add("Han: " + edit.getText().toString());
                edit.setText("");
                adapter.notifyDataSetChanged();
            }
        };

        /** Setting the event listener for the add button */
        btn.setOnClickListener(listener);

        /** Setting the adapter to the ListView */
        setListAdapter(adapter);

        list.add(messageName.getText() +": I love you.");;
    }
}