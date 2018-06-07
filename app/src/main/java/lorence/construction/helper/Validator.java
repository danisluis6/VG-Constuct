package lorence.construction.helper;

import java.net.MalformedURLException;
import java.net.URL;

import javax.inject.Inject;

import lorence.construction.BuildConfig;
import lorence.construction.data.SessionManager;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class Validator {

    @Inject
    public Validator() {
    }

    public boolean checkValidD(String valueD) {
        if (valueD.charAt(0) != '.') {
            return Double.parseDouble(valueD) >= 0.8 && Double.parseDouble(valueD) <= 1.4;
        }
        return false;
    }

    public String getUrlData(SessionManager sessionManager) {
        String baseUrl = sessionManager.getBaseUrl().trim();
        if (isValidURL(baseUrl)) {
            if (baseUrl.lastIndexOf(Constants.SLASH) != (baseUrl.length() - 1)) {
                baseUrl = baseUrl + Constants.SLASH;
            }
        } else {
            baseUrl = BuildConfig.BASE_URL;
        }
        return baseUrl;
    }

    private static boolean isValidURL(String urlStr) {
        try {
            new URL(urlStr);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

}
