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

    fun onEmailChange(newEmail: String) {
        email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        password.value = newPassword
    }

    fun onConfirmPasswordChange(newConfirmPassword: String) {
        confirmPassword.value = newConfirmPassword
    }

    // Проверка на валидность email
    private fun isEmailValid(): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
        return Pattern.matches(emailPattern, email.value)
    }

    // Проверка на валидность пароля
    private fun isPasswordValid(): Boolean {
        val passwordPattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#\$%^&*(),.?\":{}|<>]).{8,}$"
        return Pattern.matches(passwordPattern, password.value)
    }

    // Проверка совпадения паролей
    private fun arePasswordsMatching(): Boolean {
        return password.value == confirmPassword.value
    }

    // Проверка всех условий
    fun validateInputs(): Boolean {
        return isEmailValid() && isPasswordValid() && arePasswordsMatching()
    }

    // Функция регистрации
    fun register(onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        if (validateInputs()) {
            auth.createUserWithEmailAndPassword(email.value, password.value)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        isAuthenticated.value = true
                        onSuccess()  // Регистрация успешна
                    } else {
                        task.exception?.message?.let {
                            onFailure(it)  // Ошибка
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

    fun login() {
        auth.signInWithEmailAndPassword(email.value, password.value)
            .addOnCompleteListener { task ->
                isAuthenticated.value = task.isSuccessful
            }
    }

    fun logout() {
        auth.signOut()
        isAuthenticated.value = false
    }
}
