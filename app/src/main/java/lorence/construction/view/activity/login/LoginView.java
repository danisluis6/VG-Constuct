package lorence.construction.view.activity.login;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;

import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.custom.DialogClass;
import lorence.construction.di.LoginModule;
import lorence.construction.helper.Validator;
import lorence.construction.view.activity.BaseActivity;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class LoginView extends BaseActivity implements ILoginView {

    /**
     * Login Presenter
     */
    private ILoginPresenter mLoginPresenter;
    /**
     * Loading Dialog
     */
    private DialogClass mDialogProgress;

    @Inject
    Context mContext;

    @Inject
    Validator mValidator;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    public void distributedDaggerComponents() {
        Application.get(this)
                .getAppComponent()
                .plus(new LoginModule(this))
                .inject(this);
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
        if (mContext != null) {
            Toast.makeText(mContext, "Hello World", Toast.LENGTH_SHORT).show();
        }
        mLoginPresenter.checkUserName("Nguyen Van Vuong");
    }
}
