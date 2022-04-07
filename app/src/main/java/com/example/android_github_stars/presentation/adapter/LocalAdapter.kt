package com.example.android_github_stars.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_github_stars.R
import com.example.android_github_stars.databinding.FavoriteLocalBinding
import com.example.android_github_stars.domain.model.FavoriteItemModel

class LocalAdapter(private var items: List<FavoriteItemModel>, val onClickLocalFavorite: OnClickLocalFavorite)
    : RecyclerView.Adapter<LocalAdapter.VerticalViewHolder>(){
    val arrayList = ArrayList<FavoriteItemModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalViewHolder {

        return FavoriteLocalBinding
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

    fun setItem(itemList: List<FavoriteItemModel>) {
        items = itemList
        arrayList.addAll(itemList)
        notifyDataSetChanged()
    }

    // ViewHolder
    inner class VerticalViewHolder(private val binding: FavoriteLocalBinding)
        : RecyclerView.ViewHolder(binding.root){


        fun bind(item: FavoriteItemModel) {
            binding.item = item
            if (arrayList.contains(item)) {
                binding.borderStar.setImageResource(R.drawable.ic_baseline_star_24)
            } else {
                binding.borderStar.setImageResource(R.drawable.ic_baseline_star_border_24)
            }

            binding.borderStar.setOnClickListener {
                if (!arrayList.contains(item)) {
                    arrayList.add(item)
                    onClickLocalFavorite.onClickStar(FavoriteItemModel(id = item.id, avatarUrl = item.avatarUrl, login = item.login),1)
                    binding.borderStar.setImageResource(R.drawable.ic_baseline_star_24)
                } else {
                    arrayList.remove(item)
                    onClickLocalFavorite.onClickStar(FavoriteItemModel(id = item.id, avatarUrl = item.avatarUrl, login = item.login),2)
                    binding.borderStar.setImageResource(R.drawable.ic_baseline_star_border_24)
                }
            }
        }
    }
}

interface OnClickLocalFavorite{
    fun onClickStar(itemModel: FavoriteItemModel, type:Int)


}