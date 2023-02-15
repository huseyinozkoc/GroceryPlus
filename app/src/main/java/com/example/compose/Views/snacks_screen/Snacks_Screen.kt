package com.example.compose.Views.snacks_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.compose.R
import com.example.compose.models.Snacks


@Composable
fun SnacksScreen(navController: NavHostController) {

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
        title = { Text("Snacks") },
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

    val snackstList = listOf(
        Snacks("Albeni", R.drawable.huawei, 100),
        Snacks("Halley", R.drawable.huawei, 70),
        Snacks("Biskrem", R.drawable.huawei, 89),
        Snacks("Ülker Çikolata", R.drawable.huawei, 50),
        Snacks("Rulokat", R.drawable.huawei, 20),
        Snacks("Tutku", R.drawable.huawei, 15),
    )

    LazyVerticalGrid(modifier = modifier.padding(8.dp), columns = GridCells.Fixed(2), content = {

        items(snackstList.count()) { index ->


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
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
                        painterResource(id = snackstList[index].picture),
                        contentDescription = "product",
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.65f),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = snackstList[index].name,
                        fontSize = 13.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,

                        )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = snackstList[index].price.toString() + "₺",
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color(255, 87, 34, 255),
                        fontWeight = FontWeight.Bold,

                        )
                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(contentColor = Color.White
                        , containerColor = Color(139, 195, 74, 255)
                        )
                    ) {

                        Icon(Icons.Default.ShoppingBag, "backIcon")
                        Text(
                            text = "Add To Bag",
                            color = Color.White,
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .weight(1f)
                        )
                    }


                }


            }


        }
    })

}