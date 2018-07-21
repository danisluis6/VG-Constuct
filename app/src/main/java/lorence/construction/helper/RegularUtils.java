package lorence.construction.helper;

import javax.inject.Inject;

public class RegularUtils {

    @Inject
    public RegularUtils() {
    }

    public boolean isRealNumber(String number) {
        String regex = "[+-]?([0-9]*[.])?[0-9]+";
        return number.trim().matches(regex);
    }
}
