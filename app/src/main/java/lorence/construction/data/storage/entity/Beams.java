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

@Entity(tableName = DatabaseInfo.Tables.Beams)
public class Beams implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DatabaseInfo.Beams.COLUMN_ID)
    @SerializedName(DatabaseInfo.Beams.COLUMN_ID)
    private int id;

    @ColumnInfo(name = DatabaseInfo.Beams.COLUMN_NAME)
    @SerializedName(DatabaseInfo.Beams.COLUMN_NAME)
    private String name;

    @ColumnInfo(name = DatabaseInfo.Beams.COLUMN_IMAGE)
    @SerializedName(DatabaseInfo.Beams.COLUMN_IMAGE)
    private int image;

    @ColumnInfo(name = DatabaseInfo.Beams.COLUMN_TYPE)
    @SerializedName(DatabaseInfo.Beams.COLUMN_TYPE)
    private String type;

    @ColumnInfo(name = DatabaseInfo.Beams.COLUMN_M1)
    @SerializedName(DatabaseInfo.Beams.COLUMN_M1)
    private String m1;

    @ColumnInfo(name = DatabaseInfo.Beams.COLUMN_M2)
    @SerializedName(DatabaseInfo.Beams.COLUMN_M2)
    private String m2;

    @Ignore
    public Beams(String name, int image, String type, String m1, String m2) {
        this.name = name;
        this.image = image;
        this.type = type;
        this.m1 = m1;
        this.m2 = m2;
    }

    public Beams(){
    }

    protected Beams(Parcel in) {
        id = in.readInt();
        name = in.readString();
        image = in.readInt();
    }

    public static final Creator<Beams> CREATOR = new Creator<Beams>() {
        @Override
        public Beams createFromParcel(Parcel in) {
            return new Beams(in);
        }

        @Override
        public Beams[] newArray(int size) {
            return new Beams[size];
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public int describeContents() {
        return 0;
    }

    public static Creator<Beams> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeValue(this.image);
    }
}
