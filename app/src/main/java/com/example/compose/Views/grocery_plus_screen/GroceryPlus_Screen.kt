package com.example.compose.Views.grocery_plus_screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.compose.NavRoutes.NavRoutes
import com.example.compose.models.Product
import com.example.compose.R

@Composable
fun GroceryPlusScreen(navController: NavHostController) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (topAppBar, locationCard, searchField, gridView) = createRefs()

        topAppBar(modifier = Modifier.constrainAs(topAppBar) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
        }, navController)

        LocationCard(modifier = Modifier.constrainAs(locationCard) {

            start.linkTo(parent.start, 8.dp)
            end.linkTo(parent.end, 8.dp)
            top.linkTo(topAppBar.bottom)
        }, navController)

        SearchField(modifier = Modifier.constrainAs(searchField) {
            start.linkTo(parent.start, 8.dp)
            end.linkTo(parent.end, 8.dp)
            top.linkTo(locationCard.bottom)
        })

        GridView(modifier = Modifier
            .constrainAs(gridView) {
                start.linkTo(parent.start, 8.dp)
                end.linkTo(parent.end, 8.dp)
                top.linkTo(searchField.bottom)
            }
            .fillMaxHeight())

    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBar(modifier: Modifier, navController: NavHostController) {
    TopAppBar(
        modifier = modifier
            .padding(16.dp)
            .clip(shape = RoundedCornerShape(20.dp)),
        title = { Text("Grocery Plus!") },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.ArrowBack, "backIcon")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.Black,
        ),
        actions = {
            IconButton(onClick = { navController.navigate(NavRoutes.CategoryScreen.route) }) {
                Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
            }
            IconButton(onClick = { navController.navigate(NavRoutes.SnacksScreen.route) }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }

            IconButton(onClick = { navController.navigate(NavRoutes.OrdersScreen.route) }) {
                Icon(imageVector = Icons.Default.Notifications, contentDescription = null)
            }
        }


    )
}


@Composable
fun LocationCard(modifier: Modifier, navController: NavHostController) {

    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .height(65.dp)
    ) {

        val (floatingButton, yourLocationText, adressText, rightIcon) = createRefs()

        //FAB custom color
        FloatingActionButton(
            modifier = Modifier.constrainAs(floatingButton) {
                start.linkTo(parent.start, 8.dp)
                top.linkTo(parent.top, 8.dp)
            },
            shape = CircleShape,
            onClick = { navController.navigate(NavRoutes.WishlistScreen.route) },
            contentColor = Color(29, 214, 36, 255)
        ) {
            Icon(Icons.Default.MyLocation, "")
        }

        Text(
            text = "Your Location",
            modifier = Modifier
                .constrainAs(yourLocationText) {
                    start.linkTo(floatingButton.end, 8.dp)
                    top.linkTo(parent.top, 8.dp)
                },
            fontSize = 12.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Gray,
            fontWeight = FontWeight.Light,

            )

        Text(
            text = "Hasan Güven Caddesi 53 Sokak No:21",
            modifier = Modifier
                .constrainAs(adressText) {
                    start.linkTo(floatingButton.end, 8.dp)
                    top.linkTo(yourLocationText.bottom, 8.dp)

                },
            fontSize = 12.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            fontWeight = FontWeight.Bold,

            )

        IconButton(
            onClick = { navController.navigate(NavRoutes.AddToWishlistScreen.route) },
            modifier = Modifier.constrainAs(rightIcon) {
                end.linkTo(parent.end)
                top.linkTo(parent.top, 8.dp)
            }) {
            Icon(Icons.Filled.ArrowForward, "backIcon")
        }


    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(modifier: Modifier) {

    val textState = remember { mutableStateOf("") }

    TextField(
        value = textState.value,
        onValueChange = {
            textState.value = it
        },

        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "searchIcon"
            )
        },

        shape = RoundedCornerShape(16.dp),
        singleLine = true,


        label = { Text(text = "Search Anything") },
        placeholder = { Text(text = "Search") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(

            cursorColor = Color.Black,
            disabledLabelColor = Color.Black,
            containerColor = Color(243, 243, 243, 255),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent

        )

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

