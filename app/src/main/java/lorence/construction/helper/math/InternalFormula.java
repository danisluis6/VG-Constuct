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

    public Operation calculateM1(List<ListingOperation> arrListingOperations, String titleToolbar, double value) {
        Operation operation = null;
        if (TextUtils.equals(titleToolbar, Constants.LISTINGS.ONE)) {
            operation = getM1M2(arrListingOperations, Constants.LISTINGS.ONE, value);
        } else if (TextUtils.equals(titleToolbar, Constants.LISTINGS.TWO)) {
            operation = getM1M2(arrListingOperations, Constants.LISTINGS.TWO, value);
            operation.setK1(getK1K2(arrListingOperations, Constants.LISTINGS.TWO, value).getK1());
        }
        return operation;
    }

    private Operation getM1M2(List<ListingOperation> arrListingOperations, String type, double value) {
        Double m1 = 0.0, m2 = 0.0;
        List<ListingOperation> temps = null;
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
                if (Math.round(value*100.0)/100.0 > Double.parseDouble(temps.get(i).getScope())) {
                    index = i;
                }
            }
            m1 = Double.parseDouble(temps.get(index).getM1()) - ((Double.parseDouble(temps.get(index).getM1()) - Double.parseDouble(temps.get(index+1).getM1()))/0.05)*(Math.round(value*100.0)/100.0 - Double.parseDouble(temps.get(index).getScope()));
            m2 = Double.parseDouble(temps.get(index).getM2()) - ((Double.parseDouble(temps.get(index).getM2()) - Double.parseDouble(temps.get(index+1).getM2()))/0.05)*(Math.round(value*100.0)/100.0 - Double.parseDouble(temps.get(index).getScope()));
        }
        return new Operation(String.valueOf(Math.round(m1*100000.0)/100000.0), String.valueOf(Math.round(m2*100000.0)/100000.0), "0.0", "0.0");
    }

    private Operation getK1K2(List<ListingOperation> arrListingOperations, String type, double value) {
        Double k1 = 0.0, k2 = 0.0;
        List<ListingOperation> temps = null;
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
}
