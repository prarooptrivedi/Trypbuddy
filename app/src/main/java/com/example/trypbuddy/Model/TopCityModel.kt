package com.example.trypbuddy.Model

import com.google.gson.annotations.SerializedName

class TopCityModel:BaseModels() {
    @SerializedName("data")
    var data: ArrayList<Data>? = null

    class Data {
        @SerializedName("id")
        var id: String? = null

        @SerializedName("city_name")
        var city_name: String? = null

        @SerializedName("city_image")
        var city_image: String? = null

        @SerializedName("status")
        var status: String? = null

        @SerializedName("createdon")
        var createdon: String? = null

        @SerializedName("createdby")
        var createdby: String? = null

        @SerializedName("modifiedon")
        var modifiedon: String? = null

        }

}