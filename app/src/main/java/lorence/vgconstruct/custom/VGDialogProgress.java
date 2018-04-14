package lorence.vgconstruct.custom;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;

import lorence.vgconstruct.R;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class VGDialogProgress extends Dialog {

    private Activity mActivity;

    public VGDialogProgress(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    private void init() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        setContentView(R.layout.vg_progress_dialog);
        setCancelable(false);
    }

    @Override
    public void show() {
        if (mActivity != null && !mActivity.isFinishing()) {
            super.show();
        }
    }

    @Override
    public void dismiss() {
        if (mActivity != null && !mActivity.isFinishing()) {
            super.dismiss();
        }
    }
}
