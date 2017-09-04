package com.example.giuseppe.clima.api;

import com.example.giuseppe.clima.model.Geoname;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by giuseppe on 9/3/17.
 */

public interface GeonameService {

    String URL_BASE = "http://api.geonames.org/";

    @GET("searchJSON")
    Call<Geoname> getCitiesByName(
            @Query("q") String name,
            @Query("maxRows") int max_rows,
            @Query("startRow") int start_rows,
            @Query("lang") String language,
            @Query("isNameRequired") boolean isNameRequired,
            @Query("style") String style,
            @Query("username") String username
    );
}
