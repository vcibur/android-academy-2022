package com.strv.movies.ui.movieslist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.strv.movies.extension.fold
import com.strv.movies.network.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private val _viewState = MutableStateFlow(MoviesListViewState(loading = true))
    val viewState = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            fetchPopularMovies()
        }
    }

    private suspend fun fetchPopularMovies() {
        Log.e("TAG", "MovieList - Start fetching data.")
        movieRepository.getPopularMovies().fold(
            { error ->
                Log.d("TAG", "MovieListLoadingError: $error")
                _viewState.update {
                    MoviesListViewState(
                        error = error
                    )
                }
            },
            { movieList ->
                Log.e("TAG", "MovieListSuccess: ${movieList.size}")
                _viewState.update {
                    MoviesListViewState(
                        movies = movieList.sortedByDescending { movie -> movie.popularity }
                    )
                }
            }
        )
    }
}