package bitgear.mmwa.installation.manholemonitorinstallation.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import bitgear.mmwa.installation.manholemonitorinstallation.R;
import bitgear.mmwa.installation.manholemonitorinstallation.domain.Manhole;

/**
 * Created by ila on 24.1.18..
 */

public class ManholeListAdapter extends BaseAdapter {

    private List<Manhole> manholeList;
    private Context mContext;

    public ManholeListAdapter(Context context){
        this.mContext = context;
        this.manholeList = new ArrayList<Manhole>();
        for ( int i=1; i<15; i++ ){
            Manhole manhole = new Manhole(i, 44.4, 20.5, "teto "+ i, new Long(234022433 +  i ), "Stevana Markovica 8");
            this.manholeList.add(manhole);
        }
    }

    @Override
    public int getCount() {
        return manholeList.size();
    }

    @Override
    public Object getItem(int i) {
        return manholeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        // inflate the layout for each list row
        if (view == null) {
            view = LayoutInflater.from(mContext).
                    inflate(R.layout.manhole_list_row, viewGroup, false);
        }

        // get current item to be displayed
        Manhole currentDevice = (Manhole) getItem(position);

        // get the TextView for item name and item description
        TextView textViewItemName = (TextView)
                view.findViewById(R.id.device_user_name);
        TextView textViewItemDescription = (TextView)
                view.findViewById(R.id.textLastSeenAgo);
        TextView textTrackName = (TextView)
                view.findViewById(R.id.text_track_name);
        if( textTrackName != null ){

            try {
                textTrackName.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorAllRed));
                textTrackName.setTextColor(ContextCompat.getColor(mContext, R.color.colorWhite));
            }catch (Exception e ){
                //@TODO exception log
                Logger.d(e.getMessage());
            }
        }
        TextView deviceListColorView = (TextView)
                view.findViewById(R.id.deviceListColorView);

        ImageView attentionImageDeviceList = (ImageView)
                view.findViewById(R.id.attentionImageDeviceList);


        ImageView trackDifficultyCircle = (ImageView) view.findViewById(R.id.trackDifficultyCircle);



        //sets the text for item name and item description from the current item object
        textViewItemName.setText(currentDevice.getName());
        textViewItemDescription.setText(currentDevice.getLast_update().toString() +  " mins ago");
        textTrackName.setText(currentDevice.getAddress());

        // returns the view for the current row
        return view;
    }
}
