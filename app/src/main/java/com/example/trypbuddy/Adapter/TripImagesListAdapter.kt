package com.example.trypbuddy.Adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.trypbuddy.Model.BannerModel
import com.example.trypbuddy.Model.CategoryModel
import com.example.trypbuddy.Model.TripDetailsModel
import com.example.trypbuddy.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.infulate_bannerlist.view.*
import kotlinx.android.synthetic.main.infulate_categorylist.view.*

import java.util.*

/**
 * Created by Chirag on 22-02-2019.
 */
class TripImagesListAdapter(val arrData: ArrayList<TripDetailsModel.images>?, var fragmentContext: Activity?) : RecyclerView.Adapter<TripImagesListAdapter.ViewHolder>(), Observer {
        var int:Int?=null
    override fun update(o: Observable?, arg: Any?) {
        Log.e("CA", "CA")
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = arrData!![position]


        if (!data.trip_image.equals("")) {
            Picasso.with(fragmentContext).load("http://sampledocs.org/trypbuddy/uploads/"+data.trip_image)
                /*.placeholder(R.layout.progress_dialog)
                .error(R.layout.progress_dialog)*/
                .into(holder.bannerimage)
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent!!.context)

        val cellForRow = layoutInflater.inflate(R.layout.infulate_tripbannerlist, parent, false)
        return ViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return arrData!!.size
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
       // var text_attachment=view.text_attachment
        var bannerimage=view.bannerimage


    }
}