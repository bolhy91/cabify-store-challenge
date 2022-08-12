package com.bolhy91.cabifystore.presentation.product_lists.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bolhy91.cabifystore.domain.model.Product
import com.bolhy91.cabifystore.ui.theme.Neutral600
import com.bolhy91.cabifystore.ui.theme.Purple600

@Composable
fun ProductItem(
    product: Product,
    itemPress: (Product) -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(Color.White)
            .clickable { itemPress(product) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = "Code: ${product.code}",
                    style = MaterialTheme.typography.subtitle2,
                    color = Neutral600
                )
            }
            Text(
                text = "$${product.price}",
                style = MaterialTheme.typography.subtitle2.copy(
                    fontWeight = FontWeight.Bold,
                    color = Purple600,
                    fontSize = 16.sp
                )
            )
        }
    }
}

@Preview
@Composable
fun ProductItemPreview() {
    val item = Product(code = "TSHIRT", name = "Cabify T-Shirt", price = 20.00)
    ProductItem(item, {})
}