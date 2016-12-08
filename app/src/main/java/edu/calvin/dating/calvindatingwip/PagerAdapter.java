package edu.calvin.dating.calvindatingwip;

/**
 * Created by Drew Vande Lune on 10/28/2016.
 * Used http://www.truiton.com/2015/06/android-tabs-example-fragments-viewpager/ for tabs
 */


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ProfileTab tab1 = new ProfileTab();
                return tab1;
            case 1:
                SearchTab tab2 = new SearchTab();
                return tab2;
            case 2:
                MessageTab tab3 = new MessageTab();
                return tab3;
            case 3:
                CalendarTab tab4 = new CalendarTab();
                return tab4;
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
