package lorence.vgconstruct.custom;


import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class SpannableGridLayoutManager extends RecyclerView.LayoutManager {

    private static final String TAG = SpannableGridLayoutManager.class.getSimpleName();

    private static final int DEFAULT_COUNT = 1;

    /* View Removal Constants */
    private static final int REMOVE_INVISIBLE = 1;

    /* First (top-left) position visible at any point */
    private int mFirstVisiblePosition;

    /* Standard Size For Views, Can be used to calculate multiple spans */
    private int mDecoratedChildStandardWidth;
    private int mDecoratedChildStandardHeight;

    /* Number of columns that exist in the grid */
    private int mSpanCount = DEFAULT_COUNT;

    /* Metrics for the visible window of our data */
    private int mVisibleColumnCount;
    private int mVisibleRowCount;

    /* Span Lookup used to determine how many */
    private GridLayoutManager.SpanSizeLookup mSpanSizeLookup;

    /**
     * Constructor of Layout Manager, this constructors creates the LayoutManager and applies the
     * span count of the recyclerview written in the xml layout file.
     */
    public SpannableGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr,
                                      int defStyleRes) {
        super();
        Properties properties = getProperties(context, attrs, defStyleAttr, defStyleRes);
        setTotalColumnCount(properties.spanCount);
        mDecoratedChildStandardHeight = 0;
        mDecoratedChildStandardWidth = 0;
    }


    /**
     * Set the number of columns the layout manager will use.
     *
     * @param count Number of columns. also known as span count.
     */
    private void setTotalColumnCount(int count) {
        mSpanCount = count;
    }

    /*
     * We dont need complicated animations for this layout. Return false
     */
    @Override
    public boolean supportsPredictiveItemAnimations() {
        return false;
    }

//    /*
//     * Called by RecyclerView when a view removal is triggered. This is called
//     * before onLayoutChildren() in pre-layout if the views removed are not visible. We
//     * use it in this case to inform pre-layout that a removal took place.
//     *
//     * This method is still called if the views removed were visible, but it will
//     * happen AFTER pre-layout.
//     */
//    @Override
//    public void onItemsRemoved(RecyclerView recyclerView, int positionStart, int itemCount) {
//        mFirstChangedPosition = positionStart;
//        mChangedPositionCount = itemCount;
//    }

    /*
     * This method is your initial call from the framework. You will receive it when you
     * need to start laying out the initial set of views. This method will not be called
     * repeatedly, so don't rely on it to continually process changes during user
     * interaction.
     *
     * This method will be called when the data set in the adapter changes, so it can be
     * used to update a layout based on a new item count.
     *
     *
     */
    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        //We have nothing to show for an empty data set but clear any existing views
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(recycler);
            return;
        }

        int childLeft = 0;
        int childTop = 32;

        if (getChildCount() == 0) { //First or empty layout

            // Need to measure and scrap all views so that they can be
            // displayed in the after this first layout.

            int count = getItemCount();
            for (int i = 0; i < count; i++) {
                View scrappedView = recycler.getViewForPosition(i);
                int scrappedViewSize = getSpanSize(recycler, state, i);

                addView(scrappedView);
                measureChildWithMargins(scrappedView, 0, 0);

                if (scrappedViewSize == 1) { // if these view has a standard size, record its values
                    mDecoratedChildStandardHeight = getDecoratedMeasuredHeight(scrappedView);
                    mDecoratedChildStandardWidth = getDecoratedMeasuredWidth(scrappedView);
                }
                detachAndScrapView(scrappedView, recycler);
            }

            /*
             * The building blocks of this grid are uniformThis allows
             * us to compute the following values up front because they
             * won't change.
             */
            updateWindowSizing();
        }


        //Reset the visible and scroll positions
        mFirstVisiblePosition = 0;

        //Clear all attached views into the recycle bin
        detachAndScrapAttachedViews(recycler);

        //Fill the grid for the initial layout of views
        fillGrid(childLeft, childTop, recycler, state);
    }

    /**
     * Method is called whenever setAdapter is called on the recyclerview. We need to remove all views
     * from the layout.
     *
     * @param oldAdapter old adapter
     * @param newAdapter new adapter
     */
    @Override
    public void onAdapterChanged(RecyclerView.Adapter oldAdapter, RecyclerView.Adapter newAdapter) {
        //Completely scrap the existing layout
        removeAllViews();
    }

    /*
     * Rather than continuously checking how many views we can fit
     * based on scroll offsets, we simplify the math by computing the
     * visible grid as what will initially fit on screen, plus one.
     */
    private void updateWindowSizing() {
        mVisibleColumnCount = getTotalColumnCount();
        mVisibleRowCount = getTotalRowCount();
    }

    private void fillGrid(RecyclerView.Recycler recycler, RecyclerView.State state) {
        fillGrid(0, 0, recycler, state);
    }

    private void fillGrid(int emptyLeft, int emptyTop,
                          RecyclerView.Recycler recycler,
                          RecyclerView.State state) {
        SparseIntArray removedPositions = new SparseIntArray();
        if (mFirstVisiblePosition < 0) mFirstVisiblePosition = 0;
        if (mFirstVisiblePosition >= getItemCount()) mFirstVisiblePosition = (getItemCount() - 1);

        /*
         * First, we will detach all existing views from the layout.
         * detachView() is a lightweight operation that we can use to
         * quickly reorder views without a full add/remove.
         */
        SparseArray<View> viewCache = new SparseArray<>(getChildCount());
        int startLeftOffset = emptyLeft;
        int startTopOffset = emptyTop;
        View spanView = null;
        if (getChildCount() != 0) {
            final View topView = getChildAt(0);
            startLeftOffset = getDecoratedLeft(topView);
            startTopOffset = getDecoratedTop(topView);

            //Cache all views by their existing position, before updating counts
            for (int i = 0; i < getChildCount(); i++) {
                int position = positionOfIndex(i);
                final View child = getChildAt(i);
                viewCache.put(position, child);
            }

            //Temporarily detach all views.
            // Views we still need will be added back at the proper index.
            for (int i = 0; i < viewCache.size(); i++) {
                detachView(viewCache.valueAt(i));
            }
        }

        /*
         * Next, we supply the grid of items that are deemed visible.
         * If these items were previously there, they will simply be
         * re-attached. New views that must be created are obtained
         * from the Recycler and added.
         */
        int leftOffset = startLeftOffset;
        int topOffset = startTopOffset;

        int cardMargin = 0;
        int spanTotal = getTotalColumnCount();
        for (int i = 0; i < getVisibleChildCount(); i++) {


            int nextPosition = positionOfIndex(i);
            int viewSpanSize = 1;
            /*
             * When a removal happens out of bounds, the pre-layout positions of items
             * after the removal are shifted to their final positions ahead of schedule.
             * We have to track off-screen removals and shift those positions back
             * so we can properly lay out all current (and appearing) views in their
             * initial locations.
             */
            if (state.isPreLayout()) {
                int offsetPosition = nextPosition;

                for (int offset = 0; offset < removedPositions.size(); offset++) {
                    //Look for off-screen removals that are less-than this
                    if (removedPositions.valueAt(offset) == REMOVE_INVISIBLE
                            && removedPositions.keyAt(offset) < nextPosition) {
                        //Offset position to match
                        offsetPosition--;
                    }
                }
                nextPosition = offsetPosition;
            }

            if (nextPosition < 0 || nextPosition >= state.getItemCount()) {
                //Item space beyond the data set, don't attempt to add a view
                continue;
            }


            // Layout this position
            View view = viewCache.get(nextPosition);
            if (view == null) {

                viewSpanSize = getSpanSize(recycler, state, nextPosition);

                int right = leftOffset + mDecoratedChildStandardWidth * viewSpanSize;
                int bottom = topOffset + mDecoratedChildStandardHeight * viewSpanSize;

                /*
                 * The Recycler will give us either a newly constructed view,
                 * or a recycled view it has on-hand. In either case, the
                 * view will already be fully bound to the data by the
                 * adapter for us.
                 */
                view = recycler.getViewForPosition(nextPosition);
                LayoutParams lp = (LayoutParams) view.getLayoutParams();
                cardMargin = lp.bottomMargin * 2;
                if (viewSpanSize > 1) {
                    spanView = view;
                    bottom += cardMargin * 2;
                    right += cardMargin * 2; // these two offsets are for that middle margin should change.
                } else {
                    right += cardMargin;
                    bottom += cardMargin;
                }


                /*
                 * Update the new view's metadata, but only when this is a real
                 * layout pass.
                 */

                if (!state.isPreLayout()) {
                    lp.height = mDecoratedChildStandardHeight * viewSpanSize;
                    lp.width = mDecoratedChildStandardWidth * viewSpanSize;
                    if (viewSpanSize > 1) {
                        lp.width += (cardMargin) * (viewSpanSize - 1);
                        lp.height += (cardMargin) * (viewSpanSize - 1);
                    }
                    lp.row = getGlobalRowOfPosition(nextPosition);
                    lp.column = getGlobalColumnOfPosition(nextPosition);
                }

                addView(view);

                /*
                 * It is prudent to measure/layout each new view we
                 * receive from the Recycler. We don't have to do
                 * this for views we are just re-arranging.
                 */
                measureChildWithMargins(view, 0, 0);

                // layout the item with these left, top, right, bottom dimensions
                if (viewSpanSize <= spanTotal) {
                    layoutDecoratedWithMargins(view, leftOffset, topOffset, right, bottom);
                }
                spanTotal -= viewSpanSize;


            } else {
                //Re-attach the cached view at its new index
                attachView(view);
                viewCache.remove(nextPosition);
            }

            if (spanTotal == 0) {
                topOffset += (mDecoratedChildStandardHeight + cardMargin) * viewSpanSize;
                if (spanView != null && getTotalColumnCount() > 2) {
                    leftOffset = startLeftOffset + (spanView.getLayoutParams().width) + cardMargin;
                    spanTotal = getTotalColumnCount() - getSpanSize(recycler, state, getPosition(spanView));
                    spanView = null;
                } else {
                    leftOffset = startLeftOffset;
                    spanTotal = getTotalColumnCount();
                }
            } else { // place card next in line
                // left offset by card width?
                leftOffset += view.getLayoutParams().width + cardMargin;
            }
        }

        /*
         * Finally, we ask the Recycler to scrap and store any views
         * that we did not re-attach. These are views that are not currently
         * necessary because they are no longer visible.
         */
        for (int i = 0; i < viewCache.size(); i++) {
            final View removingView = viewCache.valueAt(i);
            recycler.recycleView(removingView);
        }
    }


    /*
     * You must override this method if you would like to support external calls
     * to shift the view to a given adapter position. In our implementation, this
     * is the same as doing a fresh layout with the given position as the top-left
     * (or first visible), so we simply set that value and trigger onLayoutChildren()
     */
    @Override
    public void scrollToPosition(int position) {
        if (position >= getItemCount()) {
            Log.e(TAG, "Cannot scroll to " + position + ", item count is " + getItemCount());
            return;
        }

        //Set requested position as first visible
        mFirstVisiblePosition = position;
        //Toss all existing views away
        removeAllViews();
        //Trigger a new view layout
        requestLayout();
    }

    /*
     * You must override this method if you would like to support external calls
     * to animate a change to a new adapter position. The framework provides a
     * helper scroller implementation (LinearSmoothScroller), which we leverage
     * to do the animation calculations.
     */
    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, final int position) {
        if (position >= getItemCount()) {
            Log.e(TAG, "Cannot scroll to " + position + ", item count is " + getItemCount());
            return;
        }

        /*
         * LinearSmoothScroller's default behavior is to scroll the contents until
         * the child is fully visible. It will snap to the top-left or bottom-right
         * of the parent depending on whether the direction of travel was positive
         * or negative.
         */
        LinearSmoothScroller scroller = new LinearSmoothScroller(recyclerView.getContext()) {
            /*
             * LinearSmoothScroller, at a minimum, just need to know the vector
             * (x/y distance) to travel in order to get from the current positioning
             * to the target.
             */
            @Override
            public PointF computeScrollVectorForPosition(int targetPosition) {
                final int rowOffset = getGlobalRowOfPosition(targetPosition)
                        - getGlobalRowOfPosition(mFirstVisiblePosition);
                final int columnOffset = getGlobalColumnOfPosition(targetPosition)
                        - getGlobalColumnOfPosition(mFirstVisiblePosition);

                return new PointF(columnOffset * mDecoratedChildStandardWidth, rowOffset * mDecoratedChildStandardHeight);
            }
        };
        scroller.setTargetPosition(position);
        startSmoothScroll(scroller);
    }

    /*
     * Use this method to tell the RecyclerView if scrolling is even possible
     * in the horizontal direction.
     */
    @Override
    public boolean canScrollHorizontally() {
        //We don't want horizontal scrolling
        return false;
    }

    /*
     * Use this method to tell the RecyclerView if scrolling is even possible
     * in the vertical direction.
     */
    @Override
    public boolean canScrollVertically() {
        //We do allow scrolling
        return true;
    }

    /*
     * This method describes how far RecyclerView thinks the contents should scroll vertically.
     * You are responsible for verifying edge boundaries, and determining if this scroll
     * event somehow requires that new views be added or old views get recycled.
     */
    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }

        //Take top measurements from the top-left child
        final View topView = getChildAt(0);
        //Take bottom measurements from the bottom-right child.
        final View bottomView = getChildAt(getChildCount() - 1);

        //Optimize the case where the entire data set is too small to scroll
        int viewSpan = getDecoratedBottom(bottomView) - getDecoratedTop(topView);
        if (viewSpan < getVerticalSpace()) {
            //We cannot scroll in either direction
            return 0;
        }

        int delta;
        int maxRowCount = getTotalRowCount();
        boolean topBoundReached = getFirstVisibleRow() == 0;
        boolean bottomBoundReached = getLastVisibleRow() >= maxRowCount;
        if (dy > 0) { // Contents are scrolling up
            //Check against bottom bound
            if (bottomBoundReached) {
                //If we've reached the last row, enforce limits
                int bottomOffset;
                if (rowOfIndex(getChildCount() - 1) >= (maxRowCount - 1)) {
                    //We are truly at the bottom, determine how far
                    bottomOffset = getVerticalSpace() - getDecoratedBottom(bottomView)
                            + getPaddingBottom();
                } else {
                    /*
                     * Extra space added to account for allowing bottom space in the grid.
                     * This occurs when the overlap in the last row is not large enough to
                     * ensure that at least one element in that row isn't fully recycled.
                     */
                    bottomOffset = getVerticalSpace() - (getDecoratedBottom(bottomView)
                            + mDecoratedChildStandardHeight) + getPaddingBottom();
                }

                delta = Math.max(-dy, bottomOffset);
            } else {
                //No limits while the last row isn't visible
                delta = -dy;
            }
        } else { // Contents are scrolling down
            //Check against top bound
            if (topBoundReached) {
                RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) topView.getLayoutParams();
                int topOffset = -getDecoratedTop(topView) + getPaddingTop() + lp.topMargin * 2;

                delta = Math.min(-dy, topOffset);
            } else {
                delta = -dy;
            }
        }

        offsetChildrenVertical(delta);

        if (dy > 0) {
            if (getDecoratedBottom(topView) < 0 && !bottomBoundReached) {
                fillGrid(recycler, state);
            } else if (!bottomBoundReached) {
                fillGrid(recycler, state);
            }
        } else {
            if (getDecoratedTop(topView) > 0 && !topBoundReached) {
                fillGrid(recycler, state);
            } else if (!topBoundReached) {
                fillGrid(recycler, state);
            }
        }

        /*
         * Return value determines if a boundary has been reached
         * (for edge effects and flings). If returned value does not
         * match original delta (passed in), RecyclerView will draw
         * an edge effect.
         */
        return -delta;
    }

    /*
     * This is a helper method used by RecyclerView to determine
     * if a specific child view can be returned.
     */
    @Override
    public View findViewByPosition(int position) {
        for (int i = 0; i < getChildCount(); i++) {
            if (positionOfIndex(i) == position) {
                return getChildAt(i);
            }
        }

        return null;
    }


    /**
     * Boilerplate to extend LayoutParams for tracking row/column of attached views
     */

    /*
     * Even without extending LayoutParams, we must override this method
     * to provide the default layout parameters that each child view
     * will receive when added.
     */
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public RecyclerView.LayoutParams generateLayoutParams(Context c, AttributeSet attrs) {
        return new LayoutParams(c, attrs);
    }

    @Override
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) lp);
        } else {
            return new LayoutParams(lp);
        }
    }

    @Override
    public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
        return lp instanceof LayoutParams;
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        //Current row in the grid
        int row;
        //Current column in the grid
        int column;

        LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        LayoutParams(int width, int height) {
            super(width, height);
        }

        LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
        }

        LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }
    }

    /* Return the overall column index of this position in the global layout */
    private int getGlobalColumnOfPosition(int position) {
        return position % mSpanCount;
    }

    /* Return the overall row index of this position in the global layout */
    private int getGlobalRowOfPosition(int position) {
        return position / mSpanCount;
    }

    /*
     * Mapping between child view indices and adapter data
     * positions helps fill the proper views during scrolling.
     */
    private int positionOfIndex(int childIndex) {
        int row = childIndex / mVisibleColumnCount;
        int column = childIndex % mVisibleColumnCount;

        return mFirstVisiblePosition + (row * getTotalColumnCount()) + column;
    }

    private int rowOfIndex(int childIndex) {
        int position = positionOfIndex(childIndex);

        return position / getTotalColumnCount();
    }

    private int getFirstVisibleRow() {
        return (mFirstVisiblePosition / getTotalColumnCount());
    }

    private int getLastVisibleRow() {
        return getFirstVisibleRow() + mVisibleRowCount;
    }

    private int getVisibleChildCount() {
        return mVisibleColumnCount * mVisibleRowCount;
    }

    private int getTotalColumnCount() {
        if (getItemCount() < mSpanCount) {
            return getItemCount();
        }

        return mSpanCount;
    }

    private int getTotalRowCount() {
        if (getItemCount() == 0 || mSpanCount == 0) {
            return 0;
        }
        int maxRow = getItemCount() / mSpanCount;
        //Bump the row count if it's not exactly even
        if (getItemCount() % mSpanCount != 0) {
            maxRow++;
        }

        return maxRow;
    }

    private int getVerticalSpace() {
        return getHeight() - getPaddingBottom() - getPaddingTop();
    }


    public void setSpanSizeLookup(GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        mSpanSizeLookup = spanSizeLookup;
    }


    private int getSpanSize(RecyclerView.Recycler recycler, RecyclerView.State state, int pos) {
        final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();

        if (!state.isPreLayout()) {
            return mSpanSizeLookup.getSpanSize(pos);
        }
        final int cached = mPreLayoutSpanSizeCache.get(pos, -1);
        if (cached != -1) {
            return cached;
        }
        final int adapterPosition = recycler.convertPreLayoutPositionToPostLayout(pos);
        if (adapterPosition == -1) {
            Log.w(TAG, "Cannot find span size for pre layout position. It is"
                    + " not cached, not in the adapter. Pos:" + pos);
            return 1;
        }
        return 0;
    }
}