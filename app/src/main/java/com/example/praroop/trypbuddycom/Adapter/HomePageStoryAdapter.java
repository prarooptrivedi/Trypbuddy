package com.example.praroop.trypbuddycom.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.praroop.trypbuddycom.Customfont.TextViewSFProDisplayMedium;
import com.example.praroop.trypbuddycom.Customfont.TextViewSFProDisplaySemibold;
import com.example.praroop.trypbuddycom.Models.CategoryModel;
import com.example.praroop.trypbuddycom.Models.HomePageStoryModel;
import com.example.praroop.trypbuddycom.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomePageStoryAdapter extends RecyclerView.Adapter<HomePageStoryAdapter.ViewHolder>{
    private Context context;
    private List<CategoryModel> homePageStoryModelList;

    public HomePageStoryAdapter(Context context, List<CategoryModel> homePageStoryModelList) {
        this.context = context;
        this.homePageStoryModelList = homePageStoryModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_page_story_item_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
      //  holder.storyimage.setImageResource(homePageStoryModelList.get(position).getStoryimage());
        holder.nametext.setText(homePageStoryModelList.get(position).getCategory_name());
        if (!homePageStoryModelList.get(position).getCategory_image().equalsIgnoreCase("")) {
            Picasso.with(context).load("http://sampledocs.org/trypbuddy/uploads/"+homePageStoryModelList.get(position).getCategory_image())
                    .placeholder(R.drawable.demo)
                    .error(R.drawable.demo)
                    .into(holder.storyimage);
        }
        ////////////////////////////
        //putting condition to show the marker icon on position 0.......
        /* if (position == 0){
             holder.redcircleimg.setVisibility(View.VISIBLE);
             holder.locationimg.setVisibility(View.VISIBLE);
         }else {
             holder.redcircleimg.setVisibility(View.GONE);
             holder.locationimg.setVisibility(View.GONE);
         }
         if (position == 3 || position == 5 || position == 9 || position == 11){
             holder.offertxt.setVisibility(View.VISIBLE);
         }else {
             holder.offertxt.setVisibility(View.GONE);
         }*/
    }

    @Override
    public int getItemCount() {
        return homePageStoryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView storyimage;
        TextViewSFProDisplaySemibold nametext;
        ImageView redcircleimg,locationimg;
        TextViewSFProDisplayMedium offertxt;
        public ViewHolder(View itemView) {
            super(itemView);

            storyimage = itemView.findViewById(R.id.storyimage);
            nametext = itemView.findViewById(R.id.nametext);
            redcircleimg = itemView.findViewById(R.id.redcircleimg);
            locationimg = itemView.findViewById(R.id.locationimg);
            offertxt = itemView.findViewById(R.id.offertxt);

        }
    }
}
