package com.example.compose.Views.add_to_wishlist_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.compose.NavRoutes.NavRoutes
import com.example.compose.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddToWishlistScreen(navController: NavHostController) {

    var textState = remember { mutableStateOf("") }
    var textState2 = remember { mutableStateOf("") }
    var textState3 = remember { mutableStateOf("") }

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        // Create references for the composables to constrain
        val (topAppBar, productNameField, amountField, brandField, uploadImageField, saveButton) = createRefs()

        topAppBar(modifier = Modifier.constrainAs(topAppBar) {

            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)

        }, navController)


        /**
         * All textField Example(Also include with passwords)
         * @sample https://semicolonspace.com/jetpack-compose-textfield/
         */
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },

            modifier = Modifier
                .constrainAs(productNameField) {

                    start.linkTo(parent.start, 8.dp)
                    end.linkTo(parent.end, 8.dp)
                    top.linkTo(topAppBar.bottom, 8.dp)
                }
                .fillMaxWidth()
                .padding(12.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.ShoppingBag,
                    contentDescription = "shoppingBagIcon"
                )
            },

            shape = RoundedCornerShape(16.dp),


            label = { Text(text = "Product Name") },
            placeholder = { Text(text = "Product Name") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(

                cursorColor = Color.Black,
                disabledLabelColor = Color.Black,
                containerColor = Color(243, 243, 243, 255),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent

            ), maxLines = 1

        )



        TextField(
            value = textState2.value,
            onValueChange = { textState2.value = it },

            modifier = Modifier
                .constrainAs(amountField) {

                    start.linkTo(parent.start, 8.dp)
                    end.linkTo(parent.end, 8.dp)
                    top.linkTo(productNameField.bottom, 8.dp)
                }
                .fillMaxWidth()
                .padding(12.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AttachMoney,
                    contentDescription = "shoppingBagIcon"
                )
            },

            shape = RoundedCornerShape(16.dp),


            label = { Text(text = "Amount") },
            placeholder = { Text(text = "Amount") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(

                cursorColor = Color.Black,
                disabledLabelColor = Color.Black,
                containerColor = Color(243, 243, 243, 255),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent

            ), maxLines = 1

        )


        TextField(
            value = textState3.value,
            onValueChange = { textState3.value = it },

            modifier = Modifier
                .constrainAs(brandField) {

                    start.linkTo(parent.start, 8.dp)
                    end.linkTo(parent.end, 8.dp)
                    top.linkTo(amountField.bottom, 8.dp)
                }
                .fillMaxWidth()
                .padding(12.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Camera,
                    contentDescription = "shoppingBagIcon"
                )
            },

            shape = RoundedCornerShape(16.dp),


            label = { Text(text = "Brand(Optional") },
            placeholder = { Text(text = "Brand") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(

                cursorColor = Color.Black,
                disabledLabelColor = Color.Black,
                containerColor = Color(243, 243, 243, 255),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent

            ), maxLines = 1

        )

        Image(
            painter = painterResource(R.drawable.upload_image),
            contentDescription = "logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(10.dp))                       // clip to the circle shape
                .border(2.dp, Color.Black, RoundedCornerShape(10.dp))
                .constrainAs(uploadImageField) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(brandField.bottom, 8.dp)
                }
                .background(Color(233, 226, 226, 243))
        )



        Button(
            onClick = { navController.navigate(NavRoutes.ProductDetailScreen.route) },
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .shadow(0.dp)
                .constrainAs(saveButton) {
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    top.linkTo(uploadImageField.bottom,16.dp)
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
                        imageVector = Icons.Default.Save,
                        contentDescription = "ArrowBack",
                        modifier = Modifier
                            .size(18.dp),
                        tint = Color.White
                    )
                }
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Save to Wishlist",
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
        title = { Text("Add to Wishlist") },
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