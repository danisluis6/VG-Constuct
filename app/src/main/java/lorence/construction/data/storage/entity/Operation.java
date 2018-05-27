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

@Entity(tableName = DatabaseInfo.Tables.Operation)
public class Operation implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DatabaseInfo.Operation.COLUMN_ID)
    @SerializedName(DatabaseInfo.Operation.COLUMN_ID)
    private int id;

    @ColumnInfo(name = DatabaseInfo.Operation.COLUMN_M1)
    @SerializedName(DatabaseInfo.Operation.COLUMN_M1)
    private String m1;

    @ColumnInfo(name = DatabaseInfo.Operation.COLUMN_M2)
    @SerializedName(DatabaseInfo.Operation.COLUMN_M2)
    private String m2;

    @ColumnInfo(name = DatabaseInfo.Operation.COLUMN_K1)
    @SerializedName(DatabaseInfo.Operation.COLUMN_K1)
    private String k1;

    @ColumnInfo(name = DatabaseInfo.Operation.COLUMN_K2)
    @SerializedName(DatabaseInfo.Operation.COLUMN_K2)
    private String k2;

    @Ignore
    public Operation(String m1, String m2, String k1, String k2) {
        this.m1 = m1;
        this.m2 = m2;
        this.k1 = k1;
        this.k2 = k2;
    }

    public Operation(){
    }

    protected Operation(Parcel in) {
        id = in.readInt();
        m1 = in.readString();
        m2 = in.readString();
        k1 = in.readString();
        k2 = in.readString();
    }

    public static final Creator<Operation> CREATOR = new Creator<Operation>() {
        @Override
        public Operation createFromParcel(Parcel in) {
            return new Operation(in);
        }

        @Override
        public Operation[] newArray(int size) {
            return new Operation[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static Creator<Operation> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.m1);
        dest.writeString(this.m2);
        dest.writeString(this.k1);
        dest.writeString(this.k2);
    }
}

