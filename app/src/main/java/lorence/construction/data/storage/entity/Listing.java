package lorence.construction.data.storage.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import lorence.construction.data.DatabaseInfo;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@Entity(tableName = DatabaseInfo.Tables.Listing)
public class Listing implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DatabaseInfo.Listing.COLUMN_ID)
    @SerializedName(DatabaseInfo.Listing.COLUMN_ID)
    private int id;

    @ColumnInfo(name = DatabaseInfo.Listing.COLUMN_NAME)
    @SerializedName(DatabaseInfo.Listing.COLUMN_NAME)
    private String name;

    @ColumnInfo(name = DatabaseInfo.Listing.COLUMN_IMAGE)
    @SerializedName(DatabaseInfo.Listing.COLUMN_IMAGE)
    private int image;

    @Ignore
    public Listing(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public Listing(){
    }

    protected Listing(Parcel in) {
        id = in.readInt();
        name = in.readString();
        image = in.readInt();
    }

    public static final Creator<Listing> CREATOR = new Creator<Listing>() {
        @Override
        public Listing createFromParcel(Parcel in) {
            return new Listing(in);
        }

        @Override
        public Listing[] newArray(int size) {
            return new Listing[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static Creator<Listing> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeValue(this.image);
    }
}
