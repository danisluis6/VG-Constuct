package lorence.construction.data.storage.entity;

import android.arch.persistence.room.Ignore;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lorence.construction.data.DatabaseInfo;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class Configuration implements Parcelable {

    @SerializedName(DatabaseInfo.Configuration.COLUMN_MININUM_VERSION)
    @Expose
    private String minimumVersion;

    @SerializedName(DatabaseInfo.Configuration.COLUMN_NEWEST_VERSION)
    @Expose
    private String newestVersion;

    @Ignore
    public Configuration(String minimumVersion, String newestVersion) {
        this.minimumVersion = minimumVersion;
        this.newestVersion = newestVersion;
    }

    public Configuration(){
    }

    protected Configuration(Parcel in) {
        minimumVersion = in.readString();
        newestVersion = in.readString();
    }

    public static final Creator<Configuration> CREATOR = new Creator<Configuration>() {
        @Override
        public Configuration createFromParcel(Parcel in) {
            return new Configuration(in);
        }

        @Override
        public Configuration[] newArray(int size) {
            return new Configuration[size];
        }
    };

    public String getMinimumVersion() {
        return minimumVersion;
    }

    public void setMinimumVersion(String minimumVersion) {
        this.minimumVersion = minimumVersion;
    }

    public String getNewestVersion() {
        return newestVersion;
    }

    public void setNewestVersion(String newestVersion) {
        this.newestVersion = newestVersion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static Creator<Configuration> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.minimumVersion);
        dest.writeString(this.newestVersion);
    }
}
