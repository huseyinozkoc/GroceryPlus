package com.example.compose.Views.orders_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.compose.R
import com.example.compose.Views.snacks_screen.GridView
import com.example.compose.models.Orders
import com.example.compose.models.Snacks


@Composable
fun OrdersScreen(navController: NavHostController) {

    Column(modifier = Modifier.fillMaxSize()) {

        topAppBar(modifier = Modifier.fillMaxWidth())
        OrderLazyColumn(modifier = Modifier.fillMaxSize())


    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBar(modifier: Modifier) {
    TopAppBar(
        modifier = modifier
            .padding(16.dp),
        title = { Text("Orders") },
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
fun OrderLazyColumn(modifier: Modifier) {

    val orderList = listOf(
        Orders(1, 700, "Delivered", "October 24,2014"),
        Orders(2, 99, "Cancelled", "October 24,2014"),
        Orders(3, 70, "Delivered", "October 24,2014"),
        Orders(4, 1000, "Delivered", "October 24,2014"),
        Orders(5, 20, "Cancelled", "October 24,2014"),
        Orders(6, 39, "Delivered", "October 24,2014"),
        Orders(7, 80, "Delivered", "October 24,2014"),
    )

    LazyColumn(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(8.dp), content = {

        items(orderList.size) { index ->

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

                    val (floatingButton, orderNo, orderStatus, orderDate, orderPrice) = createRefs()

                    //FAB custom color
                    FloatingActionButton(
                        modifier = Modifier.constrainAs(floatingButton) {
                            start.linkTo(parent.start, 8.dp)
                            top.linkTo(parent.top, 8.dp)
                            bottom.linkTo(parent.bottom, 8.dp)
                        },
                        shape = CircleShape,
                        onClick = {},
                        contentColor = Color.White,
                        containerColor = Color(255, 152, 0, 255)
                    ) {
                        Icon(Icons.Default.ShoppingCart, "")
                    }

                    Text(
                        text = "Order #" + (orderList[index].orderNo),
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.constrainAs(orderNo) {
                            start.linkTo(floatingButton.end, 16.dp)
                            top.linkTo(parent.top, 16.dp)


                        }

                    )

                    if (orderList[index].orderStatus == "Delivered") {
                        Text(
                            text = orderList[index].orderStatus,
                            fontSize = 12.sp,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Green,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.constrainAs(orderStatus) {
                                start.linkTo(floatingButton.end, 16.dp)
                                top.linkTo(orderNo.bottom, 16.dp)


                            }

                        )
                    } else {
                        Text(
                            text = orderList[index].orderStatus,
                            fontSize = 12.sp,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Red,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.constrainAs(orderStatus) {
                                start.linkTo(floatingButton.end, 16.dp)
                                top.linkTo(orderNo.bottom, 16.dp)


                            }

                        )
                    }

                    Text(
                        text = orderList[index].orderData,
                        fontSize = 12.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.constrainAs(orderDate) {
                            start.linkTo(floatingButton.end, 16.dp)
                            top.linkTo(orderStatus.bottom, 16.dp)


                        }

                    )

                    Text(
                        text = orderList[index].orderPrice.toString() + "₺",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color(255, 152, 0, 255),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.constrainAs(orderPrice) {
                            end.linkTo(parent.end, 8.dp)
                            top.linkTo(parent.top, 8.dp)
                            bottom.linkTo(parent.bottom, 8.dp)


                        }

                    )


                } //End of Constraint Layout


            }


        }

    })


}