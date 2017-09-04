package com.example.giuseppe.clima;

import android.content.Context;

import com.example.giuseppe.clima.model.Geoname_;

import java.util.List;

/**
 * Created by giuseppe on 9/2/17.
 */

public interface FindCityInteractor {

    void findItemsByName(OnFinishedListenerByName listener, String query);

    void saveQuery(String query, Context context);

    interface OnFinishedListenerByName {
        void onFinishedByName(List<Geoname_> items);
    }

    interface OnFinishedListener {
        void onFinished(List<String> items);
    }

    void findItems(OnFinishedListener listener);

}
