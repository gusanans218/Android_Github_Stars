package com.example.android_github_stars.util

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android_github_stars.data.Item
import com.example.android_github_stars.presentation.adapter.ApiRecyclerViewAdapter

object AdapterBindings {

    const val TEST = "test@123"

    @JvmStatic
    @BindingAdapter("bind:item")
    fun bindItem(recyclerView: RecyclerView, itemList: List<Item>?) {
        Log.d(TEST, "bind:item")
        with(recyclerView.adapter as ApiRecyclerViewAdapter) {
            itemList?.let {
                setItem(it)
            }
        }
    }
}