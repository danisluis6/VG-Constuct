package lorence.construction.other;

import android.content.Context;

import javax.inject.Inject;

import lorence.construction.R;

/**
 * Created by lorence on 28/12/2017.
 *
 * @version master
 * @since 12/28/2017
 */

public class TitleStringUtils {

    private Context mContext;

    @Inject
    public TitleStringUtils(Context context) {
        mContext = context;
    }

    public String[] getGroupTitleFragment() {
        return new String[]{mContext.getResources().getString(R.string.tab_title_calculate), mContext.getString(R.string.tab_title_result), mContext.getString(R.string.tab_title_reference)};
    }
}
