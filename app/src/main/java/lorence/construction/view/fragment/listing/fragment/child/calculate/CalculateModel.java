package lorence.construction.view.fragment.listing.fragment.child.calculate;

import lorence.construction.data.storage.async.ListingOperationAsynTask;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public interface CalculateModel {
    void attachCalculatePresenter(CalculatePresenterImpl calculatePresenter);
    void getListingOperationByCalculatePresenter(CalculatePresenterImpl calculatePresenter);
    void attachListingOperationAsynTask(ListingOperationAsynTask listingOperationAsynTask);
}
