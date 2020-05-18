package com.example.trypbuddy.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.biz_intelligence.Utils.Utility
import com.example.meetingschedule.Webservice.ServiceModel
import com.example.trypbuddy.Adapter.TripListAdapter
import com.example.trypbuddy.Adapter.WishListAdapter
import com.example.trypbuddy.Model.AboutModel
import com.example.trypbuddy.Model.RequestModelHome
import com.example.trypbuddy.Model.RequestWishlistModel
import com.example.trypbuddy.Model.WishListModel
import com.example.trypbuddy.R
import java.util.*

class WishListScreen : BaseActivity(),View.OnClickListener {

    var serviceModel:ServiceModel= ServiceModel()
    var top_icon:ImageView?=null
    var top_title:TextView?=null
    var rv_trips:RecyclerView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wish_list_screen)
        initViews()
        sendRequest()
    }

    private fun initViews() {
        top_icon=findViewById(R.id.top_icon)
        top_icon!!.setOnClickListener(this)
        top_title=findViewById(R.id.top_title)
        rv_trips=findViewById(R.id.rv_trips)
        top_title!!.text="WishList"
    }

    override fun getModel(): Observable {
       return serviceModel
    }

    override fun update(o: Observable?, arg: Any?) {
        if (arg is WishListModel) {
            if (arg.status.equals("success")) {
                val respone = arg
                rv_trips!!.visibility = View.VISIBLE
                rv_trips!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                rv_trips!!.adapter = WishListAdapter(respone.data!!,this)
            }
        }
    }

    private fun sendRequest() {
        if (Utility.hasInternet(this!!) == true) {
            val data = RequestWishlistModel("FBB9F97DE77C7888DE36E5B74CFF9","1")
            serviceModel!!.doPostRequest(data, "wishlist/listtrip.php", this!!)
        } else {
            Utility.showToast(this!!,"No Internet", Toast.LENGTH_SHORT)?.show()
        }


    }
    override fun onClick(v: View?) {
       if (v==top_icon){
           finish()
       }
    }

}
