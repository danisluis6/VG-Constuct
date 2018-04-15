package lorence.vgconstruct.view.fragment.Listings;


import android.support.annotation.NonNull;

import java.util.ArrayList;

import lorence.vgconstruct.R;
import lorence.vgconstruct.app.VGApplication;
import lorence.vgconstruct.custom.adapter.CardConfig;
import lorence.vgconstruct.helper.BasePresenter;
import lorence.vgconstruct.model.ListingItem;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class ListingsPresenter extends BasePresenter<ArrayList<ListingItem>, ListingsView> {

    private ListingsModel mListingsModel;

    ListingsPresenter() {
        mListingsModel = ListingsModel.getInstance();
    }
    @Override
    public void bindView(@NonNull ListingsView view) {
        super.bindView(view);
        mListingsModel.registerPresenter(this);
        mListingsModel.getCategoryItems();
    }

    @Override
    public void unbindView() {
        super.unbindView();
        mListingsModel.unregisterPresenter();
    }


    public void listingsUpdated(ArrayList<ListingItem> items) {
        model = items;
        updateView();
    }

    private CardConfig createCardConfig(int columnConstant) {
        int cardMargin = (int) view().getViewContext().getResources().getDimension(R.dimen.fragment_listing_horizontal_margin);
        int cardWidth = (VGApplication.SCREEN_WIDTH - (cardMargin * 2 * (columnConstant + 1))) / columnConstant;
        int cardHeight = (int) (cardWidth * .665);
        int priorityCardHeight = 2 * cardHeight + 2 * cardMargin;
        int priorityCardWidth = 2 * cardWidth + 2 * cardMargin;
        return new CardConfig(cardMargin, cardWidth, cardHeight, priorityCardHeight, priorityCardWidth);
    }

    @Override
    protected void updateView() {
        CardConfig cardConfig = createCardConfig(view().getScreenColumns());
        view().showListingItems(model, cardConfig);
    }
}
