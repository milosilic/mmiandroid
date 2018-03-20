package bitgear.mmwa.installation.manholemonitorinstallation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.orhanobut.logger.Logger;

import java.util.List;

import bitgear.mmwa.installation.manholemonitorinstallation.adapter.ManholeListAdapter;
import bitgear.mmwa.installation.manholemonitorinstallation.domain.Manhole;
import bitgear.mmwa.installation.manholemonitorinstallation.network.NoConnectivityException;
import bitgear.mmwa.installation.manholemonitorinstallation.rest.ApiClient;
import bitgear.mmwa.installation.manholemonitorinstallation.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManholeList extends AppCompatActivity {

    private static final String TAG = ManholeList.class.getSimpleName();
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ListView mRecyclerView;
    private ManholeListAdapter mCatNamesRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhole_list);
        deviceSwipeList();
        this.getManholes();
    }

    private void getManholes() {

        Log.d(TAG, "Krećem sa Retrofit");
        Log.d(TAG, Boolean.toString(ManholeList.isOnline(this)));
        ApiInterface apiService =
                ApiClient.getClient(getApplicationContext()).create(ApiInterface.class);
        Call<List<Manhole>> call = apiService.getTopRatedMovies("Bearer DeXXeb3FePOe9dXRifZ5TupJeEjnZpHQsw0HUoF7ma7W7Z9uSpsjFW5PHbZP");
        call.enqueue(new Callback<List<Manhole>>() {
            @Override
            public void onResponse(Call<List<Manhole>> call, Response<List<Manhole>> response) {
                Log.d(TAG, "Stigao response");
                int statusCode = response.code();

                List<Manhole> listaOkana = response.body();
                mCatNamesRecyclerViewAdapter.setManholeList(listaOkana);
                Log.d(TAG, listaOkana.toString());
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<Manhole>> call, Throwable t) {
                // Log error here since request failed
                Log.d(TAG, "onFailure");
                Log.e(TAG, t.toString());
                if ( t instanceof NoConnectivityException){
                    Log.e(TAG, "E sam ti reko");
                    showDialog();
                }
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });



    }


    private void deviceSwipeList(){
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mRecyclerView = (ListView) findViewById(R.id.eventListView);
        setupAdapter();
        setupItemListener();


        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimary));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getManholes();
                    }
                }, 25);
            }
        });    }

    private void setupAdapter() {
        mCatNamesRecyclerViewAdapter = new ManholeListAdapter(this);
        mRecyclerView.setAdapter(mCatNamesRecyclerViewAdapter);
    }

    private void setupItemListener(){
        if ( mRecyclerView != null){
            mRecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ManholeList.this, ManholeDetailsActivity.class);
                    Logger.d( mCatNamesRecyclerViewAdapter.getItem(position));
                    intent.putExtra("id_device", (String) ((Manhole)mCatNamesRecyclerViewAdapter.getItem(position)).getId().toString());
                    startActivity(intent);
                }
            });
        }
    }


    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
        return (netInfo != null && netInfo.isConnected());
    }

    private void showDialog()
    {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Greska")
                .setMessage("Proverite internet konekciju")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();    }


}
