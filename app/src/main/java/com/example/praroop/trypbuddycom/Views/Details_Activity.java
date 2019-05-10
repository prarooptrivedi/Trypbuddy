package com.example.praroop.trypbuddycom.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.praroop.trypbuddycom.Customfont.MyTextView_Roboto_Medium;
import com.example.praroop.trypbuddycom.Customfont.TextViewSFProDisplayRegular;
import com.example.praroop.trypbuddycom.R;

public class Details_Activity extends AppCompatActivity implements View.OnClickListener {
        String notes="",Heading;
    TextViewSFProDisplayRegular tv_notes;
    MyTextView_Roboto_Medium title;
    ImageView back_arrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);
        Intent i=getIntent();
        notes=i.getStringExtra("notes");
        Heading=i.getStringExtra("Heading");
        Views();
       setintentvalue();
    }

    private void setintentvalue() {
        tv_notes.setText(notes);
        title.setText(Heading);
    }

    private void Views() {
        title=(MyTextView_Roboto_Medium)findViewById(R.id.title);
        back_arrow=(ImageView) findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(this);
        title.setText("Traveller Details");
        tv_notes=(TextViewSFProDisplayRegular)findViewById(R.id.tv_notes);
    }

    @Override
    public void onClick(View view) {
        if (view==back_arrow){
            finish();
        }
    }
}
