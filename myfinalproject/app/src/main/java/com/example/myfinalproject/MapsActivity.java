package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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

        // Add a marker in abbottabad and move the camera
        LatLng abbottanad = new LatLng(34.170517, 73.223920);
        mMap.addMarker(new MarkerOptions().position(abbottanad).title("Marker in abbottabad"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(abbottanad,11F));

        // Add a marker in Veterinary Hospital and Research Centre and move the camera
        LatLng VeterinaryHospitalandResearchCentre = new LatLng(34.193170, 73.236641);
        mMap.addMarker(new MarkerOptions().position(VeterinaryHospitalandResearchCentre).title("Marker in Veterinary Hospital and Research Centre"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(VeterinaryHospitalandResearchCentre,11F));

        // Add a marker in Army Medical Corps Centre and move the camera
        LatLng ArmyMedicalCorpsCentre = new LatLng(34.159782, 73.226946);
        mMap.addMarker(new MarkerOptions().position(ArmyMedicalCorpsCentre).title("Marker in Army Medical Corps Centre"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ArmyMedicalCorpsCentre,11F));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_options, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Change the map type based on the user's selection.
        switch (item.getItemId()) {
            case R.id.normal_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case R.id.hybrid_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case R.id.satellite_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case R.id.terrain_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
