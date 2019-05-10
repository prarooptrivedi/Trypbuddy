package com.example.praroop.trypbuddycom.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.praroop.trypbuddycom.Customfont.MyTextView_Roboto_Bold;
import com.example.praroop.trypbuddycom.Models.CategoryModel;
import com.example.praroop.trypbuddycom.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by PRAROOP on 26-09-2017.
 */
public class Display_Adpater extends RecyclerView.Adapter<Display_Adpater.MyViewHolder> {
    Activity act;
    private List<CategoryModel> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        CircleImageView iv_profile;

        public MyViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            iv_profile = (CircleImageView) view.findViewById(R.id.iv_profile);




        }
    }


    public Display_Adpater(List<CategoryModel> moviesList, Activity act) {
        this.moviesList = moviesList;
        this.act = act;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.infulate_category, parent, false);
        
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final CategoryModel movie = moviesList.get(position);
        holder.tvTitle.setText(movie.getCategory_name().toString());
        if (!movie.getCategory_image().equalsIgnoreCase("")) {
            Picasso.with(act).load("http://sampledocs.org/trypbuddy/uploads/"+movie.getCategory_image())
                    .placeholder(R.drawable.demo)
                    .error(R.drawable.demo)
                    .into(holder.iv_profile);
        }


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}