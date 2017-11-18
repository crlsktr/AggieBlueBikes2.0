package com.example.tylerivory.aggiebluebikes;

import android.support.v4.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;

import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.OnMapReadyCallback;

import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.maps.model.LatLngBounds;

import com.google.android.gms.maps.model.MarkerOptions;







public class BikeResourceMap extends FragmentActivity implements OnMapReadyCallback {



    private GoogleMap mMap;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bike_resource_map);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()

                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

    }



    /**

     * Manipulates the map once available.

     * This callback is triggered when the map is ready to be used.

     */

    @Override

    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        centerMap();

        modifyControls();

        addMarkers();

    }



    /**

     * Centers the map on Logan, Utah. Sets bounds for zoom and map.

     */

    private void centerMap() {

        // Center the map on Utah State University in Logan, UT

        LatLng loganUT = new LatLng(41.7452, -111.8097);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(loganUT));

        mMap.moveCamera(CameraUpdateFactory.zoomTo(15));

        mMap.setMinZoomPreference(14);

        mMap.setMaxZoomPreference(18);



        // Set bounds of the map

        mMap.setLatLngBoundsForCameraTarget(new LatLngBounds(

                new LatLng(41.738560, -111.816939),

                new LatLng(41.757697, -111.798396)));

    }



    /**

     * Adds the markers for locations to park bikes on campus

     */

    private void addMarkers() {



        // Add markers for bike tool stations on USU's campus

        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.741771, -111.809145))

                .title("Library South")

                .snippet("Parking & Tools"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.742409, -111.807887))

                .title("Engineering Quad")

                .snippet("Covered Parking & Tools"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.744127, -111.813248))

                .title("Aggie Blue Bikes")

                .snippet("Complete Services"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.749978, -111.803118))

                .title("Student Living Center")

                .snippet("Covered Parking & Tools"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.741154, -111.813869))

                .title("Old Main North")

                .snippet("Parking"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.740749, -111.813543))

                .title("Old Main East")

                .snippet("Parking"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.740194, -111.812971))

                .title("Ray B. West")

                .snippet("Parking"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.740193, -111.812423))

                .title("Family Life West")

                .snippet("Parking"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.740189, -111.811757))

                .title("Family Life East")

                .snippet("Parking"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.741054, -111.810478))

                .title("Ag Science")

                .snippet("Parking"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.741402, -111.809692))

                .title("Huntsman Hall")

                .snippet("Parking"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.742596, -111.809174))

                .title("Library North")

                .snippet("Parking"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.741952, -111.807297))

                .title("Engineering South")

                .snippet("Parking"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.742296, -111.807368))

                .title("Engineering North")

                .snippet("Parking"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.742483, -111.806157))

                .title("Fine Arts South")

                .snippet("Parking"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.743106, -111.812390))

                .title("Student Center North")

                .snippet("Parking"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.742658, -111.812421))

                .title("Student Center South")

                .snippet("Parking"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.743220, -111.814102))

                .title("Student Center West")

                .snippet("Covered Parking"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.742314, -111.813794))

                .title("Eccels Science")

                .snippet("Covered Parking"));



        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(41.742400, -111.813504))

                .title("TSC Patio")

                .snippet("Parking"));



    }



    /**

     * Modifies the controls the user can interface with

     */

    private void modifyControls() {

        // Enable Map Features

        mMap.getUiSettings().setCompassEnabled(true);

        mMap.getUiSettings().setZoomGesturesEnabled(true);

        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.getUiSettings().setMapToolbarEnabled(true);

        mMap.getUiSettings().setRotateGesturesEnabled(true);

    }

}

