package lorence.construction.helper;

import javax.inject.Inject;

public class ConditionCalculating {

    @Inject
    public ConditionCalculating() {
    }

    public boolean islistingOrBeams(double L1, double L2) {
        return Math.round((L2/L1) * 100.0) / 100.0 < 2.0;
    }
}
