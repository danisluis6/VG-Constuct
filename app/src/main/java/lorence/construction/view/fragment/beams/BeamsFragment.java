package lorence.construction.view.fragment.beams;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Stack;

import javax.inject.Inject;

import butterknife.BindView;
import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.data.storage.entity.Beams;
import lorence.construction.di.module.beams.BeamsModule;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.helper.FragmentStack;
import lorence.construction.helper.FragmentUtils;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.beams.adapter.BeamsAdapter;
import lorence.construction.view.fragment.beams.fragment.BeamsOperationFragment;
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
    HomeActivity mActivity;

    @Inject
    BeamsFragment mBeamsFragment;

    @Inject
    BeamsPresenter mBeamsPresenter;

    @Inject
    BeamsAdapter mBeamsAdapter;

    @Inject
    DataSource mListingDataSource;

    @Inject
    Context mContext;

    @Inject
    BeamsOperationFragment mBeamsOperationFragment;

    private Stack<FragmentStack> mCurrentFrgStack;
    private FragmentUtils mFragmentUtils;

    public BeamsFragment() {

    }

    private void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new HomeModule((HomeActivity) getActivity()))
                .plus(new BeamsModule(Application.getInstance(), (HomeActivity) getActivity(), this, this))
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beam, container, false);
        distributedDaggerComponents();
        bindView(view);
        initComponents();
        return view;
    }

    @Override
    public void initComponents() {
        GridLayoutManager mLayoutManager = new GridLayoutManager(mActivity, 2);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (mBeamsAdapter.getItemViewType(position)) {
                    case BeamsAdapter.TYPE_ITEM:
                        return 2;
                    default:
                        return -1;
                }
            }
        });
        rcvBeams.setLayoutManager(mLayoutManager);
        rcvBeams.setItemAnimator(new DefaultItemAnimator());
        rcvBeams.setAdapter(mBeamsAdapter);

        mCurrentFrgStack = new Stack<>();
        mFragmentUtils = new FragmentUtils(mActivity, mBeamsFragment, mCurrentFrgStack, R.id.content_listing);
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

    public void navigatePageOperation(String tag) {
        mBeamsOperationFragment = (BeamsOperationFragment) mBeamsOperationFragment.newInstance(tag);
        mBeamsOperationFragment.setArguments(getBundle(tag));
        pushFragment(mBeamsOperationFragment, tag);
    }

    @Override
    public Bundle getBundle(String tag) {
        Bundle bundle = new Bundle();
        for (int index = 0; index < mBeamsAdapter.getlistOfBeams().size(); index++) {
            if (TextUtils.equals(mBeamsAdapter.getlistOfBeams().get(index).getName(), tag)) {
                bundle.putParcelable("beam", mBeamsAdapter.getlistOfBeams().get(index));
            }
        }
        return bundle;
    }

    @Override
    public void pushFragment(Fragment fragment, String tag) {
        switchFragment(fragment, tag);
        mActivity.attachBeamFragment(this);
        defineToolbar(tag);
    }

    void switchFragment(@NonNull Fragment fragment, String tag) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content_listing, fragment);
        transaction.addToBackStack(tag);
        transaction.commit();
        fragmentManager.executePendingTransactions();
    }

    @Override
    public void defineToolbar(String title) {
        mActivity.updateTitleToolbar(title);
    }
}
