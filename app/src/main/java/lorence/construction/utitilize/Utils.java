package lorence.construction.utitilize;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class Utils {
    public static final String CARD_POSITION = "cardPosition";
    public static final String LISTING_ID_KEY = "listingID";
    public static final String LISTING_KEY = "listingKey";
    public static final String FEED_LISTING = "selectedListing";

    public static final String LISTING_DETAIL_ACTIVITY = "lorence.vgconstruct.view.activity.splash";

    public static int dpToPx(Context context, int dp) {
        Resources r = context.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
