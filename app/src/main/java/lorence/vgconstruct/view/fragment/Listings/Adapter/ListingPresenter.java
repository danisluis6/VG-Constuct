package lorence.vgconstruct.view.fragment.Listings.Adapter;

import com.squareup.otto.Bus;

import lorence.vgconstruct.app.VGApplication;
import lorence.vgconstruct.custom.adapter.CardConfig;
import lorence.vgconstruct.events.CardClickInfo;
import lorence.vgconstruct.events.StartActEvent;
import lorence.vgconstruct.helper.BasePresenter;
import lorence.vgconstruct.model.ListingItem;
import lorence.vgconstruct.utitilize.Utils;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class ListingPresenter extends BasePresenter<ListingItem, ListingView> {

    private Bus mCommunicationBus;
    private CardConfig mCardConfig;

    public ListingPresenter(CardConfig cardConfig) {
        mCardConfig = cardConfig;
        mCommunicationBus = VGApplication.eventBus;
    }

    public void cardClicked() {
        CardClickInfo info = new CardClickInfo();
        info.setActivityClassName(Utils.LISTING_DETAIL_ACTIVITY);
        StartActEvent startActivity = new StartActEvent(info);
        mCommunicationBus.post(startActivity);
    }

    @Override
    protected void updateView() {
        view().setCardMeasurements(mCardConfig.getCardHeight(), mCardConfig.getCardWidth(), mCardConfig.getCardMargin());
        view().displayBackground(model.getDrawable());
    }

}
