package com.example.giuseppe.clima.api;


import com.example.giuseppe.clima.Geoname_;

import java.util.List;

/**
 * Created by giuseppe on 9/3/17.
 */

public interface GeonameControllerListener {
    void OnLoadFinished(List<Geoname_> Geonames_);
    List<Geoname_> Testing(String query);
}
