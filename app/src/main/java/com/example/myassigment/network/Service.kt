package com.example.smapledemo.MyService


import com.example.myassigment.datamodel.SearchUser
import com.example.myassigment.datamodel.Users
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface Service {

    @GET("authorizations")
    fun Login(@Header("Authorization")auth:String): Call<ResponseBody>

    @GET("users")
    fun fetchAllUsers():Call<List<Users>>

  /*  @GET("search/users")
    @Headers("Accept: application/json")
    fun getUser(
        @Query("q") query: String
    ): Call<Result>

*/
    @GET("search/users")
    @Headers("Accept: application/json")
    fun getDefer(
        @Query("q") query: String
    ): Call<SearchUser>
}