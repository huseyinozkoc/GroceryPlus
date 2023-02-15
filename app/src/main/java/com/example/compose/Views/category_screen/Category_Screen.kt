package com.example.compose.Views.category_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.compose.R
import com.example.compose.models.Product


@Composable
fun CategoryScreen(navController: NavHostController) {

    Column(modifier = Modifier.fillMaxSize()) {

        topAppBar(modifier = Modifier.fillMaxWidth())
        GridView(modifier = Modifier.fillMaxHeight())


    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBar(modifier: Modifier) {
    TopAppBar(
        modifier = modifier
            .padding(16.dp),
        title = { Text("Category") },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.ArrowBack, "backIcon")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.Black,
        ),

        )
}


@Composable
fun GridView(modifier: Modifier) {

    val productList = listOf(
        Product("Fruit & Vegetables", R.drawable.huawei),
        Product("Breakfast", R.drawable.huawei),
        Product("Beverages", R.drawable.huawei),
        Product("Meat & Fish", R.drawable.huawei),
        Product("Snacks", R.drawable.huawei),
        Product("Dairy", R.drawable.huawei),
    )

    LazyVerticalGrid(modifier = modifier.padding(8.dp), columns = GridCells.Fixed(2), content = {

        items(productList.count()) { index ->


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                shape = RoundedCornerShape(20.dp),
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Image(
                        painterResource(id = productList[index].picture),
                        contentDescription = "product",
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.75f),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = productList[index].name,
                        fontSize = 13.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,

                        )

                }


            }


        }
    })

}