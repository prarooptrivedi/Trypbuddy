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

import com.example.praroop.trypbuddycom.Customfont.MyTextView_Roboto_Regular;
import com.example.praroop.trypbuddycom.Models.CategoryModel;
import com.example.praroop.trypbuddycom.Models.DataAdd;
import com.example.praroop.trypbuddycom.R;
import com.example.praroop.trypbuddycom.Views.Activity_TripDetails;

import java.util.List;


/**
 * Created by PRAROOP on 26-09-2017.
 */
public class Display_Adpater2 extends RecyclerView.Adapter<Display_Adpater2.MyViewHolder> {
    Activity act;
    private List<DataAdd> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout ll_click,fav;
        TextView tvTitle,tvTitle2,tvTitle3;
        ImageView itemImage;


        public MyViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            ll_click = (LinearLayout) view.findViewById(R.id.ll_click);




        }
    }


    public Display_Adpater2(List<DataAdd> moviesList, Activity act) {
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
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final DataAdd movie = moviesList.get(position);
        holder.tvTitle.setText(movie.getTitle().toString());
        holder.ll_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(act, Activity_TripDetails.class);
                act.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}