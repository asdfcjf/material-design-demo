package com.nho.mydesign;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nho on 3/4/2016.
 */
public class FragmentTabs extends android.support.v4.app.Fragment{
    TabPageAdapter tabPageAdapter;
    ActionBar actionBar;
    TabLayout tabLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View tab = inflater.inflate(R.layout.fragment_tabs,container,false);
        final ViewPager viewPager = (ViewPager) tab.findViewById(R.id.viewPager);
        tabPageAdapter = new TabPageAdapter(getChildFragmentManager());
        tabLayout = (TabLayout) tab.findViewById(R.id.tabLayout);
        viewPager.setAdapter(tabPageAdapter);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        /*actionBar = getActivity().getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        };
        actionBar.addTab(actionBar.newTab().setText("Android").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("IOS").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Windows Phone").setTabListener(tabListener));*/
        return tab;
    }
}
