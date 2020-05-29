package com.epiafric.epiarfic_mobile_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.epiafric.epiarfic_mobile_app.R
import com.epiafric.epiarfic_mobile_app.model.Data
import kotlinx.android.synthetic.main.recent_list_item.view.*

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
        return EntriesViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: EntriesViewHolder, position: Int) {
        val entriesData = getItem(position)
        holder.bind(entriesData)

    }

    class EntriesViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

        fun bind(entriesData: Data) = with(itemView) {

            itemView.text_tittle.text = entriesData.date_created

            itemView.text_details.text = entriesData.date_of_entry
        }
        
        companion object {
            fun from(parent: ViewGroup): EntriesViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = layoutInflater.inflate(R.layout.recent_list_item, parent, false)
                return EntriesViewHolder(binding)
            }
        }
    }
}