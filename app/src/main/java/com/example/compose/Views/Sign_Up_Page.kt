package com.example.compose.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.compose.NavRoutes.NavRoutes


@Composable
fun SignUpScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
        ,
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Welcome to ", style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.size(30.dp))

            Button(onClick = { navController.navigate(NavRoutes.Home.route)  }) {
                Text(text = "Sign Up Screen")
            }
        }
    }

}