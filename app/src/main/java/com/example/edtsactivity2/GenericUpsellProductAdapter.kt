
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.edtsactivity2.R
import com.example.edtsactivity2.UpsellProduct

class GenericUpsellProductAdapter<T : UpsellProduct>(
    private val listUpsellProduct: List<T>,
    private val onProductSelected: (T) -> Unit,
    private val onButtonClicked: (T) -> Unit
) : RecyclerView.Adapter<GenericUpsellProductAdapter.ViewHolder<T>>() {

    // ViewHolder class to bind the views
    class ViewHolder<T : UpsellProduct>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProductUpsell: ImageView = itemView.findViewById(R.id.ivProductUpsell)
        val tvTitleUpsellProduct: TextView = itemView.findViewById(R.id.tvTitleUpsellProduct)
        val tvUpsellProductVariant: TextView = itemView.findViewById(R.id.tvUpsellProductVariant)
        val tvUpsellProductPrice: TextView = itemView.findViewById(R.id.tvUpsellProductPrice)
        val tvDiscountPrice: TextView = itemView.findViewById(R.id.tvDiscountPriceVariant)
        val tvDiscountPriceVariant: TextView = itemView.findViewById(R.id.tvDiscountPriceVariant)
        val buttonUpsellProduct: Button = itemView.findViewById(R.id.buttonUpsellProduct)

        fun bind(item: T) {
            ivProductUpsell.setImageResource(item.imageProduct)
            tvTitleUpsellProduct.text = item.titleProduct
            tvUpsellProductVariant.text = item.variantProduct
            tvUpsellProductPrice.text = item.priceProduct
            tvDiscountPrice.text = item.discountPrice
            tvDiscountPriceVariant.text = item.discountChip
        }
    }

    // Create ViewHolder and inflate the layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_upsell_product, parent, false)
        return ViewHolder(itemView)
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
        holder.buttonUpsellProduct.setOnClickListener {
            onButtonClicked(currentProduct)  // Pass the product when button is clicked
        }
    }
}
