package com.bolhy91.cabifystore.presentation.product_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bolhy91.cabifystore.R
import com.bolhy91.cabifystore.ui.components.RoundedButtonIcon

@Composable
fun ChoiceQuantity() {
    val quantity = remember { mutableStateOf(1) }
    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Choice quantity",
            style = MaterialTheme.typography.body2
        )
        Row(
            modifier = Modifier
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundedButtonIcon(icon = R.drawable.ic_minus) {}
            Text(
                text = quantity.value.toString(),
                style = MaterialTheme.typography.subtitle1.copy(fontSize = 18.sp)
            )
            RoundedButtonIcon(icon = R.drawable.ic_add) {}
        }
    }
}