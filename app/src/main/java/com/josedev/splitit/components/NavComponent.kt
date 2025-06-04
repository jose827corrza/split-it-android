package com.josedev.splitit.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.josedev.splitit.navigation.routes.AppRoute
import com.josedev.splitit.screens.HomeScreen

@Composable
fun NavComponent(
    navigation: NavController,
    modifier: Modifier = Modifier
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            NavDrawerSheetComponent(navigation, scope, drawerState)
        }
    )
    {
        Scaffold(
            modifier = modifier.fillMaxSize(),
            topBar = { TopBarComponent(drawerState, scope) },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navigation.navigate(AppRoute.ProjectInfoWithId(null).route)
                    }
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        )
        { innerPadding ->
                    HomeScreen(navigation, Modifier.padding(innerPadding))
        }
    }
}
