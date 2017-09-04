package com.example.giuseppe.clima;

import android.Manifest;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.giuseppe.clima.adapter.GeonameAdapter;
import com.example.giuseppe.clima.model.Geoname_;
import com.example.giuseppe.clima.utils.RecyclerItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = MainActivity.class.getCanonicalName();
    @BindView(R.id.editText) EditText mSearch;
    @BindView(R.id.button) Button mButton;

    private PresenterImpl presenter;
    private GeonameAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Context context = getContext();
        presenter = new PresenterImpl(this, new FindCitiesInteractorImpl(context));
        askForPermission();
        recyclerView = findViewById(R.id.recycler_view);
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
    public void setItemsByName(final List<Geoname_> items) {
        Log.d(TAG, "setItemsByName: ACTIVATED");
        if (items != null) {
            for (int i = 0; i < items.size(); i++) {
                Log.d(TAG, "setItemsByName: ITEM NO NULO EN LA VISTA "+items.get(i).getAsciiName());
            }
        } else {
            Log.d(TAG, "setItemsByName: ITEMS NULOS");
        }
        mAdapter = new GeonameAdapter(items);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), "Hola! esta es  "+items.get(position).getAsciiName(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemLongClick(View view, int position) {
                // ...
            }
        }));

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
