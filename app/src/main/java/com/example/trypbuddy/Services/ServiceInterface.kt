package com.example.meetingschedule.Webservice



import com.example.trypbuddy.Model.*
import io.reactivex.Observable
import okhttp3.Call
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*
import retrofit2.http.GET



/**
 * Created by Praroop on 20-05-2019.
 */

interface ServiceInterface {

    companion object {
        val BASE_URL = "http://sampledocs.org/trypbuddy/core/api/"
    }

   /* @FormUrlEncoded
    @POST("tripcategory/listtripcategory.php")
    fun getCategory(@Field("token",encoded = false) token: String): Observable<CategoryModel>*/

    @Headers("Content-Type:application/json")
    @POST("tripcategory/listtripcategory.php")
    fun getCategory(@Body body: Any?) : Observable<CategoryModel>


    @Headers("Content-Type:application/json")
    @POST("trip/listtrip.php")
    fun getTrip(@Body body: Any?) : Observable<TripListModel>


    @Headers("Content-Type:application/json")
    @POST("city/listcitytrips.php")
    fun getCityWiseTrip(@Body body: Any?) : Observable<TripListModel>


    @Headers("Content-Type:application/json")
    @POST("city/listcity.php")
    fun getCity(@Body body: Any?) : Observable<CityListModel>

    @Headers("Content-Type:application/json")
    @POST("banner/listbanner.php")
    fun getBanner(@Body body: Any?) : Observable<BannerModel>


    @Headers("Content-Type:application/json")
    @POST("accessoriescategory/listaccessoriescategory.php")
    fun getAccessoriesCategory(@Body body: Any?) : Observable<AccessoriesCategoryModel>

    @Headers("Content-Type:application/json")
    @POST("productaccessories/listproductaccessories.php")
    fun getAccessoriesProduct(@Body body: Any?) : Observable<AccessoriesProductModel>


    @Headers("Content-Type:application/json")
    @POST("aboutus/listaboutus.php")
    fun getAboutus(@Body body: Any?) : Observable<AboutModel>

    @Headers("Content-Type:application/json")
    @POST("faq/listfaq.php")
    fun getFaq(@Body body: Any?) : Observable<AboutModel>


    @Headers("Content-Type:application/json")
    @POST("privacy/listprivacy.php")
    fun getPrivacyPolicy(@Body body: Any?) : Observable<AboutModel>

    @Headers("Content-Type:application/json")
    @POST("terms/listterms.php")
    fun getTerms(@Body body: Any?) : Observable<AboutModel>


    @Headers("Content-Type:application/json")
    @POST("trip/listtripAll.php")
    fun getTripDetails(@Body body: Any?) : Observable<TripDetailsModel>

    @Headers("Content-Type:application/json")
    @POST("wishlist/listtrip.php")
    fun getwishlistDetails(@Body body: Any?) : Observable<WishListModel>

    @Headers("Content-Type:application/json")
    @POST("wishlist/create.php")
    fun getwishlistsubmit(@Body body: Any?) : Observable<WishListSubmitModel>


    @Headers("Content-Type:application/json")
    @POST("bookmark/create.php")
    fun getBookMarhlistsubmit(@Body body: Any?) : Observable<WishListSubmitModel>


    @Headers("Content-Type:application/json")
    @POST("blog/listblog.php")
    fun getBlog(@Body body: Any?) : Observable<BlogModel>

    @Headers("Content-Type:application/json")
    @POST("contactus/create.php")
    fun getContactus(@Body body: Any?) : Observable<WishListSubmitModel>


    @Headers("Content-Type:application/json")
    @POST("tripcallback/create.php")
    fun sendTripCallBack(@Body body: Any?) : Observable<WishListSubmitModel>

}

