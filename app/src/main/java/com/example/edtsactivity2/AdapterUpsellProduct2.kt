package com.example.edtsactivity2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterUpsellProduct2(
    private val listUpsellProduct2: List<UpsellProduct2>,
    private val selectedUpsellProduct2: (UpsellProduct2) -> Unit
) : RecyclerView.Adapter<AdapterUpsellProduct2.ViewHolder>() {

    // ViewHolder class to bind the views
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProductUpsell: ImageView = itemView.findViewById(R.id.ivProductUpsell)
        val tvTitleUpsellProduct: TextView = itemView.findViewById(R.id.tvTitleUpsellProduct)
        val tvUpsellProductVariant: TextView = itemView.findViewById(R.id.tvUpsellProductVariant)
        val tvUpsellProductPrice: TextView = itemView.findViewById(R.id.tvUpsellProductPrice)
        val tvDiscountPrice: TextView = itemView.findViewById(R.id.tvDiscountPrice)
        val tvDiscountPriceVariant: TextView = itemView.findViewById(R.id.tvDiscountPriceVariant)
    }

    // Create ViewHolder and inflate the layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_upsell_product, parent, false)
        return ViewHolder(itemView)
    }

    // Get the total number of items
    override fun getItemCount(): Int {
        return listUpsellProduct2.size
    }

    // Bind the data to the view elements in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentProduct = listUpsellProduct2[position]

        // Bind the product data to the views
        Glide.with(holder.ivProductUpsell.context)
            .load(currentProduct.imageProduct)
            .into(holder.ivProductUpsell)

        holder.tvTitleUpsellProduct.text = currentProduct.titleProduct
        holder.tvUpsellProductVariant.text = currentProduct.variantProduct
        holder.tvUpsellProductPrice.text = currentProduct.priceProduct
        holder.tvDiscountPrice.text = currentProduct.discountPrice
        holder.tvDiscountPriceVariant.text = currentProduct.discountChip

        // Optionally, set a click listener to pass the selected product
        holder.itemView.setOnClickListener {
            selectedUpsellProduct2(currentProduct) // Pass the current product on click
        }
    }
}
