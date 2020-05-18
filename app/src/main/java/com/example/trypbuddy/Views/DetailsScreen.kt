package com.example.trypbuddy.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.trypbuddy.R
import org.w3c.dom.Text

class DetailsScreen : AppCompatActivity() {
var tv_details:TextView?=null
var top_title:TextView?=null
var top_icon:ImageView?=null
    var details:String?=null
    var name:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_screen)
        initViews()
        getIntentValues()
    }

    private fun initViews() {
        tv_details=findViewById(R.id.tv_details)
        top_title=findViewById(R.id.top_title)
        top_icon=findViewById(R.id.top_icon)
        top_icon!!.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
    private fun getIntentValues() {
        details = intent.extras!!.getString("details", "")
        name = intent.extras!!.getString("name", "")
        val detail = Html.fromHtml(details)
        tv_details!!.text=detail
        top_title!!.text=name
    }
}
