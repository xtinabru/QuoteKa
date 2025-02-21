import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {

    private val auth = FirebaseAuth.getInstance()

    var isAuthenticated = mutableStateOf(false)

    fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    isAuthenticated.value = true
                } else {
                    isAuthenticated.value = false
                }
            }
    }

    fun register(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    isAuthenticated.value = true
                } else {
                    isAuthenticated.value = false
                }
            }
    }

    fun logout() {
        auth.signOut()
        isAuthenticated.value = false
    }
}
