package lorence.construction.view.fragment.listing.fragment;

import java.util.List;

import lorence.construction.data.storage.entity.Concrete;
import lorence.construction.data.storage.entity.ListingOperation;
import lorence.construction.data.storage.entity.Steel;

public interface ListingOperationView {
    void updateValueFieldConcrete(Concrete concrete);

    void updateValueFieldSteel(Steel steel);

    void showConcreteDialog();

    void showSteelDialog();

    boolean checkValidDataInput();

    void onGetListingOperationsSuccess(List<ListingOperation> listingOperations);
}
