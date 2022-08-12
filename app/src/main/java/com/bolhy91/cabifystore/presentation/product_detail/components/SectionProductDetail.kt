package com.bolhy91.cabifystore.presentation.product_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bolhy91.cabifystore.domain.model.Product
import com.bolhy91.cabifystore.ui.theme.Neutral600

@Composable
fun SectionProductDetail(product: Product) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
            .padding(start = 20.dp, bottom = 15.dp, end = 20.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = product.name,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = "Code: ${product.code}",
                style = MaterialTheme.typography.h3.copy(color = Neutral600),
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 25.sp)) {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Normal, fontSize = 18.sp)) {
                        append("Price\n")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp
                        )
                    ) {
                        append("$${product.price}")
                    }
                }
            })
            Spacer(modifier = Modifier.height(20.dp))
            ChoiceQuantity()
        }
    }
}