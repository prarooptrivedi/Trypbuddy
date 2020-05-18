package com.example.trypbuddy.Adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.trypbuddy.Model.CategoryModel
import com.example.trypbuddy.Presenter.CategoryClick
import com.example.trypbuddy.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.infulate_categorylist.view.*

import java.util.*

/**
 * Created by Chirag on 22-02-2019.
 */
class CategoryListAdapter(val arrData: ArrayList<CategoryModel.Data>?, var fragmentContext: Activity?,var categoryClick: CategoryClick) : RecyclerView.Adapter<CategoryListAdapter.ViewHolder>(), Observer {

    override fun update(o: Observable?, arg: Any?) {
        Log.e("CA", "CA")
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = arrData!![position]

        holder?.text_category!!.text = data.category_name
        if (! data.category_image.equals("")) {
            Picasso.with(fragmentContext).load("http://sampledocs.org/trypbuddy/uploads/"+data.category_image)
               /* .placeholder(R.drawable.demo)
                .error(R.drawable.demo)*/
                .into(holder.iv_categoryimage)
        }
        holder?.card_category.setOnClickListener(View.OnClickListener {
            categoryClick.categeoryClick(data.id!!)
        })
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent!!.context)

        val cellForRow = layoutInflater.inflate(R.layout.infulate_categorylist, parent, false)
        return ViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return arrData!!.size
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
       // var text_attachment=view.text_attachment
        var text_category=view.text_category
        var iv_categoryimage=view.iv_categoryimage
        var card_category=view.card_category


    }
}