
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quotekaapplication.ui.theme.screens.MainScreen
import com.example.quotekaapplication.ui.theme.screens.QuoteInfo
import com.example.quotekaapplication.ui.theme.screens.SettingsScreen

@Composable
fun ScaffoldApp() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            // Добавляем TopAppBar с названием "Main Screen"
            TopAppBar(title = "Main Screen", navController = navController)
        },
        content = { paddingValues -> // paddings btwn elements
            NavHost(
                navController = navController,
                startDestination = "home"
            ) {
                composable(route = "home")  { MainScreen(navController, paddingValues) }
                composable(route = "info")  { QuoteInfo(navController, paddingValues) }
                composable(route = "settings")  { SettingsScreen(navController, paddingValues) }
            }
        }
    )
}
