package com.josedev.splitit.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.josedev.splitit.navigation.routes.AppRoute
import com.josedev.splitit.presentation.LoginVM
import com.josedev.splitit.repository.events.AuthEvent
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    nav: NavController,
    modifier: Modifier = Modifier,
    viewModel: LoginVM = hiltViewModel()
)
{

    val scope = rememberCoroutineScope()

    Scaffold (
        modifier = modifier.fillMaxSize(),
    ){ innerPadding ->
        Column (
            modifier = modifier.padding(innerPadding)
        ){
            Text(text = "Home")
            Button(onClick = {
                scope.launch {
                    viewModel.onEvent(AuthEvent.SignOut)
                    nav.navigate(AppRoute.Login().route)
                }
            }){
                Text(text = "Log out")
            }
        }

    }

}