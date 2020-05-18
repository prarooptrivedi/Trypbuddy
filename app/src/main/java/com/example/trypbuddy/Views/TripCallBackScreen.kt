package com.example.trypbuddy.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.meetingschedule.Webservice.ServiceModel
import com.example.trypbuddy.R
import java.util.*

class TripCallBackScreen : BaseActivity(),View.OnClickListener {


    var serviceModel: ServiceModel = ServiceModel()
    var top_title:TextView?=null
    var text_tripname:TextView?=null
    var text_tripdays:TextView?=null
    var top_icon:ImageView?=null
    var tripId:String?=null
    var tripname:String?=null
    var tripdays:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_call_back_screen)
        initViews()
        getIntentValues()
    }

    private fun getIntentValues() {
        tripId = intent.extras!!.getString("TripId", "")
        tripname = intent.extras!!.getString("tripname", "")
        tripdays = intent.extras!!.getString("tripdays", "")
        text_tripdays!!.text=tripdays
        text_tripname!!.text=tripname
    }

    private fun initViews() {
        text_tripname=findViewById(R.id.text_tripname)
        top_title=findViewById(R.id.top_title)
        text_tripdays=findViewById(R.id.text_tripdays)
        top_icon=findViewById(R.id.top_icon)
        top_icon!!.setOnClickListener(this)
        top_title!!.text="Request Call Back"
    }

    override fun getModel(): Observable {
        return serviceModel
    }

    override fun update(o: Observable?, arg: Any?) {

    }
    override fun onClick(v: View?) {
       if (v==top_icon){
           finish()
       }
    }
}
