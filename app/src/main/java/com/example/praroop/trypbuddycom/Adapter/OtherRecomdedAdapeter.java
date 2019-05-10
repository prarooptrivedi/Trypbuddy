package com.example.praroop.trypbuddycom.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.praroop.trypbuddycom.Customfont.TextViewSFProDisplayBold;
import com.example.praroop.trypbuddycom.Customfont.TextViewSFProDisplayRegular;
import com.example.praroop.trypbuddycom.Customfont.TextViewSFProDisplaySemibold;
import com.example.praroop.trypbuddycom.Models.TripListModel;
import com.example.praroop.trypbuddycom.R;

import java.util.List;


public class OtherRecomdedAdapeter extends RecyclerView.Adapter<OtherRecomdedAdapeter.ViewHolder>{

    private Context context;
    private List<TripListModel> topPicksModelList;

    public OtherRecomdedAdapeter(Context context, List<TripListModel> topPicksModelList) {
        this.context = context;
        this.topPicksModelList = topPicksModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.other_recomm_item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_tripname.setText(topPicksModelList.get(position).getTrip_name());
        holder.tvtrip_fare.setText("₹ "+topPicksModelList.get(position).getTrip_fare());
       /* if (!topPicksModelList.get(position).getTrip_image().equalsIgnoreCase("")) {
            Picasso.with(context).load("http://sampledocs.org/trypbuddy/uploads/"+topPicksModelList.get(position).getTrip_image())
                    .placeholder(R.drawable.demo)
                    .error(R.drawable.demo)
                    .into(holder.otherreommimg);
        }*/

    }

    @Override
    public int getItemCount() {
        return topPicksModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView otherreommimg;
        TextViewSFProDisplaySemibold tv_tripname;
        TextViewSFProDisplayBold tvtrip_fare;
        public ViewHolder(View itemView) {
            super(itemView);

            otherreommimg = itemView.findViewById(R.id.otherreommimg);
            tv_tripname = itemView.findViewById(R.id.tv_tripname);
            tvtrip_fare = itemView.findViewById(R.id.tvtrip_fare);
        }
    }
}
