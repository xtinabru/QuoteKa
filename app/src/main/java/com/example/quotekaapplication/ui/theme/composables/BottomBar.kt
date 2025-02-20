import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun BottomBar(navController: NavController) {

    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.Green,
        actions = {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceAround, // Выравнивание
                verticalAlignment = Alignment.CenterVertically
            ) {
                // btns
                IconButton(onClick = { navController.navigate("home") }) {
                    Icon(imageVector = Icons.Filled.Home, contentDescription = "Home")
                }
                IconButton(onClick = { navController.navigate("categories") }) {
                    Icon(imageVector = Icons.Filled.Info, contentDescription = "Categories")
                }

                IconButton(onClick = { navController.navigate("add_quote") }) {
                    Icon(imageVector = Icons.Filled.AddCircle, contentDescription = "Add Quote")
                }
                IconButton(onClick = { navController.navigate("favorite") }) {
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorite")
                }

                IconButton(onClick = { navController.navigate("profile") }) {
                    Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "Profile")
                }
            }


        }
    )
}