import android.os.Parcel
import android.os.Parcelable

data class UpsellProduct(
    val imageProduct: Int,
    val titleProduct: String,
    val variantProduct: String,
    val priceProduct: String,
    val discountPrice: String,
    val discountChip: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageProduct)
        parcel.writeString(titleProduct)
        parcel.writeString(variantProduct)
        parcel.writeString(priceProduct)
        parcel.writeString(discountPrice)
        parcel.writeString(discountChip)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<UpsellProduct> {
        override fun createFromParcel(parcel: Parcel): UpsellProduct {
            return UpsellProduct(parcel)
        }

        override fun newArray(size: Int): Array<UpsellProduct?> {
            return arrayOfNulls(size)
        }
    }
}

