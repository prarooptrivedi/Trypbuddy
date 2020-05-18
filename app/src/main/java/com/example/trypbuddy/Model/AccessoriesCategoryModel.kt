package com.example.trypbuddy.Model

import com.google.gson.annotations.SerializedName

class AccessoriesCategoryModel:BaseModels() {
    @SerializedName("data")
    var data: ArrayList<Data>? = null

    class Data {
        @SerializedName("id")
        var id: String? = null

        @SerializedName("category_name")
        var category_name: String? = null

        @SerializedName("category_image")
        var category_image: String? = null

        @SerializedName("createdon")
        var createdon: String? = null

        @SerializedName("createdby")
        var createdby: String? = null

        @SerializedName("modifiedon")
        var modifiedon: String? = null

        @SerializedName("modifiedby")
        var modifiedby: String? = null


        }

}