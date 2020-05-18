package com.example.trypbuddy.Views

import android.os.Bundle
import io.vrinda.kotlinpermissions.PermissionsActivity

import java.util.*

/**
 * Created by Praroop on 20-05-2019.
 */

abstract class BaseActivity : PermissionsActivity(), Observer {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model = getModel()
        model.addObserver(this)
    }

    abstract fun getModel(): Observable

}
