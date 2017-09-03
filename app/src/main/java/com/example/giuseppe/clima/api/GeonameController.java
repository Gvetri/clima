package com.example.giuseppe.clima.api;

import android.util.Log;

import com.example.giuseppe.clima.Geoname;
import com.example.giuseppe.clima.Geoname_;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by giuseppe on 9/3/17.
 */

public class GeonameController implements Callback<Geoname> {
    public static final String language = "en";
    public static final int max_rows = 20;
    public static final int start_rows = 0;
    public static final boolean isNameRequired = true;
    public static final String style = "FULL";
    public static final String username = "demo";
    private static final String TAG = GeonameController.class.getCanonicalName();
    private List<Geoname_> mGeonameList;

    GeonameControllerListener listener;
    String query;

    public GeonameController(GeonameControllerListener listener, String query) {
        this.listener = listener;
        this.query = query;
        getDataByName(query);
    }

    public void getDataByName(String name){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(GeonameService.URL_BASE).addConverterFactory(GsonConverterFactory.create(gson)).build();
        GeonameService geonameService = retrofit.create(GeonameService.class);
        Call<Geoname> geonames = geonameService.getCitiesByName("madrid",20,0,"en",true,"FULL","ilgeonamessample");
        geonames.enqueue(this);
    }

    @Override
    public void onResponse(Call<Geoname> call, Response<Geoname> response) {
        Log.d(TAG, "onResponse: ON RESPONSE ACTIVADO");
        if(response.isSuccessful()){
            Log.d(TAG, "onResponse: RESPONSE SUCCESFULL"+response.body().toString());
            Geoname geoname = response.body();
            if (geoname != null) {
                Geoname_[] a = new Geoname_[geoname.getGeonames().size()];
                Log.d(TAG, "onResponse: GEONAME NOT NULL = "+geoname.toString());
                for (int i = 0; i < geoname.getGeonames().size(); i++) {
                    Log.d(TAG, "onResponse: GEONAME_ === "+geoname.getGeonames().get(i).getAsciiName());
                    Geoname_ geoname_ = new Geoname_();
                    geoname_.setGeonameId(geoname.getGeonames().get(i).getGeonameId());
                    geoname_.setAsciiName(geoname.getGeonames().get(i).getAsciiName());
                    geoname_.setLat(geoname.getGeonames().get(i).getLat());
                    geoname_.setLng(geoname.getGeonames().get(i).getLng());
                    a[i] = geoname_;
                }

                for (int i = 0; i < a.length; i++) {
                    Log.d(TAG, "onResponse: GEONAME_ === "+geoname.getGeonames().get(i).getAsciiName());
                }

                mGeonameList = Arrays.asList(a);

                listener.OnLoadFinished(mGeonameList);

                Log.d(TAG, "onResponse: CONVERSION -----------");
                for (int i = 0; i < mGeonameList.size(); i++) {
                    Log.d(TAG, "onResponse: GEONAME_ === "+mGeonameList.get(i).getAsciiName());
                }
            } else {
                Log.d(TAG, "onResponse: GEONAME NULL");
            }
        }
    }



    @Override
    public void onFailure(Call<Geoname> call, Throwable t) {
        Log.e(TAG,"LA URL ES " +call.request().url().toString(),t);
        Log.e(TAG,"EL BODY ES " +call.request().body(),t);
        Log.e(TAG,"LA URL ES " + call.request().headers(),t);
        Log.e(TAG, "onFailure: ON FAILURE ACTIVATE",t);
    }


}
