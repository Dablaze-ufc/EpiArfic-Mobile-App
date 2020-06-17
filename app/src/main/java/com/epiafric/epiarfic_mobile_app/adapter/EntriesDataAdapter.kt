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

class EntriesDataAdapter(val clickListener: OnclickListener): ListAdapter<Data, EntriesDataAdapter.EntriesViewHolder>(DiffCallBack) {
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
        holder.bind(entriesData, clickListener)

    }

    class EntriesViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

        fun bind(entriesData: Data, clickListener: OnclickListener) = with(itemView) {

            itemView.text_tittle.text = entriesData.name

            itemView.text_details.text = entriesData.website
            itemView.setOnClickListener{
                clickListener.onClick(entriesData)
            }

            itemView.image_type.setImageResource(when(entriesData.category_of_innovation){
                "Education" -> R.drawable.education_icon
                "Health" -> R.drawable.health
                "Vulnerable Populations" -> R.drawable.vunerable_population
                "Communities" -> R.drawable.communites
                "Research" -> R.drawable.research
                else -> R.drawable.others
            }

            )
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

class OnclickListener(val clickListener: (data: Data) -> Unit){
    fun onClick(data: Data) = clickListener(data)
}