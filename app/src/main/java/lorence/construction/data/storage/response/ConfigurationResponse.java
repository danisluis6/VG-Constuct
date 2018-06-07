package lorence.construction.data.storage.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lorence.construction.data.storage.entity.Configuration;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class ConfigurationResponse {

    @SerializedName("error")
    @Expose
    private Error error;
    @SerializedName("data")
    @Expose
    private Configuration data;

    public Error getError() {
        return error;
    }

    public Configuration getData() {
        return data;
    }

}
