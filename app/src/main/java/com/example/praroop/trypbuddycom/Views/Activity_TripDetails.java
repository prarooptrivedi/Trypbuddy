package com.example.praroop.trypbuddycom.Views;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.praroop.trypbuddycom.Adapter.DisplayList_Adpater;
import com.example.praroop.trypbuddycom.Customfont.MyTextView_Roboto_Regular;
import com.example.praroop.trypbuddycom.Fragments.Fragment_Home;
import com.example.praroop.trypbuddycom.Models.CombineDataSetNew;
import com.example.praroop.trypbuddycom.Models.TripListModel;
import com.example.praroop.trypbuddycom.R;
import com.example.praroop.trypbuddycom.Utils.UtilClassForValidations;
import com.example.praroop.trypbuddycom.Webservices.WebService;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;
import ir.apend.slider.model.Slide;
import ir.apend.slider.ui.Slider;

public class Activity_TripDetails extends AppCompatActivity implements View.OnClickListener {
    Slider slider;
    LinearLayout layout_book;
    SliderLayout sliderLayout;
    ACProgressFlower dialog;
    String iid,trip_name,about_trip,trip_from,trip_to,trip_days,category_id,trip_usp,trip_includes,trip_fare,trip_seats,
            trip_complimentary,trip_itinerary_details,
    trip_excludes,trip_payment_policy,trip_cancellation_policy,trip_hotels_recommended,trip_vehicle,trip_discount,trip_video_link,
    trip_nearby_places,trip_notes,trip_image,trip_destination_image,trip_destination_image1,trip_destination_image2,
            trip_destination_image3,
    createdon,createdby,modifiedon,organizedby,whychooseus,forgroup,latitude,longitude,
            trip_destination_image4,trip_destination_image5,trip_destination_image6,trip_destination_image7,
            trip_destination_image8,
    transport,food,activity,guide,accomodation,trip_city;
    MyTextView_Roboto_Regular tv_exclusion,tv_includes,tv_abouttrip,tv_tripname,tv_tripdays,tv_tripammout,tv_complimetary,
            tv_numofseat,tv_tripcity,tv_triphighlight,tv_nearbyplaces,tv_intneary,tv_paymentpolicy,tv_cancelationpolicy,tv_whytravelwithus,tv_discount;
    String id="";
    CardView card_whytravel,card_cancelationpolicy;
    LinearLayout ll_hostcontact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__trip_details);
        try{
            Intent i=getIntent();
            id=i.getStringExtra("id");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        slider = findViewById(R.id.slider);
        layout_book = findViewById(R.id.layout_book);
        layout_book.setOnClickListener(this);
        List<Slide> slideList = new ArrayList<>();
        slideList.add(new Slide(0,"http://cssslider.com/sliders/demo-20/data1/images/picjumbo.com_img_4635.jpg" , R.dimen.slider_image_corner));
        slideList.add(new Slide(1,"http://cssslider.com/sliders/demo-12/data1/images/picjumbo.com_hnck1995.jpg" ,  R.dimen.slider_image_corner));
        slideList.add(new Slide(2,"http://cssslider.com/sliders/demo-19/data1/images/picjumbo.com_hnck1588.jpg" ,  R.dimen.slider_image_corner));
        slideList.add(new Slide(3,"http://wowslider.com/sliders/demo-18/data1/images/shanghai.jpg" ,  R.dimen.slider_image_corner));

//handle slider click listener
        slider.setItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //do what you want
            }
        });

//add slides to slider
        slider.addSlides(slideList);

        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :

        setSliderViews();
        intAll();
        if (UtilClassForValidations.haveInternet(Activity_TripDetails.this)){
            dialog = new ACProgressFlower.Builder(Activity_TripDetails.this)
                    .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                    .themeColor(Color.WHITE)
                    .text("Loading...")
                    .fadeColor(Color.DKGRAY).build();
            dialog.show();
            new callToLoadDetails().execute();
        }
        else {
            Toast.makeText(Activity_TripDetails.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }

    }

    private void intAll() {
        tv_abouttrip=(MyTextView_Roboto_Regular)findViewById(R.id.tv_abouttrip);
        tv_tripname=(MyTextView_Roboto_Regular)findViewById(R.id.tv_tripname);
        tv_tripdays=(MyTextView_Roboto_Regular)findViewById(R.id.tv_tripdays);
        tv_tripammout=(MyTextView_Roboto_Regular)findViewById(R.id.tv_tripammout);
        tv_numofseat=(MyTextView_Roboto_Regular)findViewById(R.id.tv_numofseat);
        tv_tripcity=(MyTextView_Roboto_Regular)findViewById(R.id.tv_tripcity);
        tv_triphighlight=(MyTextView_Roboto_Regular)findViewById(R.id.tv_triphighlight);
        tv_includes=(MyTextView_Roboto_Regular)findViewById(R.id.tv_includes);
        tv_exclusion=(MyTextView_Roboto_Regular)findViewById(R.id.tv_exclusion);
        tv_complimetary=(MyTextView_Roboto_Regular)findViewById(R.id.tv_complimetary);
        tv_intneary=(MyTextView_Roboto_Regular)findViewById(R.id.tv_intneary);
        tv_paymentpolicy=(MyTextView_Roboto_Regular)findViewById(R.id.tv_paymentpolicy);
        tv_cancelationpolicy=(MyTextView_Roboto_Regular)findViewById(R.id.tv_cancelationpolicy);
        tv_nearbyplaces=(MyTextView_Roboto_Regular)findViewById(R.id.tv_nearbyplaces);
        tv_whytravelwithus=(MyTextView_Roboto_Regular)findViewById(R.id.tv_whytravelwithus);
        tv_discount=(MyTextView_Roboto_Regular)findViewById(R.id.tv_discount);
        card_whytravel=(CardView) findViewById(R.id.card_whytravel);
        card_cancelationpolicy=(CardView) findViewById(R.id.card_cancelationpolicy);
        ll_hostcontact=(LinearLayout) findViewById(R.id.ll_hostcontact);
        ll_hostcontact.setOnClickListener(this);
    }

    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            SliderView sliderView = new SliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageUrl("https://images.pexels.com/photos/547114/pexels-photo-547114.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
                case 1:
                    sliderView.setImageUrl("https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
                case 2:
                    sliderView.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
                    break;
                case 3:
                    sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
          //  sliderView.setDescription("setDescription " + (i + 1));
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(Activity_TripDetails.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }}

    @Override
    public void onClick(View view) {
        if (view==layout_book){
            Intent i=new Intent(Activity_TripDetails.this,Activity_Select_Person.class);
            startActivity(i);
        }
        if (view==ll_hostcontact){
            Dialog dialog=new Dialog(Activity_TripDetails.this);
            dialog.setContentView(R.layout.layout_callbackdialog);
            dialog.show();
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
                        for (int i = 0; i < numberOfItemsInResp; i++) {
                            JSONObject perResult = jsonArray.getJSONObject(i);
                            iid= perResult.getString("id");
                            trip_name= perResult.getString("trip_name");
                            about_trip= perResult.getString("about_trip");
                            trip_from= perResult.getString("trip_from");
                            trip_to= perResult.getString("trip_to");
                            trip_days= perResult.getString("trip_days");
                            category_id= perResult.getString("category_id");
                            trip_usp= perResult.getString("trip_usp");
                            trip_includes= perResult.getString("trip_includes");
                            trip_fare= perResult.getString("trip_fare");
                            trip_seats= perResult.getString("trip_seats");
                            trip_complimentary= perResult.getString("trip_complimentary");
                            trip_itinerary_details= perResult.getString("trip_itinerary_details");
                            trip_excludes= perResult.getString("trip_excludes");
                            trip_payment_policy= perResult.getString("trip_payment_policy");
                            trip_cancellation_policy= perResult.getString("trip_cancellation_policy");
                            trip_hotels_recommended= perResult.getString("trip_hotels_recommended");
                            trip_vehicle= perResult.getString("trip_vehicle");
                            trip_discount= perResult.getString("trip_discount");
                            trip_video_link= perResult.getString("trip_video_link");
                            trip_nearby_places= perResult.getString("trip_nearby_places");
                            trip_notes= perResult.getString("trip_notes");
                            trip_image= perResult.getString("trip_image");
                            trip_destination_image= perResult.getString("trip_destination_image");
                            trip_destination_image1= perResult.getString("trip_destination_image1");
                            trip_destination_image2= perResult.getString("trip_destination_image2");
                            trip_destination_image3= perResult.getString("trip_destination_image3");
                            createdon= perResult.getString("createdon");
                            createdby= perResult.getString("createdby");
                            modifiedon= perResult.getString("modifiedon");
                            organizedby= perResult.getString("organizedby");
                            whychooseus= perResult.getString("whychooseus");
                            forgroup= perResult.getString("forgroup");
                            latitude= perResult.getString("latitude");
                            longitude= perResult.getString("longitude");
                            trip_destination_image4= perResult.getString("trip_destination_image4");
                            trip_destination_image5= perResult.getString("trip_destination_image5");
                            trip_destination_image6= perResult.getString("trip_destination_image6");
                            trip_destination_image7= perResult.getString("trip_destination_image7");
                            trip_destination_image8= perResult.getString("trip_destination_image8");
                            transport= perResult.getString("transport");
                            food= perResult.getString("food");
                            activity= perResult.getString("activity");
                            guide= perResult.getString("guide");
                            accomodation= perResult.getString("accomodation");
                            trip_city= perResult.getString("trip_city");

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
                if (!iid.equalsIgnoreCase("")) {
                    tv_abouttrip.setText(about_trip);
                    tv_tripname.setText(trip_name);
                    tv_tripdays.setText(trip_days);
                    tv_numofseat.setText(trip_seats+" Adult");
                    tv_tripcity.setText(trip_city);
                    tv_triphighlight.setText(trip_usp);
                    tv_includes.setText(trip_includes);
                    tv_exclusion.setText(trip_excludes);
                    tv_complimetary.setText(trip_complimentary);
                    tv_intneary.setText(trip_itinerary_details);
                    tv_paymentpolicy.setText(trip_payment_policy);
                    tv_cancelationpolicy.setText(trip_cancellation_policy);
                    tv_whytravelwithus.setText(whychooseus);
                    tv_nearbyplaces.setText(trip_nearby_places);
                    tv_discount.setText("Trypbuddy discount "+trip_discount.replace(".00",""));
                    tv_tripammout.setText(trip_fare.replace(".00","")+" / Per Person");
                    if (whychooseus.equalsIgnoreCase("")||whychooseus==null){
                        card_whytravel.setVisibility(View.GONE);

                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }}
}
