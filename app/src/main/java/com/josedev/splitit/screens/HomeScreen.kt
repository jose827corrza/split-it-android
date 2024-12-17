package com.josedev.splitit.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    nav: NavController,
    modifier: Modifier = Modifier
)
{
    Scaffold (
        modifier = modifier.fillMaxSize(),
    ){ innerPadding ->
        Column (
            modifier = modifier.padding(innerPadding)
        ){
            Text(text = "Home")
        }

    }

}