package com.example.android_github_stars.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_github_stars.R
import com.example.android_github_stars.databinding.ItemHeaderBinding
import com.example.android_github_stars.databinding.VerticalViewItemBinding
import com.example.android_github_stars.domain.model.FavoriteItemModel
import com.example.android_github_stars.domain.model.ItemModel

// 리사이클러뷰에 깃허브 User 검색 결과값을 보여줍니다.

class ApiRecyclerViewAdapter(private var items: List<ItemModel>,val onClickFavorite: OnClickFavorite)
    :RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    val arrayList = ArrayList<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if(viewType == 1) {
            VerticalViewItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
                .run {
                    VerticalViewHolder(this)
                }
        } else {
            ItemHeaderBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
                .run {
                    HeaderViewHolder(this)
                }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder.itemViewType == 0){
            (holder as HeaderViewHolder).bind(items[position].login)
        } else {
            (holder as VerticalViewHolder).bind(items[position], position)
        }
    }

    fun setItem(itemList: List<ItemModel>) {
        items = itemList
        notifyDataSetChanged()
    }

    fun getFavorite(list: List<FavoriteItemModel>){
        arrayList.clear()
        list.forEach {
            items.forEachIndexed { index, itemModel ->
                if (it.id == itemModel.id) {
                    arrayList.add(index)
                    notifyItemChanged(index)
                }
            }
        }
    }

    // 초성 헤더를 보여줍니다.
    inner class HeaderViewHolder(private val binding: ItemHeaderBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind(title: String) {
            binding.title = title
        }
    }

    // UserList에 User를 한 명씩 보여줍니다.
    inner class VerticalViewHolder(private val binding: VerticalViewItemBinding)
        :RecyclerView.ViewHolder(binding.root){


        fun bind(item: ItemModel, position: Int) {
            binding.item = item
            if (arrayList.contains(position)) {
                binding.borderStar.setImageResource(R.drawable.ic_baseline_star_24)
            } else {
                binding.borderStar.setImageResource(R.drawable.ic_baseline_star_border_24)
            }

            binding.borderStar.setOnClickListener {
                if (!arrayList.contains(position)) {
                    arrayList.add(position)
                    onClickFavorite.onClickStar(FavoriteItemModel(id = item.id, avatarUrl = item.avatar_url, login = item.login),1)
                    binding.borderStar.setImageResource(R.drawable.ic_baseline_star_24)
                } else {
                    arrayList.remove(position)
                    onClickFavorite.onClickStar(FavoriteItemModel(id = item.id, avatarUrl = item.avatar_url, login = item.login),2)
                    binding.borderStar.setImageResource(R.drawable.ic_baseline_star_border_24)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].id == 0) {
            0
        } else {
            1
        }
    }
}

interface OnClickFavorite{
    fun onClickStar(itemModel: FavoriteItemModel, type:Int)
}