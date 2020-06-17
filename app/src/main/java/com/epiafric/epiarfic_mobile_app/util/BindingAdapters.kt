package com.epiafric.epiarfic_mobile_app.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.epiafric.epiarfic_mobile_app.R
import com.epiafric.epiarfic_mobile_app.adapter.EntriesDataAdapter
import com.epiafric.epiarfic_mobile_app.model.Data

@BindingAdapter("entriesData")
fun bindRecyclerview(recyclerView: RecyclerView, data: List<Data>?){
    val adapter = recyclerView.adapter as EntriesDataAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageData")
fun bindImageView(imageView: ImageView, data:Data){
    imageView.setImageResource(when(data.category_of_innovation){
        "Education" -> R.drawable.education_icon
        "Health" -> R.drawable.health
        "Vulnerable Populations" -> R.drawable.vunerable_population
        "Communities" -> R.drawable.communites
        "Research" -> R.drawable.research
        else -> R.drawable.others
    })
}