package com.example.quotekaapplication.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern

class AuthViewModel : ViewModel() {

    private val auth = FirebaseAuth.getInstance()

    // state for inputs
    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var confirmPassword = mutableStateOf("")
    var isAuthenticated = mutableStateOf(false)

    // validation error
    var validationError = mutableStateOf<String?>(null)


  // ________________________________________
        // TO STAY LOGGED IN WHEN REFRESH
    // Check if the user is already logged in
    init {
        // This will check if the user is logged in when the ViewModel is created
        checkUserAuthenticationStatus()
    }

    private fun checkUserAuthenticationStatus() {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            email.value = currentUser.email ?: "" // Получаем email текущего пользователя
        }
        isAuthenticated.value = currentUser != null

    }


 // _________________________________________________

    // inputs
    fun onEmailChange(newEmail: String) {
        email.value = newEmail
    }
    fun onPasswordChange(newPassword: String) {
        password.value = newPassword
    }
    fun onConfirmPasswordChange(newConfirmPassword: String) {
        confirmPassword.value = newConfirmPassword
    }

    // email validaition!
    private fun isEmailValid(): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
        return Pattern.matches(emailPattern, email.value)
    }

    // password validation
    private fun isPasswordValid(): Boolean {
        val passwordPattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#\$%^&*(),.?\":{}|<>]).{8,}$"
        return Pattern.matches(passwordPattern, password.value)
    }

    // check that they match
    private fun arePasswordsMatching(): Boolean {
        return password.value == confirmPassword.value
    }

    // all conditions check
    fun validateInputs(): Boolean {
        return isEmailValid() && isPasswordValid() && arePasswordsMatching()
    }

    // REGISTRATION
    fun register(onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        if (validateInputs()) {
            auth.createUserWithEmailAndPassword(email.value, password.value)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        isAuthenticated.value = true
                        onSuccess()
                    } else {
                        // check if email exists
                        task.exception?.let { exception ->
                            if (exception.message?.contains("The email address is already in use") == true) {
                                validationError.value = "Email is already in use"
                            }
                        }
                        task.exception?.message?.let {
                            onFailure(it)  // error
                        }
                    }
                }
        } else {
            validationError.value = when {
                !isEmailValid() -> "Invalid email format"
                !isPasswordValid() -> "Password must be at least 8 characters long, contain a digit, a special character, and both uppercase and lowercase letters."
                !arePasswordsMatching() -> "Passwords do not match"
                else -> "Unknown error"
            }
            onFailure(validationError.value ?: "Unknown error")
        }
    }

    // LOGIN
    fun login(onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        auth.signInWithEmailAndPassword(email.value, password.value)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val currentUser = auth.currentUser
                    email.value = currentUser?.email ?: ""
                    isAuthenticated.value = true
                    onSuccess()
                } else {
                    task.exception?.message?.let {
                        onFailure(it)
                    }
                }
            }
    }

    //LOGOUT
    fun logout() {
        auth.signOut()
        email.value = ""
        isAuthenticated.value = false
    }
}
