package com.anibalbastias.coolmovies.library.base.ui.extension

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.anibalbastias.coolmovies.library.base.R

@BindingAdapter("setImageUrl")
fun AppCompatImageView.setImageUrl(imageUrl: String?) {
    imageUrl?.let { image ->
        load(image) {
            crossfade(true)
            error(R.drawable.ic_placeholder)
            transformations(RoundedCornersTransformation(10F))
        }
    }
}