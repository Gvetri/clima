package com.example.giuseppe.clima;

import android.util.Log;

import java.util.List;

/**
 * Created by giuseppe on 9/2/17.
 */

public class PresenterImpl implements MainPresenter,FindCityInteractor.OnFinishedListener,FindCityInteractor.OnFinishedListenerByName {

    private static final String TAG = PresenterImpl.class.getCanonicalName();
    private MainView mainView;
    private FindCityInteractor findCityInteractor;

    public PresenterImpl(MainView mainView, FindCityInteractor findCityInteractor) {
        this.mainView = mainView;
        this.findCityInteractor = findCityInteractor;
    }

    @Override
    public void onResume() {
        if (mainView != null) {
            mainView.showProgress();
        }
        findCityInteractor.findItems(this);
    }

    @Override
    public void onItemClicked(int position) {
        if (mainView != null) {
            mainView.showMessage(String.format("Position %d clicked", position + 1));
        }
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onSearchStarted(String query) {
        Log.d(TAG, "onSearchStarted: ");
        findCityInteractor.findItemsByName(this,query);
    }

    @Override
    public void onSaveSearchQuery(String query) {
        findCityInteractor.saveQuery(query,mainView.getContext());
    }


    @Override
    public void onFinished(List<String> items) {
        if (mainView != null) {
            mainView.setItems(items);
            mainView.hideProgress();
        }
    }

    public MainView getMainView() {
        return mainView;
    }


}
