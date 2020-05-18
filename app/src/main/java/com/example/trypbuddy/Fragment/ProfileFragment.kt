package com.wajahatkarim3.bottomnavigationdemo

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.example.trypbuddy.R
import com.example.trypbuddy.Views.*
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import io.vrinda.kotlinpermissions.PermissionCallBack
import io.vrinda.kotlinpermissions.PermissionsActivity

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment(),PermissionListener {

    var linear_aboutus:LinearLayout?=null
    var linear_faq:LinearLayout?=null
    var linear_privacy:LinearLayout?=null
    var linear_terms:LinearLayout?=null
    var ll_help:LinearLayout?=null
    var layout_callback:LinearLayout?=null
    var ll_blog:LinearLayout?=null
    var ll_wishlist:LinearLayout?=null
    var ll_bookmark:LinearLayout?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_profile, container, false)

        linear_aboutus=view.findViewById(R.id.linear_aboutus)
        linear_faq=view.findViewById(R.id.linear_faq)
        linear_privacy=view.findViewById(R.id.linear_privacy)
        linear_terms=view.findViewById(R.id.linear_terms)
        ll_help=view.findViewById(R.id.ll_help)
        layout_callback=view.findViewById(R.id.layout_callback)
        ll_blog=view.findViewById(R.id.ll_blog)
        ll_wishlist=view.findViewById(R.id.ll_wishlist)
        ll_bookmark=view.findViewById(R.id.ll_bookmark)
        ll_blog!!.setOnClickListener(View.OnClickListener {
            val intent=Intent(activity,BlogScreen::class.java)
            startActivity(intent)
        })
        linear_aboutus!!.setOnClickListener(View.OnClickListener {
            val intent=Intent(activity,AbountUsScreen::class.java)
            startActivity(intent)
        })
        linear_faq!!.setOnClickListener(View.OnClickListener {
            val intent=Intent(activity,FaqScreen::class.java)
            startActivity(intent)
        })
        linear_privacy!!.setOnClickListener(View.OnClickListener {
            val intent=Intent(activity,PrivacyAndPolicyScreen::class.java)
            startActivity(intent)
        })
        linear_terms!!.setOnClickListener(View.OnClickListener {
            val intent=Intent(activity,TermsandConditionScreen::class.java)
            startActivity(intent)
        })
        layout_callback!!.setOnClickListener(View.OnClickListener {
            val intent=Intent(activity,EnquiryScreen::class.java)
            startActivity(intent)
        })
        ll_wishlist!!.setOnClickListener(View.OnClickListener {
            val intent=Intent(activity,WishListScreen::class.java)
            startActivity(intent)
        })
        ll_bookmark!!.setOnClickListener(View.OnClickListener {
            val intent=Intent(activity,BookMarkListScreen::class.java)
            startActivity(intent)
        })
        ll_help!!.setOnClickListener(View.OnClickListener {
            Dexter.withActivity(activity)
                .withPermission(Manifest.permission.CALL_PHONE)
                .withListener(this)
                .check()

        })
        return  view
    }

    override fun onPermissionGranted(response: PermissionGrantedResponse?) {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:" + "9582646447")//9999909292
        startActivity(callIntent)
    }

    override fun onPermissionRationaleShouldBeShown(permission: PermissionRequest?, token: PermissionToken?) {

    }

    override fun onPermissionDenied(response: PermissionDeniedResponse?) {

    }


}
