package lorence.construction.view.fragment.listing.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import javax.inject.Inject;

import lorence.construction.other.TitleStringUtils;
import lorence.construction.view.fragment.listing.fragment.child.calculate.CalculateFragment;
import lorence.construction.view.fragment.listing.fragment.child.reference.ReferenceFragment;
import lorence.construction.view.fragment.listing.fragment.child.result.ResultFragment;

/**
 * Created by lorence on 28/12/2017.
 *
 * @version master
 * @since 12/28/2017
 */

public class PagerAdapterPushed extends FragmentStatePagerAdapter {

    private TitleStringUtils titles;
    private CalculateFragment mCalculateFragment;
    private ResultFragment mResultFragment;
    private ReferenceFragment mReferenceFragment;

    @Inject
    public PagerAdapterPushed(FragmentManager fragmentManager, TitleStringUtils titleStringUtils, CalculateFragment calculateFragment, ResultFragment resultFragment, ReferenceFragment referenceFragment) {
        super(fragmentManager);
        titles = titleStringUtils;
        mCalculateFragment = calculateFragment;
        mResultFragment = resultFragment;
        mReferenceFragment = referenceFragment;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:{
                return mCalculateFragment.newInstance(mCalculateFragment, position);
            }
            case 1:{
                return mResultFragment.newInstance(mResultFragment, position);
            }
            case 2:{
                return mReferenceFragment.newInstance(mReferenceFragment, position);
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return titles.getGroupTitleFragment().length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.getGroupTitleFragment()[position];
    }
}
