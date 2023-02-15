package com.example.compose.Views.your_information_screen

import android.widget.Toast
import androidx.compose.foundation.*
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.compose.NavRoutes.NavRoutes
import com.example.compose.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YourInformationScreen(navController: NavHostController) {

    val contextForToast = LocalContext.current.applicationContext

    var textState = remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        // Create references for the composables to constrain
        val (topAppBar, accountText, uploadImage, facebookButton, nameField, surnameField, nextButton) = createRefs()


        TopAppBar(
            modifier = Modifier
                .constrainAs(topAppBar) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
                .background(Color.Transparent),
            title = {
                Text(text = "Your Information")
            },
            navigationIcon = {
                IconButton(onClick = {
                    Toast.makeText(contextForToast, "Back Icon Click", Toast.LENGTH_SHORT)
                        .show()


                }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go Back")
                }
            }
        )


        Text(
            text = "It looks like you don't have account in this number. Please let us know some information for a scure service.",
            modifier = Modifier
                .constrainAs(accountText) {
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 0.dp)
                    top.linkTo(topAppBar.bottom, 16.dp)
                }
                .fillMaxWidth(),
            fontSize = 12.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Gray,
            fontWeight = FontWeight.Bold,

            )

        Image(
            painter = painterResource(R.drawable.upload_image),
            contentDescription = "logo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(256.dp)
                .clip(CircleShape)                       // clip to the circle shape
                .border(2.dp, Color.Gray, CircleShape)
                .constrainAs(uploadImage) {
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 0.dp)
                    top.linkTo(accountText.bottom, 16.dp)
                }
                .background(Color(233, 226, 226, 243))
        )


        Button(
            onClick = { navController.navigate(NavRoutes.YourInformationScreen.route) },
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .shadow(0.dp)
                .constrainAs(facebookButton) {
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    top.linkTo(uploadImage.bottom, 16.dp)

                },


            shape = RoundedCornerShape(12.dp),
            contentPadding = PaddingValues(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(3, 111, 197, 255)
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

                    Image(
                        painter = painterResource(id = R.drawable.facebook1),
                        contentDescription = "facebook",
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                    )
                }
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Sync From Facebook",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )


            }

        }


        /**
         * All textField Example(Also include with passwords)
         * @sample https://semicolonspace.com/jetpack-compose-textfield/
         */
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },

            modifier = Modifier
                .constrainAs(nameField) {

                    start.linkTo(parent.start, 16.dp)
                    top.linkTo(facebookButton.bottom, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                }
                .fillMaxWidth()
                .padding(12.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "phoneIcon"
                )
            },

            shape = RoundedCornerShape(16.dp),


            label = { Text(text = "Enter your name") },
            placeholder = { Text(text = "Name") },
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
            value = textState.value,
            onValueChange = { textState.value = it },

            modifier = Modifier
                .constrainAs(surnameField) {

                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    top.linkTo(nameField.bottom, 0.dp)

                }
                .fillMaxWidth()
                .padding(12.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "phoneIcon"
                )
            },

            shape = RoundedCornerShape(16.dp),


            label = { Text(text = "Enter your surname") },
            placeholder = { Text(text = "Surname") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(

                cursorColor = Color.Black,
                disabledLabelColor = Color.Black,
                containerColor = Color(243, 243, 243, 255),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent

            ), maxLines = 1

        )

        Button(
            onClick = { navController.navigate(NavRoutes.ChoosePasswordScreen.route) },
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
                    text = "Next",
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