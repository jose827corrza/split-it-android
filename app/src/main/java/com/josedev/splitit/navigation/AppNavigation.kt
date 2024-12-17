package com.josedev.splitit.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.josedev.splitit.navigation.routes.AppRoute
import com.josedev.splitit.screens.HomeScreen
import com.josedev.splitit.screens.LoginScreen
import com.josedev.splitit.screens.SplashScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    val appNavController = rememberNavController()

    NavHost(navController = appNavController, startDestination = AppRoute.Splash().route){
        composable(AppRoute.Splash().route){
            SplashScreen(appNavController)
        }
        composable(AppRoute.Login().route){
            LoginScreen(appNavController)
        }
        composable(AppRoute.Home().route){
            HomeScreen(appNavController, modifier = modifier)
        }
    }
}