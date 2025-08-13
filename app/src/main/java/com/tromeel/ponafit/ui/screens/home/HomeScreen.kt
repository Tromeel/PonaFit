package com.tromeel.ponafit.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tromeel.ponafit.R
import com.tromeel.ponafit.navigation.ROUT_ABOUT
import com.tromeel.ponafit.navigation.ROUT_DASHBOARD
import com.tromeel.ponafit.navigation.ROUT_REGISTER
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun HomeScreen(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .paint(painter = painterResource(R.drawable.greenbg), contentScale = ContentScale.FillBounds),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Center,


        ){
        Image(
            painter = painterResource(R.drawable.pona),
            contentDescription = "logo",
            modifier = Modifier
                .size(300.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop


        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Ponafit",
            fontSize = 30.sp,
            color = Grin,
            fontWeight = FontWeight.ExtraBold,

            )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Move well. Live well",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,

            )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Your personal physiotherapy & fitness companion.Recover faster, move better, and stay strong with guided exercises, progress tracking, and expert tips — all in one app.\n" +
                    "\n",
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)

        )


        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                navController.navigate(ROUT_DASHBOARD)

            },
            colors = ButtonDefaults.buttonColors(Grin),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)



        ) {
            Text(text = "Get Started")

        }

        TextButton(onClick = { navController.navigate(ROUT_ABOUT) }) {
            Text(
                "Want to learn more about us? Click Here",
                color = Grin
            )
        }





    }




}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(navController= rememberNavController())
}