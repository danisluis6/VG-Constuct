package lorence.construction.data.storage.async;

import android.content.Context;

import java.util.List;

import lorence.construction.data.storage.dao.ListingOperationDao;
import lorence.construction.data.storage.entity.ListingOperation;
import lorence.construction.view.fragment.listing.ListingPresenter;
import lorence.construction.view.fragment.listing.fragment.ListingOperationPresenter;
import lorence.construction.view.fragment.listing.fragment.child.calculate.CalculatePresenterImpl;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public interface ListingOperationAsynTask {

    void attachListingOperationDao(Context mContext, ListingOperationDao listingOperationDao);

    void attachListingOperationPresenter(ListingOperationPresenter listingOperationPresenter);

    void inertListingOperations(List<ListingOperation> list, ListingPresenter listingPresenter);

    void getListingOperationByListingPresenters(ListingPresenter listingPresenter);

    void getListingOperationByListingOperationPresenters(ListingOperationPresenter listingOperationPresenter);

    void attachCalculatePresenter(CalculatePresenterImpl calculatePresenter);

    void getListingOperationByCalculatePresenters(CalculatePresenterImpl calculatePresenter);
}
