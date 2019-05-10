package com.example.praroop.trypbuddycom.Fragments;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.praroop.trypbuddycom.Adapter.HomePageStoryAdapter;
import com.example.praroop.trypbuddycom.Adapter.OtherRecomdedAdapeter;
import com.example.praroop.trypbuddycom.Adapter.TopTripAdapter;
import com.example.praroop.trypbuddycom.Models.CategoryModel;
import com.example.praroop.trypbuddycom.Models.CombineDataSetNew;
import com.example.praroop.trypbuddycom.Models.TripListModel;
import com.example.praroop.trypbuddycom.R;
import com.example.praroop.trypbuddycom.Utils.UtilClassForValidations;
import com.example.praroop.trypbuddycom.Webservices.WebService;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;

/**
 * Created by Wolf Soft on 10/10/2017.
 */

public class Fragment_Search extends Fragment {
    ArrayList<TripListModel> listModels =new ArrayList<TripListModel>();
    ArrayList<TripListModel> listModels1 =new ArrayList<TripListModel>();
    ACProgressFlower dialog;
    private RecyclerView toppicksrecyview,otherrecommrecyview,hpstoryrecyview;
    private TopTripAdapter topTripAdapter;
    private HomePageStoryAdapter homePageStoryAdapter;
    private OtherRecomdedAdapeter otherRecommendationsAdapter;
    View view;
    ArrayList<CategoryModel> categoryModels =new ArrayList<CategoryModel>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        toppicksrecyview = view.findViewById(R.id.toppicksrecyview);
        if (UtilClassForValidations.haveInternet(getActivity())){
            dialog = new ACProgressFlower.Builder(getActivity())
                    .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                    .themeColor(Color.WHITE)
                    .text("Loading...")
                    .fadeColor(Color.DKGRAY).build();
            dialog.show();
            new callToLoadCategory().execute();
        }
        else {
            Toast.makeText(getActivity(), "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);





    }

    class callToLoadCategory extends AsyncTask<String, Integer, CombineDataSetNew> {
        protected CombineDataSetNew doInBackground(String... arg0) {
            CombineDataSetNew Response = null;
            try {
                Response = WebService.offercoupon(
                );
                if (Response != null) {
                    try {
                        JSONArray jsonArray = Response.getJsonArray();
                        final int numberOfItemsInResp = jsonArray.length();
                        for (int i = 0; i < numberOfItemsInResp; i++) {
                            JSONObject perResult = jsonArray.getJSONObject(i);
                            CategoryModel inboxDataset = new CategoryModel();
                            inboxDataset.setId(perResult.getString("id"));
                            inboxDataset.setCategory_name(perResult.getString("category_name"));
                            inboxDataset.setCategory_image(perResult.getString("category_image"));
                            inboxDataset.setCreatedon(perResult.getString("createdon"));
                            inboxDataset.setCreatedby(perResult.getString("createdby"));
                            categoryModels.add(inboxDataset);
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

                if (!categoryModels.isEmpty()) {
                    hpstoryrecyview = view.findViewById(R.id.hpstoryrecyview);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
                    hpstoryrecyview.setLayoutManager(layoutManager);
                    hpstoryrecyview.setItemAnimator(new DefaultItemAnimator());
                    homePageStoryAdapter = new HomePageStoryAdapter(getActivity(),categoryModels);
                    hpstoryrecyview.setAdapter(homePageStoryAdapter);
                    new callToLoadList().execute();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }}
    class callToLoadList extends AsyncTask<String, Integer, CombineDataSetNew> {
        protected CombineDataSetNew doInBackground(String... arg0) {
            CombineDataSetNew Response = null;
            try {
                Response = WebService.LoadList("0");
                if (Response != null) {
                    try {
                        JSONArray jsonArray = Response.getJsonArray();
                        final int numberOfItemsInResp = jsonArray.length();
                        for (int i = 0; i < numberOfItemsInResp; i++) {
                            JSONObject perResult = jsonArray.getJSONObject(i);
                            TripListModel inboxDataset = new TripListModel();
                            inboxDataset.setId(perResult.getString("id"));
                            inboxDataset.setForgroup(perResult.getString("forgroup"));
                            inboxDataset.setTrip_name(perResult.getString("trip_name"));
                            inboxDataset.setTrip_image(perResult.getString("trip_image"));
                            inboxDataset.setTrip_days(perResult.getString("trip_days"));
                            inboxDataset.setTrip_fare(perResult.getString("trip_fare"));
                            inboxDataset.setCategory_id(perResult.getString("category_id"));
                            inboxDataset.setTrip_discount(perResult.getString("trip_discount"));
                            inboxDataset.setTrip_from(perResult.getString("trip_from"));
                            inboxDataset.setTrip_to(perResult.getString("trip_to"));
                            listModels.add(inboxDataset);
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

                if (!listModels.isEmpty()) {
                    RecyclerView.LayoutManager layoutManagerluxuryhotels = new LinearLayoutManager(getActivity());
                    toppicksrecyview.setLayoutManager(layoutManagerluxuryhotels);
                    toppicksrecyview.setItemAnimator(new DefaultItemAnimator());
                    topTripAdapter = new TopTripAdapter(getActivity(),listModels);
                    toppicksrecyview.setAdapter(topTripAdapter);
                    new callToLoadList1().execute();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }}
    class callToLoadList1 extends AsyncTask<String, Integer, CombineDataSetNew> {
        protected CombineDataSetNew doInBackground(String... arg0) {
            CombineDataSetNew Response = null;
            try {
                Response = WebService.LoadList("0");
                if (Response != null) {
                    try {
                        JSONArray jsonArray = Response.getJsonArray();
                        final int numberOfItemsInResp = jsonArray.length();
                        for (int i = 0; i < numberOfItemsInResp; i++) {
                            JSONObject perResult = jsonArray.getJSONObject(i);
                            TripListModel inboxDataset = new TripListModel();
                            inboxDataset.setId(perResult.getString("id"));
                            inboxDataset.setForgroup(perResult.getString("forgroup"));
                            inboxDataset.setTrip_name(perResult.getString("trip_name"));
                            inboxDataset.setTrip_image(perResult.getString("trip_image"));
                            inboxDataset.setTrip_days(perResult.getString("trip_days"));
                            inboxDataset.setTrip_fare(perResult.getString("trip_fare"));
                            inboxDataset.setCategory_id(perResult.getString("category_id"));
                            inboxDataset.setTrip_discount(perResult.getString("trip_discount"));
                            inboxDataset.setTrip_from(perResult.getString("trip_from"));
                            inboxDataset.setTrip_to(perResult.getString("trip_to"));
                            listModels1.add(inboxDataset);
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
            dialog.dismiss();
            try {
                dialog.dismiss();
                if (!listModels.isEmpty()) {
                    otherrecommrecyview = view.findViewById(R.id.otherrecommrecyview);
                    RecyclerView.LayoutManager layoutManagerbythesea = new GridLayoutManager(getActivity(),2);
                    otherrecommrecyview.setLayoutManager(layoutManagerbythesea);
                    otherrecommrecyview.setItemAnimator(new DefaultItemAnimator());
                    otherRecommendationsAdapter = new OtherRecomdedAdapeter(getActivity(),listModels1);
                    otherrecommrecyview.setAdapter(otherRecommendationsAdapter);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }}

}
