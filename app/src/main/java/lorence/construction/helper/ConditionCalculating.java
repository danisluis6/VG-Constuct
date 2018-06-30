package lorence.construction.helper;

import android.text.TextUtils;

import javax.inject.Inject;

public class ConditionCalculating {

    @Inject
    public ConditionCalculating() {
    }

    public boolean islistingOrBeams(double L1, double L2, String titleToolbar) {
        if (TextUtils.equals(titleToolbar, Constants.LISTINGS.TEN) || TextUtils.equals(titleToolbar, Constants.LISTINGS.ELEVEN)) {
            return Math.round((L2/L1) * 100.0) / 100.0 <= 1.5;
        }
        return Math.round((L2/L1) * 100.0) / 100.0 <= 2.0;
    }
}
