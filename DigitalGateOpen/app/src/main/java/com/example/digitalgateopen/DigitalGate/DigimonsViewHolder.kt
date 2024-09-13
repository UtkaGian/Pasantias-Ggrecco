package com.example.digitalgateopen.DigitalGate


import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalgateopen.databinding.ItemDigimonBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class DigimonsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding= ItemDigimonBinding.bind(view)
    fun bind(movieItemResponse: DigimonItemResponse, onItemSelected:(Int)->Unit){
        binding.DigiName.text= DigimonItemResponse.Name
        val url="https://images.digimoncard.io/images/cards/"+DigimonItemResponse.Id+".jpg"
        Log.i("gg", "$url")
        Picasso.get().load(url).into(binding.ivCard)
        binding.root.setOnClickListener { onItemSelected(DigimonItemResponse.Name) }
    }
}