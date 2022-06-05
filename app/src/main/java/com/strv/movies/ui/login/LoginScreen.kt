package com.strv.movies.ui.login

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.strv.movies.ui.error.ErrorScreen
import com.strv.movies.ui.loading.LoadingScreen

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    navigateToMoviesList: () -> Unit,
) {
    val viewState by viewModel.viewState.collectAsState()

    if (viewState.loading) {
        LoadingScreen()
    } else if (viewState.error != null) {
        ErrorScreen(errorMessage = viewState.error!!)
    } else {
        Login(navigateToMoviesList = navigateToMoviesList)
    }
}

@Composable
fun Login(
    navigateToMoviesList: () -> Unit,
) {
    Button(
        onClick = {
            navigateToMoviesList()
        }
    ) {
        Text(text = "Sign Up")
    }
}