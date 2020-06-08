package com.wajahatkarim3.bottomnavigationdemo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.biz_intelligence.Utils.Utility
import com.example.meetingschedule.Webservice.ServiceModel
import com.example.trypbuddy.Adapter.AccessoriesCategoryListAdapter
import com.example.trypbuddy.Adapter.AccessoriesListAdapter
import com.example.trypbuddy.Adapter.BannerListAdapter
import com.example.trypbuddy.Adapter.CategoryListAdapter
import com.example.trypbuddy.Fragment.BaseFragment
import com.example.trypbuddy.Model.*
import com.example.trypbuddy.Presenter.*
import com.example.trypbuddy.R
import com.example.trypbuddy.Views.AccessoriesDetailsActivity
import com.example.trypbuddy.Views.TripDetailScreen
import kotlinx.android.synthetic.main.fragment_notifications.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class AccessoriesFragment : BaseFragment(),CategoryClick, AccessoriesClickListner,
    ClickListnerBookMark, ClickListnerWishList {

    var clickListnerBookMark:ClickListnerBookMark?=null
    var clickListnerWishList:ClickListnerWishList?=null
    var categoryClick:CategoryClick?=null
    var tripClickListner:AccessoriesClickListner?=null

    var rv_banner:RecyclerView?=null
    var rv_category:RecyclerView?=null
    var rv_Accessories:RecyclerView?=null
    var cat_id:String?="0"
    var serviceModel: ServiceModel? = ServiceModel()
    lateinit var bannerPath: ArrayList<String>
    override val model: Observable?
        get() = serviceModel

    override fun onCreateViewPost(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun update(o: Observable?, arg: Any?) {
        if (arg is BannerModel) {
            val respone = arg
            if (arg.status.equals("success")) {
                val respone = arg
                rv_banner!!.visibility = View.VISIBLE
                rv_banner!!.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                rv_banner!!.adapter = BannerListAdapter(respone.data!!,activity,"R")

                sendCategoryRequst()

            }

        }
        if (arg is AccessoriesCategoryModel) {
            if (arg.status.equals("success")) {
                val respone = arg
                rv_category!!.visibility = View.VISIBLE
                rv_category!!.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                rv_category!!.adapter = AccessoriesCategoryListAdapter(respone.data!!,activity,categoryClick!!)
                sendProductRequst()

            }

        }
        if (arg is AccessoriesProductModel) {
            if (arg.status.equals("success")) {
                val respone = arg
                rv_Accessories!!.visibility = View.VISIBLE
                rv_Accessories!!.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
                rv_Accessories!!.adapter = AccessoriesListAdapter(respone.data!!,activity,tripClickListner!!,clickListnerBookMark!!,clickListnerWishList!!)

            }

        }
        if (arg is WishListSubmitModel) {
            if (arg.status.equals("success")) {
                val respone = arg
                Utility.showToast(activity!!, respone.message!!, Toast.LENGTH_SHORT)?.show()

            }

        }
        
    }

    private fun sendCategoryRequst() {
        if (Utility.hasInternet(activity!!) == true) {
            /*val stringHashMap = HashMap<String, String>()
            stringHashMap.put("token","FBB9F97DE77C7888DE36E5B74CFF9")*/
            val data = RequestModelHome("FBB9F97DE77C7888DE36E5B74CFF9")
            serviceModel!!.doPostRequest(data, "accessoriescategory/listaccessoriescategory.php", activity!!)
        } else {
            Utility.showToast(activity!!,"No Internet", Toast.LENGTH_SHORT)?.show()
        }
    }
    private fun sendProductRequst() {
        if (Utility.hasInternet(activity!!) == true) {
            /*val stringHashMap = HashMap<String, String>()
            stringHashMap.put("token","FBB9F97DE77C7888DE36E5B74CFF9")*/
            val data = RequestAccessoriesModel("FBB9F97DE77C7888DE36E5B74CFF9",cat_id!!)
            serviceModel!!.doPostRequest(data, "productaccessories/listproductaccessories.php", activity!!)
        } else {
            Utility.showToast(activity!!,"No Internet", Toast.LENGTH_SHORT)?.show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bannerPath = ArrayList()
        categoryClick=this as CategoryClick
        tripClickListner=this as AccessoriesClickListner
        initViews(view)
        clickListnerBookMark=this as ClickListnerBookMark
        clickListnerWishList=this as ClickListnerWishList
        sendBannerRequest()
      

    }

    private fun initViews(view: View) {
        rv_banner=view.findViewById(R.id.rv_banner)
        rv_category=view.findViewById(R.id.rv_category)
        rv_Accessories=view.findViewById(R.id.rv_Accessories)
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
    override fun categeoryClick(category_id: String) {
        if (Utility.hasInternet(activity!!) == true) {
            /*val stringHashMap = HashMap<String, String>()
            stringHashMap.put("token","FBB9F97DE77C7888DE36E5B74CFF9")*/
            val data = RequestAccessoriesModel("FBB9F97DE77C7888DE36E5B74CFF9",category_id!!)
            serviceModel!!.doPostRequest(data, "productaccessories/listproductaccessories.php", activity!!)
        } else {
            Utility.showToast(activity!!,"No Internet", Toast.LENGTH_SHORT)?.show()
        }
    }

    override fun TripClick(id: String, isGroup: String,description:String,price:String,latitude:String,longitude:String,merchantid:String) {
        val  intent= Intent(activity, AccessoriesDetailsActivity::class.java)
        intent.putExtra("productname",isGroup)
        intent.putExtra("description",description)
        intent.putExtra("price",price)
        intent.putExtra("latitude",latitude)
        intent.putExtra("longitude",longitude)
        intent.putExtra("merchantid",merchantid)
        intent.putExtra("id",id)
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
}
