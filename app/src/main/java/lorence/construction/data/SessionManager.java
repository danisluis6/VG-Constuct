package lorence.construction.data;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import lorence.construction.helper.Constants;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public class SessionManager {

    private static final String L1 = "l1";
    private static final String PREF_NAME = "_sharedPref";
    private static SessionManager instance;
    private final SharedPreferences pref;
    private final SharedPreferences.Editor editor;

    @Inject
    public SessionManager(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.apply();
    }

    public static SessionManager getInstance(Context context) {
        if (instance == null) {
            instance = new SessionManager(context);
        }
        return instance;
    }

    public String getL1() {
        return pref.getString(L1, Constants.EMPTY_STRING);
    }

    public void setL1(String l1) {
        editor.putString(L1, l1);
        editor.apply();
    }

    public void clear() {
        editor.remove(L1);
        editor.apply();
    }
}
