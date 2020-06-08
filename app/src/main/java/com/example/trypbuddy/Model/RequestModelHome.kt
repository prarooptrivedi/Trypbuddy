package com.example.trypbuddy.Model

data class RequestModelHome(var token : String)
data class RequestTripModel(var token : String,var category_id:String,var uid:String)
data class RequestAccessoriesModel(var token : String,var category_id:String)
data class RequestTripDetailsModel(var token : String,var id:String)
data class RequestTripCityModel(var token : String,var city_id:String)
data class RequestWishlistModel(var token : String,var user_id:String)
data class RequestWishlistSubmitModel(var token : String,var userid:String,var tripid:String,var merchantid:String,var status:String,val type:String)
data class RequestContactusModel(var token : String,var emailid:String,var mobileno:String,var name:String,var message:String,var  deviceid:String)
data class RequestTripCallBackModel(var token : String,var userid:String,var tripid:String,var merchantid:String,var name:String,
                                    var  todate:String,var fromdate:String,var pincode:String,
                                    var emailid:String,var num_of_adult:String,var remarks:String,var mobile:String)
data class RequestAccessoriesCallBackModel(var token : String,var userid:String,var paid:String,var merchantid:String,var fromdate:String,
                                    var  todate:String,var name:String,var emailid:String,
                                    var remarks:String,var mobile:String)
data class RequestTripBooking(var token : String,var tripid:String,var bookingdate:String,var fromdate:String,var todate:String,
                                           var  numberofadult:String,var userid:String,var merchantid:String,
                                           var username:String,var useremail:String,var userphone:String)