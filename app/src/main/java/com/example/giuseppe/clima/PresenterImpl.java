package com.example.giuseppe.clima;

import android.util.Log;

import com.example.giuseppe.clima.model.Geoname_;

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
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onSearchStarted(String query) {
        Log.d(TAG, "onSearchStarted: "+query);
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


    @Override
    public void onFinishedByName(List<Geoname_> items) {
        if (items == null) {
            Log.d(TAG, "onFinishedByName: ITEMS NULOS EN EL PRESENTADOR");
        } else {
            Log.d(TAG, "onFinishedByName ITEMS NO NULOS EN EL PRESENTADOR: "+ items.size());
        }
        if (mainView != null) {
            mainView.setItemsByName(items);
            mainView.hideProgress();
        }
    }
}
