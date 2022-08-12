package com.bolhy91.cabifystore.presentation.product_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bolhy91.cabifystore.domain.model.Product
import com.bolhy91.cabifystore.presentation.product_detail.components.SectionProductDetail
import com.bolhy91.cabifystore.presentation.product_detail.components.TopBarSectionDetail
import com.bolhy91.cabifystore.ui.theme.Neutral600

@Composable
fun ProductDetailScreen(
    product: Product?,
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(
                    top = 25.dp,
                )
        ) {
            TopBarSectionDetail(onBack)
            Spacer(modifier = Modifier.height(20.dp))
            if (product != null) SectionProductDetail(product)
            Box(modifier = Modifier.padding(20.dp)) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Neutral600)
                ) {
                    Text(
                        text = "Add Cart",
                        style = MaterialTheme.typography.button,
                        modifier = Modifier,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
        }
    }
}
