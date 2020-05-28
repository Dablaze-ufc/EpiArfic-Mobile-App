package com.epiafric.epiarfic_mobile_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.epiafric.epiarfic_mobile_app.databinding.RecentListItemBinding
import com.epiafric.epiarfic_mobile_app.model.Data

class EntriesDataAdapter: ListAdapter<Data, EntriesDataAdapter.EntriesViewHolder>(DiffCallBack) {
    companion object DiffCallBack: DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntriesViewHolder {
        return EntriesViewHolder(RecentListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: EntriesViewHolder, position: Int) {
        val entriesData = getItem(position)
        holder.bind(entriesData)

    }

    class EntriesViewHolder(private var binding : RecentListItemBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(entriesData: Data){
            binding.entriesData = entriesData
            binding.executePendingBindings()
        }

    }


}