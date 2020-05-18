package com.example.trypbuddy.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.biz_intelligence.Utils.Utility
import com.example.meetingschedule.Webservice.ServiceModel
import com.example.trypbuddy.Model.RequestContactusModel
import com.example.trypbuddy.Model.RequestModelHome
import com.example.trypbuddy.Model.WishListSubmitModel
import com.example.trypbuddy.R
import java.util.*

class EnquiryScreen : BaseActivity(),View.OnClickListener {

    var edit_name:EditText?=null
    var edit_mobile:EditText?=null
    var edit_email:EditText?=null
    var edit_message:EditText?=null
    var top_title:TextView?=null
    var top_icon:ImageView?=null
    var btn_submit:Button?=null
    var serviceModel: ServiceModel = ServiceModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enquiry_screen)
        initViews()
    }

    private fun initViews() {
        edit_name=findViewById(R.id.edit_name)
        edit_mobile=findViewById(R.id.edit_mobile)
        edit_email=findViewById(R.id.edit_email)
        edit_message=findViewById(R.id.edit_message)
        top_title=findViewById(R.id.top_title)
        btn_submit=findViewById(R.id.btn_submit)
        top_title!!.text="Call Back"
        top_icon=findViewById(R.id.top_icon)
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

                Utility.showToast(this!!, respone.message!!, Toast.LENGTH_SHORT)?.show()
                finish()

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
            sendRequest()
        }
    }
    private fun sendRequest() {
        if (Utility.hasInternet(this!!) == true) {

            val data = RequestContactusModel("FBB9F97DE77C7888DE36E5B74CFF9",edit_email!!.text.toString()
                ,edit_mobile!!.text.toString(),edit_name!!.text.toString(),edit_message!!.text.toString(),"")
            serviceModel!!.doPostRequest(data, "contactus/create.php", this!!)
        } else {
            Utility.showToast(this!!,"No Internet", Toast.LENGTH_SHORT)?.show()
        }
    }
}
