
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.edtsactivity2.UpsellProduct
import com.example.edtsactivity2.databinding.ItemUpsellProductBinding

class GenericUpsellProductAdapter<T : UpsellProduct>(
    private val listUpsellProduct: List<T>,
    private val onProductSelected: (T) -> Unit,
    private val onButtonClicked: (T) -> Unit
) : RecyclerView.Adapter<GenericUpsellProductAdapter.ViewHolder<T>>() {

    // ViewHolder class to bind the views using ViewBinding
    class ViewHolder<T : UpsellProduct>(val binding: ItemUpsellProductBinding) : RecyclerView.ViewHolder(binding.root) {
        // Bind data to views
        fun bind(item: T) {
            binding.ivProductUpsell.setImageResource(item.imageProduct)
            binding.tvTitleUpsellProduct.text = item.titleProduct
            binding.tvUpsellProductVariant.text = item.variantProduct
            binding.tvUpsellProductPrice.text = item.priceProduct
            binding.tvDiscountPriceUpsell.text = item.discountPrice
            binding.tvDiscountPriceVariant.text = item.discountChip
        }
    }

    // Create ViewHolder and inflate the layout using ViewBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        val binding = ItemUpsellProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // Get the total number of items
    override fun getItemCount(): Int {
        return listUpsellProduct.size
    }

    // Bind the data to the view elements in each row
    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
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
