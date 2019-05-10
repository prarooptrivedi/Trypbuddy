package com.example.praroop.trypbuddycom.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.praroop.trypbuddycom.Customfont.MyTextView_Roboto_Regular;
import com.example.praroop.trypbuddycom.Models.CategoryModel;
import com.example.praroop.trypbuddycom.Models.TripListModel;
import com.example.praroop.trypbuddycom.R;
import com.example.praroop.trypbuddycom.Views.Activity_TripDetails;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by PRAROOP on 26-09-2017.
 */
public class DisplayList_Adpater extends RecyclerView.Adapter<DisplayList_Adpater.MyViewHolder> {
    Activity act;
    private List<TripListModel> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvdays;
        MyTextView_Roboto_Regular tv_fare,tv_Noofseat;
        ImageView itemImage;
        LinearLayout ll_click;

        public MyViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvdays = (TextView) view.findViewById(R.id.tvdays);
            itemImage = (ImageView) view.findViewById(R.id.itemImage);
            ll_click = (LinearLayout) view.findViewById(R.id.ll_click);
            tv_fare = (MyTextView_Roboto_Regular) view.findViewById(R.id.tv_fare);
            tv_Noofseat = (MyTextView_Roboto_Regular) view.findViewById(R.id.tv_Noofseat);
            tv_Noofseat.setVisibility(View.GONE);




        }
    }


    public DisplayList_Adpater(List<TripListModel> moviesList, Activity act) {
        this.moviesList = moviesList;
        this.act = act;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.infulate_list, parent, false);
        
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final TripListModel movie = moviesList.get(position);
        if(moviesList.get(position).getForgroup().equalsIgnoreCase("0")){
            holder.ll_click.setVisibility(View.VISIBLE);
        }
        else {
            holder.ll_click.setVisibility(View.GONE);
        }
        holder.ll_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(act, Activity_TripDetails.class);
                i.putExtra("id",moviesList.get(position).getId());
                act.startActivity(i);
            }
        });
        try {
            holder.tvTitle.setText(movie.getTrip_name().toString());
            holder.tvdays.setText(movie.getTrip_days().toString());
            holder.tv_fare.setText(movie.getTrip_fare().toString().replace(".00","")+"  / per person");
            holder.tv_Noofseat.setText("No. of seat   "+"30");
            if (!movie.getTrip_image().equalsIgnoreCase("")) {
                Picasso.with(act).load("http://sampledocs.org/trypbuddy/uploads/"+movie.getTrip_image())
                        .placeholder(R.drawable.demo)
                        .error(R.drawable.demo)
                        .into(holder.itemImage);
            }
        }
       catch (Exception e){
            e.printStackTrace();
       }


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}