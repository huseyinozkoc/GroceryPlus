package com.example.compose.NavRoutes

sealed class NavRoutes(val route: String) {

    object Splash : NavRoutes("Splash")
    object SingIn : NavRoutes("SingIn")
    object SignUp : NavRoutes("SignUp")
    object Home : NavRoutes("Home")
    object EnterNumberScreen : NavRoutes("EnterNumberScreen")
    object EnterPasswordScreen : NavRoutes("EnterPasswordScreen")
    object EnterVerificationCodeScreen : NavRoutes("EnterVerificationCodeScreen")
    object YourInformationScreen : NavRoutes("YourInformationScreen")
    object ChoosePasswordScreen : NavRoutes("ChoosePasswordScreen")
    object GroceryPlusScreen : NavRoutes("GroceryPlusScreen")
    object CategoryScreen : NavRoutes("CategoryScreen")
    object SnacksScreen : NavRoutes("SnacksScreen")
    object OrdersScreen : NavRoutes("OrdersScreen")
    object WishlistScreen : NavRoutes("WishlistScreen")
    object AddToWishlistScreen : NavRoutes("AddToWishlistScreen")
    object ProductDetailScreen:NavRoutes("ProductDetailScreen")
    object EditProfileScreen:NavRoutes("EditProfileScreen")
    object FullPackageDetailScreen:NavRoutes("FullPackageDetailScreen")
    object OrderDetailScreen:NavRoutes("OrderDetailScreen")
}