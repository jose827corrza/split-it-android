package com.josedev.splitit.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.josedev.splitit.domain.entities.Project

@Composable
fun ListOfCards(
    itemList: List<Project>,
    nav: NavController,
    modifier: Modifier = Modifier)
{
    Column(
        modifier = Modifier.fillMaxSize().padding(5f.dp, 10.dp),
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ){
            items(itemList){
                CardComponent(nav, it)
            }
        }
    }
}