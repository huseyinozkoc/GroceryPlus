package com.example.compose.Views.enter_password_screen


import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.compose.NavRoutes.NavRoutes
import com.example.compose.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterPasswordScreen(navController: NavHostController) {

    val contextForToast = LocalContext.current.applicationContext

    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        // Create references for the composables to constrain
        val (topAppBar, mainImage, enterNumberText, verifyText, passwordField, nextButton,forgotPassword) = createRefs()


        TopAppBar(
            modifier = Modifier
                .constrainAs(topAppBar) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
                .background(Color.Transparent),
            title = {
                Text(text = "")
            },
            navigationIcon = {
                IconButton(onClick = {
                    Toast.makeText(contextForToast, "Back Icon Click", Toast.LENGTH_SHORT)
                        .show()
                    navController.navigate(NavRoutes.EnterNumberScreen.route)

                }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go Back")
                }
            }
        )

        Image(
            painter = painterResource(id = R.drawable.password),
            contentDescription = "",
            modifier = Modifier
                .constrainAs(mainImage) {
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    top.linkTo(topAppBar.bottom, 16.dp)

                }
                .fillMaxWidth()
                .fillMaxHeight(0.45f), contentScale = ContentScale.Fit
        )

        Text(
            text = "Enter the password",
            modifier = Modifier
                .constrainAs(enterNumberText) {
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    top.linkTo(mainImage.bottom, 16.dp)
                }
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color(0, 0, 0), textAlign = TextAlign.Center,

            )

        Text(
            text = "It looks like you already have an account in this number. Please enter the password to proceed.",
            modifier = Modifier.constrainAs(verifyText) {
                start.linkTo(parent.start, 16.dp)
                end.linkTo(parent.end, 16.dp)
                top.linkTo(enterNumberText.bottom, 16.dp)

            },
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color(146, 146, 146, 255), textAlign = TextAlign.Center,

            )

        //Password
        //https://stackoverflow.com/questions/65304229/toggle-password-field-jetpack-compose
        TextField(
            modifier = Modifier
                .constrainAs(passwordField) {
                    top.linkTo(verifyText.bottom, 16.dp)
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


        Button(
            onClick = { navController.navigate(NavRoutes.EnterVerificationCodeScreen.route) },
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .shadow(0.dp)
                .constrainAs(nextButton) {
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
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "ArrowBack",
                        modifier = Modifier
                            .size(18.dp),
                        tint = Color.White
                    )
                }
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Submit",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )


            }

        }

        Text(
            text = "Forgot Password?",
            modifier = Modifier.constrainAs(forgotPassword) {
                start.linkTo(parent.start, 16.dp)
                end.linkTo(parent.end,16.dp)
                top.linkTo(passwordField.bottom, 16.dp)
            }.clickable {  },

            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color(255, 87, 34, 134)

        )

    }
}