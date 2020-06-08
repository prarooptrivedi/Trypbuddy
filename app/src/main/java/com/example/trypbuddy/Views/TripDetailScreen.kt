package com.example.trypbuddy.Views

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.biz_intelligence.Utils.Utility
import com.example.meetingschedule.Webservice.ServiceModel
import com.example.trypbuddy.Adapter.TripImagesListAdapter
import com.example.trypbuddy.Model.RequestTripDetailsModel
import com.example.trypbuddy.Model.TripDetailsModel
import com.example.trypbuddy.R
import java.util.*

class TripDetailScreen : BaseActivity(),View.OnClickListener{

    var serviceModel: ServiceModel = ServiceModel()
    var rv_tripbanner:RecyclerView?=null
    var tripId:String?=null
    var merchantId:String?=null
    var tv_tripname:TextView?=null
    var tv_nearbyplces:TextView?=null
    var tv_tripcity:TextView?=null
    var tv_tripprice:TextView?=null
    var tv_abouttrip:TextView?=null
    var tv_triphighlights:TextView?=null
    var card_tripusp:CardView?=null
    var card_duration:CardView?=null
    var card_complimentary:CardView?=null
    var card_PaymentPolicy:CardView?=null
    var card_nearbyplces:CardView?=null
    var card_trripinclude:CardView?=null
    var card_Itinerary:CardView?=null
    var card_PreferredHotels:CardView?=null
    var card_notes:CardView?=null
    var card_whychooseus:CardView?=null
    var card_CancelationPolicy:CardView?=null
    var tv_tripduration:TextView?=null
    var tv_tripinclude:TextView?=null
    var tv_Complimentary:TextView?=null
    var tv_Itinerary:TextView?=null
    var top_icon:ImageView?=null
    var tv_PreferredHotels:TextView?=null
    var tv_PaymentPolicy:TextView?=null
    var tv_CancelationPolicy:TextView?=null
    var tv_whychooseus:TextView?=null
    var ll_callback:LinearLayout?=null
    var ll_book:LinearLayout?=null

    var tripcomplementory:String=""
    var tripwhychooseus:String=""
    var tripnearby:String=""
    var tripnotes:String=""
    var tripname:String=""
    var tripdays:String=""
    var tripcity:String=""
    var tripprice:String=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_detail_screen)
        getIntentValues()
        initViews()
        sendRequest()
    }

    private fun getIntentValues() {
        tripId = intent.extras!!.getString("TripId", "")
    }

    private fun initViews() {
        rv_tripbanner=findViewById(R.id.rv_tripbanner)
        top_icon=findViewById(R.id.top_icon)
        tv_tripname=findViewById(R.id.tv_tripname)
        tv_tripcity=findViewById(R.id.tv_tripcity)
        tv_tripprice=findViewById(R.id.tv_tripprice)
        tv_abouttrip=findViewById(R.id.tv_abouttrip)
        tv_triphighlights=findViewById(R.id.tv_triphighlights)
        card_tripusp=findViewById(R.id.card_tripusp)
        tv_tripduration=findViewById(R.id.tv_tripduration)
        card_duration=findViewById(R.id.card_duration)
        card_trripinclude=findViewById(R.id.card_trripinclude)
        tv_tripinclude=findViewById(R.id.tv_tripinclude)
        card_complimentary=findViewById(R.id.card_complimentary)
        card_whychooseus=findViewById(R.id.card_whychooseus)
        card_nearbyplces=findViewById(R.id.card_nearbyplces)
        card_CancelationPolicy=findViewById(R.id.card_CancelationPolicy)
        card_PaymentPolicy=findViewById(R.id.card_PaymentPolicy)
        card_notes=findViewById(R.id.card_notes)
        ll_book=findViewById(R.id.ll_book)
        card_complimentary!!.setOnClickListener(this)
        card_whychooseus!!.setOnClickListener(this)
        card_nearbyplces!!.setOnClickListener(this)
        top_icon!!.setOnClickListener(this)
        card_notes!!.setOnClickListener(this)
        //  card_PaymentPolicy!!.setOnClickListener(this)
        tv_Complimentary=findViewById(R.id.tv_Complimentary)
        tv_Itinerary=findViewById(R.id.tv_Itinerary)
        card_Itinerary=findViewById(R.id.card_Itinerary)
        card_PreferredHotels=findViewById(R.id.card_PreferredHotels)
        tv_PreferredHotels=findViewById(R.id.tv_PreferredHotels)
        tv_PaymentPolicy=findViewById(R.id.tv_PaymentPolicy)
        tv_CancelationPolicy=findViewById(R.id.tv_CancelationPolicy)
        tv_nearbyplces=findViewById(R.id.tv_nearbyplces)
        ll_callback=findViewById(R.id.ll_callback)
        ll_callback!!.setOnClickListener(this)
        ll_book!!.setOnClickListener(this)
    }

    override fun getModel(): Observable {
        return serviceModel
    }

    override fun update(o: Observable?, arg: Any?) {
        if (arg is TripDetailsModel) {
            if (arg.status.equals("success")) {
                val respone = arg
                rv_tripbanner!!.visibility = View.VISIBLE
                rv_tripbanner!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                rv_tripbanner!!.adapter = TripImagesListAdapter(respone.Images!!,this)
                tripname=respone.Data!!.get(0).trip_name.toString()
                tripdays=respone.Data!!.get(0).trip_days.toString()
                tripcity=respone.Data!!.get(0).city_name.toString()
                tripprice=respone.Data!!.get(0).trip_fare.toString()
                tv_tripname!!.text=respone.Data!!.get(0).trip_name
                tv_tripcity!!.text=respone.Data!!.get(0).city_name
                tv_tripprice!!.text=" ₹ "+respone.Data!!.get(0).trip_fare
                tv_abouttrip!!.text=respone.Data!!.get(0).about_trip
                val tripusp = Html.fromHtml(respone.Data!!.get(0).trip_usp)
                val tripinclude = Html.fromHtml(respone.Data!!.get(0).trip_includes)
                tripcomplementory = respone.Data!!.get(0).trip_complimentary.toString()
                tripwhychooseus = respone.Data!!.get(0).whychooseus.toString()
                tripnearby = respone.Data!!.get(0).trip_nearby_places.toString()
                tripnotes = respone.Data!!.get(0).trip_notes.toString()
                merchantId=respone.Data!!.get(0).createdby
                val tripPaymentPolicy = Html.fromHtml(respone.Data!!.get(0).trip_payment_policy)
                val tripCancelationPolicy = Html.fromHtml(respone.Data!!.get(0).trip_cancellation_policy)
                val tripitinerary = Html.fromHtml(respone.Data!!.get(0).trip_itinerary_details)
                val triptv_PreferredHotels = Html.fromHtml(respone.Data!!.get(0).trip_hotels_recommended)
                if (respone.Data!!.get(0).trip_usp.equals("")){
                    card_tripusp!!.isVisible=false
                }
                else{

                    tv_triphighlights!!.text=tripusp

                }
                if (respone.Data!!.get(0).trip_days.equals("")){
                    card_duration!!.isVisible=false
                }
                else{
                    tv_tripduration!!.text=respone.Data!!.get(0).trip_days
                }
                if (respone.Data!!.get(0).trip_includes.equals("")){
                    card_trripinclude!!.isVisible=false
                }
                else{
                    tv_tripinclude!!.text=tripinclude
                }
                if (respone.Data!!.get(0).trip_complimentary.equals("")){
                    card_complimentary!!.isVisible=false
                }
                else{
                    tv_tripinclude!!.text=tripcomplementory
                }
                if (respone.Data!!.get(0).trip_itinerary_details.equals("")){
                    card_Itinerary!!.isVisible=false
                }
                else{
                    tv_Itinerary!!.text=tripitinerary
                }
                if (respone.Data!!.get(0).trip_hotels_recommended.equals("")){
                    card_PreferredHotels!!.isVisible=false
                }
                else{
                    tv_PreferredHotels!!.text=triptv_PreferredHotels
                }
                if (respone.Data!!.get(0).whychooseus.equals("")){
                    card_whychooseus!!.isVisible=false
                }
                else{
                    card_whychooseus!!.isVisible=true
                }
                if (respone.Data!!.get(0).trip_nearby_places.equals("")){
                    card_nearbyplces!!.isVisible=false
                }
                else{
                    card_nearbyplces!!.isVisible=true
                }
                if (respone.Data!!.get(0).trip_notes.equals("")){
                    card_notes!!.isVisible=false
                }
                else{
                    card_notes!!.isVisible=true
                }
                if (respone.Data!!.get(0).trip_payment_policy.equals("")){
                    card_PaymentPolicy!!.isVisible=false
                }
                else{
                    tv_PaymentPolicy!!.text=tripPaymentPolicy
                }
                if (respone.Data!!.get(0).trip_cancellation_policy.equals("")){
                    card_CancelationPolicy!!.isVisible=false
                }
                else{
                    tv_CancelationPolicy!!.text=tripCancelationPolicy
                }


            }

        }
        else{

        }
    }
    private fun sendRequest() {
        if (Utility.hasInternet(this!!) == true) {
            val data = RequestTripDetailsModel("FBB9F97DE77C7888DE36E5B74CFF9",tripId!!)
            serviceModel!!.doPostRequest(data, "trip/listtripAll.php", this!!)
        } else {
            Utility.showToast(this!!,"No Internet", Toast.LENGTH_SHORT)?.show()
        }


    }
    override fun onClick(v: View?) {
        if (v==card_complimentary){
            val intent=Intent(this,DetailsScreen::class.java)
            intent.putExtra("details",tripcomplementory)
            intent.putExtra("name","Complimentary")
            startActivity(intent)
        }
        if (v==card_whychooseus){
            val intent=Intent(this,DetailsScreen::class.java)
            intent.putExtra("details",tripwhychooseus)
            intent.putExtra("name","Why Choose Us")
            startActivity(intent)
        }
        if (v==card_nearbyplces){
            val intent=Intent(this,DetailsScreen::class.java)
            intent.putExtra("details",tripnearby)
            intent.putExtra("name","Nearby Places")
            startActivity(intent)
        }
        if (v==card_notes){
            val intent=Intent(this,DetailsScreen::class.java)
            intent.putExtra("details",tripnotes)
            intent.putExtra("name","Notes")
            startActivity(intent)
        }
        if (v==ll_callback){
            val intent=Intent(this,TripCallBackScreen::class.java)
            intent.putExtra("tripId",tripId)
            intent.putExtra("merchantId",merchantId)
            intent.putExtra("tripname",tripname)
            intent.putExtra("tripdays",tripdays)
            startActivity(intent)
        }
        if (v==ll_book){
            val intent=Intent(this,TripBookingScreen::class.java)
            intent.putExtra("tripId",tripId)
            intent.putExtra("merchantId",merchantId)
            intent.putExtra("tripname",tripname)
            intent.putExtra("tripdays",tripdays)
            intent.putExtra("tripcity",tripcity)
            intent.putExtra("tripprice",tripprice)
            startActivity(intent)
        }
        if (v==top_icon){
             finish()
        }
        /*  if (v==card_PaymentPolicy){
             val intent=Intent(this,DetailsScreen::class.java)
             intent.putExtra("details",tripPaymentPolicy)
             intent.putExtra("name","Payment Policy")
             startActivity(intent)
         }*/
    }

}
