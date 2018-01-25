package bitgear.mmwa.installation.manholemonitorinstallation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.orhanobut.logger.Logger;

import java.util.List;

import bitgear.mmwa.installation.manholemonitorinstallation.adapter.ManholeListAdapter;
import bitgear.mmwa.installation.manholemonitorinstallation.domain.Manhole;

public class ManholeDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private String name;
    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhole_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if ( savedInstanceState == null) {
            name = getIntent().getStringExtra("id_device");
        }else {
            name = savedInstanceState.getString("id_device");
        }

        populateScreen(Integer.parseInt(name));
        populateMap();

    }

    private void populateMap() {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.eventMap);
        mapFragment.getMapAsync(this);

    }

    private void populateScreen(Integer name) {

        Manhole device = null;
        if ( name != null ) {

            ManholeListAdapter manholeListAdapter = new ManholeListAdapter(getApplicationContext());

            device = (Manhole) manholeListAdapter.getItem(name);

        }

        if ( device != null){
            TextView deviceName = (TextView) findViewById(R.id.childName);
            if ( deviceName != null){
                deviceName.setText(device.getName());
            }
            TextView serialNumberTextView = (TextView) findViewById(R.id.serialNumberTextView);
            if ( serialNumberTextView != null){
                //serialNumberTextView.setText(device.getId());
            }
            TextView expiresOnTextView = (TextView) findViewById(R.id.expiresOn);
            if ( expiresOnTextView != null){
                expiresOnTextView.setText("Expires on: " + device.getLast_update().toString());
            }
            TextView deviceColorImageView = (TextView) findViewById(R.id.deviceColorImageView);
            if ( deviceColorImageView != null){
                //deviceColorImageView.setBackgroundColor(Color.parseColor(device.getColor()));
            }

        }


    }


    public void shareDevice(View view) {

    }

    public void deviceSetupClick(View view) {
        Intent intent = new Intent(ManholeDetailsActivity.this, MainActivity.class);
        startActivity(intent);

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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

}
