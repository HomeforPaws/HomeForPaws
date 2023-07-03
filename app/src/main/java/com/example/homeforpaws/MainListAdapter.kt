package com.example.homeforpaws

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainListAdapter(val itemList:ArrayList<MainListItem>):RecyclerView.Adapter<MainListAdapter.MainViewHolder>() {
    inner class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.main_name)
        val img = itemView.findViewById<ImageView>(R.id.main_img_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_item_layout,parent,false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item  = itemList[position]
        holder.name.text = item.name
        Glide.with(holder.itemView.context).load(item.url).into(holder.img)
    }
}