package com.strv.movies.ui.movieslist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.strv.movies.R
import com.strv.movies.model.Movie

@Composable
fun MovieItem(movie: Movie) {
    Column {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500${movie.posterPath}",
            contentDescription = stringResource(id = R.string.movie_image)
        )
        Text(
            text = movie.originalTitle,
            fontSize = 15.sp,
            modifier = Modifier.padding(bottom = 10.dp, start = 5.dp)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesList(movies: List<Movie>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2)
    ) {
        items(movies) { movie ->
            MovieItem(movie)
        }
    }
}