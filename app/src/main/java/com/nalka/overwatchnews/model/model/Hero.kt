package com.nalka.overwatchnews.model.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Hero(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String = "",
    var groupId: Int? = 0,
    var iconId: Int = 0,

    var hitPoints: Int? = 200,
    var armor: Int? = 50,
    var shields: Int? = 50,

    var forwardMovementSpeed: Float? = 0.0f,
    var backwardsMovementSpeed: Float? = 0.0f
) {


}