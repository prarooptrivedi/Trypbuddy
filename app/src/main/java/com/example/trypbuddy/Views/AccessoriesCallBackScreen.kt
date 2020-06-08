package com.example.trypbuddy.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.biz_intelligence.Utils.Utility
import com.example.meetingschedule.Webservice.ServiceModel
import com.example.trypbuddy.Model.RequestAccessoriesCallBackModel
import com.example.trypbuddy.Model.RequestModelHome
import com.example.trypbuddy.Model.RequestTripCallBackModel
import com.example.trypbuddy.Model.WishListSubmitModel
import com.example.trypbuddy.R
import java.util.*

class AccessoriesCallBackScreen : BaseActivity(),View.OnClickListener {


    var serviceModel: ServiceModel = ServiceModel()
    var top_title:TextView?=null
    var text_accessoriesname:TextView?=null
    var text_price:TextView?=null
    var top_icon:ImageView?=null
    var id:String?=null
    var merchantid:String?=null
    var name:String?=null
    var price:String?=null
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
        getIntentValues()
        initViews()

    }

    private fun getIntentValues() {
        id = intent.extras!!.getString("id", "")
        name = intent.extras!!.getString("name", "")
        price = intent.extras!!.getString("price", "")
        merchantid = intent.extras!!.getString("merchantid", "")

    }

    private fun initViews() {
        top_title=findViewById(R.id.top_title)
        text_accessoriesname=findViewById(R.id.text_accessoriesname)
        text_price=findViewById(R.id.text_price)
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
        text_accessoriesname!!.setText(name)
        text_price!!.setText("₹ "+price+" Price Per day")
    }

    override fun getModel(): Observable {
        return serviceModel
    }

    override fun update(o: Observable?, arg: Any?) {
        if (arg is WishListSubmitModel) {
            if (arg.status.equals("failure")) {
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
        if (v==btn_submit){
            if (Utility.hasInternet(this!!) == true) {
                val data = RequestAccessoriesCallBackModel("FBB9F97DE77C7888DE36E5B74CFF9","1",id!!,merchantid!!,edit_fromdate!!.text.toString(),edit_fromdate!!.text.toString(),
                  edit_name!!.text.toString(),edit_email!!.text.toString(),edit_message!!.text.toString(),edit_mobile!!.text.toString())
                serviceModel!!.doPostRequest(data, "productaccessoriescallback/create.php", this)
            } else {
                Utility.showToast(this!!,"No Internet", Toast.LENGTH_SHORT)?.show()
            }
        }

    }
}
