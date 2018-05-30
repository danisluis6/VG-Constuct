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
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.10","0.0349", "0.0231", "0.0892", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.15","0.0353", "0.0213", "0.0885", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.20","0.0357", "0.0196", "0.0872", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.25","0.0359", "0.0179", "0.0859", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.30","0.0359", "0.0165", "0.0843", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.35","0.0358", "0.0152", "0.0827", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.40","0.0357", "0.0140", "0.0808", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.45","0.0353", "0.0128", "0.0790", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.50","0.0350", "0.0119", "0.0772", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.55","0.0346", "0.0109", "0.0754", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.60","0.0341", "0.0101", "0.0735", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.65","0.0338", "0.0093", "0.0718", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.70","0.0333", "0.0086", "0.0701", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.75","0.0329", "0.0080", "0.0685", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.80","0.0326", "0.0075", "0.0668", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.85","0.0321", "0.0069", "0.0653", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.90","0.0316", "0.0064", "0.0638", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "1.95","0.0310", "0.0060", "0.0624", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TWO, "2.00","0.0303", "0.0056", "0.0610", "0"));

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE,"1.00", "0.0273", "0.0334", "0.0", "0.0893"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.05","0.0293", "0.0325", "0.0", "0.0883"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.10","0.0313", "0.0313", "0.0", "0.0867"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.15","0.0332", "0.0302", "0.0", "0.0844"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.20","0.0348", "0.0292", "0.0", "0.0820"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.25","0.0363", "0.0280", "0.0", "0.0791"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.30","0.0378", "0.0269", "0.0", "0.0760"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.35","0.0391", "0.0258", "0.0", "0.0726"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.40","0.0401", "0.0248", "0.0", "0.0688"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.45","0.0411", "0.0237", "0.0", "0.0654"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.50","0.0420", "0.0228", "0.0", "0.0620"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.55","0.0427", "0.0219", "0.0", "0.0585"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.60","0.0433", "0.0208", "0.0", "0.0553"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.65","0.0437", "0.0198", "0.0", "0.0519"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.70","0.0441", "0.0190", "0.0", "0.0489"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.75","0.0443", "0.0181", "0.0", "0.0460"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.80","0.0444", "0.0172", "0.0", "0.0432"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.85","0.0445", "0.0165", "0.0", "0.0407"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.90","0.0445", "0.0157", "0.0", "0.0332"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "1.95","0.0444", "0.0149", "0.0", "0.0359"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.THREE, "2.00","0.0443", "0.0142", "0.0", "0.0338"));

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR,"1.00", "0.0334", "0.0273", "0.0892", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0343", "0.0252", "0.0895", "0"));

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE,"1.00", "0.0334", "0.0273", "0.0892", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0343", "0.0252", "0.0895", "0"));

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX,"1.00", "0.0334", "0.0273", "0.0892", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0343", "0.0252", "0.0895", "0"));

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN,"1.00", "0.0334", "0.0273", "0.0892", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT,"1.00", "0.0334", "0.0273", "0.0892", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0343", "0.0252", "0.0895", "0"));

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE,"1.00", "0.0334", "0.0273", "0.0892", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0343", "0.0252", "0.0895", "0"));

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN,"1.00", "0.0334", "0.0273", "0.0892", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.05","0.0343", "0.0252", "0.0895", "0"));

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN,"1.00", "0.0334", "0.0273", "0.0892", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.05","0.0343", "0.0252", "0.0895", "0"));

        return groupListingOperations;
    }
}
