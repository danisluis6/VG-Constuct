package lorence.vgconstruct.view.fragment.Listings;

import java.util.ArrayList;

import lorence.vgconstruct.model.ListingItem;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class ListingsModel {

    private ListingsPresenter mPresenter;
    private static ListingsModel instance;

    public void registerPresenter(ListingsPresenter presenter) {
        mPresenter = presenter;
    }

    public void unregisterPresenter() {
        mPresenter = null;
    }

    public static synchronized ListingsModel getInstance() {
        if (instance == null) {
            instance = new ListingsModel();
        }
        return instance;
    }

    private ListingsModel() {
        // TODO
    }

    public ArrayList<ListingItem> getCategoryItems() {
        return null;
    }
}
