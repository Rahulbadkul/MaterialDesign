package actiknow.com.materialdesign.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import actiknow.com.materialdesign.fragment.DesignDemoFragment;

public class DesignDemoPagerAdapter extends FragmentStatePagerAdapter {

    public DesignDemoPagerAdapter (FragmentManager fm) {
        super (fm);
    }

    @Override
    public Fragment getItem (int position) {
        return DesignDemoFragment.newInstance (position);
    }

    @Override
    public int getCount () {
        return 3;
    }

    @Override
    public CharSequence getPageTitle (int position) {
        return "Tab " + position;
    }
}
