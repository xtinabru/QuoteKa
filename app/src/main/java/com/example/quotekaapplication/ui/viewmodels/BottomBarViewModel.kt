package com.example.quotekaapplication.ui.viewmodels


import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

class BottomBarViewModel : ViewModel() {
    // state of the active screen
    var currentRoute by mutableStateOf("home")
        private set

    // update the route
    fun onNavItemClicked(navController: NavController, route: String) {
        if (currentRoute != route) {
            currentRoute = route
            navController.navigate(route) {
            }
        }
    }
}