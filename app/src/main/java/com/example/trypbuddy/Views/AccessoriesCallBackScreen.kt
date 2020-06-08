package com.example.trypbuddy.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.biz_intelligence.Utils.Utility
import com.example.meetingschedule.Webservice.ServiceModel
import com.example.trypbuddy.Model.RequestModelHome
import com.example.trypbuddy.Model.RequestTripCallBackModel
import com.example.trypbuddy.Model.WishListSubmitModel
import com.example.trypbuddy.R
import java.util.*

class AccessoriesCallBackScreen : BaseActivity(),View.OnClickListener {


    var serviceModel: ServiceModel = ServiceModel()
    var top_title:TextView?=null
    var top_icon:ImageView?=null
    var tripId:String?=null
    var merchantId:String?="1"
    var tripname:String?=null
    var tripdays:String?=null
    var edit_fromdate:EditText?=null
    var edit_name:EditText?=null
    var edit_mobile:EditText?=null
    var edit_email:EditText?=null
    var edit_message:EditText?=null
    var btn_frombutton:Button?=null
    var btn_submit:Button?=null



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
        edit_fromdate=findViewById(R.id.edit_fromdate)
        top_icon=findViewById(R.id.top_icon)
        btn_frombutton=findViewById(R.id.btn_frombutton)
        edit_name=findViewById(R.id.edit_name)
        edit_mobile=findViewById(R.id.edit_mobile)
        edit_email=findViewById(R.id.edit_email)
        edit_message=findViewById(R.id.edit_message)
        btn_submit=findViewById(R.id.btn_submit)
        edit_fromdate!!.setText("2020-09-09")
        top_icon!!.setOnClickListener(this)
        btn_submit!!.setOnClickListener(this)
        top_title!!.text="Request Call Back"
    }

    override fun getModel(): Observable {
        return serviceModel
    }

    override fun update(o: Observable?, arg: Any?) {
        if (arg is WishListSubmitModel) {
            if (arg.status.equals("success")) {
                val respone = arg

                Utility.showToast(applicationContext!!, respone.message!!, Toast.LENGTH_SHORT)?.show()

            }

        }
        else{

        }
    }
    override fun onClick(v: View?) {
        if (v==top_icon){
            finish()
        }

    }
}
