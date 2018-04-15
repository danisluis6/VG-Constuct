package lorence.vgconstruct.helper;

import java.util.HashMap;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class PresenterManager {
    private static PresenterManager instance;
    private HashMap<String, BasePresenter> presenters;


    private PresenterManager() {

        presenters = new HashMap<>();

    }

    public static synchronized PresenterManager getInstance() {
        if (instance == null) {
            instance = new PresenterManager();
        }
        return instance;
    }


    public void put(String key, BasePresenter presenter) {
        presenters.put(key, presenter);
    }

    public BasePresenter get(String key) {
        return presenters.get(key);
    }

    public synchronized void removePresenter(String key) {
        if (presenters != null) {
            presenters.remove(key);
        }
    }
}
