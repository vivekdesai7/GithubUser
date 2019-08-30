package com.example.myassigment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myassigment.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*




class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val i = intent
        idtxt.setText(i.getStringExtra("id"));
        nametxt.setText(i.getStringExtra("name"));
        Picasso
            .with(this)
            .load(i.getStringExtra("url"))
            .into(imageprofile);
    }
}
