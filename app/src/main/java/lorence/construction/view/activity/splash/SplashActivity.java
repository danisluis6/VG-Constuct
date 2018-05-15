package lorence.construction.view.activity.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import lorence.construction.R;
import lorence.construction.view.activity.home.HomeActivity;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class SplashActivity extends AppCompatActivity {

    private boolean mTimeOut = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mTimeOut = true;
                moveToNextActivity();
            }
        }, 1000);
    }

    /**
     * Move to next activity
     */
    private void moveToNextActivity() {
        if (mTimeOut) {
            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
            finish();
        }
    }
}
