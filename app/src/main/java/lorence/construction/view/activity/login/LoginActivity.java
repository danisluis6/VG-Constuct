package lorence.construction.view.activity.login;

import lorence.construction.R;
import lorence.construction.custom.DialogClass;
import lorence.construction.view.activity.BaseActivity;

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
    private DialogClass mDialogProgress;

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
        mDialogProgress = new DialogClass(this);
        // initialize Login Presenter
        mLoginPresenter = new LoginPresenter(mContext);
        mLoginPresenter.attachView(this);
    }

    @Override
    public void initViews() {
    }
}
