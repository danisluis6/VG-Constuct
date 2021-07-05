package lorence.construction.helper;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.Stack;

import lorence.construction.R;
import lorence.construction.view.activity.home.HomeActivity;

public class FragmentUtils {
    private Context mContext;
    private Stack<FragmentStack> mCurrentFrgStack;
    private int mContainerId;
    private Fragment mFragment;

    public FragmentUtils(Context context, Fragment fragment, Stack<FragmentStack> currentFrgStack, @IdRes int containerId) {
        this.mContext = context;
        this.mCurrentFrgStack = currentFrgStack;
        this.mContainerId = containerId;
        this.mFragment = fragment;
    }

    public void peekFragment() {
        try {
            FragmentStack fragment = mCurrentFrgStack.peek();
            FragmentManager manager = ((HomeActivity) mContext).getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            ft.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
            ft.replace(mContainerId, fragment.getFragment(), fragment.getTag());
            ft.commitAllowingStateLoss();
        } catch (IllegalStateException | ArrayIndexOutOfBoundsException e) {
        }
    }

    public void popFragment() {
        mCurrentFrgStack.pop();
        peekFragment();
    }

    public void pushFragment(PushFrgType type, Fragment fragment, String tag, boolean shouldAdd) {
        try {
            FragmentManager manager = ((HomeActivity) mContext).getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            ft.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
            if (type == PushFrgType.REPLACE) {
                ft.replace(mContainerId, fragment, tag);
                ft.addToBackStack(tag);
                ft.commitAllowingStateLoss();
            } else if (type == PushFrgType.ADD) {
                ft.add(mContainerId, fragment, tag);
                ft.addToBackStack(tag);
                ft.commit();
            }
            manager.executePendingTransactions();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        if (shouldAdd) {
            mCurrentFrgStack.add(new FragmentStack(fragment, tag));
        }
    }

    public enum PushFrgType {
        REPLACE, ADD
    }
}
