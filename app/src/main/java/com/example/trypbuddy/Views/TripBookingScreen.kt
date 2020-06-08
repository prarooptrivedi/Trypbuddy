package com.example.trypbuddy.Views

import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.biz_intelligence.Utils.Utility
import com.example.meetingschedule.Webservice.ServiceModel
import com.example.trypbuddy.Model.AboutModel
import com.example.trypbuddy.Model.RequestAccessoriesCallBackModel
import com.example.trypbuddy.Model.RequestTripBooking
import com.example.trypbuddy.Model.WishListSubmitModel
import com.example.trypbuddy.R
import org.w3c.dom.Text
import java.util.*

class TripBookingScreen:BaseActivity(),View.OnClickListener {


    var tripId:String?=null
    var tripname:String?=null
    var tripdays:String?=null
    var merchantId:String?=null
    var tripcity:String?=null
    var tripprice:String?=null
    var text_tripname:TextView?=null
    var text_tripdays:TextView?=null
    var text_tripcity:TextView?=null
    var text_tripprice:TextView?=null
    var edit_fromdate:EditText?=null
    var edit_adult:EditText?=null
    var edit_name:EditText?=null
    var edit_mobile:EditText?=null
    var edit_email:EditText?=null
    var btn_frombutton:Button?=null
    var btn_submit:Button?=null
    var serviceModel: ServiceModel = ServiceModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_booking_screen)
        initViews()
        getIntentValues()
    }
    private fun getIntentValues() {
        tripId = intent.extras!!.getString("tripId", "")
        merchantId = intent.extras!!.getString("merchantId", "")
        tripname = intent.extras!!.getString("tripname", "")
        tripdays = intent.extras!!.getString("tripdays", "")
        tripcity = intent.extras!!.getString("tripcity", "")
        tripprice = intent.extras!!.getString("tripprice", "")
        text_tripdays!!.text=tripdays
        text_tripname!!.text=tripname
        text_tripcity!!.text=tripcity
        text_tripprice!!.text=" ₹ "+tripprice+" Per person"
    }
    fun initViews(){
        text_tripname=findViewById(R.id.text_tripname)
        text_tripdays=findViewById(R.id.text_tripdays)
        text_tripcity=findViewById(R.id.text_tripcity)
        text_tripprice=findViewById(R.id.text_tripprice)
        edit_fromdate=findViewById(R.id.edit_fromdate)
        btn_frombutton=findViewById(R.id.btn_frombutton)
        edit_adult=findViewById(R.id.edit_adult)
        edit_name=findViewById(R.id.edit_name)
        edit_mobile=findViewById(R.id.edit_mobile)
        edit_email=findViewById(R.id.edit_email)
        btn_submit=findViewById(R.id.btn_submit)
        btn_submit!!.setOnClickListener(this)
    }
    override fun getModel(): Observable {
        return serviceModel
    }

    override fun update(o: Observable?, arg: Any?) {
        if (arg is WishListSubmitModel) {
            val respone = arg
            if (arg.status.equals("failure")) {


                Utility.showToast(applicationContext!!, respone.message!!, Toast.LENGTH_SHORT)?.show()

            }
            else{
                Utility.showToast(applicationContext!!, respone.message!!, Toast.LENGTH_SHORT)?.show()
            }

        }
    }
    override fun onClick(v: View?) {
        if (v==btn_submit){
            if (Utility.hasInternet(this!!) == true) {
                val data = RequestTripBooking("FBB9F97DE77C7888DE36E5B74CFF9",tripId!!,edit_fromdate!!.text.toString()!!
                    ,edit_fromdate!!.text.toString(),edit_fromdate!!.text.toString(),edit_adult!!.text.toString(),"1",merchantId!!,edit_name!!.text.toString(),
                    edit_email!!.text.toString(),edit_mobile!!.text.toString())
                serviceModel!!.doPostRequest(data, "booking/tripbooking.php", this)
            } else {
                Utility.showToast(this!!,"No Internet", Toast.LENGTH_SHORT)?.show()
            }
        }
    }
}