package com.example.myassigment.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel


import com.example.myassigment.interfaces.AuthListner
import com.example.myassigment.repository.LoginRepo

class LoginViewModel : ViewModel() {

    var email:String? = "vivekdesai7"
    var password:String? = "Vivek777"

    var authListner: AuthListner? = null

    fun onLoginButtonClick(view: View){

        val user = email.toString();
        val pass = password.toString()
        val str = user + ":" + pass

        var loginRepo = LoginRepo().vierfyUser(str)
        authListner?.success(loginRepo)

    }



}