package lorence.construction.view.activity.login;

import android.content.Context;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class LoginPresenter implements ILoginPresenter {

    /**
     * Context
     */
    private final Context mContext;

    /**
     * ILoginView
     */
    private ILoginView mLoginView;

    /**
     * IEditUserProfileModel
     */
    private ILoginModel mLoginModel;

    LoginPresenter(Context context) {
        this.mContext = context;
        mLoginModel = new LoginModel(mContext);
        mLoginModel.attachView(this);
    }

    @Override
    public void attachView(ILoginView view) {
    }
}
