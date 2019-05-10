package com.example.praroop.trypbuddycom.Views;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.praroop.trypbuddycom.Adapter.HotelProfileAdapter;
import com.example.praroop.trypbuddycom.Adapter.HotelProfileSliderAdapter;
import com.example.praroop.trypbuddycom.Customfont.TextViewSFProDisplayBold;
import com.example.praroop.trypbuddycom.Customfont.TextViewSFProDisplayMedium;
import com.example.praroop.trypbuddycom.Customfont.TextViewSFProDisplayRegular;
import com.example.praroop.trypbuddycom.Customfont.TextViewSFProDisplaySemibold;
import com.example.praroop.trypbuddycom.Customfont.TextViewSFProDisplaySemiboldItalic;
import com.example.praroop.trypbuddycom.Models.CombineDataSetNew;
import com.example.praroop.trypbuddycom.Models.HotelProfileModel;
import com.example.praroop.trypbuddycom.Models.TripDetailModel;
import com.example.praroop.trypbuddycom.Models.TripListModel;
import com.example.praroop.trypbuddycom.R;
import com.example.praroop.trypbuddycom.Utils.UtilClassForValidations;
import com.example.praroop.trypbuddycom.Webservices.WebService;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;
import ir.apend.slider.ui.indicators.CircleIndicator;


public class HotelProfile extends AppCompatActivity implements OnClickListener {
    ACProgressFlower dialog;
    TextViewSFProDisplayBold tv_noofphotos;
    TextViewSFProDisplayMedium tv_tripto,tv_tripfrom;
    String id,iid,trip_name,about_trip,trip_from,trip_to,trip_days,category_id,trip_usp,trip_includes,trip_fare,trip_seats,
            trip_complimentary,trip_itinerary_details,
            trip_excludes,trip_payment_policy,trip_cancellation_policy,trip_hotels_recommended,trip_vehicle,trip_discount,trip_video_link,
            trip_nearby_places,trip_notes,trip_image,trip_destination_image,trip_destination_image1,trip_destination_image2,
            trip_destination_image3,
            createdon,createdby,modifiedon,organizedby,whychooseus,forgroup,latitude,longitude,status,
            trip_destination_image4,trip_destination_image5,trip_destination_image6,trip_destination_image7,
            trip_destination_image8,
            transport,food,activity,guide,accomodation,trip_city,city_name,createdby_name,vehicle_name;
    ArrayList<TripDetailModel>tripDetailModels=new ArrayList<TripDetailModel>();
    private Integer[] ICONS = {R.drawable.minisplit,R.drawable.tv_monitor,R.drawable.minisplit,
            R.drawable.minisplit,R.drawable.minisplit};
    private String[] NAME = {"AC","TV","Free","Complementary","Geyser"};
    private String[] NOTXT = {"","","Wifi","Breakfast",""};
    TextViewSFProDisplayRegular tv_abouttrip;
    private HotelProfileSliderAdapter hotelProfileSliderAdapter;
    private ViewPager viewPager;
    LinearLayout ll_whtchosseus,ll_notes;
    private RecyclerView hotelprofilerecyview;
    private HotelProfileAdapter hotelProfileAdapter;
    private ArrayList<HotelProfileModel> homePageStoryModelArrayList;
    TextViewSFProDisplaySemibold tv_trip_name;
    TextViewSFProDisplayRegular tv_Itinerary,tv_tripplace,tv_pickuplocation,tv_triphighlight;
    TextViewSFProDisplaySemiboldItalic tv_tripdays;
    TextViewSFProDisplaySemibold bttn_callback,btn_book,tv_notesheading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_profile);
        tv_notesheading=(TextViewSFProDisplaySemibold)findViewById(R.id.tv_notesheading);
        bttn_callback=(TextViewSFProDisplaySemibold)findViewById(R.id.bttn_callback);
        btn_book=(TextViewSFProDisplaySemibold)findViewById(R.id.btn_book);
        bttn_callback.setOnClickListener(this);
        btn_book.setOnClickListener(this);
        tv_tripto=(TextViewSFProDisplayMedium)findViewById(R.id.tv_tripto);
        tv_tripfrom=(TextViewSFProDisplayMedium)findViewById(R.id.tv_tripfrom);
        tv_noofphotos=(TextViewSFProDisplayBold)findViewById(R.id.tv_noofphotos);

        ll_whtchosseus=(LinearLayout)findViewById(R.id.ll_whtchosseus);
        ll_notes=(LinearLayout)findViewById(R.id.ll_notes);
        ll_notes.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HotelProfile.this,Details_Activity.class);
                i.putExtra("notes",trip_notes);
                i.putExtra("Heading","Notes");
                startActivity(i);
            }
        });
        tv_trip_name=(TextViewSFProDisplaySemibold)findViewById(R.id.tv_trip_name);




        tv_Itinerary=(TextViewSFProDisplayRegular)findViewById(R.id.tv_Itinerary);
        tv_tripplace=(TextViewSFProDisplayRegular)findViewById(R.id.tv_tripplace);
        tv_abouttrip=(TextViewSFProDisplayRegular)findViewById(R.id.tv_abouttrip);
        tv_pickuplocation=(TextViewSFProDisplayRegular)findViewById(R.id.tv_pickuplocation);
        tv_triphighlight=(TextViewSFProDisplayRegular)findViewById(R.id.tv_triphighlight);


        tv_tripdays=(TextViewSFProDisplaySemiboldItalic)findViewById(R.id.tv_tripdays);

        viewPager = findViewById(R.id.hotelprofilevp);

        //CircleIndicator indicator = findViewById(R.id.indicator);

        hotelProfileSliderAdapter = new HotelProfileSliderAdapter(getSupportFragmentManager(),3);

        viewPager.setAdapter(hotelProfileSliderAdapter);

        /*indicator.setViewPager(viewPager);

        hotelProfileSliderAdapter.registerDataSetObserver(indicator.getDataSetObserver());*/

        //Recycler view for Amenities.....
        hotelprofilerecyview = findViewById(R.id.hotelprofilerecyview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HotelProfile.this, LinearLayoutManager.HORIZONTAL,false);
        hotelprofilerecyview.setLayoutManager(layoutManager);
        hotelprofilerecyview.setItemAnimator(new DefaultItemAnimator());

       /* hotelProfileAdapter = new HotelProfileAdapter(HotelProfile.this,homePageStoryModelArrayList);
        hotelprofilerecyview.setAdapter(hotelProfileAdapter);*/

        ///////////////////////////
        //Code For having a strike on a text view (cancel text)............
       /* TextView txt0 = findViewById(R.id.canceltxt);
        txt0.setText("₹1899");
        txt0.setPaintFlags(txt0.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);*/
        try{
            Intent i=getIntent();
            id=i.getStringExtra("id");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if (UtilClassForValidations.haveInternet(HotelProfile.this)){
            dialog = new ACProgressFlower.Builder(HotelProfile.this)
                    .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                    .themeColor(Color.WHITE)
                    .text("Loading...")
                    .fadeColor(Color.DKGRAY).build();
            dialog.show();
            new callToLoadDetails().execute();
        }
        else {
            Toast.makeText(HotelProfile.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        if (view==bttn_callback){
           Intent i=new Intent(HotelProfile.this,RequestEnquiry.class);
           startActivity(i);
        }
        if (view==btn_book){
           Intent i=new Intent(HotelProfile.this,CheckavailabilityActivity.class);
           startActivity(i);
        }
    }


    class callToLoadDetails extends AsyncTask<String, Integer, CombineDataSetNew> {
        protected CombineDataSetNew doInBackground(String... arg0) {
            CombineDataSetNew Response = null;
            try {
                Response = WebService.Loaddetails(id);
                if (Response != null) {
                    try {
                        JSONArray jsonArray = Response.getJsonArray();

                        final int numberOfItemsInResp = jsonArray.length();
                        /*for (int i = 0; i < numberOfItemsInResp; i++) {
                            JSONObject perResult = jsonArray.getJSONObject(i);
                            JSONObject jsonObject=perResult.getJSONObject("amenties");
                            Trip_amentiesModel inboxDataset = new Trip_amentiesModel();
                            inboxDataset.set(jsonObject.getString("transport"));
                            inboxDataset.setFood(jsonObject.getString("food"));
                            inboxDataset.setActivity(jsonObject.getString("activity"));
                            inboxDataset.setGuide(jsonObject.getString("guide"));
                            inboxDataset.setAccomodation(jsonObject.getString("accomodation"));
                            homePageStoryModelArrayList.add(inboxDataset);


                        }*/
                        for (int i = 0; i < numberOfItemsInResp; i++) {
                            JSONObject perResult = jsonArray.getJSONObject(i);

                            JSONArray jsonObject=perResult.getJSONArray("images");
                            for(int a=0;a<jsonObject.length();a++){
                                JSONObject js = jsonObject.getJSONObject(a);
                                TripDetailModel inboxDataset = new TripDetailModel();
                                trip_image=js.getString("trip_image");
                                inboxDataset.setTrip_image(js.getString("trip_image"));

                                tripDetailModels.add(inboxDataset);
                            }



                        }
                        for (int i = 0; i < numberOfItemsInResp; i++) {
                            JSONObject perResult = jsonArray.getJSONObject(i);
                            JSONObject jsonObject=perResult.getJSONObject("data");
                            iid= jsonObject.getString("id");
                            trip_name= jsonObject.getString("trip_name");
                            about_trip= jsonObject.getString("about_trip");
                            trip_from= jsonObject.getString("trip_from");
                            trip_to= jsonObject.getString("trip_to");
                            trip_days= jsonObject.getString("trip_days");
                            category_id= jsonObject.getString("category_id");
                            trip_usp= jsonObject.getString("trip_usp");
                            trip_includes= jsonObject.getString("trip_includes");
                            trip_fare= jsonObject.getString("trip_fare");
                            trip_seats= jsonObject.getString("trip_seats");
                            trip_complimentary= jsonObject.getString("trip_complimentary");
                            trip_itinerary_details= jsonObject.getString("trip_itinerary_details");
                            trip_excludes= jsonObject.getString("trip_excludes");
                            trip_payment_policy= jsonObject.getString("trip_payment_policy");
                            trip_cancellation_policy= jsonObject.getString("trip_cancellation_policy");
                            trip_hotels_recommended= jsonObject.getString("trip_hotels_recommended");
                            trip_vehicle= jsonObject.getString("trip_vehicle");
                            trip_discount= jsonObject.getString("trip_discount");
                            trip_video_link= jsonObject.getString("trip_video_link");
                            trip_nearby_places= jsonObject.getString("trip_nearby_places");
                            trip_notes= jsonObject.getString("trip_notes");
                            createdon= jsonObject.getString("createdon");
                            createdby= jsonObject.getString("createdby");
                            modifiedon= jsonObject.getString("modifiedon");
                            organizedby= jsonObject.getString("organizedby");
                            whychooseus= jsonObject.getString("whychooseus");
                            forgroup= jsonObject.getString("forgroup");
                            latitude= jsonObject.getString("latitude");
                            longitude= jsonObject.getString("longitude");
                            status= jsonObject.getString("status");
                            trip_city= jsonObject.getString("trip_city");
                            city_name= jsonObject.getString("city_name");
                            vehicle_name= jsonObject.getString("vehicle_name");
                            createdby_name= jsonObject.getString("createdby_name");


                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        return null;
                    }
                    return Response;
                }
                else
                    return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        protected void onPostExecute(CombineDataSetNew result) {
            super.onPostExecute(result);
            try {
                dialog.dismiss();
                tv_noofphotos.setText(String.valueOf(tripDetailModels.size()));
                if (!iid.equalsIgnoreCase("")) {
                    tv_trip_name.setText(trip_name);
                    tv_tripplace.setText(city_name);
                    tv_tripto.setText(trip_to);
                    tv_tripfrom.setText(trip_from);
                    tv_abouttrip.setText(about_trip);
                    tv_tripdays.setText(trip_days);
                    tv_triphighlight.setText(trip_usp);
                   // tv_priceinclusion.setText(trip_includes);
                   // tv_priceexclusion.setText(trip_excludes);
                    tv_Itinerary.setText(trip_itinerary_details);
                    //tv_complimetary.setText(trip_complimentary);
                    //tv_nearbyplaces.setText(trip_nearby_places);
                   // tv_cancelationpolicy.setText(trip_cancellation_policy);
                   // tv_paymentpolicy.setText(trip_payment_policy);

                    if (whychooseus.equalsIgnoreCase("")){
                        ll_whtchosseus.setVisibility(View.GONE);
                    }
                    else {
                        ll_whtchosseus.setVisibility(View.VISIBLE);
                    }
                    if (trip_notes.equalsIgnoreCase("")){
                        ll_notes.setVisibility(View.GONE);
                    }
                    else {
                        ll_notes.setVisibility(View.VISIBLE);
                    }
                    tv_pickuplocation.setText("KeshavPuram Metro Station evg 5 pm departure and after trip vaishali metro station");

                }
               /* if (!trip_image.equalsIgnoreCase("")) {
                    Picasso.with(HotelProfile.this).load("http://sampledocs.org/trypbuddy/uploads/"+trip_image)
                            .placeholder(R.drawable.demo)
                            .error(R.drawable.demo)
                            .into(iv_tripheader);
                }*/
            } catch (Exception e) {
                e.printStackTrace();
            }
        }}
}

