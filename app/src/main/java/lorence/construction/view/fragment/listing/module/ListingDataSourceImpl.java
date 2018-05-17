package lorence.construction.view.fragment.listing.module;


import java.util.ArrayList;
import java.util.List;

import lorence.construction.R;
import lorence.construction.data.storage.entity.Listing;

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

        groupListings.add(new Listing("Bảng Kê 1", covers[0]));
        groupListings.add(new Listing("Bảng Kê 2", covers[1]));
        groupListings.add(new Listing("Bảng Kê 3", covers[2]));
        groupListings.add(new Listing("Bảng Kê 4", covers[3]));
        groupListings.add(new Listing("Bảng Kê 5", covers[4]));
        groupListings.add(new Listing("Bảng Kê 6", covers[5]));
        groupListings.add(new Listing("Bảng Kê 7", covers[6]));
        groupListings.add(new Listing("Bảng Kê 8", covers[7]));
        groupListings.add(new Listing("Bảng Kê 9", covers[8]));
        groupListings.add(new Listing("Bảng Kê 10", covers[9]));
        groupListings.add(new Listing("Bảng Kê 11", covers[10]));
        return groupListings;
    }
}
