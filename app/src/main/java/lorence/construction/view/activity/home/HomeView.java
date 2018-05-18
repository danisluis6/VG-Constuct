package lorence.construction.view.activity.home;

import android.support.v4.app.Fragment;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public interface HomeView {
    void displayFragment(Fragment fragment, String title);
    void updateTitleToolbar(String title);
}
