package com.example.myassigment.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myassigment.R
import com.example.myassigment.databinding.ActivityLoginBinding
import com.example.myassigment.interfaces.AuthListner
import com.example.myassigment.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity(), AuthListner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_login
        )
        val viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.authListner = this

    //    setContentView(R.layout.activity_login)
    }


    override fun success(str:LiveData<String>) {

        str.observe(this, Observer {
            if(it.equals("1")) {
                Toast.makeText(this,"Login Successfull",Toast.LENGTH_LONG).show()
                var intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Login Failed!!Please check user name and password",Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun failur() {
        Toast.makeText(this,"Loginfailure",Toast.LENGTH_LONG).show()
    }

}
