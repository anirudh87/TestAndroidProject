package com.test.testandroidproject.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.test.testandroidproject.R;
import com.test.testandroidproject.utility.Constants;

public class LocationFragment extends Fragment {
    Context mContext;
    private GoogleMap map;
    Bundle locationData;
    double latitude;
    double longitude;
    String placename;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.location_fragment, container, false);
        locationData = getArguments();
        if(locationData != null) {
            latitude = locationData.getDouble(Constants.LATITUDE);
            longitude = locationData.getDouble(Constants.LONGITUDE);
            placename = locationData.getString(Constants.PLACE);
        }
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapwhere);
        mapFragment.getMapAsync(onMapReadyCallback);

        return view;
    }

    OnMapReadyCallback onMapReadyCallback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            map = googleMap;

            if(map != null) {

                if(locationData != null) {

                    MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title(placename);
                    map.addMarker(marker);

                    CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 10);
                    map.animateCamera(cameraUpdate);

                }
            }
        }
    };

}
