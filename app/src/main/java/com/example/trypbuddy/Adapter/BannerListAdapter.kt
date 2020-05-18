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
import com.example.trypbuddy.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.infulate_bannerlist.view.*
import kotlinx.android.synthetic.main.infulate_categorylist.view.*

import java.util.*

/**
 * Created by Chirag on 22-02-2019.
 */
class BannerListAdapter(val arrData: ArrayList<BannerModel.Data>?, var fragmentContext: Activity?,var string: String) : RecyclerView.Adapter<BannerListAdapter.ViewHolder>(), Observer {

    override fun update(o: Observable?, arg: Any?) {
        Log.e("CA", "CA")
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = arrData!![position]

 /*       if (data.banner_type.equals(string)) {*/
            if (!data.banner_image.equals("")) {
                Picasso.with(fragmentContext)
                    .load("http://sampledocs.org/trypbuddy/uploads/" + data.banner_image)
                    /*.placeholder(R.layout.progress_dialog)
                .error(R.layout.progress_dialog)*/
                    .into(holder.bannerimage)
            }
       /* }
        else{
            holder.bannerimage.isVisible=false
            holder.card_banner.isVisible=false
        }*/
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent!!.context)

        val cellForRow = layoutInflater.inflate(R.layout.infulate_bannerlist, parent, false)
        return ViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return arrData!!.size
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
       // var text_attachment=view.text_attachment
        var bannerimage=view.bannerimage
        var card_banner=view.card_banner


    }
}