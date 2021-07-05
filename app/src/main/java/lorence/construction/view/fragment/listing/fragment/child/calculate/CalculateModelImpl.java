package lorence.construction.view.fragment.listing.fragment.child.calculate;

import android.content.Context;

import javax.inject.Inject;

import lorence.construction.data.storage.async.ListingOperationAsynTask;
import lorence.construction.data.storage.dao.ListingOperationDao;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public class CalculateModelImpl implements CalculateModel {

    private Context mContext;
    private ListingOperationDao mListingOperationDao;

    private CalculatePresenter mCalculatePresenter;
    private ListingOperationAsynTask mListingOperationAsynTask;

    @Inject
    public CalculateModelImpl(Context context, ListingOperationDao listingOperationDao) {
        mContext = context;
        mListingOperationDao = listingOperationDao;
    }

    @Override
    public void attachCalculatePresenter(CalculatePresenterImpl calculatePresenter) {
        mCalculatePresenter = calculatePresenter;
        mListingOperationAsynTask.attachCalculatePresenter(calculatePresenter);
    }

    @Override
    public void attachListingOperationAsynTask(ListingOperationAsynTask listingOperationAsynTask) {
        mListingOperationAsynTask = listingOperationAsynTask;
        mListingOperationAsynTask.attachListingOperationDao(mContext, mListingOperationDao);
    }

    @Override
    public void getListingOperationByCalculatePresenter(CalculatePresenterImpl calculatePresenter) {
        mListingOperationAsynTask.getListingOperationByCalculatePresenters(calculatePresenter);
    }
}
