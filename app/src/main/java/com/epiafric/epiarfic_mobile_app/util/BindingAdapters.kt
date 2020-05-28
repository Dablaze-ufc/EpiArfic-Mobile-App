package com.epiafric.epiarfic_mobile_app.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.epiafric.epiarfic_mobile_app.adapter.EntriesDataAdapter
import com.epiafric.epiarfic_mobile_app.model.Data

@BindingAdapter("entriesData")
fun bindRecyclerview(recyclerView: RecyclerView, data: List<Data>?){
    val adapter = recyclerView.adapter as EntriesDataAdapter
    adapter.submitList(data)
}