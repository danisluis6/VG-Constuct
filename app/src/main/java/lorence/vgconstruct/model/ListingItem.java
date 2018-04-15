package lorence.vgconstruct.model;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@Parcel
public class ListingItem implements Comparable<ListingItem> {

    @SerializedName("drawable")
    @Expose
    private int resId;

    @Override
    public int compareTo(@NonNull ListingItem o) {
        return 0;
    }

    public int getDrawable() {
        return resId;
    }

    public void setDrawable(int resId) {
        this.resId = resId;
    }
}
