package com.example.android_github_stars.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.android_github_stars.data.Item
import com.example.android_github_stars.databinding.FragmentApiBinding
import com.example.android_github_stars.databinding.VerticalViewItemBinding
import com.example.android_github_stars.presentation.placeholder.PlaceholderContent.PlaceholderItem


class ApiRecyclerViewAdapter(private var items: List<Item>)
    :RecyclerView.Adapter<ApiRecyclerViewAdapter.VerticalViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalViewHolder {
        return VerticalViewItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
            .run {
                VerticalViewHolder(this)
            }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: VerticalViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItem(itemList: List<Item>) {
        items = itemList
        notifyDataSetChanged()
    }

    // ViewHolder
    class VerticalViewHolder(private val binding: VerticalViewItemBinding)
        :RecyclerView.ViewHolder(binding.root){

        fun bind(item: Item) {
            binding.item = item
        }
    }
}