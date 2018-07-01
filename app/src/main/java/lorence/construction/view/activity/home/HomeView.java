package lorence.construction.view.activity.home;

import android.support.v4.app.Fragment;
import android.widget.ImageView;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public interface HomeView {
    void displayFragment(Fragment fragment, String title);
    void updateTitleToolbar(String title);

    String getTitleToolbar();

    void hiddenBottomBar();

    void showBottomBar();

    void updateShareButton(int resId);

    ImageView attachShareButton();
}
