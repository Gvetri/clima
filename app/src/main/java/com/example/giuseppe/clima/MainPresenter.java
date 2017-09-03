package com.example.giuseppe.clima;

/**
 * Created by giuseppe on 9/2/17.
 */

public interface MainPresenter {

    void onResume();

    void onItemClicked(int position);

    void onDestroy();

    void onSearchStarted(String query);

    void onSaveSearchQuery(String query);
}
