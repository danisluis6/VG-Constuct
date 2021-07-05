package lorence.construction.view.fragment.listing;

import java.util.List;

import lorence.construction.data.storage.entity.Listing;
import lorence.construction.data.storage.entity.ListingOperation;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public interface ListingPresenter {

    void saveListings(List<Listing> list);

    void onInsertListingsSuccess();

    void onInsertListingsFailed();

    void getListings();

    void getListingOperations();

    void onGetListingsSuccess(List<Listing> listings);

    void saveListingOperations(List<ListingOperation> defaultListingOperationData);

    void onGetListingOperationsSuccess(List<ListingOperation> listings);
}
