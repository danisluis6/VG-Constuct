package lorence.construction.view.activity.login;

import android.content.Context;
import android.widget.Toast;

import lorence.construction.helper.Validator;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class LoginPresenter implements ILoginPresenter {

    private ILoginModel mLoginModel;

    private Validator mValidator;
    private Context mContext;
    private LoginActivity mActivity;

    public LoginPresenter(Validator validator, Context context, LoginActivity activity) {
        this.mContext = context;
        mValidator = validator;
        mContext = context;
        mActivity = activity;
        mLoginModel = new LoginModel(mContext);
        mLoginModel.attachView(this);
    }

    @Override
    public void attachView(ILoginView view) {
    }

    @Override
    public void checkUserName(String username) {
        if (mActivity != null) {
            Toast.makeText(mActivity, "No null!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mActivity, "null!", Toast.LENGTH_SHORT).show();
        }
    }
}
