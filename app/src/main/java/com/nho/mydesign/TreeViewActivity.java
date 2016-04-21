package com.nho.mydesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TreeViewActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_view);
        list = new ArrayList<String>();
        list.add("Cars");
        list.add("Houes");
        list.add("Football Clubs");
        list.add("My Hobby");
        HashMap<String,List<String>> allItems = setup();
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        ExpandableListViewAdapter expandableListVewAdapter = new ExpandableListViewAdapter(list,allItems,this);
        expandableListView.setAdapter(expandableListVewAdapter);
    }

    private HashMap<String,List<String>> setup()
    {
        HashMap<String,List<String>> childContent = new HashMap<>();
        List<String> cars = new ArrayList<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Toyota");
        cars.add("Nissan");

        List<String> houses = new ArrayList<String>();
        houses.add("Duplex");
        houses.add("Twin Duplex");
        houses.add("Bungalow");
        houses.add("Two Storey");

        List<String> footballClubs = new ArrayList<String>();
        footballClubs.add("Liverpool");
        footballClubs.add("Arsenal");
        footballClubs.add("Stoke City");
        footballClubs.add("West Ham");

        List<String> hobbyClubs = new ArrayList<String>();
        hobbyClubs.add("Android");
        hobbyClubs.add("Ios");
        hobbyClubs.add("CR7");

        childContent.put(list.get(0), cars);

        childContent.put(list.get(1), houses);

        childContent.put(list.get(2), footballClubs);
        childContent.put(list.get(3),hobbyClubs);

        return childContent;
    }
}
