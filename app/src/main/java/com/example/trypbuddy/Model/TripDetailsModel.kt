package com.example.trypbuddy.Model

import com.google.gson.annotations.SerializedName

class TripDetailsModel:BaseModels() {


    @SerializedName("images")
    var Images: ArrayList<images>? = null

    @SerializedName("amenties")
    var Amenties: ArrayList<amenties>? = null

    @SerializedName("data")
    var Data: ArrayList<data>? = null



    class images {
        @SerializedName("trip_image")
        var trip_image: String? = null
    }

    class amenties {
        @SerializedName("trip_amenties")
        var trip_amenties: String? = null
    }

    class data {
        @SerializedName("id")
        var id: String? = null

     @SerializedName("trip_name")
        var trip_name: String? = null

     @SerializedName("about_trip")
        var about_trip: String? = null

     @SerializedName("trip_from")
        var trip_from: String? = null

     @SerializedName("trip_to")
        var trip_to: String? = null

     @SerializedName("trip_days")
        var trip_days: String? = null

     @SerializedName("category_id")
        var category_id: String? = null

     @SerializedName("trip_usp")
        var trip_usp: String? = null

     @SerializedName("trip_includes")
        var trip_includes: String? = null

     @SerializedName("trip_fare")
        var trip_fare: String? = null

     @SerializedName("trip_seats")
        var trip_seats: String? = null

     @SerializedName("trip_complimentary")
        var trip_complimentary: String? = null

     @SerializedName("trip_itinerary_details")
        var trip_itinerary_details: String? = null

     @SerializedName("trip_excludes")
        var trip_excludes: String? = null

     @SerializedName("trip_payment_policy")
        var trip_payment_policy: String? = null

     @SerializedName("trip_cancellation_policy")
        var trip_cancellation_policy: String? = null

     @SerializedName("trip_hotels_recommended")
        var trip_hotels_recommended: String? = null

     @SerializedName("trip_vehicle")
        var trip_vehicle: String? = null

     @SerializedName("trip_pickup_point")
        var trip_pickup_point: String? = null


     @SerializedName("trip_discount")
        var trip_discount: String? = null

     @SerializedName("trip_video_link")
        var trip_video_link: String? = null

     @SerializedName("trip_nearby_places")
        var trip_nearby_places: String? = null

     @SerializedName("trip_notes")
        var trip_notes: String? = null

     @SerializedName("createdon")
        var createdon: String? = null

     @SerializedName("createdby")
        var createdby: String? = null

     @SerializedName("modifiedon")
        var modifiedon: String? = null

     @SerializedName("organizedby")
        var organizedby: String? = null

     @SerializedName("whychooseus")
        var whychooseus: String? = null

     @SerializedName("forgroup")
        var forgroup: String? = null

     @SerializedName("latitude")
        var latitude: String? = null

     @SerializedName("longitude")
        var longitude: String? = null

     @SerializedName("status")
        var status: String? = null

     @SerializedName("trip_city")
        var trip_city: String? = null

     @SerializedName("city_name")
        var city_name: String? = null

     @SerializedName("vehicle_name")
        var vehicle_name: String? = null

     @SerializedName("createdby_name")
        var createdby_name: String? = null

     @SerializedName("category_name")
        var category_name: String? = null

    }

}