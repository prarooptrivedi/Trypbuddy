package com.example.praroop.trypbuddycom.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.praroop.trypbuddycom.Customfont.MyTextView_Roboto_Regular;
import com.example.praroop.trypbuddycom.R;

public class Activity_ReviewBooking extends AppCompatActivity implements View.OnClickListener {
    MyTextView_Roboto_Regular btn_proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__review_booking);
        intAll();
    }

    private void intAll() {
        btn_proceed=(MyTextView_Roboto_Regular)findViewById(R.id.btn_proceed);
        btn_proceed.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==btn_proceed){
            Intent i=new Intent(Activity_ReviewBooking.this,Activity_PaymentFeatures.class);
            startActivity(i);
        }
    }
}
