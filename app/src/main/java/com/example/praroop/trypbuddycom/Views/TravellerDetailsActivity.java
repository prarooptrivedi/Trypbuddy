package com.example.praroop.trypbuddycom.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.praroop.trypbuddycom.Customfont.MyTextView_Roboto_Medium;
import com.example.praroop.trypbuddycom.R;

public class TravellerDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    MyTextView_Roboto_Medium title;
    ImageView back_arrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traveller_details);
        intviews();
    }
    private void intviews() {
        title=(MyTextView_Roboto_Medium)findViewById(R.id.title);
        back_arrow=(ImageView) findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(this);
        title.setText("Traveller Details");
    }

    @Override
    public void onClick(View view) {
        if (view==back_arrow){
            finish();
        }
    }
}

