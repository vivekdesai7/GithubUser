package com.example.myassigment.interfaces

import androidx.lifecycle.LiveData

interface AuthListner {

    fun success(sr:LiveData<String>)
    fun failur()
}