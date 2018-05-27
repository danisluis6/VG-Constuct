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

@Entity(tableName = DatabaseInfo.Tables.ListingOperation)
public class ListingOperation implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DatabaseInfo.ListingOperation.COLUMN_ID)
    @SerializedName(DatabaseInfo.ListingOperation.COLUMN_ID)
    private int id;

    @ColumnInfo(name = DatabaseInfo.ListingOperation.COLUMN_NAME)
    @SerializedName(DatabaseInfo.ListingOperation.COLUMN_NAME)
    private String name;

    @ColumnInfo(name = DatabaseInfo.ListingOperation.COLUMN_M1)
    @SerializedName(DatabaseInfo.ListingOperation.COLUMN_M1)
    private String m1;

    @ColumnInfo(name = DatabaseInfo.ListingOperation.COLUMN_M2)
    @SerializedName(DatabaseInfo.ListingOperation.COLUMN_M2)
    private String m2;

    @ColumnInfo(name = DatabaseInfo.ListingOperation.COLUMN_K1)
    @SerializedName(DatabaseInfo.ListingOperation.COLUMN_K1)
    private String k1;

    @ColumnInfo(name = DatabaseInfo.ListingOperation.COLUMN_K2)
    @SerializedName(DatabaseInfo.ListingOperation.COLUMN_K2)
    private String k2;

    @Ignore
    public ListingOperation(String name, String m1, String m2, String k1, String k2) {
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.k1 = k1;
        this.k2 = k2;
    }

    public ListingOperation(){
    }

    protected ListingOperation(Parcel in) {
        id = in.readInt();
        name = in.readString();
        m1 = in.readString();
        m2 = in.readString();
        k1 = in.readString();
        k2 = in.readString();
    }

    public static final Creator<ListingOperation> CREATOR = new Creator<ListingOperation>() {
        @Override
        public ListingOperation createFromParcel(Parcel in) {
            return new ListingOperation(in);
        }

        @Override
        public ListingOperation[] newArray(int size) {
            return new ListingOperation[size];
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

    public String getM1() {
        return m1;
    }

    public void setM1(String m1) {
        this.m1 = m1;
    }

    public String getM2() {
        return m2;
    }

    public void setM2(String m2) {
        this.m2 = m2;
    }

    public String getK1() {
        return k1;
    }

    public void setK1(String k1) {
        this.k1 = k1;
    }

    public String getK2() {
        return k2;
    }

    public void setK2(String k2) {
        this.k2 = k2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static Creator<ListingOperation> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeString(this.m1);
        dest.writeString(this.m2);
        dest.writeString(this.k1);
        dest.writeString(this.k2);
    }
}

