package com.example.trypbuddy.Model

data class RequestModelHome(var token : String)
data class RequestTripModel(var token : String,var category_id:String,var uid:String)
data class RequestAccessoriesModel(var token : String,var category_id:String)
data class RequestTripDetailsModel(var token : String,var id:String)
data class RequestTripCityModel(var token : String,var city_id:String)
data class RequestWishlistModel(var token : String,var user_id:String)
data class RequestWishlistSubmitModel(var token : String,var userid:String,var tripid:String,var merchantid:String,var status:String)
data class RequestContactusModel(var token : String,var emailid:String,var mobileno:String,var name:String,var message:String,var  deviceid:String)