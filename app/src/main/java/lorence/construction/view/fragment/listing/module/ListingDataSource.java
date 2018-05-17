package lorence.construction.view.fragment.listing.module;

import java.util.List;

import lorence.construction.data.storage.entity.Listing;

/**
 * Created by lorence on 28/12/2017.
 *
 * @version master
 * @since 12/28/2017
 */

public interface ListingDataSource {

    List<Listing> getDefaultListingData();
}
