package lorence.construction.other;

import java.util.HashMap;

import lorence.construction.helper.Validator;


/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public class TemporaryStorage {

    private static TemporaryStorage instance;
    private HashMap<String, String> presenters;


    private TemporaryStorage() {

        presenters = new HashMap<>();

    }

    public static synchronized TemporaryStorage getInstance() {
        if (instance == null) {
            instance = new TemporaryStorage();
        }
        return instance;
    }


    public void put(String key, String value) {
        presenters.put(key, value);
    }

    public String get(String key) {
        return presenters.get(key);
    }

    public synchronized void removePresenter(String key) {
        if (presenters != null) {
            presenters.remove(key);
        }
    }

}
