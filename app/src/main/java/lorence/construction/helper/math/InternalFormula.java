package lorence.construction.helper.math;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import lorence.construction.data.storage.entity.ListingOperation;
import lorence.construction.data.storage.entity.Operation;
import lorence.construction.helper.Constants;

public class InternalFormula {

    @Inject
    public InternalFormula() {
    }

    public Operation calculate(List<ListingOperation> arrListingOperations, String titleToolbar, double value) {
        Operation operation = null;
        if (TextUtils.equals(titleToolbar, Constants.LISTINGS.ONE)) {
            operation = getM1M2(arrListingOperations, Constants.LISTINGS.ONE, value);
        } else if (TextUtils.equals(titleToolbar, Constants.LISTINGS.TWO)) {
            operation = getM1M2(arrListingOperations, Constants.LISTINGS.TWO, value);
            operation.setK1(getK1K2(arrListingOperations, Constants.LISTINGS.TWO, value).getK1());
        } else if (TextUtils.equals(titleToolbar, Constants.LISTINGS.THREE)) {
            operation = getM1M2(arrListingOperations, Constants.LISTINGS.THREE, value);
            operation.setK2(getK1K2(arrListingOperations, Constants.LISTINGS.THREE, value).getK2());
        } else if (TextUtils.equals(titleToolbar, Constants.LISTINGS.FOUR)) {
            operation = getM1M2(arrListingOperations, Constants.LISTINGS.FOUR, value);
            operation.setK1(getK1K2(arrListingOperations, Constants.LISTINGS.FOUR, value).getK1());
        } else if (TextUtils.equals(titleToolbar, Constants.LISTINGS.FIVE)) {
            operation = getM1M2(arrListingOperations, Constants.LISTINGS.FIVE, value);
            operation.setK2(getK1K2(arrListingOperations, Constants.LISTINGS.FIVE, value).getK2());
        } else if (TextUtils.equals(titleToolbar, Constants.LISTINGS.SIX)) {
            operation = getM1M2(arrListingOperations, Constants.LISTINGS.SIX, value);
            operation.setK1(getK1K2(arrListingOperations, Constants.LISTINGS.SIX, value).getK1());
            operation.setK2(getK1K2(arrListingOperations, Constants.LISTINGS.SIX, value).getK2());
        } else if (TextUtils.equals(titleToolbar, Constants.LISTINGS.SEVEN)) {
            operation = getM1M2(arrListingOperations, Constants.LISTINGS.SEVEN, value);
            operation.setK1(getK1K2(arrListingOperations, Constants.LISTINGS.SEVEN, value).getK1());
            operation.setK2(getK1K2(arrListingOperations, Constants.LISTINGS.SEVEN, value).getK2());
        } else if (TextUtils.equals(titleToolbar, Constants.LISTINGS.EIGHT)) {
            operation = getM1M2(arrListingOperations, Constants.LISTINGS.EIGHT, value);
            operation.setK1(getK1K2(arrListingOperations, Constants.LISTINGS.EIGHT, value).getK1());
            operation.setK2(getK1K2(arrListingOperations, Constants.LISTINGS.EIGHT, value).getK2());
        } else if (TextUtils.equals(titleToolbar, Constants.LISTINGS.NINE)) {
            operation = getM1M2(arrListingOperations, Constants.LISTINGS.NINE, value);
            operation.setK1(getK1K2(arrListingOperations, Constants.LISTINGS.NINE, value).getK1());
            operation.setK2(getK1K2(arrListingOperations, Constants.LISTINGS.NINE, value).getK2());
        } else if (TextUtils.equals(titleToolbar, Constants.LISTINGS.TEN)) {
            operation = getM1M2Special(arrListingOperations, Constants.LISTINGS.TEN, value);
            operation.setK1(getK1K2Special(arrListingOperations, Constants.LISTINGS.TEN, value).getK1());
            operation.setK2(getK1K2Special(arrListingOperations, Constants.LISTINGS.TEN, value).getK2());
        } else if (TextUtils.equals(titleToolbar, Constants.LISTINGS.ELEVEN)) {
            operation = getM1M2Special(arrListingOperations, Constants.LISTINGS.ELEVEN, value);
            operation.setK1(getK1K2Special(arrListingOperations, Constants.LISTINGS.ELEVEN, value).getK1());
            operation.setK2(getK1K2Special(arrListingOperations, Constants.LISTINGS.ELEVEN, value).getK2());
        }
        return operation;
    }

    private Operation getM1M2(List<ListingOperation> arrListingOperations, String type, double value) {
        Double m1 = 0.0, m2 = 0.0, k1 = 0.0, k2 = 0.0;
        List<ListingOperation> temps;
        int index = 0;
        temps = getTypeOfListings(arrListingOperations, type);
        for (int i = 0; i < temps.size(); i++) {
            if (Math.round(value*100.0)/100.0 == Double.parseDouble(temps.get(i).getScope())) {
                m1 = Double.parseDouble(temps.get(i).getM1());
            }
            if (Math.round(value*100.0)/100.0 == Double.parseDouble(temps.get(i).getScope())) {
                m2 = Double.parseDouble(temps.get(i).getM2());
            }
        }
        if (m1 == 0.0 || m2 == 0.0) {
            for (int i = 0; i < temps.size(); i++) {
                if ((Math.round(value*100.0)/100.0) > Double.parseDouble(temps.get(i).getScope())) {
                    index = i;
                }
            }
            m1 = Double.parseDouble(temps.get(index).getM1()) - ((Double.parseDouble(temps.get(index).getM1()) - Double.parseDouble(temps.get(index+1).getM1()))/0.05)*(Math.round(value*100.0)/100.0 - Double.parseDouble(temps.get(index).getScope()));
            m2 = Double.parseDouble(temps.get(index).getM2()) - ((Double.parseDouble(temps.get(index).getM2()) - Double.parseDouble(temps.get(index+1).getM2()))/0.05)*(Math.round(value*100.0)/100.0 - Double.parseDouble(temps.get(index).getScope()));
        }
        return new Operation(String.valueOf(Math.round(m1*100000.0)/100000.0), String.valueOf(Math.round(m2*100000.0)/100000.0), String.valueOf(k1), String.valueOf(k2));
    }

    private Operation getM1M2Special(List<ListingOperation> arrListingOperations, String type, double value) {
        Double m1 = 0.0, m2 = 0.0, k1 = 0.0, k2 = 0.0;
        List<ListingOperation> temps;
        int index = 0;
        temps = getTypeOfListings(arrListingOperations, type);
        for (int i = 0; i < temps.size(); i++) {
            if (Math.round(value*100.0)/100.0 == Double.parseDouble(temps.get(i).getScope())) {
                m1 = Double.parseDouble(temps.get(i).getM1());
            }
            if (Math.round(value*100.0)/100.0 == Double.parseDouble(temps.get(i).getScope())) {
                m2 = Double.parseDouble(temps.get(i).getM2());
            }
        }
        if (m1 == 0.0 || m2 == 0.0) {
            for (int i = 0; i < temps.size(); i++) {
                if ((Math.round(value*100.0)/100.0) > Double.parseDouble(temps.get(i).getScope())) {
                    index = i;
                }
            }
            m1 = Double.parseDouble(temps.get(index).getM1()) - ((Double.parseDouble(temps.get(index).getM1()) - Double.parseDouble(temps.get(index+1).getM1()))/0.1)*(Math.round(value*100.0)/100.0 - Double.parseDouble(temps.get(index).getScope()));
            m2 = Double.parseDouble(temps.get(index).getM2()) - ((Double.parseDouble(temps.get(index).getM2()) - Double.parseDouble(temps.get(index+1).getM2()))/0.1)*(Math.round(value*100.0)/100.0 - Double.parseDouble(temps.get(index).getScope()));
        }
        return new Operation(String.valueOf(Math.round(m1*100000.0)/100000.0), String.valueOf(Math.round(m2*100000.0)/100000.0), String.valueOf(k1), String.valueOf(k2));
    }

    private Operation getK1K2(List<ListingOperation> arrListingOperations, String type, double value) {
        Double k1 = 0.0, k2 = 0.0;
        List<ListingOperation> temps;
        int index = 0;
        temps = getTypeOfListings(arrListingOperations, type);
        for (int i = 0; i < temps.size(); i++) {
            if (Math.round(value*100.0)/100.0 == Double.parseDouble(temps.get(i).getScope())) {
                k1 = Double.parseDouble(temps.get(i).getK1());
            }
            if (Math.round(value*100.0)/100.0 == Double.parseDouble(temps.get(i).getScope())) {
                k2 = Double.parseDouble(temps.get(i).getK2());
            }
        }
        if (k1 == 0.0 || k2 == 0.0) {
            for (int i = 0; i < temps.size(); i++) {
                if (Math.round(value*100.0)/100.0 > Double.parseDouble(temps.get(i).getScope())) {
                    index = i;
                }
            }
            k1 = Double.parseDouble(temps.get(index).getK1()) - ((Double.parseDouble(temps.get(index).getK1()) - Double.parseDouble(temps.get(index+1).getK1()))/0.05)*(Math.round(value*100.0)/100.0 - Double.parseDouble(temps.get(index).getScope()));
            k2 = Double.parseDouble(temps.get(index).getK2()) - ((Double.parseDouble(temps.get(index).getK2()) - Double.parseDouble(temps.get(index+1).getK2()))/0.05)*(Math.round(value*100.0)/100.0 - Double.parseDouble(temps.get(index).getScope()));
        }
        return new Operation("0.0", "0.0", String.valueOf(Math.round(k1*100000.0)/100000.0), String.valueOf(Math.round(k2*100000.0)/100000.0));
    }

    private Operation getK1K2Special(List<ListingOperation> arrListingOperations, String type, double value) {
        Double k1 = 0.0, k2 = 0.0;
        List<ListingOperation> temps;
        int index = 0;
        temps = getTypeOfListings(arrListingOperations, type);
        for (int i = 0; i < temps.size(); i++) {
            if (Math.round(value*100.0)/100.0 == Double.parseDouble(temps.get(i).getScope())) {
                k1 = Double.parseDouble(temps.get(i).getK1());
            }
            if (Math.round(value*100.0)/100.0 == Double.parseDouble(temps.get(i).getScope())) {
                k2 = Double.parseDouble(temps.get(i).getK2());
            }
        }
        if (k1 == 0.0 || k2 == 0.0) {
            for (int i = 0; i < temps.size(); i++) {
                if (Math.round(value*100.0)/100.0 > Double.parseDouble(temps.get(i).getScope())) {
                    index = i;
                }
            }
            k1 = Double.parseDouble(temps.get(index).getK1()) - ((Double.parseDouble(temps.get(index).getK1()) - Double.parseDouble(temps.get(index+1).getK1()))/0.1)*(Math.round(value*100.0)/100.0 - Double.parseDouble(temps.get(index).getScope()));
            k2 = Double.parseDouble(temps.get(index).getK2()) - ((Double.parseDouble(temps.get(index).getK2()) - Double.parseDouble(temps.get(index+1).getK2()))/0.1)*(Math.round(value*100.0)/100.0 - Double.parseDouble(temps.get(index).getScope()));
        }
        return new Operation("0.0", "0.0", String.valueOf(Math.round(k1*100000.0)/100000.0), String.valueOf(Math.round(k2*100000.0)/100000.0));
    }

    private List<ListingOperation> getTypeOfListings(List<ListingOperation> arrListingOperations, String type) {
        List<ListingOperation> temps = new ArrayList<>();
        if (TextUtils.equals(type, Constants.LISTINGS.ONE)) {
            for (int i = 0; i < arrListingOperations.size(); i++) {
                if (TextUtils.equals(arrListingOperations.get(i).getName(), Constants.LISTINGS.ONE)) {
                    temps.add(arrListingOperations.get(i));
                }
            }
        } else if (TextUtils.equals(type, Constants.LISTINGS.TWO)) {
            for (int i = 0; i < arrListingOperations.size(); i++) {
                if (TextUtils.equals(arrListingOperations.get(i).getName(), Constants.LISTINGS.TWO)) {
                    temps.add(arrListingOperations.get(i));
                }
            }
        } else if (TextUtils.equals(type, Constants.LISTINGS.THREE)) {
            for (int i = 0; i < arrListingOperations.size(); i++) {
                if (TextUtils.equals(arrListingOperations.get(i).getName(), Constants.LISTINGS.THREE)) {
                    temps.add(arrListingOperations.get(i));
                }
            }
        } else if (TextUtils.equals(type, Constants.LISTINGS.FOUR)) {
            for (int i = 0; i < arrListingOperations.size(); i++) {
                if (TextUtils.equals(arrListingOperations.get(i).getName(), Constants.LISTINGS.FOUR)) {
                    temps.add(arrListingOperations.get(i));
                }
            }
        } else if (TextUtils.equals(type, Constants.LISTINGS.FIVE)) {
            for (int i = 0; i < arrListingOperations.size(); i++) {
                if (TextUtils.equals(arrListingOperations.get(i).getName(), Constants.LISTINGS.FIVE)) {
                    temps.add(arrListingOperations.get(i));
                }
            }
        } else if (TextUtils.equals(type, Constants.LISTINGS.SIX)) {
            for (int i = 0; i < arrListingOperations.size(); i++) {
                if (TextUtils.equals(arrListingOperations.get(i).getName(), Constants.LISTINGS.SIX)) {
                    temps.add(arrListingOperations.get(i));
                }
            }
        } else if (TextUtils.equals(type, Constants.LISTINGS.SEVEN)) {
            for (int i = 0; i < arrListingOperations.size(); i++) {
                if (TextUtils.equals(arrListingOperations.get(i).getName(), Constants.LISTINGS.SEVEN)) {
                    temps.add(arrListingOperations.get(i));
                }
            }
        } else if (TextUtils.equals(type, Constants.LISTINGS.EIGHT)) {
            for (int i = 0; i < arrListingOperations.size(); i++) {
                if (TextUtils.equals(arrListingOperations.get(i).getName(), Constants.LISTINGS.EIGHT)) {
                    temps.add(arrListingOperations.get(i));
                }
            }
        } else if (TextUtils.equals(type, Constants.LISTINGS.NINE)) {
            for (int i = 0; i < arrListingOperations.size(); i++) {
                if (TextUtils.equals(arrListingOperations.get(i).getName(), Constants.LISTINGS.NINE)) {
                    temps.add(arrListingOperations.get(i));
                }
            }
        } else if (TextUtils.equals(type, Constants.LISTINGS.TEN)) {
            for (int i = 0; i < arrListingOperations.size(); i++) {
                if (TextUtils.equals(arrListingOperations.get(i).getName(), Constants.LISTINGS.TEN)) {
                    temps.add(arrListingOperations.get(i));
                }
            }
        } else if (TextUtils.equals(type, Constants.LISTINGS.ELEVEN)) {
            for (int i = 0; i < arrListingOperations.size(); i++) {
                if (TextUtils.equals(arrListingOperations.get(i).getName(), Constants.LISTINGS.ELEVEN)) {
                    temps.add(arrListingOperations.get(i));
                }
            }
        }
        return temps;
    }

    public String calculateFloorThickness(String L, String D) {
        Double minimum = Double.parseDouble(D)*Double.parseDouble(L)/40.0;
        Double maximum = Double.parseDouble(D)*Double.parseDouble(L)/45.0;
        return String.valueOf((Math.round(minimum*100000.0)/100000.0)+" -> "+(Math.round(maximum*100000.0)/100000.0));
    }

    /**
     *
     * @param brick
     * @param mortar
     * @param concreteFloor
     * @param plasterMortar
     * @return
     */
    public String performStaticLoad(Double brick, Double mortar, Double concreteFloor, Double plasterMortar) {
        Double value = brick*2.2 + mortar*2.4 + concreteFloor*2.8 + plasterMortar*2.4;
        return String.valueOf(Math.round(value*100000.0)/100000.0);
    }

    public String calculateq(double g, double p) {
        return String.valueOf(Math.round(g + p*1.2*100000.0)/100000.0);
    }

    public String calculateP(double g, double p, double l1, double l2) {
        Double q = g + p*1.2;
        return String.valueOf(Math.round(q*l1*l2*100000.0)/100000.0);
    }

    public String calculateM1(double m1, double P) {
        return String.valueOf(Math.round(m1*P*100000.0)/100000.0);
    }

    public String calculateM2(double m2, double P) {
        return String.valueOf(Math.round(m2*P*100000.0)/100000.0);
    }

    public String calculateK1(double k1, double P) {
        return String.valueOf(Math.round(k1*P*100000.0)/100000.0);
    }

    public String calculateK2(double k2, double P) {
        return String.valueOf(Math.round(k2*P*100000.0)/100000.0);
    }
}
