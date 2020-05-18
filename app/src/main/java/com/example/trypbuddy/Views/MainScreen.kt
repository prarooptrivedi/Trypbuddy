package com.example.trypbuddy.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.trypbuddy.R

class MainScreen : AppCompatActivity(),View.OnClickListener {


    var text_logintext:TextView?=null
    var text_skip:TextView?=null
    var btn_loginemail:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login__screen)
        initViews()
    }

    private fun initViews() {
        text_logintext=findViewById(R.id.text_logintext)
        btn_loginemail=findViewById(R.id.btn_loginemail)
        text_skip=findViewById(R.id.text_skip)
        text_logintext!!.setOnClickListener(this)
        btn_loginemail!!.setOnClickListener(this)
        text_skip!!.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
       if (v==text_logintext){
           val intent=Intent(applicationContext,LoginScreen::class.java)
           startActivity(intent)
       }
        if (v==btn_loginemail){
           val intent=Intent(applicationContext,RegisterScreen::class.java)
           startActivity(intent)
       }
        if (v==text_skip){
           val intent=Intent(applicationContext,LoginScreen::class.java)
           startActivity(intent)
       }
    }
}
