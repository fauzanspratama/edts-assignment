package com.example.edtsactivity2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterService (private val listService: List<Service>, private val selectedPenyajian: (Service) -> Unit):
    RecyclerView.Adapter<AdapterService.ViewHolder>()
{
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvListTitle: TextView = itemView.findViewById(R.id.tvListTitle)
        val radioList: RadioButton = itemView.findViewById(R.id.radioList)

        fun getRadioButtonText(): String {
            return radioList.text.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterService.ViewHolder {
        val itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_service, parent,
                false);
        // Pass holder view
        return ViewHolder(itemView);
    }

    override fun onBindViewHolder(holder: AdapterService.ViewHolder, position: Int) {
        // Menetapkan teks pada TextView atau RadioButton
        val currentItem = listService[position]
        holder.tvListTitle.text = currentItem.listTitle // Untuk TextView
        holder.radioList.isChecked = currentItem.radioValue    // Untuk RadioButton
        holder.radioList.text = currentItem.radioText //Untuk RadioText

        // Set listener pada RadioButton
        holder.radioList.setOnClickListener {
            // Uncheck semua RadioButton
            listService.forEach { it.radioValue = false }

            // Set radioValue yang dipilih menjadi true
            currentItem.radioValue = true

            // Update UI
            selectedPenyajian(currentItem)

            // Notifikasi perubahan data ke adapter
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return listService.size
    }

}