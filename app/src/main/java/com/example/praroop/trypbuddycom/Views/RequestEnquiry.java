package com.example.praroop.trypbuddycom.Views;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.praroop.trypbuddycom.Customfont.MyTextView_Roboto_Medium;
import com.example.praroop.trypbuddycom.R;


public class RequestEnquiry extends Activity {
    MyTextView_Roboto_Medium title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.requestenquiry);
        intviews();

    }

    private void intviews() {
        title=(MyTextView_Roboto_Medium)findViewById(R.id.title);
        title.setText("Enquire Now");
    }

}
