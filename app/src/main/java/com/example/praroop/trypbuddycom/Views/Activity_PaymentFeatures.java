package com.example.praroop.trypbuddycom.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.praroop.trypbuddycom.Adapter.PaymentRecycleAdapter;
import com.example.praroop.trypbuddycom.Models.PaymentModelClass;
import com.example.praroop.trypbuddycom.R;

import java.util.ArrayList;

public class Activity_PaymentFeatures extends AppCompatActivity {
    LinearLayout ll_pay;
    TextView textView;


    private ArrayList<PaymentModelClass> paymentModelClasses;
    private RecyclerView category_recyclerView;
    private PaymentRecycleAdapter mAdapter1;

    private Integer image[] = {R.drawable.ic_credit, R.drawable.ic_credit_gray, R.drawable.ic_netbanking, R.drawable.ic_payathotel};
    private String title[] = {"Debit Card", "Credit Card", "Net Banking", "Pay @ Hotel"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__payment_features);
        ll_pay = (LinearLayout) findViewById(R.id.ll_pay);
        textView = (TextView) findViewById(R.id.title);

        textView.setText("Payment");


        category_recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        paymentModelClasses = new ArrayList<>();


        for (int i = 0; i < image.length; i++) {
            PaymentModelClass beanClassForRecyclerView_contacts = new PaymentModelClass(image[i], title[i]);

            paymentModelClasses.add(beanClassForRecyclerView_contacts);
        }


        mAdapter1 = new PaymentRecycleAdapter(Activity_PaymentFeatures.this, paymentModelClasses);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(Activity_PaymentFeatures.this, LinearLayoutManager.HORIZONTAL, false);
        category_recyclerView.setLayoutManager(mLayoutManager1);


        category_recyclerView.setLayoutManager(mLayoutManager1);
        category_recyclerView.setItemAnimator(new DefaultItemAnimator());
        category_recyclerView.setAdapter(mAdapter1);
    }
}