package com.example.champions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListChampionAdapter(private val listChampion: ArrayList<Champion>) :
    RecyclerView.Adapter<ListChampionAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_champion, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, alias, region, wiseWord, story, photo, miniPhoto, icRegion) = listChampion[position]
        Glide.with(holder.itemView.context)
            .load(miniPhoto) // URL Gambar
            .into(holder.imgPhoto) // imageView yang diterapkan
        Glide.with(holder.itemView.context)
            .load(icRegion)
            .into(holder.imgRegion)
        holder.tvName.text = name
        holder.tvAlias.text = alias
        holder.tvRegion.text = region
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listChampion[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listChampion.size
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvAlias: TextView = itemView.findViewById(R.id.tv_item_alias)
        val tvRegion: TextView = itemView.findViewById(R.id.tv_item_region)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val imgRegion: ImageView = itemView.findViewById(R.id.img_item_region)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Champion)
    }
}
