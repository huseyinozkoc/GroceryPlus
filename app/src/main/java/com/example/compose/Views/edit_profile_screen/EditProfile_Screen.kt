package com.example.compose.Views.edit_profile_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.compose.NavRoutes.NavRoutes
import com.example.compose.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(navController: NavHostController) {


    var textState = remember { mutableStateOf("") }
    var textState2 = remember { mutableStateOf("") }


    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }


    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        // Create references for the composables to constrain
        val (topAppBar, image, nameField, passwordField, numberField, saveButton) = createRefs()

        topAppBar(modifier = Modifier.constrainAs(topAppBar) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
        }, navController = navController)
        ///////////////////////////////////////////


        Image(
            painter = painterResource(R.drawable.huseyin),
            contentDescription = "logo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(275.dp)
                .clickable {  }
                .clip(CircleShape)                       // clip to the circle shape
                .border(2.dp, Color.Black, CircleShape)
                .constrainAs(image) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(topAppBar.bottom, 8.dp)
                }
                .background(Color(233, 226, 226, 243))
        )

        ///////////////////////////////////////////
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },

            modifier = Modifier
                .constrainAs(nameField) {

                    start.linkTo(parent.start, 8.dp)
                    end.linkTo(parent.end, 8.dp)
                    top.linkTo(image.bottom, 16.dp)
                }
                .fillMaxWidth()
                .padding(12.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "shoppingBagIcon"
                )
            },

            shape = RoundedCornerShape(16.dp),


            label = { Text(text = "Name") },
            placeholder = { Text(text = "Full Name") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(

                cursorColor = Color.Black,
                disabledLabelColor = Color.Black,
                containerColor = Color(243, 243, 243, 255),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent

            ), maxLines = 1

        )



        ///////////////////////////////////////////


        TextField(
            modifier = Modifier
                .constrainAs(passwordField) {
                    top.linkTo(nameField.bottom, 16.dp)
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                }
                .fillMaxWidth()
                .padding(12.dp),
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            placeholder = { Text("Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                // Please provide localized description for accessibility services
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, description)
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(

                cursorColor = Color.Black,
                disabledLabelColor = Color.Black,
                containerColor = Color(243, 243, 243, 255),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent

            ),
            maxLines = 1,
            shape = RoundedCornerShape(16.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password"
                )
            },
        )


        ///////////////////////////////////////////

        TextField(
            value = textState2.value,
            onValueChange = { textState2.value = it },

            modifier = Modifier
                .constrainAs(numberField) {

                    start.linkTo(parent.start, 8.dp)
                    end.linkTo(parent.end, 8.dp)
                    top.linkTo(passwordField.bottom, 16.dp)
                }
                .fillMaxWidth()
                .padding(12.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "shoppingBagIcon"
                )
            },

            shape = RoundedCornerShape(16.dp),


            label = { Text(text = "Phone") },
            placeholder = { Text(text = "Phone Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            colors = TextFieldDefaults.outlinedTextFieldColors(

                cursorColor = Color.Black,
                disabledLabelColor = Color.Black,
                containerColor = Color(243, 243, 243, 255),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent

            ), maxLines = 1

        )



        ///////////////////////////////////////////


        Button(
            onClick = { navController.navigate(NavRoutes.FullPackageDetailScreen.route) },
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .shadow(0.dp)
                .constrainAs(saveButton) {
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
                        imageVector = Icons.Default.Save,
                        contentDescription = "ArrowBack",
                        modifier = Modifier
                            .size(18.dp),
                        tint = Color.White
                    )
                }
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Save ",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )


            }

        }





        ////////////////////////////////////////////


    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBar(modifier: Modifier, navController: NavHostController) {
    TopAppBar(
        modifier = modifier
            .padding(16.dp),
        title = { Text("Edit Profile") },
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