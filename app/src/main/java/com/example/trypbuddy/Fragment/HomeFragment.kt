package com.wajahatkarim3.bottomnavigationdemo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.biz_intelligence.Utils.Utility
import com.example.meetingschedule.Utils.MainApp
import com.example.meetingschedule.Webservice.ServiceModel
import com.example.trypbuddy.Adapter.BannerListAdapter
import com.example.trypbuddy.Adapter.CategoryListAdapter
import com.example.trypbuddy.Adapter.TripListAdapter
import com.example.trypbuddy.Fragment.BaseFragment
import com.example.trypbuddy.Model.*
import com.example.trypbuddy.Presenter.CategoryClick
import com.example.trypbuddy.Presenter.ClickListnerBookMark
import com.example.trypbuddy.Presenter.ClickListnerWishList
import com.example.trypbuddy.Presenter.TripClickListner
import com.example.trypbuddy.R
import com.example.trypbuddy.Views.TripDetailScreen
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONObject
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment :BaseFragment(),View.OnClickListener,TripClickListner, ClickListnerBookMark,CategoryClick,ClickListnerWishList {



    var tripClickListner:TripClickListner?=null
    var clickListnerBookMark:ClickListnerBookMark?=null
    var clickListnerWishList:ClickListnerWishList?=null
    var categoryClick:CategoryClick?=null
    var rv_category:RecyclerView?=null
    var rv_banner:RecyclerView?=null
    var rv_trips:RecyclerView?=null

    var serviceModel: ServiceModel? = ServiceModel()
    override val model: Observable?
        get() = serviceModel

    override fun onCreateViewPost(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        tripClickListner=this as TripClickListner
        clickListnerBookMark=this as ClickListnerBookMark
        clickListnerWishList=this as ClickListnerWishList
        categoryClick=this as CategoryClick
        sendBannerRequest()

        onClickViews()

    }

    private fun onClickViews() {

    }

    private fun initViews(view: View) {
        rv_category=view.findViewById(R.id.rv_category)
        rv_trips=view.findViewById(R.id.rv_trips)
        rv_banner=view.findViewById(R.id.rv_banner)
    }

    override fun update(o: Observable?, arg: Any?) {


        if (arg is BannerModel) {
            if (arg.status.equals("success")) {
                val respone = arg
                rv_banner!!.visibility = View.VISIBLE
                rv_banner!!.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                rv_banner!!.adapter = BannerListAdapter(respone.data!!,activity,"M")
                sendRequest()
            }

        }
        else{

        }
        if (arg is CategoryModel) {
            if (arg.status.equals("success")) {
                val respone = arg
                rv_category!!.visibility = View.VISIBLE
                rv_category!!.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                rv_category!!.adapter = CategoryListAdapter(respone.data!!,activity,categoryClick!!)

                getTrip()

            }

        }
        if (arg is TripListModel) {
            if (arg.status.equals("success")) {
                val respone = arg
                rv_trips!!.visibility = View.VISIBLE
                rv_trips!!.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
                rv_trips!!.adapter = TripListAdapter(respone.data!!,activity,tripClickListner!!,clickListnerBookMark!!,clickListnerWishList!!)


            }
            else{
                rv_trips!!.visibility = View.GONE
            }
        }
        else{
            rv_trips!!.visibility = View.GONE
        }
        if (arg is WishListSubmitModel) {
            if (arg.status.equals("success")) {
                val respone = arg
                getTrip()
                Utility.showToast(activity!!, respone.message!!, Toast.LENGTH_SHORT)?.show()

            }

        }
        else{

        }
    }

    private fun getTrip() {
        if (Utility.hasInternet(activity!!) == true) {
            /*val stringHashMap = HashMap<String, String>()
            stringHashMap.put("token","FBB9F97DE77C7888DE36E5B74CFF9")*/
            val data = RequestTripModel("FBB9F97DE77C7888DE36E5B74CFF9","0","0")
            serviceModel!!.doPostRequest(data, "trip/listtrip.php", activity!!)
        } else {
            Utility.showToast(activity!!,"No Internet", Toast.LENGTH_SHORT)?.show()
        }
    }


    private fun sendRequest() {
        if (Utility.hasInternet(activity!!) == true) {
            /*val stringHashMap = HashMap<String, String>()
            stringHashMap.put("token","FBB9F97DE77C7888DE36E5B74CFF9")*/
            val data = RequestModelHome("FBB9F97DE77C7888DE36E5B74CFF9")
            serviceModel!!.doPostRequest(data, "tripcategory/listtripcategory.php", activity!!)
        } else {
            Utility.showToast(activity!!,"No Internet", Toast.LENGTH_SHORT)?.show()
        }


    }
    private fun sendBannerRequest() {
        if (Utility.hasInternet(activity!!) == true) {
            /*val stringHashMap = HashMap<String, String>()
            stringHashMap.put("token","FBB9F97DE77C7888DE36E5B74CFF9")*/
            val data = RequestModelHome("FBB9F97DE77C7888DE36E5B74CFF9")
            serviceModel!!.doPostRequest(data, "banner/listbanner.php", activity!!)
        } else {
            Utility.showToast(activity!!,"No Internet", Toast.LENGTH_SHORT)?.show()
        }


    }
    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {

            }

        }
    }
    override fun TripClick(id: String,isGroup:String) {
        val  intent=Intent(activity,TripDetailScreen::class.java)
        intent.putExtra("TripId",id)
        intent.putExtra("isGroup",isGroup)
        startActivity(intent)
    }
    override fun bookMarkClick(tripId: String, merchantId: String, status: String,type:String) {
        if (Utility.hasInternet(activity!!) == true) {
            /*val stringHashMap = HashMap<String, String>()
            stringHashMap.put("token","FBB9F97DE77C7888DE36E5B74CFF9")*/
            val data = RequestWishlistSubmitModel("FBB9F97DE77C7888DE36E5B74CFF9","1",tripId,merchantId,status,type)
            serviceModel!!.doPostRequest(data, "wishlist/create.php", activity!!)
        } else {
            Utility.showToast(activity!!,"No Internet", Toast.LENGTH_SHORT)?.show()
        }



    }
    override fun wishListClick(tripId: String, merchantId: String, status: String, type: String) {
        if (Utility.hasInternet(activity!!) == true) {
            /*val stringHashMap = HashMap<String, String>()
            stringHashMap.put("token","FBB9F97DE77C7888DE36E5B74CFF9")*/
            val data = RequestWishlistSubmitModel("FBB9F97DE77C7888DE36E5B74CFF9","1",tripId,merchantId,status,type)
            serviceModel!!.doPostRequest(data, "bookmark/create.php", activity!!)
        } else {
            Utility.showToast(activity!!,"No Internet", Toast.LENGTH_SHORT)?.show()
        }
    }
    override fun categeoryClick(category_id: String) {
        if (Utility.hasInternet(activity!!) == true) {
            /*val stringHashMap = HashMap<String, String>()
            stringHashMap.put("token","FBB9F97DE77C7888DE36E5B74CFF9")*/
            val data = RequestTripModel("FBB9F97DE77C7888DE36E5B74CFF9",category_id,"1")
            serviceModel!!.doPostRequest(data, "trip/listtrip.php", activity!!)
        } else {
            Utility.showToast(activity!!,"No Internet", Toast.LENGTH_SHORT)?.show()
        }
    }
}