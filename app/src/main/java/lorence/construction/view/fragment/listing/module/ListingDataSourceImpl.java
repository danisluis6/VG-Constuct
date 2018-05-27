package lorence.construction.view.fragment.listing.module;


import java.util.ArrayList;
import java.util.List;

import lorence.construction.R;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.data.storage.entity.ListingOperation;
import lorence.construction.helper.Constants;

/**
 * Created by lorence on 28/12/2017.
 *
 * @version master
 * @since 12/28/2017
 */

public class ListingDataSourceImpl implements ListingDataSource {
    @Override
    public List<Listing> getDefaultListingData() {
        List<Listing> groupListings = new ArrayList<>();
        int[] covers = new int[]{
                R.drawable.ic_bang_ke_1,
                R.drawable.ic_bang_ke_2,
                R.drawable.ic_bang_ke_3,
                R.drawable.ic_bang_ke_4,
                R.drawable.ic_bang_ke_5,
                R.drawable.ic_bang_ke_6,
                R.drawable.ic_bang_ke_7,
                R.drawable.ic_bang_ke_8,
                R.drawable.ic_bang_ke_9,
                R.drawable.ic_bang_ke_10,
                R.drawable.ic_bang_ke_11
        };

        groupListings.add(new Listing(Constants.LISTINGS.ONE, covers[0]));
        groupListings.add(new Listing(Constants.LISTINGS.TWO, covers[1]));
        groupListings.add(new Listing(Constants.LISTINGS.THREE, covers[2]));
        groupListings.add(new Listing(Constants.LISTINGS.FOUR, covers[3]));
        groupListings.add(new Listing(Constants.LISTINGS.FIVE, covers[4]));
        groupListings.add(new Listing(Constants.LISTINGS.SIX, covers[5]));
        groupListings.add(new Listing(Constants.LISTINGS.SEVEN, covers[6]));
        groupListings.add(new Listing(Constants.LISTINGS.EIGHT, covers[7]));
        groupListings.add(new Listing(Constants.LISTINGS.NINE, covers[8]));
        groupListings.add(new Listing(Constants.LISTINGS.TEN, covers[9]));
        groupListings.add(new Listing(Constants.LISTINGS.ELEVEN, covers[10]));
        return groupListings;
    }

    @Override
    public List<ListingOperation> getDefaultListingOperationData() {
        List<ListingOperation> groupListingOperations = new ArrayList<>();
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE,"1.00", "0.0365", "0.0365", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.05","0.0384", "0.0341", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.10","0.0399", "0.0330", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.15","0.0414", "0.0314", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.20","0.0426", "0.0298", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.25","0.0440", "0.0282", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.30","0.0452", "0.0268", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.35","0.0461", "0.0253", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.40","0.0469", "0.0240", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.45","0.0475", "0.0225", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.50","0.0480", "0.0214", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.55","0.0484", "0.0201", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.60","0.0485", "0.0189", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.65","0.0486", "0.0179", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.70","0.0488", "0.0169", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.75","0.0486", "0.0158", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.80","0.0485", "0.0148", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.85","0.0484", "0.0140", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.90","0.0480", "0.0133", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "1.95","0.0476", "0.0125", "0", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ONE, "2.00","0.0473", "0.0118", "0", "0"));

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO,"1.00", "0.0334", "0.0273", "0.0892", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.05","0.0343", "0.0252", "0.0895", "0"));
        return groupListingOperations;
    }
}
