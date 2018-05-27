package lorence.construction.helper.math;

import javax.inject.Inject;

public class InternalFormula {

    @Inject
    public InternalFormula() {
    }

    public Double calculateM1(double value) {
        return performCalcalatingM1(value);
    }

    public Double calculateM2(double value) {
        return performCalcalatingM2(value);
    }

    private double performCalcalatingM1(Double _case) {
        Double m1 = 0.0;
        if (_case > 1.00 && _case < 1.05) {
            m1 = 0.0365 - ((0.0365 - 0.0384)/0.05)*(_case-1.00);
        } else if (_case > 1.05 && _case < 1.10) {
            m1 = 0.0384 - ((0.0384 - 0.0399)/0.05)*(_case-1.05);
        } else if (_case > 1.10 && _case < 1.15) {
            m1 = 0.0399 - ((0.0399 - 0.0414)/0.05)*(_case-1.10);
        } else if (_case > 1.15 && _case < 1.20) {
            m1 = 0.0414 - ((0.0414 - 0.0426)/0.05)*(_case-1.15);
        } else if (_case > 1.20 && _case < 1.25) {
            m1 = 0.0426 - ((0.0426 - 0.044)/0.05)*(_case-1.20);
        } else if (_case > 1.25 && _case < 1.30) {
            m1 = 0.044 - ((0.044 - 0.0452)/0.05)*(_case-1.25);
        } else if (_case > 1.30 && _case < 1.35) {
            m1 = 0.0452 - ((0.0452 - 0.0461)/0.05)*(_case-1.30);
        } else if (_case > 1.35 && _case < 1.40) {
            m1 = 0.0461 - ((0.0461 - 0.0469)/0.05)*(_case-1.35);
        } else if (_case > 1.40 && _case < 1.45) {
            m1 = 0.0469 - ((0.0469 - 0.0475)/0.05)*(_case-1.40);
        } else if (_case > 1.45 && _case < 1.50) {
            m1 = 0.0475 - ((0.0475 - 0.048)/0.05)*(_case-1.45);
        } else if (_case > 1.50 && _case < 1.55) {
            m1 = 0.048 - ((0.048 - 0.0484)/0.05)*(_case-1.5);
        } else if (_case > 1.55 && _case < 1.60) {
            m1 = 0.0484 - ((0.0484 - 0.0485)/0.05)*(_case-1.55);
        } else if (_case > 1.60 && _case < 1.65) {
            m1 = 0.0485 - ((0.0485 - 0.0486)/0.05)*(_case-1.60);
        } else if (_case > 1.65 && _case < 1.70) {
            m1 = 0.0486 - ((0.0486 - 0.0488)/0.05)*(_case-1.65);
        } else if (_case > 1.70 && _case < 1.75) {
            m1 = 0.0488 - ((0.0488 - 0.0486)/0.05)*(_case-1.7);
        } else if (_case > 1.75 && _case < 1.80) {
            m1 = 0.0486 - ((0.0486 - 0.0485)/0.05)*(_case-1.75);
        } else if (_case > 1.80 && _case < 1.85) {
            m1 = 0.0485 - ((0.0485 - 0.0484)/0.05)*(_case-1.8);
        } else if (_case > 1.85 && _case < 1.90) {
            m1 = 0.0484 - ((0.0484 - 0.0480)/0.05)*(_case-1.85);
        } else if (_case > 1.90 && _case < 1.95) {
            m1 = 0.0480 - ((0.0480 - 0.0476)/0.05)*(_case-1.9);
        } else if (_case > 1.95 && _case < 2.00) {
            m1 = 0.0476 - ((0.0476 - 0.0473)/0.05)*(_case-1.95);
        }
        if (_case == 1.00) {
            m1 = 0.0365;
        } else if (_case == 1.05) {
            m1 = 0.0384;
        } else if (_case == 1.10) {
            m1 = 0.0399;
        } else if (_case == 1.15) {
            m1 = 0.0414;
        } else if (_case == 1.20) {
            m1 = 0.0426;
        } else if (_case == 1.25) {
            m1 = 0.044;
        } else if (_case == 1.30) {
            m1 = 0.0452;
        } else if (_case == 1.35) {
            m1 = 0.0461;
        } else if (_case == 1.40) {
            m1 = 0.0469;
        } else if (_case == 1.45) {
            m1 = 0.0475;
        } else if (_case == 1.50) {
            m1 = 0.048;
        } else if (_case == 1.55) {
            m1 = 0.0484;
        } else if (_case == 1.60) {
            m1 = 0.0485;
        } else if (_case == 1.65) {
            m1 = 0.0486;
        } else if (_case == 1.70) {
            m1 = 0.0488;
        } else if (_case == 1.75) {
            m1 = 0.0486;
        } else if (_case == 1.80) {
            m1 = 0.0485;
        } else if (_case == 1.85) {
            m1 = 0.0484;
        } else if (_case == 1.90) {
            m1 = 0.048;
        } else if (_case == 1.95) {
            m1 = 0.0476;
        } else if (_case == 2.00) {
            m1 = 0.0473;
        }
        return Math.round(m1*100000.0)/100000.0;
    }

    private double performCalcalatingM2(Double _case) {
        Double m1 = 0.0;
        if (_case > 1.00 && _case < 1.05) {
            m1 = 0.0365 - ((0.0365 - 0.0341)/0.05)*(_case-1.00);
        } else if (_case > 1.05 && _case < 1.10) {
            m1 = 0.0341 - ((0.0341 - 0.0330)/0.05)*(_case-1.05);
        } else if (_case > 1.10 && _case < 1.15) {
            m1 = 0.0330 - ((0.0330 - 0.0314)/0.05)*(_case-1.10);
        } else if (_case > 1.15 && _case < 1.20) {
            m1 = 0.0314 - ((0.0314 - 0.0298)/0.05)*(_case-1.15);
        } else if (_case > 1.20 && _case < 1.25) {
            m1 = 0.0298 - ((0.0298 - 0.0282)/0.05)*(_case-1.20);
        } else if (_case > 1.25 && _case < 1.30) {
            m1 = 0.0282 - ((0.0282 - 0.0268)/0.05)*(_case-1.25);
        } else if (_case > 1.30 && _case < 1.35) {
            m1 = 0.0268 - ((0.0268 - 0.0253)/0.05)*(_case-1.30);
        } else if (_case > 1.35 && _case < 1.40) {
            m1 = 0.0253 - ((0.0253 - 0.0240)/0.05)*(_case-1.35);
        } else if (_case > 1.40 && _case < 1.45) {
            m1 = 0.0240 - ((0.0240 - 0.0225)/0.05)*(_case-1.40);
        } else if (_case > 1.45 && _case < 1.50) {
            m1 = 0.0225 - ((0.0225 - 0.0214)/0.05)*(_case-1.45);
        } else if (_case > 1.50 && _case < 1.55) {
            m1 = 0.0214 - ((0.0214 - 0.0201)/0.05)*(_case-1.5);
        } else if (_case > 1.55 && _case < 1.60) {
            m1 = 0.0201 - ((0.0201 - 0.0189)/0.05)*(_case-1.55);
        } else if (_case > 1.60 && _case < 1.65) {
            m1 = 0.0189 - ((0.0189 - 0.0179)/0.05)*(_case-1.60);
        } else if (_case > 1.65 && _case < 1.70) {
            m1 = 0.0179 - ((0.0179 - 0.0169)/0.05)*(_case-1.65);
        } else if (_case > 1.70 && _case < 1.75) {
            m1 = 0.0169 - ((0.0169 - 0.0158)/0.05)*(_case-1.7);
        } else if (_case > 1.75 && _case < 1.80) {
            m1 = 0.0158 - ((0.0158 - 0.0148)/0.05)*(_case-1.75);
        } else if (_case > 1.80 && _case < 1.85) {
            m1 = 0.0148 - ((0.0148 - 0.0140)/0.05)*(_case-1.8);
        } else if (_case > 1.85 && _case < 1.90) {
            m1 = 0.0140 - ((0.0140 - 0.0133)/0.05)*(_case-1.85);
        } else if (_case > 1.90 && _case < 1.95) {
            m1 = 0.0133 - ((0.0133 - 0.0125)/0.05)*(_case-1.9);
        } else if (_case > 1.95 && _case < 2.00) {
            m1 = 0.0125 - ((0.0125 - 0.0118)/0.05)*(_case-1.95);
        }
        if (_case == 1.00) {
            m1 = 0.0365;
        } else if (_case == 1.05) {
            m1 = 0.0341;
        } else if (_case == 1.10) {
            m1 = 0.033;
        } else if (_case == 1.15) {
            m1 = 0.0314;
        } else if (_case == 1.20) {
            m1 = 0.0298;
        } else if (_case == 1.25) {
            m1 = 0.0282;
        } else if (_case == 1.30) {
            m1 = 0.0268;
        } else if (_case == 1.35) {
            m1 = 0.0253;
        } else if (_case == 1.40) {
            m1 = 0.0240;
        } else if (_case == 1.45) {
            m1 = 0.0225;
        } else if (_case == 1.50) {
            m1 = 0.0214;
        } else if (_case == 1.55) {
            m1 = 0.0201;
        } else if (_case == 1.60) {
            m1 = 0.0189;
        } else if (_case == 1.65) {
            m1 = 0.0179;
        } else if (_case == 1.70) {
            m1 = 0.0169;
        } else if (_case == 1.75) {
            m1 = 0.0158;
        } else if (_case == 1.80) {
            m1 = 0.0148;
        } else if (_case == 1.85) {
            m1 = 0.0140;
        } else if (_case == 1.90) {
            m1 = 0.0133;
        } else if (_case == 1.95) {
            m1 = 0.0125;
        } else if (_case == 2.00) {
            m1 = 0.0118;
        }
        return Math.round(m1*100000.0)/100000.0;
    }
}
