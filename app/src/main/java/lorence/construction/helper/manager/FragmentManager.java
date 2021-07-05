package lorence.construction.helper.manager;

import java.util.HashMap;

import lorence.construction.view.EBaseFragment;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */


public class FragmentManager {

    private static FragmentManager instance;
    private HashMap<String, EBaseFragment> fragments;


    private FragmentManager() {

        fragments = new HashMap<>();

    }

    public static synchronized FragmentManager getInstance() {
        if (instance == null) {
            instance = new FragmentManager();
        }
        return instance;
    }


    public void put(String key, EBaseFragment presenter) {
        fragments.put(key, presenter);
    }

    public EBaseFragment get(String key) {
        return fragments.get(key);
    }

    public synchronized void removePresenter(String key) {
        if (fragments != null) {
            fragments.remove(key);
        }
    }

}
