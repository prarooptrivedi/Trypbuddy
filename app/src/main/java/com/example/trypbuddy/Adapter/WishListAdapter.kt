package com.example.trypbuddy.Adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.trypbuddy.Model.CategoryModel
import com.example.trypbuddy.Model.TripListModel
import com.example.trypbuddy.Model.WishListModel
import com.example.trypbuddy.Presenter.ClickListnerBookMark
import com.example.trypbuddy.Presenter.TripClickListner
import com.example.trypbuddy.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.infulate_categorylist.view.*
import kotlinx.android.synthetic.main.infulate_triplist.view.*

import java.util.*

/**
 * Created by Chirag on 22-02-2019.
 */
class WishListAdapter(val arrData: ArrayList<WishListModel.Data>?, var fragmentContext: Activity?) : RecyclerView.Adapter<WishListAdapter.ViewHolder>(), Observer {

    override fun update(o: Observable?, arg: Any?) {
        Log.e("CA", "CA")
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = arrData!![position]

        holder?.tv_tripprice!!.text = "₹ "+data.trip_fare
        holder?.tv_tripname!!.text = data.trip_name
        holder?.tv_tripcity!!.text = data.city_name
        if (! data.trip_image.equals("")) {
            Picasso.with(fragmentContext!!).load("http://sampledocs.org/trypbuddy/uploads/"+data.trip_image)
                .placeholder(R.drawable.demo)
                .error(R.drawable.demo)
                .into(holder.iv_tripimage)
        }
        holder?.ll_click.setOnClickListener(View.OnClickListener {
          //  tripClickListner.TripClick(data.id!!,data.forgroup!!)
        })
        holder?.ic_bookmark.setOnClickListener(View.OnClickListener {
          //  clickListnerBookMark.bookMarkClick(data.id,data.m)
        })

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent!!.context)

        val cellForRow = layoutInflater.inflate(R.layout.infulate_triplist, parent, false)
        return ViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return arrData!!.size
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
       // var text_attachment=view.text_attachment
        var tv_tripprice=view.tv_tripprice
        var iv_tripimage=view.iv_tripimage
        var tv_tripname=view.tv_tripname
        var tv_tripcity=view.tv_tripcity
        var ll_click=view.ll_click
        var ic_bookmark=view.ic_bookmark


    }
}