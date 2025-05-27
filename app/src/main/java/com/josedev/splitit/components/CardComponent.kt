package com.josedev.splitit.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.josedev.splitit.domain.entities.Project
import com.josedev.splitit.navigation.routes.AppRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardComponent(
    nav: NavController,
    info: Project,
) {

    Card (
        onClick = {
            nav.navigate(AppRoute.Home())
        },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ){
        Row (

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(10.dp)
        ){
            Column {
                Text(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    text = "title",
                    modifier = Modifier. padding(15.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    modifier = Modifier.padding(5.dp),
                    textAlign = TextAlign.Justify,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.ExtraLight,
                    text = "Created At: ")
            }
        }
    }
}