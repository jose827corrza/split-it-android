package com.josedev.splitit.navigation.routes

sealed class AppRoute(val route: String) {
    class Splash: AppRoute("splash")
    class Login: AppRoute("login")
    class SignUp: AppRoute("signup")
    class Home: AppRoute("home")
}