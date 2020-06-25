package com.example.trypbuddy.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.*
import com.example.biz_intelligence.Utils.Utility
import com.example.meetingschedule.Webservice.ServiceModel
import com.example.trypbuddy.Model.RequestAccessoriesBooking
import com.example.trypbuddy.Model.RequestTripBooking
import com.example.trypbuddy.Model.WishListSubmitModel
import com.example.trypbuddy.R
import org.w3c.dom.Text
import java.util.*

class AccessoriesBookingScreen : BaseActivity(),View.OnClickListener {


    var id:String?=null
    var name:String?=null
    var price:String?=null
    var merchantid:String?=null
    var text_accessoriesname:TextView?=null
    var text_price:TextView?=null
    var top_title:TextView?=null
    var top_icon: ImageView?=null
    var edit_fromdate: EditText?=null
    var edit_name: EditText?=null
    var edit_mobile: EditText?=null
    var edit_email: EditText?=null
    var btn_submit: Button?=null
    var serviceModel: ServiceModel = ServiceModel()
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accessories_booking_screen)


        initView()
        getIntentValues()
    }
    fun initView(){
        text_accessoriesname=findViewById(R.id.text_accessoriesname)
        edit_fromdate=findViewById(R.id.edit_fromdate)
        text_price=findViewById(R.id.text_price)
        top_title=findViewById(R.id.top_title)
        top_icon=findViewById(R.id.top_icon)
        edit_name=findViewById(R.id.edit_name)
        edit_mobile=findViewById(R.id.edit_mobile)
        edit_email=findViewById(R.id.edit_email)
        btn_submit=findViewById(R.id.btn_submit)
        btn_submit!!.setOnClickListener(this)
    }

    fun getIntentValues() {
        name = intent.extras!!.getString("name", "")
        price = intent.extras!!.getString("price", "")
        merchantid = intent.extras!!.getString("merchantid")
        id = intent.extras!!.getString("id")
        text_price!!.setText("₹ "+price+" Price Per day")
        text_accessoriesname!!.setText(name)
        top_title!!.text="Accessories Booking"
    }
    override fun onClick(v: View?) {
        if (v==top_icon){
            finish()
        }
        if (v==btn_submit){
            if (Utility.hasInternet(this!!) == true) {
                val data = RequestAccessoriesBooking("FBB9F97DE77C7888DE36E5B74CFF9",id!!,edit_fromdate!!.text.toString()!!
                    ,edit_fromdate!!.text.toString(),edit_fromdate!!.text.toString(),"1",merchantid!!,edit_name!!.text.toString(),
                    edit_email!!.text.toString(),edit_mobile!!.text.toString())
                serviceModel!!.doPostRequest(data, "booking/productaccessoriesbooking.php", this)
            } else {
                Utility.showToast(this!!,"No Internet", Toast.LENGTH_SHORT)?.show()
            }
        }
    }
}
