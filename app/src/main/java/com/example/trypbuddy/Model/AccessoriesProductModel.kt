package com.example.trypbuddy.Model

import com.google.gson.annotations.SerializedName

class AccessoriesProductModel:BaseModels() {
    @SerializedName("data")
    var data: ArrayList<Data>? = null

    class Data {
        @SerializedName("id")
        var id: String? = null

        @SerializedName("category_id")
        var category_id: String? = null

        @SerializedName("product_name")
        var product_name: String? = null

        @SerializedName("price_perday")
        var price_perday: String? = null

        @SerializedName("product_image1")
        var product_image1: String? = null

        @SerializedName("product_image2")
        var product_image2: String? = null

        @SerializedName("product_image3")
        var product_image3: String? = null


        @SerializedName("product_image4")
        var product_image4: String? = null



        @SerializedName("product_description")
        var product_description: String? = null


    }

}