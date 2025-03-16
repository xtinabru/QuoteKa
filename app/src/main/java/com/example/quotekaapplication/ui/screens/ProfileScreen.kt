package com.example.quotekaapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.quotekaapplication.R
import com.example.quotekaapplication.ui.composables.DifferentElements.BackgroundImage
import com.example.quotekaapplication.ui.composables.DifferentElements.SmallButton
import com.example.quotekaapplication.ui.viewmodels.AuthViewModel


@Composable
fun ProfileScreen(
    navController: NavController,
    authViewModel: AuthViewModel = viewModel()
) {

    val userEmail = authViewModel.email.value

    Box(

        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        BackgroundImage()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.hello, userEmail),
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 40.sp,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(200.dp))

            SmallButton(
                text = stringResource(R.string.change_password),
                onClick = {

                },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .padding(horizontal = 16.dp)
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally)
            )

            SmallButton(
                text = stringResource(R.string.log_out),
                onClick = {
                },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .padding(horizontal = 16.dp)
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}
