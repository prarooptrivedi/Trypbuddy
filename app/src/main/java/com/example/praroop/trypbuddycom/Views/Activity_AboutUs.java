package com.example.praroop.trypbuddycom.Views;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.praroop.trypbuddycom.Adapter.Display_Adpater;
import com.example.praroop.trypbuddycom.Customfont.MyTextView_Roboto_Regular;
import com.example.praroop.trypbuddycom.Fragments.Fragment_Home;
import com.example.praroop.trypbuddycom.Models.CategoryModel;
import com.example.praroop.trypbuddycom.Models.CombineDataSetNew;
import com.example.praroop.trypbuddycom.R;
import com.example.praroop.trypbuddycom.Utils.UtilClassForValidations;
import com.example.praroop.trypbuddycom.Webservices.WebService;

import org.json.JSONArray;
import org.json.JSONObject;

import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;

public class Activity_AboutUs extends AppCompatActivity {
        MyTextView_Roboto_Regular text_aboutus,tv_header;
    ACProgressFlower dialog;
    String aboutus="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__about_us);
        text_aboutus=(MyTextView_Roboto_Regular)findViewById(R.id.text_aboutus);
        tv_header=(MyTextView_Roboto_Regular)findViewById(R.id.tv_header);
        tv_header.setText("About Us");
        if (UtilClassForValidations.haveInternet(Activity_AboutUs.this)){
            dialog = new ACProgressFlower.Builder(Activity_AboutUs.this)
                    .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                    .themeColor(Color.WHITE)
                    .text("Please wait...")
                    .fadeColor(Color.DKGRAY).build();
            dialog.show();
            new callToLoadAboutUs().execute();
        }
        else {
            Toast.makeText(Activity_AboutUs.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }
    class callToLoadAboutUs extends AsyncTask<String, Integer, CombineDataSetNew> {
        protected CombineDataSetNew doInBackground(String... arg0) {
            CombineDataSetNew Response = null;
            try {
                Response = WebService.aboutusload(
                );
                if (Response != null) {
                    try {
                        JSONArray jsonArray = Response.getJsonArray();
                        final int numberOfItemsInResp = jsonArray.length();
                        for (int i = 0; i < numberOfItemsInResp; i++) {
                            JSONObject perResult = jsonArray.getJSONObject(i);
                            aboutus=perResult.getString("mtext");
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
                text_aboutus.setText(aboutus);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }}
}
