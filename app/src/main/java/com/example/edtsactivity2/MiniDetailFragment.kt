package com.example.edtsactivity2

import UpsellProduct
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.edtsactivity2.databinding.FragmentMiniDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MiniDetailFragment : BottomSheetDialogFragment() {

    companion object {
        private const val ARG_PRODUCT = "product"

        // Function to create a new instance of the bottom sheet with product data
        fun newInstance(product: UpsellProduct): MiniDetailFragment {
            val fragment = MiniDetailFragment()
            val bundle = Bundle()
            bundle.putParcelable(ARG_PRODUCT, product)
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var product: UpsellProduct

    // Inflate the layout and set the data to views
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for the bottom sheet
        val binding = FragmentMiniDetailBinding.inflate(inflater, container, false)

        // Retrieve the product from arguments
        arguments?.let {
            product = it.getParcelable(ARG_PRODUCT)!!
        }

        // Set the product details to views
        binding.tvTitleUpsellProduct.text = product.titleProduct
        binding.tvUpsellProductVariant.text = product.variantProduct
        binding.tvUpsellProductPrice.text = product.priceProduct
        binding.tvDiscountPriceUpsell.text = product.discountPrice
        binding.tvDiscountPriceVariant.text = product.discountChip

        // Set product image
        binding.ivProductUpsell.setImageResource(product.imageProduct)

        // Show discount fields if applicable
        if (product.discountPrice.isNotEmpty()) {
            binding.tvDiscountPriceUpsell.text = product.discountPrice
            binding.tvDiscountPriceUpsell.visibility = View.VISIBLE
        }

        if (product.discountChip.isNotEmpty()) {
            binding.tvDiscountPriceVariant.text = product.discountChip
            binding.tvDiscountPriceVariant.visibility = View.VISIBLE
        }

        return binding.root
    }
}
