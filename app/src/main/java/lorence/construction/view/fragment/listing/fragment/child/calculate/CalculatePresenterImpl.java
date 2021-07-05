package lorence.construction.view.fragment.listing.fragment.child.calculate;

import android.content.Context;

import java.util.List;

import lorence.construction.data.storage.async.ListingOperationAsynTask;
import lorence.construction.data.storage.entity.ListingOperation;
import lorence.construction.view.activity.home.HomeActivity;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public class CalculatePresenterImpl implements CalculatePresenter {

    private Context mContext;
    private HomeActivity mActivity;
    private CalculateView mCalculateView;
    private CalculateModel mCalculateModel;
    private ListingOperationAsynTask mListingOperationAsynTask;

    public CalculatePresenterImpl(Context context, HomeActivity activity, CalculateView calculateView, CalculateModel calculateModel, ListingOperationAsynTask listingOperationAsynTask) {
        mContext = context;
        mActivity = activity;
        mCalculateView = calculateView;
        mCalculateModel = calculateModel;
        mListingOperationAsynTask = listingOperationAsynTask;

        mCalculateModel.attachListingOperationAsynTask(listingOperationAsynTask);
        mCalculateModel.attachCalculatePresenter(this);
    }

    @Override
    public void getListingOperations() {
        mCalculateModel.getListingOperationByCalculatePresenter(this);
    }

    @Override
    public void onGetListingOperationsSuccess(List<ListingOperation> listingOperations) {
        mCalculateView.onGetListingOperationsSuccess(listingOperations);
    }
}
