package com.bolhy91.cabifystore.presentation.product_lists

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bolhy91.cabifystore.ui.components.TopBarSection
import com.bolhy91.cabifystore.ui.theme.CabifyStoreTheme
import com.bolhy91.cabifystore.R
import com.bolhy91.cabifystore.domain.model.Product
import com.bolhy91.cabifystore.presentation.product_lists.components.ProductItem
import com.bolhy91.cabifystore.ui.components.ShimmerLoading

@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel = hiltViewModel(),
    itemPress: (Product) -> Unit
) {
    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .padding(
                start = 15.dp,
                top = 25.dp,
                bottom = 15.dp,
                end = 15.dp
            )
    ) {
        TopBarSection()
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(id = R.string.slogan),
            modifier = Modifier
                .padding(bottom = 15.dp),
            style = MaterialTheme.typography.h1.copy(
                lineHeight = 35.sp
            ),
        )
        Text(
            text = stringResource(id = R.string.title_product),
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(top = 10.dp, bottom = 15.dp)
        )

        if (state.products.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                items(state.products.size) { index ->
                    ProductItem(product = state.products[index], itemPress = {
                        itemPress(it)
                    })
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        } else {
            Column {
                repeat(5) {
                    ShimmerLoading()
                }
            }
        }
    }
}

@Preview
@Composable
fun ProductListScreenPreview() {
    CabifyStoreTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            ProductListScreen(itemPress = {})
        }
    }
}