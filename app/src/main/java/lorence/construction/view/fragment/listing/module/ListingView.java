package lorence.construction.view.fragment.listing.module;

import java.util.List;

import lorence.construction.data.storage.entity.Listing;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public interface ListingView {
    void onGetListingsSuccess(List<Listing> listings);

    void initializeNewListings();
}
