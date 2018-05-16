package lorence.construction.view.activity.login;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;

import lorence.construction.helper.Validator;

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
     * IEditUserProfileModel
     */
    private ILoginModel mLoginModel;

    @Inject
    Validator mValidator;

    @Inject
    LoginView mLoginView;

    LoginPresenter(Context context) {
        this.mContext = context;
        mLoginModel = new LoginModel(mContext);
        mLoginModel.attachView(this);
    }

    @Override
    public void attachView(ILoginView view) {
    }

    @Override
    public void checkUserName(String username) {
        if (mValidator.validUsername(username)) {
            Toast.makeText(mLoginView, "User is valid", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mLoginView, "User is invalid", Toast.LENGTH_SHORT).show();
        }
    }
}
