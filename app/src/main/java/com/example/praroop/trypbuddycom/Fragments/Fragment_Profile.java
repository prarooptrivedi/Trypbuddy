package com.example.praroop.trypbuddycom.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.praroop.trypbuddycom.R;
import com.example.praroop.trypbuddycom.Views.Activity_AboutUs;
import com.example.praroop.trypbuddycom.Views.Activity_Faq;
import com.example.praroop.trypbuddycom.Views.Activity_PrivacyPolicy;
import com.example.praroop.trypbuddycom.Views.Activity_RequestCallback;
import com.example.praroop.trypbuddycom.Views.Activity_Termsandcondition;

/**
 * Created by Wolf Soft on 10/10/2017.
 */

public class Fragment_Profile extends Fragment implements View.OnClickListener {

    View view;
    LinearLayout layout_callback,linear_aboutus,linear_faq,linear_terms,linear_privacy;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        intall();
        return view;
    }

    private void intall() {
        layout_callback=(LinearLayout)view.findViewById(R.id.layout_callback);
        linear_aboutus=(LinearLayout)view.findViewById(R.id.linear_aboutus);
        linear_faq=(LinearLayout)view.findViewById(R.id.linear_faq);
        linear_terms=(LinearLayout)view.findViewById(R.id.linear_terms);
        linear_privacy=(LinearLayout)view.findViewById(R.id.linear_privacy);
        layout_callback.setOnClickListener(this);
        linear_aboutus.setOnClickListener(this);
        linear_faq.setOnClickListener(this);
        linear_terms.setOnClickListener(this);
        linear_privacy.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);





    }


    @Override
    public void onClick(View view) {
        if (view==layout_callback){
        Intent i=new Intent(getActivity(), Activity_RequestCallback.class);
        startActivity(i);

        }
        if (view==linear_aboutus){
        Intent i=new Intent(getActivity(), Activity_AboutUs.class);
        startActivity(i);

        }
        if (view==linear_faq){
        Intent i=new Intent(getActivity(), Activity_Faq.class);
        startActivity(i);

        }
        if (view==linear_terms){
        Intent i=new Intent(getActivity(), Activity_Termsandcondition.class);
        startActivity(i);

        }
        if (view==linear_privacy){
        Intent i=new Intent(getActivity(), Activity_PrivacyPolicy.class);
        startActivity(i);

        }
    }
}
