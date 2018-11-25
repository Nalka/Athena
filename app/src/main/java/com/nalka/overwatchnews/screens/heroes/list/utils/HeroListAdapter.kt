package com.nalka.overwatchnews.screens.heroes.list.utils

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nalka.overwatchnews.R
import com.nalka.overwatchnews.model.model.Hero

class HeroListAdapter(
    var heroList: List<Hero>,
    val callback: (Hero) -> Unit
): RecyclerView.Adapter<HeroListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroListViewHolder {
        return HeroListViewHolder(View.inflate(parent.context, R.layout.item_hero, null))
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: HeroListViewHolder, position: Int) {
        holder.bind(heroList[position])
        holder.itemView.setOnClickListener { callback(heroList[position]) }
    }

}