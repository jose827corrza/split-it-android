package com.josedev.splitit.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.josedev.splitit.navigation.routes.AppRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    nav: NavController,
    modifier: Modifier = Modifier)
{

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var isPasswordVisible by remember {
        mutableStateOf(true)
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .height(IntrinsicSize.Max),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ){
        OutlinedTextField(
            singleLine = true,
            value = email,
            onValueChange = {email = it},
            label = { Text(text = "Email")},
            keyboardOptions = KeyboardOptions(autoCorrect = false, keyboardType = KeyboardType.Email)
        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            singleLine = true,
            value = password,
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(imageVector = if(isPasswordVisible) Icons.Default.Lock else Icons.Default.Warning, contentDescription = "Check")}

            },
            onValueChange = {password = it},
            label = { Text(text = "Password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),
            visualTransformation = if(isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None)
        Spacer(modifier = Modifier.height(40.dp))
        FilledTonalButton(onClick = {
            nav.navigate(AppRoute.Home().route)
        },
            modifier = Modifier.width(200.dp))
        {
            Text(text = "Log in")
        }
        ElevatedButton(onClick = {
            nav.navigate(AppRoute.Home().route)
        },
            modifier = Modifier.width(200.dp))
        {
            Text(text = "Sign up")
        }
    }

}