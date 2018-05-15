package lorence.construction.helper;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public abstract class BasePresenter<M, V> {

    protected M model;
    private WeakReference<V> view;

    public void setModel(M model) {
        this.model = model;
        if (setupDone()) {
            updateView();
        }
    }

    public void bindView(@NonNull V view) {
        this.view = new WeakReference<>(view);
        if (setupDone()) {
            updateView();
        }
    }

    public void unbindView() {
        this.view = null;
    }

    protected V view() {
        if (view == null) {
            return null;
        } else {
            return view.get();
        }
    }

    protected abstract void updateView();

    private boolean setupDone() {
        return view() != null && model != null;
    }
}
