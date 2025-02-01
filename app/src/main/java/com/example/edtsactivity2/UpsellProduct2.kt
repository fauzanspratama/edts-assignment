package com.example.edtsactivity2

data class UpsellProduct2(
    override val imageProduct: Int,
    override val titleProduct: String,
    override val variantProduct: String,
    override val priceProduct: String,
    override val discountPrice: String,
    override val discountChip: String
) : UpsellProduct