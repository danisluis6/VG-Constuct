package lorence.construction.view.fragment.listing.fragment;

import java.util.List;

import lorence.construction.data.storage.async.ListingOperationAsynTask;
import lorence.construction.data.storage.entity.ListingOperation;
import lorence.construction.view.fragment.listing.ListingPresenterImpl;

public interface ListingOperationModel {
    void getListingOperationByListingPresenters(ListingPresenterImpl listingPresenter);

    void getListingOperationByListingPresenterByListingOperationPresenters(ListingOperationPresenter listingOperationPresenter);

    void inertListingOperationByListingPresenters(List<ListingOperation> list, ListingPresenterImpl listingPresenter);

    void attachListingOperationPresenter(ListingOperationPresenterImpl listingOperationPresenter);

    void attachListingOperationAsynTask(ListingOperationAsynTask listingOperationAsynTask);
}
