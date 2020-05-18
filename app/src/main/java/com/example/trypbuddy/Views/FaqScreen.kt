package com.example.trypbuddy.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.biz_intelligence.Utils.Utility
import com.example.meetingschedule.Webservice.ServiceModel
import com.example.trypbuddy.Adapter.CategoryListAdapter
import com.example.trypbuddy.Model.AboutModel
import com.example.trypbuddy.Model.CategoryModel
import com.example.trypbuddy.Model.RequestModelHome
import com.example.trypbuddy.R
import java.util.*
import android.text.Html
import android.text.Spanned
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.app.ComponentActivity.ExtraData




class FaqScreen : BaseActivity() {
    var serviceModel: ServiceModel = ServiceModel()
    var text_aboutus:TextView?=null
    var text_title:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abount_us_screen)
        initViews()
        sendRequest()
    }

    private fun sendRequest() {
        if (Utility.hasInternet(this!!) == true) {

            val data = RequestModelHome("FBB9F97DE77C7888DE36E5B74CFF9")
            serviceModel!!.doPostRequest(data, "faq/listfaq.php", this!!)
        } else {
            Utility.showToast(this!!,"No Internet", Toast.LENGTH_SHORT)?.show()
        }
    }

    private fun initViews() {
        text_aboutus=findViewById(R.id.text_aboutus)
        text_title=findViewById(R.id.text_title)
        text_title!!.text="FAQ"
    }

    override fun getModel(): Observable {
        return serviceModel
    }

    override fun update(o: Observable?, arg: Any?) {
        if (arg is AboutModel) {
            if (arg.status.equals("success")) {
                val respone = arg
                val htmlAsSpanned = Html.fromHtml(respone.data!!.get(0).mtext)
                text_aboutus!!.text=htmlAsSpanned


            }

        }
    }
}
