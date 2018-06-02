package lorence.construction.helper;

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

    public boolean checkValidD(String valueD) {
        if (valueD.charAt(0) != '.') {
            return Double.parseDouble(valueD) >= 0.8 && Double.parseDouble(valueD) <= 1.4;
        }
        return false;
    }
}
