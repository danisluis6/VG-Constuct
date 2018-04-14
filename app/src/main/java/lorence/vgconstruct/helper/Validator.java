package lorence.vgconstruct.helper;

import android.text.TextUtils;

import javax.inject.Inject;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class Validator {

    @Inject
    public Validator() {
    }

    public boolean validUsername(String username) {
        return !TextUtils.isEmpty(username);
    }
}
