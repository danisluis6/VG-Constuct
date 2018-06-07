package lorence.construction.utitilize;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import lorence.construction.helper.Constants;

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

    /**
     * Compare between versions
     */
    public static String versionToComparable( String version )
    {
        String versionNum = version;
        int at = version.indexOf( '-' );
        if ( at >= 0 )
            versionNum = version.substring( 0, at );
        String[] numAr = versionNum.split( "\\." );
        String versionFormatted = "0";
        for ( String tmp : numAr ){
            versionFormatted += String.format( "%4s", tmp ).replace(' ', '0');
        }
        while ( versionFormatted.length() < 12 )  {
            versionFormatted += "0000";
        }
        return versionFormatted;
    }

    public static String getVersionName(Context context) {
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return Constants.EMPTY_STRING;
    }

    public static boolean isInternetOn(Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public static boolean equalsIgnoreCase(String a, String b) {
        return a != null && b != null && a.length() == b.length() && a.equalsIgnoreCase(b);
    }
}
