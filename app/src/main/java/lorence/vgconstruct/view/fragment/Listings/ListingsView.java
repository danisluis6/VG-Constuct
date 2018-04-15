package lorence.vgconstruct.view.fragment.Listings;

import android.content.Context;

import java.util.List;

import lorence.vgconstruct.custom.adapter.CardConfig;
import lorence.vgconstruct.model.ListingItem;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public interface ListingsView {
    void showListingItems(List<ListingItem> categoryItemList, CardConfig categoryCardConfig);
    int getScreenColumns();
    Context getViewContext();
}
