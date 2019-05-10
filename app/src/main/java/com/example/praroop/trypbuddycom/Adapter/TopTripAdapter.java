package com.example.praroop.trypbuddycom.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.praroop.trypbuddycom.Customfont.TextViewSFProDisplayHeavy;
import com.example.praroop.trypbuddycom.Customfont.TextViewSFProDisplayMedium;
import com.example.praroop.trypbuddycom.Customfont.TextViewSFProDisplayRegular;
import com.example.praroop.trypbuddycom.Models.TripListModel;
import com.example.praroop.trypbuddycom.R;
import com.example.praroop.trypbuddycom.Views.HotelProfile;
import com.squareup.picasso.Picasso;

import java.util.List;


public class TopTripAdapter extends RecyclerView.Adapter<TopTripAdapter.ViewHolder>{

    private Context context;
    private List<TripListModel> topPicksModelList;

    public TopTripAdapter(Context context, List<TripListModel> topPicksModelList) {
        this.context = context;
        this.topPicksModelList = topPicksModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_picks_item_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv_tripname.setText(topPicksModelList.get(position).getTrip_name());
        holder.tv_tripprice.setText("₹ "+topPicksModelList.get(position).getTrip_fare());
        if (!topPicksModelList.get(position).getTrip_image().equalsIgnoreCase("")) {
            Picasso.with(context).load("http://sampledocs.org/trypbuddy/uploads/"+topPicksModelList.get(position).getTrip_image())
                    .placeholder(R.drawable.demo)
                    .error(R.drawable.demo)
                    .into(holder.toppicksimg);
        }
        holder.ll_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, HotelProfile.class);
                i.putExtra("id",topPicksModelList.get(position).getId());
                context.startActivity(i);
            }
        });
       /* holder.toppicksname.setText(topPicksModelList.get(position).getName());
        holder.toppicksplace.setText(topPicksModelList.get(position).getPlace());
        holder.toppicksprice.setText(topPicksModelList.get(position).getPrice());
        holder.ll_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, HotelProfile.class);
                context.startActivity(i);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return topPicksModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView toppicksimg;
        LinearLayout ll_click;
        TextViewSFProDisplayMedium tv_tripname;
        TextViewSFProDisplayRegular tv_tripcity;
        TextViewSFProDisplayHeavy tv_tripprice;

        public ViewHolder(View itemView) {
            super(itemView);

            ll_click = itemView.findViewById(R.id.ll_click);
            toppicksimg = itemView.findViewById(R.id.toppicksimg);
            tv_tripname = itemView.findViewById(R.id.tv_tripname);
            tv_tripcity = itemView.findViewById(R.id.tv_tripcity);
            tv_tripprice = itemView.findViewById(R.id.tv_tripprice);

        }
    }
}
