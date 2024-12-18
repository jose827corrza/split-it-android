package com.josedev.splitit.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.josedev.splitit.R
import com.josedev.splitit.navigation.routes.AppRoute
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    nav: NavController,
    modifier: Modifier = Modifier)
{
    LaunchedEffect(key1 = true){
        delay(1000)
        nav.popBackStack()
        nav.navigate(AppRoute.Login().route)
    }

    Splash()
}

@Composable
fun Splash () {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "josedev logo",
            Modifier.size(150.dp, 150.dp)
        )
        Text(
            text = "Split It",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}