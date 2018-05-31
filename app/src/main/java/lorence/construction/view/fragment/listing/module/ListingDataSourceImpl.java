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

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR,"1.00", "0.0267", "0.0180", "0.0694", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.05","0.0267", "0.0161", "0.0680", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.10","0.0266", "0.0146", "0.0667", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.15","0.0264", "0.0131", "0.0650", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.20","0.0261", "0.0118", "0.0633", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.25","0.0257", "0.0108", "0.0616", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.30","0.0254", "0.0097", "0.0599", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.35","0.0250", "0.0088", "0.0582", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.40","0.0245", "0.0080", "0.0565", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.45","0.0240", "0.0072", "0.0550", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.50","0.0235", "0.0066", "0.0534", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.55","0.0230", "0.0060", "0.0519", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.60","0.0226", "0.0056", "0.0506", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.65","0.0221", "0.0051", "0.0493", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.70","0.0217", "0.0047", "0.0476", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.75","0.0212", "0.0043", "0.0466", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.80","0.0208", "0.0040", "0.0454", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.85","0.0204", "0.0037", "0.0443", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.90","0.0199", "0.0034", "0.0432", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "1.95","0.0196", "0.0032", "0.0422", "0"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FOUR, "2.00","0.0193", "0.0030", "0.0412", "0"));

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE,"1.00", "0.0180", "0.0267", "0.0", "0.0694"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.05","0.0199", "0.0265", "0.0", "0.0705"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.10","0.0218", "0.0262", "0.0", "0.0708"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.15","0.0236", "0.0258", "0.0", "0.0710"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.20","0.0254", "0.0254", "0.0", "0.0707"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.25","0.0271", "0.0248", "0.0", "0.0700"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.30","0.0287", "0.0242", "0.0", "0.0689"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.35","0.0302", "0.0235", "0.0", "0.0676"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.40","0.0316", "0.0229", "0.0", "0.0660"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.45","0.0329", "0.0222", "0.0", "0.0641"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.50","0.0341", "0.0214", "0.0", "0.0621"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.55","0.0352", "0.0207", "0.0", "0.0599"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.60","0.0362", "0.0200", "0.0", "0.0577"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.65","0.0369", "0.0193", "0.0", "0.0555"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.70","0.0376", "0.0186", "0.0", "0.0531"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.75","0.0383", "0.0179", "0.0", "0.0507"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.80","0.0388", "0.0172", "0.0", "0.0484"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.85","0.0393", "0.0165", "0.0", "0.0461"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.90","0.0396", "0.0158", "0.0", "0.0439"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "1.95","0.0398", "0.0152", "0.0", "0.0418"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.FIVE, "2.00","0.0400", "0.0146", "0.0", "0.0397"));

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX,"1.00", "0.0269", "0.0269", "0.0625", "0.0625"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.05","0.0282", "0.0255", "0.0655", "0.0590"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.10","0.0292", "0.0242", "0.0675", "0.0558"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.15","0.0301", "0.0228", "0.0691", "0.0522"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.20","0.0309", "0.0214", "0.0703", "0.0488"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.25","0.0314", "0.0202", "0.0710", "0.0454"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.30","0.0319", "0.0188", "0.0711", "0.0421"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.35","0.0320", "0.0176", "0.0711", "0.0391"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.40","0.0323", "0.0165", "0.0709", "0.0361"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.45","0.0324", "0.0154", "0.0703", "0.0334"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.50","0.0324", "0.0144", "0.0695", "0.0310"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.55","0.0323", "0.0134", "0.0686", "0.0286"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.60","0.0321", "0.0125", "0.0678", "0.0265"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.65","0.0319", "0.0117", "0.0668", "0.0245"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.70","0.0316", "0.0109", "0.0657", "0.0228"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.75","0.0313", "0.0097", "0.0645", "0.0211"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.80","0.0308", "0.0096", "0.0635", "0.0196"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.85","0.0306", "0.0089", "0.0622", "0.0183"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.90","0.0302", "0.0084", "0.0612", "0.0169"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "1.95","0.0299", "0.0078", "0.0599", "0.0160"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SIX, "2.00","0.0294", "0.0074", "0.0588", "0.0147"));

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN,"1.00", "0.0226", "0.0198", "0.0556", "0.0417"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.05","0.0231", "0.0184", "0.0560", "0.0385"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.10","0.0234", "0.0169", "0.0565", "0.0350"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.15","0.0236", "0.0154", "0.0564", "0.0319"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.20","0.0236", "0.0142", "0.0560", "0.0292"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.25","0.0236", "0.0132", "0.0552", "0.0267"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.30","0.0235", "0.0120", "0.0545", "0.0242"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.35","0.0233", "0.0110", "0.0536", "0.0222"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.40","0.0230", "0.0102", "0.0526", "0.0202"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.45","0.0228", "0.0094", "0.0516", "0.0185"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.50","0.0225", "0.0086", "0.0506", "0.0169"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.55","0.0221", "0.0079", "0.0495", "0.0155"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.60","0.0218", "0.0073", "0.0484", "0.0142"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.65","0.0214", "0.0067", "0.0473", "0.0131"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.70","0.0210", "0.0062", "0.0462", "0.0120"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.75","0.0206", "0.0058", "0.0452", "0.0112"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.80","0.0203", "0.0054", "0.0442", "0.0102"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.85","0.0200", "0.0050", "0.0432", "0.0095"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.90","0.0196", "0.0046", "0.0422", "0.0088"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "1.95","0.0192", "0.0043", "0.0413", "0.0082"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.SEVEN, "2.00","0.0189", "0.0040", "0.0404", "0.0076"));

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT,"1.00", "0.0198", "0.0226", "0.0417", "0.0556"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.05","0.0213", "0.0221", "0.0450", "0.0545"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.10","0.0226", "0.0212", "0.0481", "0.0530"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.15","0.0238", "0.0206", "0.0507", "0.0511"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.20","0.0249", "0.0198", "0.0530", "0.0491"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.25","0.0258", "0.0189", "0.0549", "0.0470"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.30","0.0266", "0.0181", "0.0565", "0.0447"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.35","0.0272", "0.0172", "0.0577", "0.0424"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.40","0.0279", "0.0162", "0.0588", "0.0400"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.45","0.0282", "0.0154", "0.0593", "0.0377"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.50","0.0285", "0.0146", "0.0597", "0.0354"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.55","0.0289", "0.0138", "0.0599", "0.0332"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.60","0.0289", "0.0130", "0.0599", "0.0312"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.65","0.0290", "0.0123", "0.0597", "0.0293"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.70","0.0290", "0.0116", "0.0594", "0.0274"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.75","0.0290", "0.0109", "0.0589", "0.0256"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.80","0.0288", "0.0103", "0.0583", "0.0240"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.85","0.0286", "0.0097", "0.0576", "0.0225"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.90","0.0284", "0.0092", "0.0570", "0.0212"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "1.95","0.0282", "0.0086", "0.0562", "0.0198"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.EIGHT, "2.00","0.0280", "0.0081", "0.0555", "0.0187"));

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE,"1.00", "0.0179", "0.0179", "0.0417", "0.0417"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.05","0.0187", "0.0171", "0.0437", "0.0394"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.10","0.0194", "0.0161", "0.0450", "0.0372"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.15","0.0200", "0.0150", "0.0461", "0.0349"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.20","0.0204", "0.0142", "0.0468", "0.0325"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.25","0.0207", "0.0133", "0.0473", "0.0303"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.30","0.0208", "0.0123", "0.0475", "0.0281"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.35","0.0210", "0.0115", "0.0474", "0.0262"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.40","0.0210", "0.0107", "0.0473", "0.0240"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.45","0.0209", "0.0100", "0.0469", "0.0223"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.50","0.0208", "0.0093", "0.0464", "0.0206"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.55","0.0206", "0.0086", "0.0459", "0.0191"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.60","0.0205", "0.0080", "0.0452", "0.0177"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.65","0.0202", "0.0074", "0.0446", "0.0164"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.70","0.0200", "0.0069", "0.0438", "0.0152"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.75","0.0197", "0.0064", "0.0431", "0.0141"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.80","0.0195", "0.0060", "0.0423", "0.0131"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.85","0.0192", "0.0056", "0.0415", "0.0122"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.90","0.0190", "0.0052", "0.0408", "0.0113"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "1.95","0.0186", "0.0049", "0.0400", "0.0107"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.NINE, "2.00","0.0183", "0.0046", "0.0392", "0.0098"));

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN,"1.00", "0.0099", "0.0457", "0.0510", "0.0853"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.10","0.0102", "0.0492", "0.0570", "0.0930"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.20","0.0102", "0.0519", "0.0636", "0.1000"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.30","0.0100", "0.0540", "0.0700", "0.1062"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.40","0.0097", "0.0552", "0.0761", "0.1115"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.TEN, "1.50","0.0095", "0.0556", "0.0821", "0.1155"));

        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN,"1.00", "0.0457", "0.0099", "0.0853", "0.0510"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.10","0.0421", "0.0094", "0.0777", "0.0448"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.20","0.0389", "0.0087", "0.0712", "0.0397"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.30","0.0362", "0.0079", "0.0658", "0.0354"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.40","0.0336", "0.0070", "0.0609", "0.0314"));
        groupListingOperations.add(new ListingOperation(Constants.LISTINGS.ELEVEN, "1.50","0.0311", "0.0059", "0.0562", "0.0279"));

        return groupListingOperations;
    }
}
