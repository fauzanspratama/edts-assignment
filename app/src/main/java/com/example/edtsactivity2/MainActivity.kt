package com.example.edtsactivity2

import GenericUpsellProductAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.edtsactivity2.utils.CustomPaddingItemDecoration

class MainActivity : AppCompatActivity() {

    // List of Service
    private lateinit var listService: List<Service>

    // Adapter and RecyclerView for Service List
    private lateinit var adapterService: AdapterService
    private lateinit var penyajianRecyclerView: RecyclerView

    // Lists of Upsell Products
    private lateinit var listUpsellProduct1: List<UpsellProduct1>
    private lateinit var listUpsellProduct2: List<UpsellProduct2>

    // RecyclerViews for Upsell Products
    private lateinit var upsellRecyclerView1: RecyclerView
    private lateinit var upsellRecyclerView2: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Data preparation for Service List
        listService = mutableListOf(
            Service("Roti Panggang", "+2000", false),
            Service("Buah Segar", "+4000", false),
            Service("Crackers", "+2000", false),
            Service("Kopi Hitam", "+4000", false)
        )

        // Data preparation for Upsell Product 1
        listUpsellProduct1 = mutableListOf(
            UpsellProduct1(
                R.drawable.upsell_product_1,
                "Greenfields Yoghurt Strawberry Cup 500 gr",
                "500 gr / pcs",
                "Rp45.000",
                "Rp50.400",
                "12%"
            ),
            UpsellProduct1(
                R.drawable.upsell_product_2,
                "Greenfields Susu Fresh Milk Low Fat Caffe Latte 320 ml",
                "320 ml / pcs",
                "Rp12.500",
                "Rp50.400",
                "12%"
            ),
            UpsellProduct1(
                R.drawable.upsell_product_3,
                "Greenfields Susu UHT Cokelat 105 ml",
                "150 ml / pcs",
                "Rp12.500",
                "Rp16.000",
                "20%"
            ),
            UpsellProduct1(
                R.drawable.upsell_product_4,
                "Greenfields Susu UHT Vanilla Chamomile Extra Chill 200 ml",
                "200 ml / pcs",
                "Rp12.500",
                "Rp16.000",
                "20%"
            ),
            UpsellProduct1(
                R.drawable.upsell_product_5,
                "Greenfields Yoghurt Strawberry Pouch 110 gr",
                "110 gr / pcs",
                "Rp12.500",
                "Rp16.000",
                "20%"
            ),
        )

        // Data preparation for Upsell Product 2
        listUpsellProduct2 = mutableListOf(
            UpsellProduct2(
                R.drawable.upsell2_produk_1,
                "Greenfields Yoghurt Strawberry Cup 500 gr",
                "500 gr / pcs",
                "Rp45.000",
                "Rp50.400",
                "12%"
            ),
            UpsellProduct2(
                R.drawable.upsell2_produk_2,
                "Greenfields Susu Fresh Milk Low Fat Caffe Latte 320 ml",
                "320 ml / pcs",
                "Rp12.500",
                "Rp50.400",
                "12%"
            ),
            UpsellProduct2(
                R.drawable.upsell2_produk_3,
                "Greenfields Susu UHT Cokelat 105 ml",
                "150 ml / pcs",
                "Rp12.500",
                "Rp16.000",
                "20%"
            ),
            UpsellProduct2(
                R.drawable.upsell2_produk_4,
                "Greenfields Susu UHT Vanilla Chamomile Extra Chill 200 ml",
                "200 ml / pcs",
                "Rp12.500",
                "Rp16.000",
                "20%"
            ),
            UpsellProduct2(
                R.drawable.upsell2_produk_5,
                "Greenfields Yoghurt Strawberry Pouch 110 gr",
                "110 gr / pcs",
                "Rp12.500",
                "Rp16.000",
                "20%"
            ),
        )

        // Initialize RecyclerView for Service List
        penyajianRecyclerView = findViewById(R.id.rvListPenyajian)
        penyajianRecyclerView.layoutManager = LinearLayoutManager(this)

        adapterService = AdapterService(listService) { selectedPenyajian ->
            listService.forEach { it.radioValue = false }
            selectedPenyajian.radioValue = true
            adapterService.notifyDataSetChanged()
        }

        penyajianRecyclerView.adapter = adapterService


        // Initialize RecyclerView for Upsell Product 1
        upsellRecyclerView1 = findViewById(R.id.rvListUpsellProduct1)
        upsellRecyclerView1.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val adapterUpsellProduct1 = GenericUpsellProductAdapter(
            listUpsellProduct = listUpsellProduct1,
            onProductSelected = { selectedProduct ->
                // Handle item click (e.g., show details of the selected product)
                Toast.makeText(
                    this,
                    "Selected Product: ${selectedProduct.titleProduct}",
                    Toast.LENGTH_SHORT
                ).show()
            },
            onButtonClicked = { product ->
                // Handle "Add to Cart" button click (e.g., add product to cart)
                Toast.makeText(this, "Added to cart: ${product.titleProduct}", Toast.LENGTH_SHORT)
                    .show()
            }
        )

        upsellRecyclerView1.adapter = adapterUpsellProduct1

        // Initialize RecyclerView for Upsell Product 2
        upsellRecyclerView2 = findViewById(R.id.rvListUpsellProduct2)
        upsellRecyclerView2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val adapterUpsellProduct2 = GenericUpsellProductAdapter(
            listUpsellProduct = listUpsellProduct2,
            onProductSelected = { selectedProduct ->
                // Handle item click (e.g., show details of the selected product)
                Toast.makeText(
                    this,
                    "Selected Product: ${selectedProduct.titleProduct}",
                    Toast.LENGTH_SHORT
                ).show()
            },
            onButtonClicked = { product ->
                // Handle "Add to Cart" button click (e.g., add product to cart)
                Toast.makeText(this, "Added to cart: ${product.titleProduct}", Toast.LENGTH_SHORT)
                    .show()
            }
        )

        upsellRecyclerView2.adapter = adapterUpsellProduct2

        // Apply CustomPaddingItemDecoration to add space at the start, end, and between items
        val startPadding = resources.getDimensionPixelSize(R.dimen.start_padding)
        val endPadding = resources.getDimensionPixelSize(R.dimen.end_padding)
        val itemGap = resources.getDimensionPixelSize(R.dimen.item_gap)

        upsellRecyclerView1.addItemDecoration(
            CustomPaddingItemDecoration(startPadding, endPadding, itemGap)
        )
        upsellRecyclerView2.addItemDecoration(
            CustomPaddingItemDecoration(startPadding, endPadding, itemGap)
        )
    }
}
