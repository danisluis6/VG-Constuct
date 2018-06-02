package lorence.construction.utitilize;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

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

    public static void hiddenKeyBoard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
