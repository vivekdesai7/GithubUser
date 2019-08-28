package com.example.myassigment.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myassigment.datamodel.Users

import com.example.myassigment.repository.UserRepo

class MainViewModel : ViewModel() {

    var userResponse: UserRepo
    val usersData: MutableLiveData<List<Users>> by lazy { MutableLiveData<List<Users>>() }

    init {
        userResponse = UserRepo(usersData)
    }

    fun fetchUsers(query: String = "") {
        //old retrofit call
        userResponse.getUSerList()
    }

    fun getSearchData(str:String){
        userResponse.getSearchData(str)
    }



}