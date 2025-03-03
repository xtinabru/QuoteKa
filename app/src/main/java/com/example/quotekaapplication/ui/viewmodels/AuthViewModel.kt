package com.example.quotekaapplication.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
class AuthViewModel : ViewModel() {

    private val auth = FirebaseAuth.getInstance()

    // state for inputs
    var email = mutableStateOf("")
    var password = mutableStateOf("")

    var isAuthenticated = mutableStateOf(false)

    fun onEmailChange(newEmail: String) {
        email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        password.value = newPassword
    }

    fun login() {
        auth.signInWithEmailAndPassword(email.value, password.value)
            .addOnCompleteListener { task ->
                isAuthenticated.value = task.isSuccessful
            }
    }

    fun register() {
        auth.createUserWithEmailAndPassword(email.value, password.value)
            .addOnCompleteListener { task ->
                isAuthenticated.value = task.isSuccessful
            }
    }

    fun logout() {
        auth.signOut()
        isAuthenticated.value = false
    }
}