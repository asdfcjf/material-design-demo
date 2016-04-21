package com.nho.mydesign;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by nho on 3/4/2016.
 */
public class TabPageAdapter extends FragmentStatePagerAdapter{
    public TabPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new FragmentAndroid();
            case 1:
                return new FragmentIOS();
            case 2:
                return new FragmentWindowsphone();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Android";
            case 1:
                return "IOS";
            case 2:
                return "Windows Phone";
        }
        return super.getPageTitle(position);
    }
}
