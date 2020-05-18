package com.example.trypbuddy.Model

import com.google.gson.annotations.SerializedName

class BannerModel:BaseModels() {
    @SerializedName("data")
    var data: ArrayList<Data>? = null

    class Data {
        @SerializedName("id")
        var id: String? = null

        @SerializedName("banner_type")
        var banner_type: String? = null

        @SerializedName("banner_order")
        var banner_order: String? = null

        @SerializedName("banner_image")
        var banner_image: String? = null


        }

}