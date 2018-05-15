package lorence.construction.view;

import android.support.v4.app.Fragment;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class EFragmentStack {
    /**
     * Fragment
     */
    Fragment fragment;
    /**
     * Tag tag of fragment
     */
    String tag;

    public EFragmentStack(Fragment fragment, String key) {
        this.fragment = fragment;
        tag = key;
    }

    /**
     * Get fragment
     *
     * @return fragment
     */
    public Fragment getFragment() {
        return fragment;
    }

    /**
     * Get tag of fragment
     *
     * @return tag
     */
    public String getTag() {
        return tag;
    }
}
