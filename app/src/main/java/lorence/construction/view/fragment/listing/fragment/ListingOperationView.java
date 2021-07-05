package lorence.construction.view.fragment.listing.fragment;

import java.util.List;

import lorence.construction.data.storage.entity.ListingOperation;

public interface ListingOperationView {
    void onGetListingOperationsSuccess(List<ListingOperation> listingOperations);
}
