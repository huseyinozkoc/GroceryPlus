package com.example.compose.Views.enter_number_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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
fun EnterNumberScreen(navController: NavHostController) {

    var textState = remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        // Create references for the composables to constrain
        val (mainImage, enterNumberText, verifyText, phoneNumberField, nextButton) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.enter_number),
            contentDescription = "",
            modifier = Modifier
                .constrainAs(mainImage) {
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    top.linkTo(parent.top, 48.dp)

                }
                .fillMaxWidth()
                .fillMaxHeight(0.5f), contentScale = ContentScale.Fit
        )

        Text(
            text = "Enter your mobile Number",
            modifier = Modifier.constrainAs(enterNumberText) {
                start.linkTo(parent.start, 16.dp)
                end.linkTo(parent.end,16.dp)
                top.linkTo(mainImage.bottom, 16.dp)
            },
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color(0, 0, 0),
            textAlign = TextAlign.Center,

            )

        Text(
            text = "We need to verify you. We will send you a one time verification code.",
            modifier = Modifier.constrainAs(verifyText) {
                start.linkTo(parent.start, 16.dp)
                top.linkTo(enterNumberText.bottom, 16.dp)
            },
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color(146, 146, 146, 255)

        )

        /**
         * All textField Example(Also include with passwords)
         * @sample https://semicolonspace.com/jetpack-compose-textfield/
         */
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },

            modifier = Modifier
                .constrainAs(phoneNumberField) {

                    start.linkTo(parent.start, 16.dp)
                    top.linkTo(verifyText.bottom, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                }
                .fillMaxWidth()
                .padding(12.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "phoneIcon"
                )
            },
            trailingIcon = {
                IconButton(onClick = { textState.value = "" }) {
                    Icon(
                        imageVector = Icons.Default.Flag,
                        contentDescription = null
                    )
                }
            },
            shape = RoundedCornerShape(16.dp),


            label = { Text(text = "Phone Number") },
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


        Button(
            onClick = { navController.navigate(NavRoutes.EnterPasswordScreen.route) },
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