package com.canbazdev.hipocase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canbazdev.hipocase.data.model.hipo.Member
import com.canbazdev.hipocase.databinding.ItemDeveloperBinding

/*
*   Created by hamzacanbaz on 4/5/2023
*/
class DevelopersAdapter : RecyclerView.Adapter<DevelopersAdapter.ViewHolder>() {
    private var developersList = ArrayList<Member>()

    class ViewHolder(private val binding: ItemDeveloperBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItems(item: Member) {
            binding.developer = item
        }
    }

    fun setDevelopersList(list: List<Member>) {
        developersList.clear()
        developersList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemDeveloperBinding = ItemDeveloperBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return developersList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(developersList[position])
    }
}