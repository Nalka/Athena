package com.nalka.overwatchnews.screens.heroes.list.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nalka.overwatchnews.model.model.Hero
import com.nalka.overwatchnews.model.utils.loadDrawable
import kotlinx.android.synthetic.main.item_hero.view.*

class HeroListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvHeroName: TextView = itemView.tv_hero_name
    private val ivHeroIcon: ImageView = itemView.iv_hero_icon

    fun bind(hero: Hero) {
        tvHeroName.text = hero.name
        ivHeroIcon.loadDrawable(hero.iconId)
    }
}