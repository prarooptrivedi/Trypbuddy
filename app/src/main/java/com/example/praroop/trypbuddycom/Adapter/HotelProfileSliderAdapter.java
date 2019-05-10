package com.example.praroop.trypbuddycom.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.praroop.trypbuddycom.Fragments.HotelProfileFrag1;


public class HotelProfileSliderAdapter extends FragmentStatePagerAdapter {
    int mnumoftabs;

    public HotelProfileSliderAdapter(FragmentManager fm, int numoftabs) {
        super(fm);
        this.mnumoftabs = numoftabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                HotelProfileFrag1 tab1 = new HotelProfileFrag1();
                return tab1;
            case 1:
                HotelProfileFrag1 tab2 = new HotelProfileFrag1();
                return tab2;

            case 2:
                HotelProfileFrag1 tab3 = new HotelProfileFrag1();
                return tab3;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mnumoftabs;
    }
}
