package com.strv.movies.ui.login

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.strv.movies.ui.moviedetail.MovieDetailViewModel

@Composable
fun LoginScreen(
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