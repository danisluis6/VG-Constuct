package lorence.construction.view.fragment.listings;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import lorence.construction.R;
import lorence.construction.model.Listing;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.fragment.listings.Adapter.ListingAdapter;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@SuppressLint("ValidFragment")
public class ListingFragment extends EBaseFragment {

    @BindView(R.id.listing_card_list)
    RecyclerView mRecyclerView;

    private ListingAdapter mAdapter;
    private List<Listing> mGroupListings;

    private Activity mActivity;

    @SuppressLint("ValidFragment")
    public ListingFragment(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listing, container, false);
        bindView(view);

        mGroupListings = new ArrayList<>();
        mAdapter = new ListingAdapter(mActivity, mGroupListings);


        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mActivity, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        prepareListings();
    }

    private void prepareListings() {
        int[] covers = new int[]{
                R.drawable.ic_bang_ke_1,
                R.drawable.ic_bang_ke_2,
                R.drawable.ic_bang_ke_3,
                R.drawable.ic_bang_ke_4,
                R.drawable.ic_bang_ke_5,
                R.drawable.ic_bang_ke_6,
                R.drawable.ic_bang_ke_7,
                R.drawable.ic_bang_ke_8,
                R.drawable.ic_bang_ke_9,
                R.drawable.ic_bang_ke_10,
                R.drawable.ic_bang_ke_11
        };

        mGroupListings.add(new Listing(0,"Bảng Kê 1", covers[0]));
        mGroupListings.add(new Listing(1,"Bảng Kê 2", covers[1]));
        mGroupListings.add(new Listing(2,"Bảng Kê 3", covers[2]));
        mGroupListings.add(new Listing(3,"Bảng Kê 4", covers[3]));
        mGroupListings.add(new Listing(4,"Bảng Kê 5", covers[4]));
        mGroupListings.add(new Listing(5,"Bảng Kê 6", covers[5]));
        mGroupListings.add(new Listing(6,"Bảng Kê 7", covers[6]));
        mGroupListings.add(new Listing(7,"Bảng Kê 8", covers[7]));
        mGroupListings.add(new Listing(8,"Bảng Kê 9", covers[8]));
        mGroupListings.add(new Listing(9,"Bảng Kê 10", covers[9]));
        mGroupListings.add(new Listing(10,"Bảng Kê 11", covers[10]));

        mAdapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount;

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount;
                outRect.right = (column + 1) * spacing / spanCount;

                if (position < spanCount) {
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            } else {
                outRect.left = column * spacing / spanCount;
                outRect.right = spacing - (column + 1) * spacing / spanCount;
                if (position >= spanCount) {
                    outRect.top = spacing;
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
