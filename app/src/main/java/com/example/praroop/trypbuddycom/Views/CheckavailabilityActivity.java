package com.example.praroop.trypbuddycom.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.praroop.trypbuddycom.Customfont.MyTextView_Roboto_Medium;
import com.example.praroop.trypbuddycom.Customfont.TextViewSFProDisplaySemibold;
import com.example.praroop.trypbuddycom.R;


public class CheckavailabilityActivity extends AppCompatActivity implements View.OnClickListener {
    MyTextView_Roboto_Medium title;
    ImageView back_arrow;
    TextViewSFProDisplaySemibold btn_continue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkavailability);
        intviews();
    }
    private void intviews() {
        title=(MyTextView_Roboto_Medium)findViewById(R.id.title);
        back_arrow=(ImageView) findViewById(R.id.back_arrow);
        btn_continue=(TextViewSFProDisplaySemibold) findViewById(R.id.btn_continue);
        back_arrow.setOnClickListener(this);
        btn_continue.setOnClickListener(this);
        title.setText("Check Availability");
    }

    @Override
    public void onClick(View view) {
        if (view==back_arrow){
            finish();
        }
        if (view==btn_continue){
            Intent i=new Intent(CheckavailabilityActivity.this,TravellerDetailsActivity.class);
            startActivity(i);
        }
    }
}
