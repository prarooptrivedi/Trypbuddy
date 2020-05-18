package com.example.meetingschedule.Webservice


import android.app.Dialog
import android.content.Context
import com.example.biz_intelligence.Utils.Utility
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.json.JSONObject
import java.io.File
import java.util.*

/**
 *  * Created by Praroop on 20-05-2019.

 */

class ServiceRequests {

    private var serviceName = ""
    private var serviceInterface: ServiceInterface? = null
    private var serviceResponseInterface: ServiceCallback? = null
    private var stringHashMap: HashMap<String, String>? = null
    private var jsonValueData: Any? = null
    private var progressDialog: Dialog? = null

    var response: Observable<*>? = null

    constructor(observable: java.util.Observable, stringHashMap: HashMap<String, String>, serviceName: String) {
        this.serviceResponseInterface = observable as ServiceCallback
        this.serviceName = serviceName
        this.stringHashMap = stringHashMap
    }

    constructor(observable: java.util.Observable, jsonValueData: Any, serviceName: String) {
        this.serviceResponseInterface = observable as ServiceCallback
        this.serviceName = serviceName
        this.jsonValueData = jsonValueData
    }



    constructor(observable: java.util.Observable, serviceName: String) {
        this.serviceResponseInterface = observable as ServiceCallback
        this.serviceName = serviceName
    }

    fun execute(context: Context) {
        serviceInterface = ApiClient.client!!.create(ServiceInterface::class.java)
        doRequest(context)
    }

    private fun doRequest(context: Context) {
        if (progressDialog == null) {
            progressDialog = Utility.progressDialog(context)

            if (serviceName == "tripcategory/listtripcategory.php") {
                progressDialog!!.show()
                progressDialog!!.setCancelable(false)
                response = serviceInterface!!.getCategory(jsonValueData)
            }
            if (serviceName == "aboutus/listaboutus.php") {
                progressDialog!!.show()
                progressDialog!!.setCancelable(false)
                response = serviceInterface!!.getAboutus(jsonValueData)
            }
            if (serviceName == "faq/listfaq.php") {
                progressDialog!!.show()
                progressDialog!!.setCancelable(false)
                response = serviceInterface!!.getFaq(jsonValueData)
            }

            if (serviceName == "privacy/listprivacy.php") {
                progressDialog!!.show()
                progressDialog!!.setCancelable(false)
                response = serviceInterface!!.getPrivacyPolicy(jsonValueData)
            }
            if (serviceName == "terms/listterms.php") {
                progressDialog!!.show()
                progressDialog!!.setCancelable(false)
                response = serviceInterface!!.getTerms(jsonValueData)
            }

            if (serviceName == "trip/listtrip.php") {
                progressDialog!!.show()
                progressDialog!!.setCancelable(false)
                response = serviceInterface!!.getTrip(jsonValueData)
            }
            if (serviceName == "city/listcitytrips.php") {
                progressDialog!!.show()
                progressDialog!!.setCancelable(false)
                response = serviceInterface!!.getCityWiseTrip(jsonValueData)
            }
            if (serviceName == "city/listcity.php") {
                progressDialog!!.show()
                progressDialog!!.setCancelable(false)
                response = serviceInterface!!.getCity(jsonValueData)
            }
            if (serviceName == "banner/listbanner.php") {
                progressDialog!!.show()
                progressDialog!!.setCancelable(false)
                response = serviceInterface!!.getBanner(jsonValueData)
            }
            if (serviceName == "accessoriescategory/listaccessoriescategory.php") {
                progressDialog!!.show()
                progressDialog!!.setCancelable(false)
                response = serviceInterface!!.getAccessoriesCategory(jsonValueData)
            }
            if (serviceName == "productaccessories/listproductaccessories.php") {
                progressDialog!!.show()
                progressDialog!!.setCancelable(false)
                response = serviceInterface!!.getAccessoriesProduct(jsonValueData)
            }

            if (serviceName == "trip/listtripAll.php") {
                progressDialog!!.show()
                progressDialog!!.setCancelable(false)
                response = serviceInterface!!.getTripDetails(jsonValueData)
            }
            if (serviceName == "wishlist/listtrip.php") {
                progressDialog!!.show()
                progressDialog!!.setCancelable(false)
                response = serviceInterface!!.getwishlistDetails(jsonValueData)
            }
            if (serviceName == "wishlist/create.php") {
                progressDialog!!.show()
                progressDialog!!.setCancelable(false)
                response = serviceInterface!!.getwishlistsubmit(jsonValueData)
            }
            if (serviceName == "blog/listblog.php") {
                progressDialog!!.show()
                progressDialog!!.setCancelable(false)
                response = serviceInterface!!.getBlog(jsonValueData)
            }
            if (serviceName == "contactus/create.php") {
                progressDialog!!.show()
                progressDialog!!.setCancelable(false)
                response = serviceInterface!!.getContactus(jsonValueData)
            }



            response!!.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { o -> o }
                .subscribe(Consumer<Any> { this.handleResults(it) }, Consumer<Throwable> { this.handleError(it) })
        }
    }

    private fun handleResults(o: Any) {
        progressDialog!!.dismiss()
        progressDialog = null
        serviceResponseInterface!!.onSuccess(o)
    }

    private fun handleError(t: Throwable) {
        progressDialog!!.dismiss()
        progressDialog = null
        serviceResponseInterface!!.onFail(t.message!!)
    }

}
