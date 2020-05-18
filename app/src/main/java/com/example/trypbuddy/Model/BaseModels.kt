package com.example.trypbuddy.Model

import com.google.gson.annotations.SerializedName

/**
 *
 * Created by praroop on 26-11-2018.
 */
 // base modal to use set status and message
open class BaseModels {

    @SerializedName("message")
    var message: String? = null

    @SerializedName("status")
    var status: String? = null

}

