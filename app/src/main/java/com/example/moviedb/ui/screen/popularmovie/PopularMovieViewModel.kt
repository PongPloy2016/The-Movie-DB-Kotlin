package com.example.moviedb.ui.screen.popularmovie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviedb.data.constants.MovieListType
import com.example.moviedb.data.model.Movie
import com.example.moviedb.data.remote.ApiParams
import com.example.moviedb.data.repository.UserRepository
import com.example.moviedb.ui.base.BaseLoadMoreRefreshViewModel
import kotlinx.coroutines.launch


class PopularMovieViewModel @ViewModelInject constructor(
    private val userRepository: UserRepository
) : BaseLoadMoreRefreshViewModel<Movie>() {

    val mode = MutableLiveData<Int>().apply { value = MovieListType.POPULAR.type }

    var index = 9

    override fun loadData(page: Int) {
        val hashMap = HashMap<String, String>()
        hashMap[ApiParams.PAGE] = page.toString()
        when (mode.value) {
            MovieListType.POPULAR.type -> hashMap[ApiParams.SORT_BY] = ApiParams.POPULARITY_DESC
            MovieListType.TOP_RATED.type -> hashMap[ApiParams.SORT_BY] = ApiParams.VOTE_AVERAGE_DESC
            else -> hashMap[ApiParams.SORT_BY] = ApiParams.POPULARITY_DESC
        }

        val movie1 = Movie(id = "1", title = "1", index = 1, poster_path = "/4ZocdxnOO6q2UbdKye2wgofLFhB.jpg")
        val movie2 = Movie(id = "1", title = "1", index = 2, poster_path = "/4ZocdxnOO6q2UbdKye2wgofLFhB.jpg")
        val movie3 = Movie(id = "1", title = "1", index = 3, poster_path = "/4ZocdxnOO6q2UbdKye2wgofLFhB.jpg")
        val movie4 = Movie(id = "1", title = "1", index = 4, poster_path = "/4ZocdxnOO6q2UbdKye2wgofLFhB.jpg")
        val movie5 = Movie(id = "1", title = "1", index = 5, poster_path = "/4ZocdxnOO6q2UbdKye2wgofLFhB.jpg")
        val movie6 = Movie(id = "1", title = "1", index = 6, poster_path = "/4ZocdxnOO6q2UbdKye2wgofLFhB.jpg")
        val movie7 = Movie(id = "1", title = "1", index = 7, poster_path = "/4ZocdxnOO6q2UbdKye2wgofLFhB.jpg")
        val movie8 = Movie(id = "1", title = "1", index = 8, poster_path = "/4ZocdxnOO6q2UbdKye2wgofLFhB.jpg")

        viewModelScope.launch {
            try {
                onLoadSuccess(page, listOf(movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8))
            } catch (e: Exception) {
                onError(e)
            }
        }
    }
}
