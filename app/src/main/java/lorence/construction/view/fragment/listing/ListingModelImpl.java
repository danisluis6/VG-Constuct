package lorence.construction.view.fragment.listing;

import java.util.List;

import javax.inject.Inject;

import lorence.construction.data.storage.dao.ListingDao;
import lorence.construction.data.storage.entity.Listing;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class ListingModelImpl implements ListingModel {

    private ListingDao mListingDao;

    @Inject
    public ListingModelImpl(ListingDao listingDao) {
        mListingDao = listingDao;
    }

    @Override
    public void addAll(List<Listing> list) {

    }
}
