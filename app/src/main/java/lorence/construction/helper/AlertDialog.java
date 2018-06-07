package lorence.construction.helper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lorence.construction.R;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class AlertDialog extends DialogFragment {

    @BindView(R.id.tvMessage)
    TextView tvMessage;
    @BindView(R.id.btnPositive)
    TextView btnPositive;
    @BindView(R.id.btnNegative)
    TextView btnNegative;
    /**
     * OnPositiveListener
     */
    private OnPositiveListener mOnPositiveListener;
    /**
     * OnNegativeListener
     */
    private OnNegativeListener mOnNegativeListener;

    public AlertDialog() {

    }

    public AlertDialog createDialog(String message, String positive, String negative) {
        AlertDialog frag = new AlertDialog();
        Bundle args = new Bundle();
        args.putString("message", message);
        args.putString("positive", positive);
        if (negative != null) {
            args.putString("negative", negative);
        }
        frag.setArguments(args);
        frag.setCancelable(false);
        return frag;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.cloneInContext(new ContextThemeWrapper(getContext(), R.style.FontTheme))
                .inflate(R.layout.fragment_dialog_alert, container, false);
        ButterKnife.bind(this, view);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.ef_dialog_bg);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvMessage.setText(getArguments().getString("message", Constants.EMPTY_STRING));
        btnPositive.setText(getArguments().getString("positive", Constants.EMPTY_STRING));
        btnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnPositiveListener != null) {
                    mOnPositiveListener.onPositiveListener();
                }
                dismiss();
            }
        });
        if (getArguments().getString("negative") == null) {
            btnNegative.setVisibility(View.GONE);
        } else {
            btnNegative.setVisibility(View.VISIBLE);
            btnNegative.setText(getArguments().getString("negative", Constants.EMPTY_STRING));
            btnNegative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnNegativeListener != null) {
                        mOnNegativeListener.onNegativeListener();
                    }
                    dismiss();
                }
            });
        }
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        if (getActivity() != null && getActivity().isFinishing()) {
            return;
        }

        FragmentTransaction ft = manager.beginTransaction();
        ft.add(this, tag);
        ft.commitAllowingStateLoss();
    }

    public interface OnPositiveListener {
        void onPositiveListener();
    }

    public interface OnNegativeListener {
        void onNegativeListener();
    }

    public void setOnPositiveListener(OnPositiveListener onPositiveListener) {
        this.mOnPositiveListener = onPositiveListener;
    }

    public void setOnNegativeListener(OnNegativeListener onNegativeListener) {
        this.mOnNegativeListener = onNegativeListener;
    }

}
