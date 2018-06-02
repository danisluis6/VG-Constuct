package lorence.construction.view.fragment.listing.module;

import java.util.List;

import lorence.construction.data.storage.entity.Beams;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.data.storage.entity.ListingOperation;

/**
 * Created by lorence on 28/12/2017.
 *
 * @version master
 * @since 12/28/2017
 */

public interface DataSource {

    List<Listing> getDefaultListingData();

    List<ListingOperation> getDefaultListingOperationData();

    List<Beams> getDefaultBeamsData();
}
