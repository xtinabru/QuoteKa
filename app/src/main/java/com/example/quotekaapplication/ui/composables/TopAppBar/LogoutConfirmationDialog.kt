

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

// just a log out which I put into the ... button...
@Composable
fun LogoutConfirmationDialog(
    onDismissRequest: () -> Unit,
    onConfirmLogout: () -> Unit,
    onCancelLogout: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text("Confirm Logout") },
        text = { Text("Are you sure you want to log out?") },
        confirmButton = {
            Button(onClick = onConfirmLogout) {
                Text("Yes")
            }
        },
        dismissButton = {
            Button(onClick = onCancelLogout) {
                Text("No")
            }
        }
    )
}
