package lorence.construction.view.fragment.beams;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.data.storage.entity.Beams;
import lorence.construction.di.module.beams.BeamsModule;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.beams.adapter.BeamsAdapter;
import lorence.construction.view.fragment.listing.module.DataSource;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@SuppressLint("ValidFragment")
public class BeamsFragment extends EBaseFragment implements BeamsView {

    @BindView(R.id.rcvBeams)
    RecyclerView rcvBeams;

    @Inject
    BeamsPresenter mBeamsPresenter;

    @Inject
    BeamsAdapter mBeamsAdapter;

    @Inject
    DataSource mListingDataSource;

    @Inject
    Context mContext;

    public BeamsFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Application.getInstance()
                .getAppComponent()
                .plus(new HomeModule((HomeActivity) getActivity()))
                .plus(new BeamsModule(Application.getInstance(), (HomeActivity) getActivity(), this, this))
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beam, container, false);
        bindView(view);
        initComponents();
        return view;
    }

    @Override
    public void initComponents() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        rcvBeams.setLayoutManager(mLayoutManager);
        rcvBeams.setItemAnimator(new DefaultItemAnimator());
        rcvBeams.setAdapter(mBeamsAdapter);
    }

    @Override
    public void onGetBeamsSuccess(List<Beams> beams) {
        if (beams.size() == 0) {
            initializeNewBeams();
        } else {
            mBeamsAdapter.updateBeams(beams);
        }
    }

    private void initializeNewBeams() {
        mBeamsPresenter.saveBeams(mListingDataSource.getDefaultBeamsData());
        mBeamsAdapter.updateBeams(mListingDataSource.getDefaultBeamsData());
    }

    @Override
    public void onResume() {
        super.onResume();
        mBeamsPresenter.getBeamss();
    }

    public void navigatePageOperation(String name) {
        Toast.makeText(mContext, "Go to detail", Toast.LENGTH_SHORT).show();
    }
}