package com.example.compose.Views.order_detail_screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.compose.NavRoutes.NavRoutes
import com.example.compose.R


@Composable
fun OrderDetailScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        ConstraintLayout(modifier = Modifier.fillMaxSize())
        {

            val (topAppBar, estimatedDelivery, estimatedDeliveryTime, card, date, productStatusBar, packagingText, showDeliveryDetail, showFullPackage, deliveryManCard, deliveryLocationCard, divider, totalCard,
                divider2, paymentMethodText, paymentTypeCard
            ) = createRefs()

            val (riskText,contactButton,confirmButton
            ) = createRefs()

            //////////////////////////////////

            topAppBar(modifier = Modifier.constrainAs(topAppBar) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }, navController)

            /////////////////////////////////
            Text(
                text = "Estimated Delivery",
                modifier = Modifier
                    .constrainAs(estimatedDelivery) {
                        start.linkTo(parent.start, 8.dp)
                        top.linkTo(topAppBar.bottom, 16.dp)
                    }
                    .fillMaxWidth(),
                fontSize = 24.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                fontWeight = FontWeight.Bold,

                )
            ////////////////////////////////

            Text(
                text = "6:30 PM",
                modifier = Modifier
                    .constrainAs(estimatedDeliveryTime) {
                        top.linkTo(topAppBar.bottom, 16.dp)
                        end.linkTo(parent.end, 8.dp)

                    },
                fontSize = 24.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color(255, 152, 0, 255),
                fontWeight = FontWeight.Bold,

                )

            ////////////////////////////////


            Icon(

                Icons.Filled.CalendarMonth,
                contentDescription = "card",
                Modifier
                    .size(50.dp)
                    .constrainAs(card) {
                        top.linkTo(estimatedDelivery.bottom, 16.dp)
                        start.linkTo(parent.start, 8.dp)
                    },


                )
            ////////////////////////////////

            Text(
                text = "March 5,  2019",
                modifier = Modifier
                    .constrainAs(date) {
                        top.linkTo(estimatedDelivery.bottom, 16.dp)
                        start.linkTo(card.end, 32.dp)


                    },
                fontSize = 36.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Gray,
                fontWeight = FontWeight.Bold,

                )

            ////////////////////////////////

            Row(
                Modifier
                    .fillMaxWidth()
                    .constrainAs(productStatusBar) {
                        top.linkTo(card.bottom, 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)

                    },
                horizontalArrangement = Arrangement.SpaceBetween,

                ) {
                Divider(
                    color = Color.Green,
                    thickness = 5.dp,
                    modifier = Modifier
                        .weight(0.25f)
                        .padding(8.dp)
                )
                Divider(
                    color = Color.Green,
                    thickness = 5.dp,
                    modifier = Modifier
                        .weight(0.25f)
                        .padding(8.dp)
                )
                Divider(
                    color = Color.Gray,
                    thickness = 5.dp,
                    modifier = Modifier
                        .weight(0.25f)
                        .padding(8.dp)
                )
                Divider(
                    color = Color.Gray,
                    thickness = 5.dp,
                    modifier = Modifier
                        .weight(0.25f)
                        .padding(8.dp)
                )
            }
            ////////////////////////////////

            Text(
                text = "We are packaging your products.",
                modifier = Modifier
                    .constrainAs(packagingText) {
                        top.linkTo(productStatusBar.bottom, 8.dp)
                        start.linkTo(parent.start, 8.dp)


                    },
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Gray,
                fontWeight = FontWeight.ExtraBold,

                )

            ////////////////////////////////

            ButtonCommon(modifier = Modifier.constrainAs(showDeliveryDetail) {
                top.linkTo(packagingText.bottom, 16.dp)
                start.linkTo(parent.start, 8.dp)
                end.linkTo(parent.end, 8.dp)

            }, "Show Delivery Details")


            ////////////////////////////////

            ButtonCommon(modifier = Modifier.constrainAs(showFullPackage) {
                top.linkTo(showDeliveryDetail.bottom, 16.dp)
                start.linkTo(parent.start, 8.dp)
                end.linkTo(parent.end, 8.dp)

            }, "Show Full Package")

            ////////////////////////////////

            DeliveryManCard(modifier = Modifier.constrainAs(deliveryManCard) {
                top.linkTo(showFullPackage.bottom, 16.dp)
                start.linkTo(parent.start, 8.dp)
                end.linkTo(parent.end, 8.dp)
            })

            ////////////////////////////////


            DeliveryLocation(modifier = Modifier.constrainAs(deliveryLocationCard) {
                top.linkTo(deliveryManCard.bottom, 16.dp)
                start.linkTo(parent.start, 8.dp)
                end.linkTo(parent.end, 8.dp)
            })


            /////////////////////////////////

            Divider(
                Modifier
                    .constrainAs(divider) {
                        top.linkTo(deliveryLocationCard.bottom, 16.dp)
                        start.linkTo(parent.start, 8.dp)
                        end.linkTo(parent.end, 8.dp)

                    }
                    .fillMaxWidth(0.9f),
                color = Color.LightGray,
                thickness = 1.dp,

                )


            /////////////////////////////////

            TotalCard(modifier = Modifier.constrainAs(totalCard) {
                top.linkTo(divider.bottom, 16.dp)
                start.linkTo(parent.start, 8.dp)
                end.linkTo(parent.end, 8.dp)
            })


            ////////////////////////////////


            Divider(
                Modifier
                    .constrainAs(divider2) {
                        top.linkTo(totalCard.bottom, 16.dp)
                        start.linkTo(parent.start, 8.dp)
                        end.linkTo(parent.end, 8.dp)

                    }
                    .fillMaxWidth(0.9f),
                color = Color.LightGray,
                thickness = 1.dp,

                )

            //////////////////////////////

            Text(
                text = "Payment Method",
                modifier = Modifier
                    .constrainAs(paymentMethodText) {
                        top.linkTo(divider2.bottom, 16.dp)
                        start.linkTo(parent.start, 16.dp)


                    },
                fontSize = 24.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,

                )

            //////////////////////////////

            PaymentTypeCard(modifier = Modifier.constrainAs(paymentTypeCard) {
                top.linkTo(paymentMethodText.bottom, 16.dp)
                start.linkTo(parent.start, 16.dp)
            })

            //////////////////////////////

            Text(
                text = "Cash on derivery has some potential risk of spreading contamination. You can select other payment methods for a contactless safe delivery.",
                modifier = Modifier
                    .constrainAs(riskText) {
                        top.linkTo(paymentTypeCard.bottom, 16.dp)
                        start.linkTo(parent.start, 16.dp)
                        end.linkTo(parent.end, 16.dp)


                    }.fillMaxWidth(0.95f),
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Gray,
                fontWeight = FontWeight.ExtraBold,

                )


            /////////////////////////////


            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .shadow(0.dp)
                    .constrainAs(contactButton) {
                        start.linkTo(parent.start, 16.dp)
                        end.linkTo(parent.end, 16.dp)
                        top.linkTo(riskText.bottom,16.dp)

                    },


                shape = RoundedCornerShape(12.dp),
                contentPadding = PaddingValues(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(255, 87, 34, 255)
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
                            imageVector = Icons.Default.Comment,
                            contentDescription = "ArrowBack",
                            modifier = Modifier
                                .size(25.dp),
                            tint = Color.White
                        )
                    }
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "Contact with Support",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )


                }

            }




            ///////////////////////////////


            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .shadow(0.dp)
                    .constrainAs(confirmButton) {
                        start.linkTo(parent.start, 16.dp)
                        end.linkTo(parent.end, 16.dp)
                        top.linkTo(contactButton.bottom,16.dp)
                        bottom.linkTo(parent.bottom,24.dp)


                    },


                shape = RoundedCornerShape(12.dp),
                contentPadding = PaddingValues(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(126, 255, 131, 255)
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
                            imageVector = Icons.Default.Approval,
                            contentDescription = "ArrowBack",
                            modifier = Modifier
                                .size(18.dp),
                            tint = Color.White
                        )
                    }
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "Confirm Delivery",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )


                }

            }



            /////////////////////////////////


        }


    }

}


@Composable
fun PaymentTypeCard(modifier: Modifier) {

    Card(
        modifier = modifier
            .fillMaxWidth(0.9f)
            .height(80.dp)
            .background(Color.Transparent),
        shape = RoundedCornerShape(20.dp)

    ) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(209, 243, 170, 255))
        ) {

            val (floatButton, youSelectedText, paymentTypeText, icon) = createRefs()

            FloatingActionButton(
                modifier = Modifier
                    .constrainAs(floatButton) {
                        top.linkTo(parent.top, 16.dp)
                        start.linkTo(parent.start, 8.dp)
                    }
                    .size(50.dp),
                containerColor = Color(100, 243, 106, 255),
                onClick = { },
                shape = CircleShape,
                contentColor = Color.Black
            ) {
                Icon(Icons.Filled.AttachMoney, "")
            }

            Text(
                text = "You Selected",
                modifier = Modifier
                    .constrainAs(youSelectedText) {
                        top.linkTo(parent.top, 16.dp)
                        start.linkTo(floatButton.end, 16.dp)


                    },
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Gray,
                fontWeight = FontWeight.Medium,

                )

            Text(
                text = "Cash on Delivery",
                modifier = Modifier
                    .constrainAs(paymentTypeText) {
                        top.linkTo(youSelectedText.bottom, 4.dp)
                        start.linkTo(floatButton.end, 16.dp)


                    },
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,

                )

            Icon(
                Icons.Filled.ArrowForwardIos, "",
                Modifier
                    .constrainAs(icon) {
                        top.linkTo(parent.top, 32.dp)
                        end.linkTo(parent.end, 8.dp)
                    }, tint = Color.Black
            )


        }

    }

}

@Composable
fun TotalCard(modifier: Modifier) {


    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth(0.90f)
            .height(100.dp)
            .background(Color.Transparent)
    ) {
        val (subTotal, subTotalResult, deliveryCharge, deliveryChargeResult, total, totalResult) = createRefs()

        Text(
            text = "Subtotal",
            modifier = Modifier
                .constrainAs(subTotal) {
                    top.linkTo(parent.top, 8.dp)
                    start.linkTo(parent.start, 8.dp)


                },
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            fontWeight = FontWeight.Bold,

            )

        Text(
            text = "BDT362",
            modifier = Modifier
                .constrainAs(subTotalResult) {
                    top.linkTo(parent.top, 8.dp)
                    end.linkTo(parent.end, 8.dp)


                },
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            fontWeight = FontWeight.Bold,

            )

        Text(
            text = "Delivery Charge",
            modifier = Modifier
                .constrainAs(deliveryCharge) {
                    top.linkTo(subTotal.bottom, 8.dp)
                    start.linkTo(parent.start, 8.dp)


                },
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            fontWeight = FontWeight.Bold,

            )

        Text(
            text = "Total",
            modifier = Modifier
                .constrainAs(total) {
                    top.linkTo(deliveryCharge.bottom, 8.dp)
                    start.linkTo(parent.start, 8.dp)


                },
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            fontWeight = FontWeight.Bold,

            )

        Text(
            text = "BDT50",
            modifier = Modifier
                .constrainAs(deliveryChargeResult) {
                    top.linkTo(subTotalResult.bottom, 8.dp)
                    end.linkTo(parent.end, 8.dp)


                },
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            fontWeight = FontWeight.Bold,

            )

        Text(
            text = "BDT412",
            modifier = Modifier
                .constrainAs(totalResult) {
                    top.linkTo(deliveryChargeResult.bottom, 8.dp)
                    end.linkTo(parent.end, 8.dp)


                },
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            fontWeight = FontWeight.Bold,

            )


    }
}


@Composable
fun DeliveryLocation(modifier: Modifier) {


    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth(0.90f)
            .height(110.dp)
            .background(Color.White)
    ) {
        val (deliveryText, floatButton, address) = createRefs()

        Text(
            text = "Delivery Location",
            modifier = Modifier
                .constrainAs(deliveryText) {
                    top.linkTo(parent.top, 8.dp)
                    start.linkTo(parent.start, 8.dp)


                },
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold,

            )

        FloatingActionButton(
            modifier = Modifier
                .constrainAs(floatButton) {
                    top.linkTo(deliveryText.bottom, 8.dp)
                    start.linkTo(parent.start, 8.dp)
                }
                .size(50.dp),
            containerColor = Color(208, 231, 250, 255),
            onClick = { },
            shape = CircleShape,
            contentColor = Color.Black
        ) {
            Icon(Icons.Filled.MyLocation, "")
        }

        Text(
            text = "Floor 4, Wakil Tower, Ta 131 Gulshan",
            modifier = Modifier
                .constrainAs(address) {
                    top.linkTo(deliveryText.bottom, 24.dp)
                    start.linkTo(floatButton.end, 8.dp)


                },
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            fontWeight = FontWeight.Medium,

            )


    }
}


@Composable
fun DeliveryManCard(modifier: Modifier) {


    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth(0.90f)
            .height(150.dp)
            .background(Color.White)
    ) {
        val (deliveryManText, image, name, phone, floatButton) = createRefs()

        Text(
            text = "Delivery Man",
            modifier = Modifier
                .constrainAs(deliveryManText) {
                    top.linkTo(parent.top, 8.dp)
                    start.linkTo(parent.start, 8.dp)


                },
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold,

            )

        Image(
            painter = painterResource(R.drawable.huseyin),
            contentDescription = "logo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(90.dp)
                .clickable { }
                .clip(CircleShape)                       // clip to the circle shape
                .constrainAs(image) {
                    top.linkTo(deliveryManText.bottom, 12.dp)
                    start.linkTo(parent.start, 8.dp)
                }
                .background(Color(233, 226, 226, 243))
        )

        Text(
            text = "Hüseyin Özkoç",
            modifier = Modifier
                .constrainAs(name) {
                    top.linkTo(deliveryManText.bottom, 16.dp)
                    start.linkTo(image.end, 16.dp)
                },
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            fontWeight = FontWeight.Bold,

            )

        Text(
            text = "(207) 555-0119",
            modifier = Modifier
                .constrainAs(phone) {
                    top.linkTo(name.bottom, 16.dp)
                    start.linkTo(image.end, 16.dp)
                },
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            fontWeight = FontWeight.Medium,

            )

        FloatingActionButton(
            modifier = Modifier
                .constrainAs(floatButton) {
                    top.linkTo(deliveryManText.bottom, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                }
                .size(50.dp),
            containerColor = Color(255, 222, 174, 255),
            onClick = { },
            shape = CircleShape,
            contentColor = Color(224, 143, 25, 255)
        ) {
            Icon(Icons.Filled.Phone, "")
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


@Composable
fun ButtonCommon(modifier: Modifier, buttonText: String) {
    Button(
        onClick = { },
        modifier = modifier
            .fillMaxWidth(0.95f)
            .shadow(0.dp),

        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(194, 236, 146, 255)
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

            }
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = buttonText,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraBold
            )


        }

    }
}
