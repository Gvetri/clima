package com.example.giuseppe.clima;

import android.content.Context;
import android.util.Log;

import com.example.giuseppe.clima.api.GeonameController;
import com.example.giuseppe.clima.api.GeonameControllerListener;
import com.example.giuseppe.clima.model.Geoname_;

import java.util.Arrays;
import java.util.List;

/**
 * Created by giuseppe on 9/2/17.
 */

public class FindCitiesInteractorImpl implements FindCityInteractor {


    private static final String TAG = FindCitiesInteractorImpl.class.getCanonicalName();



    @Override
    public void findItemsByName(OnFinishedListenerByName listener, String query) {
            createListByName(listener,query);
    }

    @Override
    public void saveQuery(String query, Context context) {
    }

    private void createListByName(final OnFinishedListenerByName listener, String query) {
        GeonameController geonameController = new GeonameController(new GeonameControllerListener() {
            @Override
            public void OnLoadFinished(List<Geoname_> Geonames_) {
                listener.onFinishedByName(Geonames_);
            }

        }, query);

    }


    @Override
    public void findItems(OnFinishedListener listener) {
        listener.onFinished(createList());
    }

    private List<String> createList() {
        return Arrays.asList(

                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5",
                "Item 6",
                "Item 7",
                "Item 8",
                "Item 9",
                "Item 10"
        );
    }
}
