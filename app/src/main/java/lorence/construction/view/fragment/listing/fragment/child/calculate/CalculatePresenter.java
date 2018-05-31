package lorence.construction.view.fragment.listing.fragment.child.calculate;

import java.util.List;

import lorence.construction.data.storage.entity.ListingOperation;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public interface CalculatePresenter {
    void getListingOperations();
    void onGetListingOperationsSuccess(List<ListingOperation> listingOperations);
}
