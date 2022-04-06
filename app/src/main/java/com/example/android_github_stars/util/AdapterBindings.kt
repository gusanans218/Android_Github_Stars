package com.example.android_github_stars.util

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.android_github_stars.data.Item
import com.example.android_github_stars.presentation.adapter.ApiRecyclerViewAdapter

object AdapterBindings {

    const val TEST = "test@123"

    @JvmStatic
    @BindingAdapter("app:userImage")
    fun bindItem(imageView: ImageView, imageUrl: String?){
            Glide.with(imageView.context).load(imageUrl).transform(CenterCrop(),RoundedCorners(150)).fitCenter().into(imageView)
        }

}