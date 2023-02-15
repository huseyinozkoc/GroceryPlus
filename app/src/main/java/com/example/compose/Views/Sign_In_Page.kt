package com.example.compose.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.compose.NavRoutes.NavRoutes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(navController: NavHostController) {

    var textState = remember { mutableStateOf("") }

    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }


    /**
     * Gradient Official
     * @sample https://developer.android.com/jetpack/compose/graphics/draw/brush
     */
    val largeRadialGradient = object : ShaderBrush() {
        override fun createShader(size: Size): Shader {
            val biggerDimension = maxOf(size.height, size.width)
            return RadialGradientShader(
                colors = listOf(Color(0xFF2be4dc), Color(0xFF243484)),
                center = size.center,
                radius = biggerDimension / 2f,
                colorStops = listOf(0f, 0.95f)
            )
        }
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(largeRadialGradient)
    ) {

        // Create references for the composables to constrain
        val (mainCard, EmailField, PasswordField, SignInButton, SignUpButton) = createRefs()

        /**
         * Basic Card --> you should implement
         * @see https://developer.android.com/jetpack/compose/designsystems/material3
         */
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .padding(16.dp)

                .constrainAs(mainCard) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .clickable { },

            ) {


            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Yellow)
            ) {


                /**
                 * All textField Example(Also include with passwords)
                 * @sample https://semicolonspace.com/jetpack-compose-textfield/
                 */
                OutlinedTextField(
                    value = textState.value,
                    onValueChange = { textState.value = it },

                    modifier = Modifier
                        .constrainAs(EmailField) {

                            top.linkTo(parent.top, 48.dp)
                            start.linkTo(parent.start, 16.dp)
                            end.linkTo(parent.end, 16.dp)


                        }
                        .padding(12.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "emailIcon"
                        )
                    },

                    trailingIcon = {
                        IconButton(onClick = { textState.value = "" }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null
                            )
                        }
                    },


                    label = { Text(text = "Email address") },
                    placeholder = { Text(text = "Enter your e-mail") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        cursorColor = Color.Yellow,
                        containerColor = Color.Red,
                        placeholderColor = Color.Black,
                        focusedBorderColor = Color.Cyan
                    )

                )


                //Password
                //https://stackoverflow.com/questions/65304229/toggle-password-field-jetpack-compose
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    singleLine = true,
                    placeholder = { Text("Password") },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        val image = if (passwordVisible)
                            Icons.Filled.Add
                        else Icons.Filled.Close

                        // Please provide localized description for accessibility services
                        val description = if (passwordVisible) "Hide password" else "Show password"

                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(imageVector = image, description)
                        }
                    }, modifier = Modifier.constrainAs(PasswordField) {
                        top.linkTo(EmailField.bottom, 16.dp)
                        start.linkTo(parent.start, 16.dp)
                        end.linkTo(parent.end, 16.dp)
                    }
                )

                // Rounded Button (Sign In)
                Button(
                    onClick = { navController.navigate(NavRoutes.Home.route)  },
                    modifier = Modifier
                        .padding(8.dp)
                        .constrainAs(SignInButton) {
                            top.linkTo(PasswordField.bottom, 8.dp)
                            start.linkTo(parent.start, 32.dp)
                        },

                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "Sign In")
                }

                // Rounded Button (Sign Up)
                Button(
                    onClick = { navController.navigate(NavRoutes.SignUp.route)  },
                    modifier = Modifier
                        .padding(8.dp)
                        .constrainAs(SignUpButton) {
                            top.linkTo(PasswordField.bottom, 8.dp)
                            end.linkTo(parent.end, 32.dp)
                        },

                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "Sign Up")
                }


            }  //End of the Constraint for Card

        }


    }

}