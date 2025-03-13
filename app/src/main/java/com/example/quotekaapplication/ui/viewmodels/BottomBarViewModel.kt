import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

class BottomBarViewModel : ViewModel() {
    var currentRoute by mutableStateOf<String>("home") // initial route as home

    // nav
    fun onNavItemClicked(navController: NavController, route: String) {
        currentRoute = route
        navController.navigate(route) {
            launchSingleTop = true
            restoreState = true
        }
    }
}