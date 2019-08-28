package com.example.myassigment.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.myassigment.datamodel.SearchUser
import com.example.myassigment.datamodel.Users
import com.example.smapledemo.MyService.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepo (  val usersData: MutableLiveData<List<Users>>){

    fun getUSerList(){


        RetrofitClientInstance.INSTANCE.fetchAllUsers().enqueue(object : Callback<List<Users>> {
            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                Log.e("responce",t.message)
            }

            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                Log.e("responce",response.body().toString())
                usersData.postValue(response.body())
            }
        })

    }

    fun getSearchData(str:String){

        RetrofitClientInstance.INSTANCE.getDefer(str).enqueue(object : Callback<SearchUser> {
            override fun onFailure(call: Call<SearchUser>, t: Throwable) {
                Log.e("responce",t.message)
            }

            override fun onResponse(call: Call<SearchUser>, response: Response<SearchUser>) {
                usersData.postValue(response.body()?.items)
            }


        })
    }
}