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
import com.google.firebase.Timestamp
import com.josedev.splitit.domain.entities.Project
import com.josedev.splitit.navigation.routes.AppRoute
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardComponent(
    nav: NavController,
    info: Project,
) {

    Card (
        onClick = {
            nav.navigate(AppRoute.ProjectInfoWithId(info.projectId).route)
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
                    text = info.name.orEmpty(),
                    modifier = Modifier. padding(15.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Row (){
                    Text(
                        modifier = Modifier.padding(5.dp),
                        textAlign = TextAlign.Justify,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light,
                        text = "Created At: "
                    )
                    Text(
                        modifier = Modifier.padding(5.dp),
                        textAlign = TextAlign.Justify,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraLight,
                        text = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(info.createdAt!!.toDate())
                    )
                }
            }
        }
    }
}