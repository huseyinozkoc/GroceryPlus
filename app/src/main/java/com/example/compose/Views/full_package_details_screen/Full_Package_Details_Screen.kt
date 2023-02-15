package com.example.compose.Views.full_package_details_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
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
import com.example.compose.NavRoutes.NavRoutes
import com.example.compose.models.Wishlist


@Composable
fun FullPackageDetailScreen(navController: NavHostController) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (topAppBar, productsText, list, addProductButton) = createRefs()

        //////////////////////
        topAppBar(modifier = Modifier.constrainAs(topAppBar) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
        }, navController)
        //////////////////////////
        Text(
            text = "Products",
            modifier = Modifier
                .constrainAs(productsText) {
                    start.linkTo(parent.start, 64.dp)
                    end.linkTo(parent.end, 0.dp)
                    top.linkTo(topAppBar.bottom, 16.dp)
                }
                .fillMaxWidth(),
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            fontWeight = FontWeight.Bold,

            )

        ///////////////////////
        WishListLazyColumn(modifier = Modifier.constrainAs(list) {
            start.linkTo(parent.start, 16.dp)
            end.linkTo(parent.end, 0.dp)
            top.linkTo(productsText.bottom, 16.dp)
        })

        ////////////////////////////
        Button(
            onClick = { navController.navigate(NavRoutes.OrderDetailScreen.route)  },
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .shadow(0.dp)
                .constrainAs(addProductButton) {
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    bottom.linkTo(parent.bottom, 16.dp)

                },


            shape = RoundedCornerShape(12.dp),
            contentPadding = PaddingValues(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(5, 224, 14, 255)
            )

        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {

                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "ArrowBack",
                        modifier = Modifier
                            .size(18.dp),
                        tint = Color.White
                    )
                }
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Add New Product",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )


            }

        }


    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBar(modifier: Modifier, navController: NavHostController) {
    TopAppBar(
        modifier = modifier
            .padding(16.dp),
        title = { Text("Full Package Details") },
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
        Wishlist(
            "Halley",
            com.example.compose.R.drawable.huawei,
            342,
            270
        ),
        Wishlist(
            "Halley",
            com.example.compose.R.drawable.huawei,
            500,
            100
        ),
        Wishlist(
            "Halley",
            com.example.compose.R.drawable.huawei,
            400,
            240
        ),

    )



    LazyColumn(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(8.dp)
        , content = {

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

                    val (picture, name, price, discountPrice, decreaseButton, counter, increaseButton) = createRefs()

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
                        text = wishList[index].name,
                        maxLines = 3,
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.constrainAs(name) {

                            top.linkTo(parent.top, 8.dp)
                            start.linkTo(picture.end, 16.dp)

                        },
                    )

                    Text(
                        text = wishList[index].price.toString() + "₺",
                        fontSize = 12.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(textDecoration = TextDecoration.LineThrough),
                        modifier = Modifier.constrainAs(price) {

                            top.linkTo(name.bottom, 16.dp)
                            start.linkTo(picture.end, 16.dp)

                        }

                    )

                    Text(
                        text = wishList[index].discountPrince.toString() + "₺",
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color(255, 152, 0, 255),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.constrainAs(discountPrice) {

                            top.linkTo(price.bottom, 16.dp)
                            start.linkTo(picture.end, 16.dp)

                        }

                    )


                    FloatingActionButton(
                        modifier = Modifier
                            .constrainAs(decreaseButton) {
                                top.linkTo(name.bottom, 16.dp)
                                start.linkTo(discountPrice.end, 24.dp)
                            }
                            .size(50.dp),
                        onClick = { },
                        shape = RoundedCornerShape(16.dp),
                        containerColor = Color.Red
                    ) {
                        Icon(Icons.Filled.Remove, "")
                    }


                    Text(
                        text = "1",
                        fontSize = 24.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.constrainAs(counter) {

                            top.linkTo(name.bottom, 24.dp)
                            start.linkTo(decreaseButton.end, 16.dp)

                        }

                    )


                    FloatingActionButton(
                        modifier = Modifier
                            .constrainAs(increaseButton) {
                                top.linkTo(name.bottom, 16.dp)
                                start.linkTo(counter.end, 16.dp)
                            }
                            .size(50.dp),
                        containerColor = Color.Green,
                        onClick = { },
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Icon(Icons.Filled.Add, "")
                    }


                }
            }


        }
    })


}