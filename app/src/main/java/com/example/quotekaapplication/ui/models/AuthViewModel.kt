package com.example.quotekaapplication.ui.models

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    var isAuthenticated = mutableStateOf(false)

    fun login() {
        isAuthenticated.value = true
    }

    fun register() {
        // logic
        // auto authorization
        isAuthenticated.value = true
    }
    fun logout() {
        isAuthenticated.value = false
    }
}
