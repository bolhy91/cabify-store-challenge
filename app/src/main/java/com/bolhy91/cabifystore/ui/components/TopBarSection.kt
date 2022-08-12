package com.bolhy91.cabifystore.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bolhy91.cabifystore.R

@Composable
fun TopBarSection() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_cabify_logo),
            contentDescription = "logo",
            modifier = Modifier.height(30.dp)
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(48.dp)
                .height(48.dp)
                .border(
                    width = 1.dp,
                    color = Color(0x99FF594F),
                    shape = RoundedCornerShape(50.dp)
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile",
                modifier = Modifier.clip(RoundedCornerShape(50.dp))
            )
        }
    }
}

@Preview
@Composable
fun TopBarSectionPreview() {
    TopBarSection()
}