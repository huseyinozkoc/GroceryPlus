package com.example.compose.Views.product_details_screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.compose.R
import com.example.compose.models.Wishlist


@Composable
fun ProductDetailScreen(navController: NavHostController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        ConstraintLayout(modifier = Modifier.fillMaxSize()) {

            // Create references for the composables to constrain
            val (topAppBar, productImage, productName, productKg, productPrice, productDaily, productDescription, youCanAlso,list, addToBagButton) = createRefs()


            topAppBar(modifier = Modifier.constrainAs(topAppBar) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)

            }, navController)

            Image(
                painter = painterResource(R.drawable.huawei),
                contentDescription = "logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth(0.90f)
                    .height(300.dp)
                    .clip(RoundedCornerShape(10.dp))                       // clip to the circle shape
                    .border(2.dp, Color.Black, RoundedCornerShape(10.dp))
                    .constrainAs(productImage) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(topAppBar.bottom, 8.dp)
                    }
                    .background(Color(233, 226, 226, 243))
            )

            Text(
                text = "Arla DANO Full Cream Milk Powder Instant",
                modifier = Modifier
                    .fillMaxWidth(0.90f)
                    .constrainAs(productName) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(productImage.bottom, 16.dp)
                    },
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                fontWeight = FontWeight.Bold,

                )

            Text(
                text = "1 KG",
                modifier = Modifier
                    .width(100.dp)
                    .constrainAs(productKg) {
                        start.linkTo(parent.start, 16.dp)
                        top.linkTo(productName.bottom, 16.dp)
                    },
                fontSize = 25.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                fontWeight = FontWeight.Bold,

                )

            Text(
                text = "182₺",
                modifier = Modifier
                    .width(80.dp)
                    .constrainAs(productPrice) {
                        end.linkTo(parent.end, 16.dp)
                        top.linkTo(productName.bottom, 16.dp)
                    },
                fontSize = 25.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color(76, 175, 80, 255),
                fontWeight = FontWeight.Bold,

                )

            Text(
                text = "Dairy Products",
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .constrainAs(productDaily) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(productKg.bottom, 16.dp)
                    },
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Gray,
                fontWeight = FontWeight.Bold,

                )

            Text(
                text = "Et quidem faciunt, ut summun bonum sit exremum et rationibus conquisitis de voluptate. Sed ut summun bonum sit id.",
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .constrainAs(productDescription) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(productDaily.bottom, 16.dp)
                    },
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                fontWeight = FontWeight.Bold,

                )

            Text(
                text = "You can also check this items.",
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .constrainAs(youCanAlso) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(productDescription.bottom, 16.dp)
                    },
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Gray,
                fontWeight = FontWeight.Bold,

                )


            val wishList = listOf(
                Wishlist("Nestle Nideo Full Cream Milk Powder Instant", R.drawable.huawei, 342, 270),
                Wishlist("Nestle Nideo Zero Milk Powder Instant", R.drawable.huawei, 500, 100),
                Wishlist("Nestle Nideo Zero Milk Powder Instant", R.drawable.huawei, 500, 100),
                Wishlist("Nestle Nideo Zero Milk Powder Instant", R.drawable.huawei, 500, 100),
                )

            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(16.dp).constrainAs(list) {
                    start.linkTo(parent.start,16.dp)
                    end.linkTo(parent.end,16.dp)
                    top.linkTo(youCanAlso.bottom, 8.dp)
                }, content = {

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




            Button(
                onClick = { navController.navigate(NavRoutes.EditProfileScreen.route) },
                modifier = Modifier
                    .fillMaxWidth(0.90f)
                    .shadow(0.dp)
                    .constrainAs(addToBagButton) {
                        start.linkTo(parent.start, 16.dp)
                        end.linkTo(parent.end, 16.dp)
                        top.linkTo(list.bottom,8.dp)
                        bottom.linkTo(parent.bottom,8.dp)

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
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "ArrowBack",
                            modifier = Modifier
                                .size(18.dp),
                            tint = Color.White
                        )
                    }
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "Add to Bag",
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

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBar(modifier: Modifier, navController: NavHostController) {
    TopAppBar(
        modifier = modifier
            .padding(16.dp),
        title = { Text("Product Details") },
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