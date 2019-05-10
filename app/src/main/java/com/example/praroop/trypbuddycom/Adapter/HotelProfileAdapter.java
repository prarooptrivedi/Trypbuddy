package com.example.praroop.trypbuddycom.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.praroop.trypbuddycom.Customfont.TextViewSFProDisplayMedium;
import com.example.praroop.trypbuddycom.Models.HotelProfileModel;
import com.example.praroop.trypbuddycom.R;

import java.util.List;


public class HotelProfileAdapter extends RecyclerView.Adapter<HotelProfileAdapter.ViewHolder>{

    private Context context;
    private List<HotelProfileModel> hotelProfileModelList;

    public HotelProfileAdapter(Context context, List<HotelProfileModel> hotelProfileModelList) {
        this.context = context;
        this.hotelProfileModelList = hotelProfileModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_profile_item_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.hpimg.setImageResource(hotelProfileModelList.get(position).getHpimg());
        holder.hpname.setText(hotelProfileModelList.get(position).getHpname());
        holder.hpnotxt.setText(hotelProfileModelList.get(position).getHpnotxt());
    }

    @Override
    public int getItemCount() {
        return hotelProfileModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hpimg;
        TextViewSFProDisplayMedium hpname,hpnotxt;
        public ViewHolder(View itemView) {
            super(itemView);

            hpimg = itemView.findViewById(R.id.hpimg);
            hpname = itemView.findViewById(R.id.hpname);
            hpnotxt = itemView.findViewById(R.id.hpnotxt);
        }
    }
}
