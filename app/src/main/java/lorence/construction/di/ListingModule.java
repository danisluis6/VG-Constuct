package lorence.construction.di;

import dagger.Module;
import lorence.construction.view.fragment.listing.ListingFragment;

/**
 * Created by lorence on 28/12/2017.
 *
 * @version master
 * @since 12/28/2017
 */

@Module
public class ListingModule {

    private ListingFragment mFragment;

    public ListingModule(ListingFragment fragment) {
        this.mFragment = fragment;
    }
}
