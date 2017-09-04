package com.example.giuseppe.clima;

/**
 * Created by giuseppe on 9/2/17.
 */

public interface MainPresenter {

    void onResume();

    void onDestroy();

    void onSearchStarted(String query);

    void onSaveSearchQuery(String query);
}
