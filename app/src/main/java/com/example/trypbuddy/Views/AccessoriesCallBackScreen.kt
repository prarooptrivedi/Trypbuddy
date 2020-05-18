package com.example.trypbuddy.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.meetingschedule.Webservice.ServiceModel
import com.example.trypbuddy.R
import java.util.*

class AccessoriesCallBackScreen : BaseActivity(),View.OnClickListener {


    var serviceModel: ServiceModel = ServiceModel()
    var top_title:TextView?=null
    var top_icon:ImageView?=null
    var tripId:String?=null
    var tripname:String?=null
    var tripdays:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accessories_call_back_screen)
        initViews()
        getIntentValues()
    }

    private fun getIntentValues() {
        tripId = intent.extras!!.getString("TripId", "")
        tripname = intent.extras!!.getString("tripname", "")
        tripdays = intent.extras!!.getString("tripdays", "")

    }

    private fun initViews() {
        top_title=findViewById(R.id.top_title)
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
