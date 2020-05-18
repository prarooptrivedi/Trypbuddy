package com.example.trypbuddy.Adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.trypbuddy.Model.AccessoriesProductModel
import com.example.trypbuddy.Model.CategoryModel
import com.example.trypbuddy.Model.TripListModel
import com.example.trypbuddy.Presenter.AccessoriesClickListner
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
class AccessoriesListAdapter(val arrData: ArrayList<AccessoriesProductModel.Data>?, var fragmentContext: Activity?, val tripClickListner: AccessoriesClickListner) : RecyclerView.Adapter<AccessoriesListAdapter.ViewHolder>(), Observer {

    override fun update(o: Observable?, arg: Any?) {
        Log.e("CA", "CA")
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = arrData!![position]

        holder?.tv_tripprice!!.text = "₹ "+data.price_perday+" "+"Per Day"
        holder?.tv_tripname!!.text = data.product_name
        holder?.tv_tripcity.isVisible=false
        holder?.ic_bookmark.isVisible=false
        //holder?.tv_tripcity!!.text = data.city_name
        if (! data.product_image1.equals("")) {
            Picasso.with(fragmentContext!!).load("http://sampledocs.org/trypbuddy/uploads/"+data.product_image1)
                .placeholder(R.drawable.demo)
                .error(R.drawable.demo)
                .into(holder.iv_tripimage)
        }
        holder?.ll_click.setOnClickListener(View.OnClickListener {
            tripClickListner.TripClick(data.id!!,data.product_name!!,data.product_description!!,data.price_perday!!)
        })
      /*  if (data.wishlist.equals("1")){
            holder.iv_wishlist1.isVisible=true
            holder.iv_wishlist.isVisible=false
        }
        else{
            holder.iv_wishlist1.isVisible=false
            holder.iv_wishlist.isVisible=true
        }*/
        /*holder?.iv_wishlist.setOnClickListener(View.OnClickListener {
           clickListnerBookMark.bookMarkClick(data.id!!,data.merchant_id!!,"1")
        })
        holder?.iv_wishlist1.setOnClickListener(View.OnClickListener {
            clickListnerBookMark.bookMarkClick(data.id!!,data.merchant_id!!,"0")
        })*/

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
        var iv_wishlist=view.iv_wishlist
        var iv_wishlist1=view.iv_wishlist1


    }
}