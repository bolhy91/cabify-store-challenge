package com.bolhy91.cabifystore.data.mapper

import com.bolhy91.cabifystore.data.remote.dto.ProductDto
import com.bolhy91.cabifystore.domain.model.Product

fun ProductDto.toProduct(): Product {
    return Product(
        code = code,
        name = name,
        price = price
    )
}