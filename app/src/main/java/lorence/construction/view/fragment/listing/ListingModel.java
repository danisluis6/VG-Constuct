package lorence.construction.view.fragment.listing;

import java.util.List;

import lorence.construction.data.storage.async.ListingAsynTask;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.data.storage.entity.ListingOperation;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public interface ListingModel {

    void inertListings(List<Listing> list);

    void attachListingAsynTask(ListingAsynTask listingAsynTask);

    void attachListingPresenter(ListingPresenter listingPresenter);

    void getListings();

    void getListingOperations();

    void inertListingOperations(List<ListingOperation> list);
}
