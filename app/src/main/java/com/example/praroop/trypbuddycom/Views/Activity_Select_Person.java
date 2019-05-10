package com.example.praroop.trypbuddycom.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.praroop.trypbuddycom.Customfont.Button_SF_Pro_Display_Medium;
import com.example.praroop.trypbuddycom.Customfont.MyTextView_Roboto_Medium;
import com.example.praroop.trypbuddycom.R;

public class Activity_Select_Person extends AppCompatActivity implements View.OnClickListener {
    MyTextView_Roboto_Medium title;
    Button_SF_Pro_Display_Medium ll_done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__select__person);
        intall();
    }

    private void intall() {
        title=(MyTextView_Roboto_Medium)findViewById(R.id.title);
        ll_done=(Button_SF_Pro_Display_Medium)findViewById(R.id.ll_done);
        ll_done.setOnClickListener(this);
        title.setText("Select Person");
    }

    @Override
    public void onClick(View view) {
        if (view==ll_done){
            Intent i=new Intent(Activity_Select_Person.this,Activity_ReviewBooking.class);
            startActivity(i);
        }
    }
}
