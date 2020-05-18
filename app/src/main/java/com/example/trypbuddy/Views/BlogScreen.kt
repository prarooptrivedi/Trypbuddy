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
import com.example.trypbuddy.Adapter.BlogListAdapter
import com.example.trypbuddy.Adapter.TripListAdapter
import com.example.trypbuddy.Model.BlogModel
import com.example.trypbuddy.Model.RequestModelHome
import com.example.trypbuddy.Model.WishListSubmitModel
import com.example.trypbuddy.R
import java.util.*

class BlogScreen : BaseActivity(),View.OnClickListener {


    var serviceModel:ServiceModel= ServiceModel()
    var top_icon:ImageView?=null
    var top_title:TextView?=null
    var rv_blog:RecyclerView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog_screen)
        initViews()
        sendRequest()
    }

    private fun sendRequest() {
        if (Utility.hasInternet(this!!) == true) {
            /*val stringHashMap = HashMap<String, String>()
            stringHashMap.put("token","FBB9F97DE77C7888DE36E5B74CFF9")*/
            val data = RequestModelHome("FBB9F97DE77C7888DE36E5B74CFF9")
            serviceModel!!.doPostRequest(data, "blog/listblog.php", this!!)
        } else {
            Utility.showToast(this!!,"No Internet", Toast.LENGTH_SHORT)?.show()
        }
    }

    private fun initViews() {
        top_icon=findViewById(R.id.top_icon)
        rv_blog=findViewById(R.id.rv_blog)
        top_icon!!.setOnClickListener(this)
        top_title=findViewById(R.id.top_title)
        top_title!!.text="Blog"
    }

    override fun getModel(): Observable {
        return serviceModel
    }

    override fun update(o: Observable?, arg: Any?) {
        if (arg is BlogModel) {
            if (arg.status.equals("success")) {
                val respone = arg
                rv_blog!!.visibility = View.VISIBLE
                rv_blog!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                rv_blog!!.adapter = BlogListAdapter(respone.data!!,this)
                Utility.showToast(this!!, respone.message!!, Toast.LENGTH_SHORT)?.show()

            }

        }
        else{

        }
    }
    override fun onClick(v: View?) {
        if (v==top_icon){
            finish()
        }
    }
}
