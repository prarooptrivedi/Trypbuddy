package com.example.trypbuddy.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.biz_intelligence.Utils.Utility
import com.example.meetingschedule.Webservice.ServiceModel
import com.example.trypbuddy.Model.RequestTripCallBackModel
import com.example.trypbuddy.Model.WishListSubmitModel
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
    var merchantId:String?=null
    var edit_fromdate: EditText?=null
    var edit_name: EditText?=null
    var edit_mobile: EditText?=null
    var edit_email: EditText?=null
    var edit_message: EditText?=null
    var btn_frombutton: Button?=null
    var btn_submit: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_call_back_screen)
        initViews()
        getIntentValues()
    }

    private fun getIntentValues() {
        tripId = intent.extras!!.getString("tripId", "")
        merchantId = intent.extras!!.getString("merchantId", "")
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
        btn_frombutton=findViewById(R.id.btn_frombutton)
        edit_name=findViewById(R.id.edit_name)
        edit_mobile=findViewById(R.id.edit_mobile)
        edit_email=findViewById(R.id.edit_email)
        edit_message=findViewById(R.id.edit_message)
        btn_submit=findViewById(R.id.btn_submit)
        edit_fromdate=findViewById(R.id.edit_fromdate)
        edit_fromdate!!.setText("2020-09-09")
        top_icon!!.setOnClickListener(this)
        btn_submit!!.setOnClickListener(this)
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
    }
    override fun onClick(v: View?) {
       if (v==top_icon){
           finish()
       }
        if (v==btn_submit){
            if (Utility.hasInternet(this!!) == true) {
                val data = RequestTripCallBackModel("FBB9F97DE77C7888DE36E5B74CFF9","1",tripId!!,merchantId!!,edit_name!!.text.toString(),edit_fromdate!!.text.toString(),
                    edit_fromdate!!.text.toString(),"",edit_email!!.text.toString(),"0",edit_message!!.text.toString(),edit_mobile!!.text.toString())
                serviceModel!!.doPostRequest(data, "tripcallback/create.php", this)
            } else {
                Utility.showToast(this!!,"No Internet", Toast.LENGTH_SHORT)?.show()
            }
        }
    }
}
