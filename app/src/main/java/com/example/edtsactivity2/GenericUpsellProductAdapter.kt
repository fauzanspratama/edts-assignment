
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.edtsactivity2.databinding.ItemUpsellProductBinding

// Generic adapter for UpsellProduct
class GenericUpsellProductAdapter(
    private val listUpsellProduct: List<UpsellProduct>, // No need for generic T here, as it's always UpsellProduct
    private val onProductSelected: (UpsellProduct) -> Unit,
    private val onButtonClicked: (UpsellProduct) -> Unit
) : RecyclerView.Adapter<GenericUpsellProductAdapter.ViewHolder>() {

    // ViewHolder class to bind the views using ViewBinding
    inner class ViewHolder(val binding: ItemUpsellProductBinding) : RecyclerView.ViewHolder(binding.root) {
        // Bind data to views
        fun bind(item: UpsellProduct) {
            binding.ivProductUpsell.setImageResource(item.imageProduct)
            binding.tvTitleUpsellProduct.text = item.titleProduct
            binding.tvUpsellProductVariant.text = item.variantProduct
            binding.tvUpsellProductPrice.text = item.priceProduct
            binding.tvDiscountPriceUpsell.text = item.discountPrice
            binding.tvDiscountPriceVariant.text = item.discountChip
        }
    }

    // Create ViewHolder and inflate the layout using ViewBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUpsellProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // Get the total number of items
    override fun getItemCount(): Int {
        return listUpsellProduct.size
    }

    // Bind the data to the view elements in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentProduct = listUpsellProduct[position]

        // Bind the product data to the views
        holder.bind(currentProduct)

        // Optionally, set a click listener to pass the selected product
        holder.itemView.setOnClickListener {
            onProductSelected(currentProduct)  // Pass the selected product
        }

        // Handle button click (e.g., add product to cart)
        holder.binding.buttonUpsellProduct.setOnClickListener {
            onButtonClicked(currentProduct)  // Pass the product when button is clicked
        }
    }
}
