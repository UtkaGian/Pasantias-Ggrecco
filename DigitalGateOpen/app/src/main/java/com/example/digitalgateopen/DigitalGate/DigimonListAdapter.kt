package com.example.digitalgateopen.DigitalGate

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup

class DigimonListAdapter(var digimons: List<DigimonItemResponse> = emptyList()) {
    private val onItemSelected:(Int) -> Unit) :
    RecyclerView.Adapter<DigimonsViewHolder>() {

        @SuppressLint("NewApi")
        fun updateList(movies:List<DigimonItemResponse>){
            this.digimons = digimons
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DigimonsViewHolder {
            val layoutInflater= LayoutInflater.from(parent.context)
            return DigimonsViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))
        }

        override fun onBindViewHolder(viewholder: DigimonsViewHolder, position: Int) {
            val item= digimons[position]
            viewholder.bind(item, onItemSelected)
        }

        override fun getItemCount() = digimons.size
}