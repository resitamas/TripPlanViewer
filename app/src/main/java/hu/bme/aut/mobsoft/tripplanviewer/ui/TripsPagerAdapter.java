package hu.bme.aut.mobsoft.tripplanviewer.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import hu.bme.aut.mobsoft.tripplanviewer.ui.main.TripsFragment;

/**
 * Created by Resi Tamas on 03/05/2017.
 */

public class TripsPagerAdapter extends FragmentStatePagerAdapter {


    public TripsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return TripsFragment.Instance(position);

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0)
        {
            return "My Trips";
        } else {

            if (position == 1) {
                return "Saved Trips";
            } else  {
                return "";
            }

        }
    }


}
