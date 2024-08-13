package com.example.wallet.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskforservisrukikletky.ItemEssence
import com.example.testtaskforservisrukikletky.R


class EssenceRecyclerViewAdapter(
    context: Context,
    private val essences: List<ItemEssence>,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<EssenceRecyclerViewAdapter.ViewHolder>() {

fun interface OnClickListener {
    fun onClick(frend: ItemEssence, position: Int)
}

    private val inflater: LayoutInflater = LayoutInflater.from(context)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.essence_item, parent, false)
        return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val essence = essences[position]
        holder.itemName.setText(essence.itemName)
        holder.itemDisription.setText(essence.itemDisription)
            holder.backgroundItem.setImageResource(essence.backgroundItem)
            holder.smileItem.setText(essence.smileItem)
        holder.itemView.setOnClickListener { onClickListener.onClick(essence, position) }
        }

        override fun getItemCount(): Int {
        return essences.size
        }

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemName: TextView = view.findViewById(R.id.itemTypesTextVIew)
        val itemDisription: TextView = view.findViewById(R.id.itemDescriptiontextView)
        val backgroundItem: ImageView = view.findViewById(R.id.imageViewBackriundItemEsenesn)
        val smileItem: TextView = view.findViewById(R.id.smileTextviewItemEsense)
        }
}

