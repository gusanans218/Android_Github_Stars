package com.example.android_github_stars.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

// Glide를 사용해 ImageUrl로 Image를 불러와 ImageView에 띄워줍니다.
// Databinding을 사용하여 Image를 띄우는 기능을 View로부터 분리합니다.

object AdapterBindings {

    @JvmStatic
    @BindingAdapter("app:userImage")
    fun bindItem(imageView: ImageView, imageUrl: String?) {
        Glide.with(imageView.context).load(imageUrl).transform(CenterCrop(), RoundedCorners(150))
            .fitCenter().into(imageView)
    }

}