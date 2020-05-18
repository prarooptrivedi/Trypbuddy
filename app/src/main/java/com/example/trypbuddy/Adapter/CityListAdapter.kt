package com.example.trypbuddy.Adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.trypbuddy.Model.CategoryModel
import com.example.trypbuddy.Model.CityListModel
import com.example.trypbuddy.Presenter.CityClickListner
import com.example.trypbuddy.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.infulate_categorylist.view.*
import kotlinx.android.synthetic.main.infulate_citylist.view.*

import java.util.*

/**
 * Created by Chirag on 22-02-2019.
 */
class CityListAdapter(val arrData: ArrayList<CityListModel.Data>?, var fragmentContext: Activity?,var cityClickListner: CityClickListner) : RecyclerView.Adapter<CityListAdapter.ViewHolder>(), Observer {

    override fun update(o: Observable?, arg: Any?) {
        Log.e("CA", "CA")
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = arrData!![position]

        holder?.text_cityname!!.text = data.city_name
        holder?.text_tripcount!!.text = data.nooftrips+" Listing"
        if (! data.city_image.equals("")) {
            Picasso.with(fragmentContext).load("http://sampledocs.org/trypbuddy/uploads/"+data.city_image)
               /* .placeholder(R.drawable.demo)
                .error(R.drawable.demo)*/
                .into(holder.cityimage)
        }
        holder.card_city.setOnClickListener(View.OnClickListener {
            cityClickListner.cityClick(data.id!!,data.city_name!!)
        })
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent!!.context)

        val cellForRow = layoutInflater.inflate(R.layout.infulate_citylist, parent, false)
        return ViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return arrData!!.size
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
       // var text_attachment=view.text_attachment
        var text_cityname=view.text_cityname
        var cityimage=view.cityimage
        var text_tripcount=view.text_tripcount
        var card_city=view.card_city


    }
}