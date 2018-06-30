package lorence.construction.view.fragment.beams.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.data.storage.entity.Beams;
import lorence.construction.di.module.beams.BeamsModule;
import lorence.construction.di.module.beams.child.BeamOperationModule;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.beams.BeamsFragment;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@SuppressLint("ValidFragment")
public class BeamsOperationFragment extends EBaseFragment implements BeamsOperationView {

    @Inject
    Context mContext;

    @Inject
    HomeActivity mHomeActivity;

    @BindView(R.id.image)
    ImageView imageDescription;

    @BindView(R.id.type)
    TextView type;

    @BindView(R.id.m1)
    TextView m1;

    @BindView(R.id.m2)
    TextView m2;

    public BeamsOperationFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public Fragment newInstance(String tag) {
        BeamsOperationFragment fragment = new BeamsOperationFragment();
        Bundle b = new Bundle();
        fragment.setArguments(b);
        return fragment;
    }

    private void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new HomeModule((HomeActivity) getActivity()))
                .plus(new BeamsModule(Application.getInstance(), (HomeActivity) getActivity(), (BeamsFragment) getParentFragment()))
                .plus(new BeamOperationModule(Application.getInstance(), (HomeActivity) getActivity(), this, this))
                .inject(this);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beams_operation, container, false);
        distributedDaggerComponents();
        mHomeActivity.hiddenBottomBar();
        bindView(view);
        extractBundle();
        return view;
    }

    private void extractBundle() {
        if (this.getArguments().get("beam") != null) {
            Beams beam = this.getArguments().getParcelable("beam");
            imageDescription.setImageResource(beam.getImage());
            type.setText(beam.getType());
            m1.setText(beam.getM1());
            m2.setText(beam.getM2());
        }
    }

    @Override
    public void onDestroyView() {
        mHomeActivity.updateTitleToolbar(getString(R.string.title_beams));
        mHomeActivity.showBottomBar();
        super.onDestroyView();
    }
}
