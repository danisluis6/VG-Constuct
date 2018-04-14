package lorence.vgconstruct.view.activity.login;

import lorence.vgconstruct.R;
import lorence.vgconstruct.custom.VGDialogProgress;
import lorence.vgconstruct.view.activity.BaseActivity;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class LoginActivity extends BaseActivity implements ILoginView {

    /**
     * Login Presenter
     */
    private ILoginPresenter mLoginPresenter;
    /**
     * Loading Dialog
     */
    private VGDialogProgress mDialogProgress;

    @Override
    protected int getLayoutRes() {
        return R.layout.layout_login;
    }

    @Override
    public void distributedDaggerComponents() {
    }

    @Override
    public void initAttributes() {
        // initialize Dialog Progress
        mDialogProgress = new VGDialogProgress(this);
        // initialize Login Presenter
        mLoginPresenter = new LoginPresenter(mContext);
        mLoginPresenter.attachView(this);
    }

    @Override
    public void initViews() {
    }
}
