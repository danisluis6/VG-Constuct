package lorence.vgconstruct.events;

import android.os.Bundle;

import org.parceler.Parcels;

import lorence.vgconstruct.model.ListingItem;
import lorence.vgconstruct.utitilize.Utils;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class CardClickInfo {

    private Bundle mCardInfo;
    private String mActivityClassName;

    public CardClickInfo() {
        mCardInfo = new Bundle();
    }

    public void setActivityClassName(String activityClassName) {
        mActivityClassName = activityClassName;
    }

    public void setCardPosition(int position) {
        mCardInfo.putInt(Utils.CARD_POSITION, position);
    }

    public void setItemID(Integer itemID) {
        mCardInfo.putInt(Utils.LISTING_ID_KEY, itemID);
    }

    public void setTopic(ListingItem topic) {
        mCardInfo.putParcelable(Utils.LISTING_KEY, Parcels.wrap(topic));
    }

    public void setTopicIndex(int index) {
        mCardInfo.putInt(Utils.FEED_LISTING, index);
    }


    public String getActivityClassName() {
        return mActivityClassName;
    }

    public Bundle getCardInfo() {
        return mCardInfo;
    }

}
