package lorence.construction.view.activity.home;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public interface HomePresenter {
    void navigationSelected(int menuItemId);

    void attachView(HomeView homeView);

    void initializes();
}
