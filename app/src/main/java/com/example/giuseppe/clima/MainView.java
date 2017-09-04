package com.example.giuseppe.clima;

import android.content.Context;

import com.example.giuseppe.clima.model.Geoname_;

import java.util.List;

/**
 * Created by giuseppe on 9/2/17.
 */

public interface MainView {
    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMessage(String message);

    Context getContext();

    void setItemsByName(List<Geoname_> items);
}
