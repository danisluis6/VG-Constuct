package lorence.construction.data.storage.async;

import android.content.Context;

import java.util.List;

import lorence.construction.data.storage.dao.ListingDao;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.view.fragment.listing.ListingPresenter;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public interface ListingAsynTask {

    void attachListingDao(Context mContext, ListingDao listingDao);

    void attachListingPresenter(ListingPresenter listingPresenter);

    void inertListings(List<Listing> items);

    void getListings();
}
