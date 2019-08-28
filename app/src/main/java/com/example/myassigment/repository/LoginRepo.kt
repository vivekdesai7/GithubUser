package com.example.myassigment.repository

import android.util.Base64
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.smapledemo.MyService.RetrofitClientInstance
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepo {

    fun vierfyUser(str:String): LiveData<String> {

        var result = MutableLiveData<String>()
        val auth = " Basic " + Base64.encodeToString(str.toByteArray(), Base64.NO_WRAP)

        RetrofitClientInstance.INSTANCE.Login(auth).enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("onFailure", "onFailure" + t.message)
                result.value = "0"
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.e("onResponse", "onResponse" + response.code())
                if (response.code().equals(200)) {
                    result.value = "1"
                } else if (response.code().equals(401)) {
                    result.value = "0"
                } else {
                    result.value = "2"
                }
            }

        })
        return result
    }




}