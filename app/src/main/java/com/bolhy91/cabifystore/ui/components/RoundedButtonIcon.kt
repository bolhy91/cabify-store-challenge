package com.bolhy91.cabifystore.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun RoundedButtonIcon(
    @DrawableRes icon: Int,
    operation: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .width(34.dp)
            .height(34.dp)
            .background(Color.White)
            .clickable {
                operation()
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(10.dp)
        )
    }
}