package com.example.giuseppe.clima;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeInfoDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;
import com.example.giuseppe.clima.model.Geoname;
import com.example.giuseppe.clima.model.Geoname_;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = MapsActivity.class.getCanonicalName();
    private GoogleMap mMap;
    private Geoname_ geoname;
    private Double lat;
    private Double lng;
    private String name;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        context = this;
        Bundle bundle;
        bundle = this.getIntent().getExtras();
        geoname = bundle.getParcelable("geoname");//this is for String

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (geoname != null){
            LatLng marker = new LatLng(Double.valueOf(geoname.getLat()), Double.valueOf(geoname.getLng()));
            mMap.addMarker(new MarkerOptions().position(marker).title(geoname.getAsciiName()));
            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    new AwesomeInfoDialog(context)
                            .setTitle(geoname.getAsciiName())
                            .setMessage("Temperatura : 17C")
                            .setCancelable(true)
                            .show();
                    return false;
                }
            });
            mMap.moveCamera(CameraUpdateFactory.newLatLng(marker));
        }
    }
}
