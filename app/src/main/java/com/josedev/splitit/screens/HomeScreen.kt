package com.josedev.splitit.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.josedev.splitit.components.ListOfCards
import com.josedev.splitit.navigation.routes.AppRoute
import com.josedev.splitit.presentation.HomeVM
import com.josedev.splitit.presentation.LoginVM
import com.josedev.splitit.repository.events.AuthEvent
import com.josedev.splitit.repository.events.HomeEvent
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    nav: NavController,
    modifier: Modifier = Modifier,
    loginViewModel: LoginVM = hiltViewModel(),
    homeViewModel: HomeVM = hiltViewModel()
)
{
    val state = homeViewModel.state.collectAsState()

    val scope = rememberCoroutineScope()

//    Scaffold (
//        modifier = modifier.fillMaxSize(),
//    ){ innerPadding ->
        if(state.value.isLoading){
            homeViewModel.onEvent(HomeEvent.GetAllProjects)

            Row (
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp),
                    color = MaterialTheme.colorScheme.secondary,

                    )

            }
        }else {
            Column (
                modifier = modifier
            ){
                ListOfCards(state.value.projects, nav)
                Button(onClick = {
                    scope.launch {
                        loginViewModel.onEvent(AuthEvent.SignOut)
                        nav.navigate(AppRoute.Login().route)
                    }
                }){
                    Text(text = "Log out")
                }
            }
        }

}