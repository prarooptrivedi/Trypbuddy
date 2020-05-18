package com.wajahatkarim3.bottomnavigationdemo

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.biz_intelligence.Utils.Utility
import com.example.meetingschedule.Webservice.ServiceModel
import com.example.trypbuddy.Adapter.CategoryListAdapter
import com.example.trypbuddy.Adapter.CityListAdapter
import com.example.trypbuddy.Fragment.BaseFragment
import com.example.trypbuddy.Model.CategoryModel
import com.example.trypbuddy.Model.CityListModel
import com.example.trypbuddy.Model.RequestModelHome
import com.example.trypbuddy.Presenter.CityClickListner
import com.example.trypbuddy.R
import com.example.trypbuddy.Views.CityWiseTripScreen
import com.example.trypbuddy.Views.TripDetailScreen
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : BaseFragment(),View.OnClickListener,CityClickListner {
    var cityClickListner:CityClickListner?=null
    var rv_city: RecyclerView?=null

    var serviceModel: ServiceModel? = ServiceModel()
    override val model: Observable?
        get() = serviceModel

    override fun onCreateViewPost(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_search, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        cityClickListner=this as CityClickListner
        sendRequest()
        onClickViews()

    }

    private fun onClickViews() {

    }

    private fun initViews(view: View) {

        rv_city=view.findViewById(R.id.rv_city)
    }

    override fun update(o: Observable?, arg: Any?) {
        if (arg is CityListModel) {
            if (arg.status.equals("success")) {
                val respone = arg
                rv_city!!.visibility = View.VISIBLE
                  rv_city!!.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
                  rv_city!!.adapter = CityListAdapter(respone.data!!,activity,cityClickListner!!)


            }

        }
    }


    private fun sendRequest() {
        if (Utility.hasInternet(activity!!) == true) {

            val data = RequestModelHome("FBB9F97DE77C7888DE36E5B74CFF9")
            serviceModel!!.doPostRequest(data, "city/listcity.php", activity!!)
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
    override fun cityClick(city_Id: String,city_name:String) {
        val  intent= Intent(activity, CityWiseTripScreen::class.java)
        intent.putExtra("city_Id",city_Id)
        intent.putExtra("city_name",city_name)
        startActivity(intent)
    }

}