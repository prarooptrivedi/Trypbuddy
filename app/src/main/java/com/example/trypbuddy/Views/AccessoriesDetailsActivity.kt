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
    var top_title:TextView?=null
    var text_name:TextView?=null
    var tv_description:TextView?=null
    var tv_perday:TextView?=null
var top_icon:ImageView?=null
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
        top_icon!!.setOnClickListener(this)
        ll_callback!!.setOnClickListener(this)
    }

    private fun getIntentValues() {
      val  name = intent.extras!!.getString("isGroup", "")
      val  description = intent.extras!!.getString("description", "")
      val  price = intent.extras!!.getString("price", "")
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
            intent.putExtra("tripId","")
            intent.putExtra("tripname","")
            intent.putExtra("tripdays","")
            startActivity(intent)
        }
    }
}
