package lorence.vgconstruct.view.fragment.Listings.Adapter;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public interface ListingView {
    int getListingPosition();
    void displayBackground(int resId);
    void setCardMeasurements(int height, int width, int margin);
}
