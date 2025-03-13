package com.example.quotekaapplication.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TopAppBarViewModel : ViewModel() {
    var expanded = mutableStateOf(false)
    var showLogoutConfirmation = mutableStateOf(false)
    var title = mutableStateOf("QuoteKa")
    var currentRoute = mutableStateOf("home")

    // to renew header
    fun updateTitle(route: String) {
        currentRoute.value = route
        title.value = when (route) {
            "home" -> "Home"
            "favorite" -> "Favorites"
            "profile" -> "Profile"
            "settings" -> "Settings"
            "info" -> "Info"
            else -> title.value
        }
    }
}