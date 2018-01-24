package bitgear.mmwa.installation.manholemonitorinstallation;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.orhanobut.logger.Logger;

import bitgear.mmwa.installation.manholemonitorinstallation.adapter.ManholeListAdapter;
import bitgear.mmwa.installation.manholemonitorinstallation.domain.Manhole;

public class ManholeList extends AppCompatActivity {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ListView mRecyclerView;
    private ManholeListAdapter mCatNamesRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhole_list);
        deviceSwipeList();
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
                        setupAdapter();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 2500);
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
                    Intent intent = new Intent(ManholeList.this, MainActivity.class);

                    Logger.d( mCatNamesRecyclerViewAdapter.getItem(position));
                    intent.putExtra("id_device", (String) ((Manhole)mCatNamesRecyclerViewAdapter.getItem(position)).getId().toString());
                    startActivity(intent);
                }
            });
        }
    }


}
