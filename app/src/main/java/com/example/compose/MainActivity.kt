package com.example.compose

import SplashScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.NavRoutes.NavRoutes
import com.example.compose.Views.HomeScreen
import com.example.compose.Views.SignInScreen
import com.example.compose.Views.SignUpScreen
import com.example.compose.Views.add_to_wishlist_screen.AddToWishlistScreen
import com.example.compose.Views.category_screen.CategoryScreen
import com.example.compose.Views.choose_password_screen.ChoosePasswordScreen
import com.example.compose.Views.edit_profile_screen.EditProfileScreen
import com.example.compose.Views.enter_number_screen.EnterNumberScreen
import com.example.compose.Views.enter_password_screen.EnterPasswordScreen
import com.example.compose.Views.enter_verification_code_screen.EnterVerificationCodeScreen
import com.example.compose.Views.full_package_details_screen.FullPackageDetailScreen
import com.example.compose.Views.grocery_plus_screen.GroceryPlusScreen
import com.example.compose.Views.order_detail_screen.OrderDetailScreen
import com.example.compose.Views.orders_screen.OrdersScreen
import com.example.compose.Views.product_details_screen.ProductDetailScreen
import com.example.compose.Views.snacks_screen.SnacksScreen
import com.example.compose.Views.wishlist_screen.WishlistScreen
import com.example.compose.Views.your_information_screen.YourInformationScreen
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            val navController = rememberNavController()

            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    MainScreen(navController)


                }

            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Splash.route,
    ) {

        composable(NavRoutes.Splash.route) {

            SplashScreen(navController = navController)

        }

        composable(NavRoutes.SingIn.route) {

            SignInScreen(navController = navController)
        }

        composable(NavRoutes.SignUp.route) {
            SignUpScreen(navController = navController)
        }

        composable(NavRoutes.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(NavRoutes.EnterNumberScreen.route) {
            EnterNumberScreen(navController = navController)
        }

        composable(NavRoutes.EnterPasswordScreen.route) {
            EnterPasswordScreen(navController = navController)
        }

        composable(NavRoutes.EnterVerificationCodeScreen.route) {
            EnterVerificationCodeScreen(navController = navController)
        }

        composable(NavRoutes.YourInformationScreen.route) {
            YourInformationScreen(navController = navController)
        }

        composable(NavRoutes.ChoosePasswordScreen.route) {
            ChoosePasswordScreen(navController = navController)
        }

        composable(NavRoutes.GroceryPlusScreen.route) {
            GroceryPlusScreen(navController = navController)
        }

        composable(NavRoutes.CategoryScreen.route) {
            CategoryScreen(navController = navController)
        }

        composable(NavRoutes.SnacksScreen.route) {
            SnacksScreen(navController = navController)
        }

        composable(NavRoutes.OrdersScreen.route) {
            OrdersScreen(navController = navController)
        }

        composable(NavRoutes.WishlistScreen.route) {
            WishlistScreen(navController = navController)
        }

        composable(NavRoutes.AddToWishlistScreen.route) {
            AddToWishlistScreen(navController = navController)
        }

        composable(NavRoutes.ProductDetailScreen.route) {
            ProductDetailScreen(navController = navController)
        }

        composable(NavRoutes.EditProfileScreen.route) {
            EditProfileScreen(navController = navController)
        }

        composable(NavRoutes.FullPackageDetailScreen.route) {
            FullPackageDetailScreen(navController = navController)
        }

        composable(NavRoutes.OrderDetailScreen.route) {
            OrderDetailScreen(navController = navController)
        }


    }
}