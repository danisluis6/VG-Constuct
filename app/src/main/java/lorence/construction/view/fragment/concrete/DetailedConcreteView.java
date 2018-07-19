package lorence.construction.view.fragment.concrete;

import lorence.construction.data.storage.entity.Concrete;
import lorence.construction.data.storage.entity.Steel;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public interface DetailedConcreteView {
    boolean checkValidDataInput();

    void showConcreteDialog();

    void showSteelDialog();

    void updateValueFieldConcrete(Concrete concrete);

    void updateValueFieldSteel(Steel steel);
}
