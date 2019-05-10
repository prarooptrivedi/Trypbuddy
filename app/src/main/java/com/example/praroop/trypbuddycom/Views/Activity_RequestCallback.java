package com.example.praroop.trypbuddycom.Views;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.praroop.trypbuddycom.Adapter.Display_Adpater;
import com.example.praroop.trypbuddycom.Fragments.Fragment_Home;
import com.example.praroop.trypbuddycom.Models.CategoryModel;
import com.example.praroop.trypbuddycom.Models.CombineDataSetNew;
import com.example.praroop.trypbuddycom.R;
import com.example.praroop.trypbuddycom.Utils.UtilClassForValidations;
import com.example.praroop.trypbuddycom.Webservices.WebService;
import com.hbb20.CountryCodePicker;

import org.json.JSONArray;
import org.json.JSONObject;

public class Activity_RequestCallback extends AppCompatActivity implements View.OnClickListener {
        EditText edittext_mobilenumber;
        Button btn_callme;
    CountryCodePicker ccp;
    String countryCodeAndroid = "+91";
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__request_callback);
        intall();
    }

    private void intall() {
        btn_callme=(Button)findViewById(R.id.btn_callme);
        btn_callme.setOnClickListener(this);
        edittext_mobilenumber=(EditText) findViewById(R.id.edittext_mobilenumber);
        ccp=(CountryCodePicker) findViewById(R.id.ccp);
        ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                countryCodeAndroid = ccp.getSelectedCountryCode();
            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view==btn_callme){
            if (UtilClassForValidations.haveInternet(Activity_RequestCallback.this)){
                pd = ProgressDialog.show(Activity_RequestCallback.this, "",
                        "Signing In..", true, false);
                pd.setCancelable(false);
                pd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                pd.setContentView(R.layout.demoprogrees);
                pd.setCanceledOnTouchOutside(false);
                new callToLoadData().execute();
            }
            else {
                Toast.makeText(Activity_RequestCallback.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        }
    }
    class callToLoadData extends AsyncTask<String, Integer, CombineDataSetNew> {
        protected CombineDataSetNew doInBackground(String... arg0) {
            CombineDataSetNew Response = null;
            try {
                Response = WebService.submitcallback("Praroop","A","12345677890",countryCodeAndroid,edittext_mobilenumber.getText().toString());
                if (Response != null) {
                    try {
                       /* JSONArray jsonArray = Response.getJsonArray();
                        final int numberOfItemsInResp = jsonArray.length();
                        for (int i = 0; i < numberOfItemsInResp; i++) {
                            JSONObject perResult = jsonArray.getJSONObject(i);
                            CategoryModel inboxDataset = new CategoryModel();
                            inboxDataset.setId(perResult.getString("id"));
                            inboxDataset.setCategory_name(perResult.getString("category_name"));
                            inboxDataset.setCategory_image(perResult.getString("category_image"));
                            inboxDataset.setCreatedon(perResult.getString("createdon"));
                            inboxDataset.setCreatedby(perResult.getString("createdby"));
                            categoryModels.add(inboxDataset);*/
                       // }
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
                pd.dismiss();
                pd.cancel();
                /*if (!categoryModels.isEmpty()) {
                    Display_Adpater mAdapter = new Display_Adpater(categoryModels,getActivity());
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,true);
                    recyclerviewr_catagory.setLayoutManager(mLayoutManager);
                    recyclerviewr_catagory.setItemAnimator(new DefaultItemAnimator());
                    recyclerviewr_catagory.setAdapter(mAdapter);

                }*/

            } catch (Exception e) {
                e.printStackTrace();
            }
        }}
}
