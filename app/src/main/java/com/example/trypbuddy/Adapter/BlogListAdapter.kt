package com.example.trypbuddy.Adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.trypbuddy.Model.BlogModel
import com.example.trypbuddy.Model.CategoryModel
import com.example.trypbuddy.Model.TripListModel
import com.example.trypbuddy.Presenter.ClickListnerBookMark
import com.example.trypbuddy.Presenter.TripClickListner
import com.example.trypbuddy.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.infulate_bloglist.view.*
import kotlinx.android.synthetic.main.infulate_categorylist.view.*
import kotlinx.android.synthetic.main.infulate_triplist.view.*

import java.util.*

/**
 * Created by Chirag on 22-02-2019.
 */
class BlogListAdapter(val arrData: ArrayList<BlogModel.Data>?, var fragmentContext: Activity?) : RecyclerView.Adapter<BlogListAdapter.ViewHolder>(), Observer {

    override fun update(o: Observable?, arg: Any?) {
        Log.e("CA", "CA")
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = arrData!![position]

        holder?.tv_blogtitle!!.text = data.blog_name
        if (! data.blog_image.equals("")) {
            Picasso.with(fragmentContext!!).load("http://sampledocs.org/trypbuddy/uploads/"+data.blog_image)
                .placeholder(R.drawable.demo)
                .error(R.drawable.demo)
                .into(holder.iv_blogimage)
        }



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent!!.context)

        val cellForRow = layoutInflater.inflate(R.layout.infulate_bloglist, parent, false)
        return ViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return arrData!!.size
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var iv_blogimage=view.iv_blogimage
        var tv_blogtitle=view.tv_blogtitle



    }
}