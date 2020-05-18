package com.example.trypbuddy.Model

import com.google.gson.annotations.SerializedName

class BlogModel:BaseModels() {
    @SerializedName("data")
    var data: ArrayList<Data>? = null

    class Data {
        @SerializedName("id")
        var id: String? = null

        @SerializedName("blog_name")
        var blog_name: String? = null

        @SerializedName("blog_desc")
        var blog_desc: String? = null

        @SerializedName("blog_image")
        var blog_image: String? = null

        @SerializedName("blog_image1")
        var blog_image1: String? = null

        @SerializedName("blog_image2")
        var blog_image2: String? = null

        @SerializedName("blog_image3")
        var blog_image3: String? = null

        @SerializedName("status")
        var status: String? = null


        }

}