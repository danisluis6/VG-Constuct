package lorence.construction.helper.manager;

import java.util.HashMap;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */


public class TagManager {

    private static TagManager instance;
    private HashMap<String, String> tags;


    private TagManager() {

        tags = new HashMap<>();

    }

    public static synchronized TagManager getInstance() {
        if (instance == null) {
            instance = new TagManager();
        }
        return instance;
    }


    public void put(String key, String tag) {
        tags.put(key, tag);
    }

    public String get(String key) {
        return tags.get(key);
    }

    public synchronized void removePresenter(String key) {
        if (tags != null) {
            tags.remove(key);
        }
    }

}
