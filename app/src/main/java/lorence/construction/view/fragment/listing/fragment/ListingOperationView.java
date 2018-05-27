package lorence.construction.view.fragment.listing.fragment;

import lorence.construction.data.storage.entity.Concrete;
import lorence.construction.data.storage.entity.Steel;

public interface ListingOperationView {
    void updateValueFieldConcrete(Concrete concrete);

    void updateValueFieldSteel(Steel steel);

    void showConcreteDialog();

    void showSteelDialog();

    boolean checkValidDataInput();
}
