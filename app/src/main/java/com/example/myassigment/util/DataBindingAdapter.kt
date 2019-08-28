package com.example.myassigment.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object DataBindingAdapter {

    @JvmStatic
    @BindingAdapter("bind:image_url")
    fun loadImage(imageView: ImageView, url: String?) {
        url?.let {
            Picasso.with(imageView.context).load(it).into(imageView)
        }
    }
}