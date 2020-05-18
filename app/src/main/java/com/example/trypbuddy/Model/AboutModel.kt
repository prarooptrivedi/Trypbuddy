package com.example.trypbuddy.Model

import com.google.gson.annotations.SerializedName

class AboutModel:BaseModels() {
    @SerializedName("data")
    var data: ArrayList<Data>? = null

    class Data {
        @SerializedName("id")
        var id: String? = null

        @SerializedName("mtext")
        var mtext: String? = null


        }

}