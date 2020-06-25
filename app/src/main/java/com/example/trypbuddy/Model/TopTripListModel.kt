package com.example.trypbuddy.Model

import com.google.gson.annotations.SerializedName

class TopTripListModel:BaseModels() {
    @SerializedName("data")
    var data: ArrayList<Data>? = null

    class Data {
        @SerializedName("id")
        var id: String? = null

        @SerializedName("forgroup")
        var forgroup: String? = null

        @SerializedName("trip_name")
        var trip_name: String? = null

        @SerializedName("trip_image")
        var trip_image: String? = null

        @SerializedName("trip_days")
        var trip_days: String? = null

        @SerializedName("trip_fare")
        var trip_fare: String? = null

        @SerializedName("category_id")
        var category_id: String? = null

        @SerializedName("trip_discount")
        var trip_discount: String? = null


        @SerializedName("trip_from")
        var trip_from: String? = null

        @SerializedName("trip_to")
        var trip_to: String? = null

        @SerializedName("trip_city")
        var trip_city: String? = null

        @SerializedName("city_name")
        var city_name: String? = null

        @SerializedName("vehicle_name")
        var vehicle_name: String? = null

        @SerializedName("createdby")
        var createdby: String? = null

        @SerializedName("createdby_name")
        var createdby_name: String? = null

        @SerializedName("category_name")
        var category_name: String? = null

        @SerializedName("wishlist")
        var wishlist: String? = null

        @SerializedName("bookmark")
        var bookmark: String? = null

        @SerializedName("merchant_id")
        var merchant_id: String? = null

    }

}