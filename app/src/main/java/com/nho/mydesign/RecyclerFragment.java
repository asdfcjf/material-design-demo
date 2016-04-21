package com.nho.mydesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

/**
 * Created by nho on 3/7/2016.
 */
public class RecyclerFragment extends Fragment{
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    ArrayList<String>arrayList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rerycler_view,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<String>();
        for(int i=0; i<5; i++) {
            arrayList.add("Android Deverloper");
        }
        recyclerAdapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(recyclerAdapter);

        AdView mAdView = (AdView) view.findViewById(R.id.adViewRecycler);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        return view;
    }
}
