package com.example.smapledemo.MyService

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by ucint on 7/22/2018.
 */

object RetrofitClientInstance {

    private const val BASE_URL = "https://api.github.com"

    private  val okHttpClient = OkHttpClient.Builder().addInterceptor{ chain ->
        val original = chain.request()

        val requestBuilder = original.newBuilder()
            .method(original.method(),original.body())

        val request = requestBuilder.build()
        chain.proceed(request)
    }.build()


    val INSTANCE: Service by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(Service::class.java)
    }


}
