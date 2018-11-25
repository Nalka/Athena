package com.nalka.overwatchnews.model.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HeroAbility(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String = "",
    val cooldown: Float = 0.0f,
    val description: String = "",
    val iconId: Int = 0
)