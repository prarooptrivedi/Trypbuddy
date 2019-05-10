package com.example.praroop.trypbuddycom.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.praroop.trypbuddycom.Models.PaymentModelClass;
import com.example.praroop.trypbuddycom.R;

import java.util.List;


public class PaymentRecycleAdapter extends RecyclerView.Adapter<PaymentRecycleAdapter.MyViewHolder>{

    Context context;


    private List<PaymentModelClass> OfferList;

    int myPos = 0;


    public class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView imageView;

        TextView title;


        public MyViewHolder(View view) {
            super(view);

            title=(TextView)view.findViewById(R.id.title);
            imageView = (ImageView)view.findViewById(R.id.image);


        }

    }


    public PaymentRecycleAdapter(Context context, List<PaymentModelClass> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public PaymentRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_payment_list, parent, false);


        return new PaymentRecycleAdapter.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final  int position) {
        final PaymentModelClass lists = OfferList.get(position);
        holder.title.setText(lists.getTitle());
        holder.imageView.setImageResource(lists.getImage());


        if (myPos == position){
            holder.title.setTextColor(Color.parseColor("#2ba7b7"));

          //  holder.imageView.setImageResource(Color.parseColor(#00000));
        }else {

            holder.title.setTextColor(Color.parseColor("#898a8c"));
           // holder.imageView.setImageResource(R.drawable.ic_credit_gray);
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPos = position;
                notifyDataSetChanged();

            }


        });



    }



    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}


