package com.pratice.modalbottomsheet;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arpit Jain on 10/3/2017.
 */

public class BottomBarAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> fragmentList = new ArrayList<>();

    public BottomBarAdapter(FragmentManager fm) {
        super(fm);
    }

    //custom methods that populates this Adapter with fragments
    public void addFragments(Fragment fragment){
        fragmentList.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    /* NOTES */
    /*
    1) In future if to fetch a particular Fragment
            --> <BottomBarAdapter Object Name>.getRegisteredFragment(position).

    2)
     */
}
