package com.nalka.overwatchnews.model.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadDrawable(drawableId: Int) {
    Picasso.get().load(drawableId).into(this)
}