package com.example.giuseppe.clima;

import android.content.Context;
import android.util.Log;

import com.example.giuseppe.clima.api.GeonameController;
import com.example.giuseppe.clima.api.GeonameControllerListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by giuseppe on 9/2/17.
 */

public class FindCitiesInteractorImpl implements FindCityInteractor {


    private static final String TAG = FindCitiesInteractorImpl.class.getCanonicalName();
    private Context context;

    public FindCitiesInteractorImpl(Context context) {
        this.context = context;
    }


    @Override
    public void findItemsByName(OnFinishedListenerByName listener, String query) {
        Log.d(TAG, "findItemsByName: FINDITEMSBYNAME");
            createListByName(listener,query);
    }

    @Override
    public void saveQuery(String query, Context context) {
        if (context != null){
            Log.d(TAG, "saveQuery: Context NULO");
        } else {
            Log.d(TAG, "saveQuery: Context NO NULO");
        }

        //TODO hacer que este metodo guarde la query

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
        //TODO hacer que regrese la lista guardada previamente
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
