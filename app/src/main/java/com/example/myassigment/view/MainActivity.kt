package com.example.myassigment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myassigment.adapter.HomeAdapter
import com.example.myassigment.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import com.example.myassigment.datamodel.Users
import com.example.myassigment.R

class MainActivity : AppCompatActivity() {


    private val viewModel: MainViewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }
    val adapter : HomeAdapter by lazy { HomeAdapter(mutableListOf()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.fetchUsers()

        with(viewModel) {
            usersData.observe(this@MainActivity, Observer {
                initView(it)
            })

        }

        btnsearchtxt.setOnClickListener(){
            val str = searchtxt.text.toString()
            Toast.makeText(this@MainActivity, "clicked!-", Toast.LENGTH_SHORT).show();
            viewModel.getSearchData(str);
        }
    }

    private fun initView(it: List<Users>) {
        home_rav.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        home_rav.adapter = adapter

        if (it != null && it.size>0) {
            adapter.clear()
            adapter.add(it)

        }
//        progressBar_home.visibility = View.GONE
    }


}
