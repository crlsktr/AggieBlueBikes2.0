package com.example.tylerivory.aggiebluebikes;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
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
        String logan = getResources().getString(R.string.loganUT);
        String[] loganLatLng = logan.split(",");

        LatLng loganUT = new LatLng(
                Double.parseDouble(loganLatLng[0]), Double.parseDouble(loganLatLng[1]));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(loganUT));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(getResources().getInteger(R.integer.zoomTo)));
        mMap.setMinZoomPreference(getResources().getInteger(R.integer.minZoom));
        mMap.setMaxZoomPreference(getResources().getInteger(R.integer.maxZoom));

        // Set bounds of the map
        String southWest = getResources().getString(R.string.bounds);
        String[] bndsLatLng = southWest.split(",");

        mMap.setLatLngBoundsForCameraTarget(new LatLngBounds(
                new LatLng(Double.parseDouble(bndsLatLng[0]), Double.parseDouble(bndsLatLng[1])),
                new LatLng(Double.parseDouble(bndsLatLng[2]), Double.parseDouble(bndsLatLng[3]))));
    }

    /**
     * Adds markers for locations to park bikes and repair stations on campus. All locations are
     * stored in the resourceMap.xml file located in the res/values directory. Additional locations
     * may be added by following the format:
     *
     * <item>"(Double) Latitude","(Double) Longitude","(String) Title","(String) Description"</item>
     *
     * The description must contain the words "Tools" or "Services" for a wrench to be displayed as
     * the marker icon. Otherwise a bike will be displayed, representing bike parking.
     */
    private void addMarkers() {
        String[] locations = getResources().getStringArray(R.array.locations);
        for (String l : locations) {
            String[] set = l.split(",");

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(Double.parseDouble(set[0]), Double.parseDouble(set[1])))
                    .title(set[2])
                    .snippet(set[3])
                    .icon(getIcon(set[3])));
        }
    }

    /**
     * Determines which icon to attach to the map marker. Returns a BitMap Descriptor.
     * @param type snippet from marker describing the location
     * @return a bitmap graphic corresponding to the location type
     */
    private BitmapDescriptor getIcon(String type) {
        if (type.contains("Tools") || type.contains("Services")) {
            return BitmapDescriptorFactory.fromResource(R.drawable.repair_station);
        } else {
            return BitmapDescriptorFactory.fromResource(R.drawable.bike_parking);
        }
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
