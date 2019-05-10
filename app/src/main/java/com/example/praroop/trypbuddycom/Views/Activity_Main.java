package com.example.praroop.trypbuddycom.Views;

import android.app.Dialog;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.praroop.trypbuddycom.Fragments.FragmentNotification;
import com.example.praroop.trypbuddycom.Fragments.Fragment_Home;
import com.example.praroop.trypbuddycom.Fragments.Fragment_Profile;
import com.example.praroop.trypbuddycom.Fragments.Fragment_Search;
import com.example.praroop.trypbuddycom.Fragments.Fragment_Wishlist;
import com.example.praroop.trypbuddycom.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class Activity_Main extends AppCompatActivity {

    BottomBar bottomBar;
    FrameLayout frameLayout;
    private String token,versionName;
    private int versionCode;
    private boolean isCall = false;
    private String hasCard,hasActivated;
    private Dialog slideDialog;
    private TextView tvupdate;
    private TextView tvskip,tvupdatediscription;
    private boolean callUpdateservice;

    private int selectedTabId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__main1);

        frameLayout = (FrameLayout) findViewById(R.id.framelayout);


        bottomBar = (BottomBar) findViewById(R.id.bottombar);
        for (int i = 0; i < bottomBar.getTabCount(); i++) {
            bottomBar.getTabAtPosition(i).setGravity(Gravity.CENTER_VERTICAL);
        }
        frameLayout = (FrameLayout) findViewById(R.id.framelayout);


        isCall = true;


        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        selectedTabId =R.id.home;
                        replace_fragment(new Fragment_Search());

                        break;
                    case R.id.tab_search:
                        selectedTabId =R.id.discover;
                        replace_fragment(new FragmentNotification());

                        break;
                    case R.id.tab_favorites:
                        selectedTabId =R.id.schedule;
                        replace_fragment(new Fragment_Wishlist());

                        break;

                    case R.id.tab_notification:
                        selectedTabId =R.id.favorite;
                        replace_fragment(new FragmentNotification());
                        break;
                    case R.id.tab_profile:
                        selectedTabId =R.id.more;
                        replace_fragment(new Fragment_Profile());

                        break;

                }


            }
        });
    }


    public void replace_fragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();
    }


}
