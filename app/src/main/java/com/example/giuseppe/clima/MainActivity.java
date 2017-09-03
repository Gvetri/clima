package com.example.giuseppe.clima;

import android.Manifest;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.giuseppe.clima.api.GeonameService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MainView , AdapterView.OnItemClickListener {

    private static final String TAG = MainActivity.class.getCanonicalName();
    @BindView(R.id.editText) EditText mSearch;
    @BindView(R.id.button) Button mButton;

    private PresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Context context = getContext();
        presenter = new PresenterImpl(this, new FindCitiesInteractorImpl(context));
        askForPermission();
    }

    private void askForPermission() {
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.INTERNET},
                1);
    }


    @OnClick(R.id.button)
    public void search(View view) {
        Log.d(TAG,"On Click! ---------------------- "+mSearch.getText());
        presenter.onSearchStarted(mSearch.getText().toString());
        presenter.onSaveSearchQuery(mSearch.getText().toString());
    }

    @Override
    public void showProgress() {
        Toast.makeText(this, "Cargando...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setItems(List<String> items) {
        Log.d(TAG,"SetItems: ACTIVADO");
        for (int i = 0; i < items.size(); i++) {
            Log.d(TAG, "setItems: "+ items.get(i));
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, "¡Ha ocurrido un error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void setItemsByName(List<Geoname_> items) {
        Log.d(TAG, "setItemsByName: ACTIVATED");
        if (items != null) {
            for (int i = 0; i < items.size(); i++) {
                Log.d(TAG, "setItemsByName: ITEM NO NULO EN LA VISTA "+items.get(i).getAsciiName());
            }
        } else {
            Log.d(TAG, "setItemsByName: ITEMS NULOS");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

}
