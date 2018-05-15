package lorence.construction.view.activity.login;

import android.content.Context;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

class LoginModel implements ILoginModel {

    /**
     * Context
     */
    private final Context mContext;

    /**
     * ILoginPresenter
     */
    private ILoginPresenter mLoginPresenter;

    LoginModel(Context context) {
        this.mContext = context;
    }

    @Override
    public void attachView(ILoginPresenter view) {
        mLoginPresenter = view;
    }
}
