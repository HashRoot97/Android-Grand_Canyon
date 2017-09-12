package com.example.surbh_000.grandcanyon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class MainActivity extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StreetViewPanoramaFragment fragment=(StreetViewPanoramaFragment) getFragmentManager().findFragmentById(R.id.streetview);
        fragment.getStreetViewPanoramaAsync(this);
    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama panorama) {
        panorama.setPosition(new LatLng(36.0579667,-112.1430996));
        StreetViewPanoramaCamera camera=new StreetViewPanoramaCamera.Builder().bearing(180).build();
        panorama.animateTo(camera,1000);
        panorama.setStreetNamesEnabled(true);
        panorama.setZoomGesturesEnabled(true);
        panorama.setUserNavigationEnabled(true);

    }
}
