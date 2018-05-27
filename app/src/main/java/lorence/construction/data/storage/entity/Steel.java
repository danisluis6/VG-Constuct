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

@Entity(tableName = DatabaseInfo.Tables.Steel)
public class Steel implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DatabaseInfo.Steel.COLUMN_ID)
    @SerializedName(DatabaseInfo.Steel.COLUMN_ID)
    private int id;

    @ColumnInfo(name = DatabaseInfo.Steel.COLUMN_NAME)
    @SerializedName(DatabaseInfo.Steel.COLUMN_NAME)
    private String name;

    @ColumnInfo(name = DatabaseInfo.Steel.COLUMN_NAME)
    @SerializedName(DatabaseInfo.Steel.COLUMN_NAME)
    private String value;

    @Ignore
    public Steel(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Steel(){
    }

    protected Steel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        value = in.readString();
    }

    public static final Creator<Steel> CREATOR = new Creator<Steel>() {
        @Override
        public Steel createFromParcel(Parcel in) {
            return new Steel(in);
        }

        @Override
        public Steel[] newArray(int size) {
            return new Steel[size];
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static Creator<Steel> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeString(this.value);
    }
}

