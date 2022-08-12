package com.bolhy91.cabifystore.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(val code: String, val name: String, val price: Double) : Parcelable