package com.bolhy91.cabifystore.presentation.product_detail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bolhy91.cabifystore.R

@Composable
fun TopBarSectionDetail(onBack: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_left),
            contentDescription = "arrow left",
            tint = Color.Black,
            modifier = Modifier
                .size(40.dp)
                .clickable { onBack() },
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bag),
            contentDescription = "bag",
            tint = Color.Black,
            modifier = Modifier.size(30.dp)
        )
    }
}