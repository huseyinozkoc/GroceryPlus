package com.example.compose.Views.wishlist_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.compose.R
import com.example.compose.models.Orders
import com.example.compose.models.Wishlist


@Composable
fun WishlistScreen(navController: NavHostController) {

    Column(modifier = Modifier.fillMaxSize()) {

        topAppBar(modifier = Modifier.fillMaxWidth())
        WishListLazyColumn(
            modifier = Modifier
                .fillMaxSize()
        )


    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBar(modifier: Modifier) {
    TopAppBar(
        modifier = modifier
            .padding(16.dp),
        title = { Text("Wishlist") },
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
fun WishListLazyColumn(modifier: Modifier) {

    val wishList = listOf(
        Wishlist("Nestle Nideo Full Cream Milk Powder Instant", R.drawable.huawei, 342, 270),
        Wishlist("Nestle Nideo Zero Milk Powder Instant", R.drawable.huawei, 500, 100),

        )



    LazyColumn(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(8.dp), content = {

        items(wishList.size) { index ->


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                shape = RoundedCornerShape(20.dp),
            ) {

                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {

                    val (picture, name, price, discountPrice) = createRefs()

                    Image(
                        painterResource(id = wishList[index].picture),
                        contentDescription = "product",
                        modifier = Modifier
                            .fillMaxWidth(0.20f)
                            .fillMaxHeight()
                            .constrainAs(picture) {
                                top.linkTo(parent.top, 8.dp)
                                bottom.linkTo(parent.bottom, 8.dp)
                                start.linkTo(parent.start, 8.dp)

                            },
                        contentScale = ContentScale.Fit
                    )


                    Text(
                        text = wishList[index].name ,
                        maxLines = 3,
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.constrainAs(name) {

                            top.linkTo(parent.top,8.dp)
                            start.linkTo(picture.end,16.dp)

                        },
                    )

                    Text(
                        text = wishList[index].price.toString() +"₺" ,
                        fontSize = 12.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(textDecoration = TextDecoration.LineThrough),
                        modifier = Modifier.constrainAs(price) {

                            top.linkTo(name.bottom,16.dp)
                            start.linkTo(picture.end,16.dp)

                        }

                    )

                    Text(
                        text = wishList[index].discountPrince.toString() +"₺" ,
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color(255, 152, 0, 255),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.constrainAs(discountPrice) {

                            top.linkTo(price.bottom,16.dp)
                            start.linkTo(picture.end,16.dp)

                        }

                    )


                }
            }


        }
    })


}

