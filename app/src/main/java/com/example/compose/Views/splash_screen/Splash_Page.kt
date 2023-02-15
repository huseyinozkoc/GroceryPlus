import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.*
import com.example.compose.NavRoutes.NavRoutes
import com.example.compose.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController) {

    // to keep track if the animation is playing
    // and play pause accordingly
    var isPlaying by remember {
        mutableStateOf(true)
    }

    // for speed
    var speed by remember {
        mutableStateOf(1f)
    }
    val composition by rememberLottieComposition(

        LottieCompositionSpec
            // here `code` is the file name of lottie file
            // use it accordingly
            .RawRes(R.raw.lottie2)
    )

    // to control the animation
    val progress by animateLottieCompositionAsState(
        // pass the composition created above
        composition,

        // Iterates Forever
        iterations = LottieConstants.IterateForever,

        // pass isPlaying we created above,
        // changing isPlaying will recompose
        // Lottie and pause/play
        isPlaying = isPlaying,

        // pass speed we created above,
        // changing speed will increase Lottie
        speed = speed,

        // this makes animation to restart
        // when paused and play
        // pass false to continue the animation
        // at which is was paused
        restartOnPlay = false

    )



    LaunchedEffect(key1 = true) {
        delay(1800)
        navController.navigate(NavRoutes.EnterNumberScreen.route)
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            // LottieAnimation
            // Pass the composition
            // and the progress state
            LottieAnimation(
                composition,
                progress,
                modifier = Modifier.size(400.dp)
            )

            Text(
                text = "Grocery Plus",
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 48.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
        }


    }
}