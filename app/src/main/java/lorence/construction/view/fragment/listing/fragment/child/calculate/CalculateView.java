package lorence.construction.view.fragment.listing.fragment.child.calculate;

import java.util.List;

import lorence.construction.data.storage.entity.Concrete;
import lorence.construction.data.storage.entity.ListingOperation;
import lorence.construction.data.storage.entity.Steel;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public interface CalculateView {
    void updateValueFieldConcrete(Concrete concrete);

    void updateValueFieldSteel(Steel steel);

    void showConcreteDialog();

    void showSteelDialog();

    boolean checkValidDataInput();

    void onGetListingOperationsSuccess(List<ListingOperation> listingOperations);
}
