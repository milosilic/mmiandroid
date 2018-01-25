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

import com.orhanobut.logger.Logger;

import java.util.List;

import bitgear.mmwa.installation.manholemonitorinstallation.adapter.ManholeListAdapter;
import bitgear.mmwa.installation.manholemonitorinstallation.domain.Manhole;

public class ManholeDetailsActivity extends AppCompatActivity {

    private String name;


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
}
