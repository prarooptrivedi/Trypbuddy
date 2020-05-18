package com.example.trypbuddy.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.trypbuddy.R

class LoginScreen : AppCompatActivity(),View.OnClickListener {


    var text_signup:TextView?=null
    var btn_login:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        initViews()
    }

    private fun initViews() {
        text_signup=findViewById(R.id.text_signup)
        btn_login=findViewById(R.id.btn_login)
        text_signup!!.setOnClickListener(this)
        btn_login!!.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        if (v==text_signup){
            val intent=Intent(applicationContext,RegisterScreen::class.java)
            startActivity(intent)
        }
        if (v==btn_login){
            val intent=Intent(applicationContext,DashboardScreen::class.java)
            startActivity(intent)
        }
    }
}
