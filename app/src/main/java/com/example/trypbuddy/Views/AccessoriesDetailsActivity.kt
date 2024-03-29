package com.example.trypbuddy.Views

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.trypbuddy.R

class AccessoriesDetailsActivity : AppCompatActivity(), View.OnClickListener {


    var ll_callback:LinearLayout?=null
    var ll_accessoriesBooking:LinearLayout?=null
    var top_title:TextView?=null
    var text_name:TextView?=null
    var tv_description:TextView?=null
    var tv_perday:TextView?=null
    var top_icon:ImageView?=null
    var latitude:String?=null
    var longitude:String?=null
    var merchantid:String?=null
    var description:String?=null
    var price:String?=null
    var name:String?=null
    var id:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accessories_details)
        initViews()
        getIntentValues()
    }

    private fun initViews() {
        top_title=findViewById(R.id.top_title)
        ll_callback=findViewById(R.id.ll_callback)
        text_name=findViewById(R.id.text_name)
        tv_description=findViewById(R.id.tv_description)
        tv_perday=findViewById(R.id.tv_perday)
        top_icon=findViewById(R.id.top_icon)
        ll_accessoriesBooking=findViewById(R.id.ll_accessoriesBooking)
        top_icon!!.setOnClickListener(this)
        ll_callback!!.setOnClickListener(this)
        ll_accessoriesBooking!!.setOnClickListener(this)
    }

    private fun getIntentValues() {
        name = intent.extras!!.getString("productname", "")
        description = intent.extras!!.getString("description", "")
        price = intent.extras!!.getString("price", "")
        latitude = intent.extras!!.getString("latitude")
        longitude = intent.extras!!.getString("longitude")
        merchantid = intent.extras!!.getString("merchantid")
        id = intent.extras!!.getString("id")
        top_title!!.setText(name)
        text_name!!.setText(name)
        tv_perday!!.setText("₹ "+price+" Price Per day")
        val descriptions = Html.fromHtml(description)
        tv_description!!.setText(descriptions)
    }
    override fun onClick(v: View?) {
        if (v==top_icon){
            finish()
        }
        if (v==ll_callback){
            val intent= Intent(this,AccessoriesCallBackScreen::class.java)
            intent.putExtra("id",id)
            intent.putExtra("name",name)
            intent.putExtra("price",price)
            intent.putExtra("merchantid",merchantid)
            startActivity(intent)
        }
        if (v==ll_accessoriesBooking){
            val intent= Intent(this,AccessoriesBookingScreen::class.java)
            intent.putExtra("id",id)
            intent.putExtra("name",name)
            intent.putExtra("price",price)
            intent.putExtra("merchantid",merchantid)
            startActivity(intent)
        }

    }
}
