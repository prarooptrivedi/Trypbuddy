package com.example.trypbuddy.Views

import android.content.Intent
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
import com.example.trypbuddy.Model.*
import com.example.trypbuddy.Presenter.ClickListnerBookMark
import com.example.trypbuddy.Presenter.ClickListnerWishList
import com.example.trypbuddy.Presenter.TripClickListner
import com.example.trypbuddy.R
import java.util.*

class CityWiseTripScreen : BaseActivity(),TripClickListner,ClickListnerBookMark,
    ClickListnerWishList {
   var tripClickListner:TripClickListner?=null
   var clickListnerBookMark:ClickListnerBookMark?=null
    var  top_icon:ImageView?=null
    var clickListnerWishList:ClickListnerWishList?=null
    var serviceModel: ServiceModel = ServiceModel()
    var rv_trips:RecyclerView?=null
    var city_Id:String?=null
    var city_name:String?=null
    var top_title:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_wise_trip_screen)
        tripClickListner=this as TripClickListner
        clickListnerBookMark=this as ClickListnerBookMark
        clickListnerWishList=this as ClickListnerWishList
        getIntentValues()
        initViews()
        sendRequest()
    }
    private fun getIntentValues() {
        //tripId = intent.extras!!.getString("TripId", "")
        city_Id = intent.extras!!.getString("city_Id", "")
        city_name = intent.extras!!.getString("city_name", "")
    }


    private fun initViews() {
        rv_trips=findViewById(R.id.rv_trips)
        top_icon=findViewById(R.id.top_icon)
        top_title=findViewById(R.id.top_title)
        top_title!!.setText(city_name)
        top_icon!!.setOnClickListener(View.OnClickListener {
            finish()

        })
    }

    override fun getModel(): Observable {
       return serviceModel
    }

    override fun update(o: Observable?, arg: Any?) {
        if (arg is TripListModel) {
            if (arg.status.equals("success")) {
                val respone = arg
                rv_trips!!.visibility = View.VISIBLE
                rv_trips!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                rv_trips!!.adapter = TripListAdapter(respone.data!!,this,tripClickListner!!,clickListnerBookMark!!,clickListnerWishList!!)


            }
            else{
                rv_trips!!.visibility = View.GONE
            }
        }
        if (arg is WishListSubmitModel) {
            if (arg.status.equals("success")) {
                val respone = arg
                Utility.showToast(this!!, respone.message!!, Toast.LENGTH_SHORT)?.show()

            }

        }
    }

    private fun sendRequest() {
        if (Utility.hasInternet(this!!) == true) {
            /*val stringHashMap = HashMap<String, String>()
            stringHashMap.put("token","FBB9F97DE77C7888DE36E5B74CFF9")*/
            val data = RequestTripCityModel("FBB9F97DE77C7888DE36E5B74CFF9",city_Id!!)
            serviceModel!!.doPostRequest(data, "city/listcitytrips.php", this!!)
        } else {
            Utility.showToast(this!!,"No Internet", Toast.LENGTH_SHORT)?.show()
        }


    }
    override fun TripClick(id: String, isGroup: String) {
        val  intent= Intent(this,TripDetailScreen::class.java)
        intent.putExtra("TripId",id)
        intent.putExtra("isGroup",isGroup)
        startActivity(intent)
    }

    override fun bookMarkClick(tripId: String, merchantId: String, status: String,type:String) {
        if (Utility.hasInternet(this!!) == true) {
            /*val stringHashMap = HashMap<String, String>()
            stringHashMap.put("token","FBB9F97DE77C7888DE36E5B74CFF9")*/
            val data = RequestWishlistSubmitModel("FBB9F97DE77C7888DE36E5B74CFF9","1",tripId,merchantId,status,type)
            serviceModel!!.doPostRequest(data, "wishlist/create.php", this!!)
        } else {
            Utility.showToast(this!!,"No Internet", Toast.LENGTH_SHORT)?.show()
        }
    }
    override fun wishListClick(tripId: String, merchantId: String, status: String, type: String) {
        if (Utility.hasInternet(this!!) == true) {
            /*val stringHashMap = HashMap<String, String>()
            stringHashMap.put("token","FBB9F97DE77C7888DE36E5B74CFF9")*/
            val data = RequestWishlistSubmitModel("FBB9F97DE77C7888DE36E5B74CFF9","1",tripId,merchantId,status,type)
            serviceModel!!.doPostRequest(data, "bookmark/create.php", this!!)
        } else {
            Utility.showToast(this!!,"No Internet", Toast.LENGTH_SHORT)?.show()
        }
    }
}
