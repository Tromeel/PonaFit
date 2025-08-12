package com.tromeel.ponafit.ui.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.tromeel.ponafit.R
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.navigation.ROUT_LOGIN
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.ui.theme.Parple
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController){

    var coroutine =rememberCoroutineScope()
    coroutine.launch {
        delay(2000)
        navController.navigate(ROUT_LOGIN)

    }


    Column(
        modifier = Modifier
            .paint(painter = painterResource(R.drawable.greenbg), contentScale = ContentScale.FillBounds)
            .fillMaxSize(),



        

    ) {
        Image(
            painter = painterResource(R.drawable.pona),
            contentDescription = "computer",
            modifier = Modifier
                .size(width = 200.dp, height = 100.dp),
            alignment = Alignment.TopStart
            

        )

        Spacer(modifier = Modifier.height(100.dp))

        //Lottie Animation
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.run))
        val progress by animateLottieCompositionAsState(composition)

        LottieAnimation(composition, progress,
            modifier = Modifier
            .size(300.dp)
                .align(Alignment.CenterHorizontally)




        )
        //End of animation


        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Move Well. Live Well",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Grin,
            modifier = Modifier.align(Alignment.CenterHorizontally),


        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Your personal physiotherapy & fitness guide.",
            fontSize =20.sp,
            fontWeight = FontWeight.Bold,
            color = Grin,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally),



            )

        Spacer(modifier = Modifier.height(80.dp))

        LinearProgressIndicator(
            color = Grin,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )







    }

}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    SplashScreen(rememberNavController())
}