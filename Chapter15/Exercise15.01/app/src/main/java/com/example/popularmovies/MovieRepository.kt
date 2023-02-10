package com.example.popularmovies

import android.util.Log
import com.example.popularmovies.api.MovieService
import com.example.popularmovies.database.MovieDao
import com.example.popularmovies.database.MovieDatabase
import com.example.popularmovies.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRepository(private val movieService: MovieService, private val movieDatabase: MovieDatabase) {
    private val apiKey = "4b6a464636483bd0c7d5451186b74c0e"

//    fun fetchMovies(): Flow<List<Movie>> {
//        return flow {
//            emit(movieService.getPopularMovies(apiKey).results)
//        }.flowOn(Dispatchers.IO)
//    }
    fun fetchMovies(): Flow<List<Movie>> {
        return flow {
            val movieDao: MovieDao = movieDatabase.movieDao()
            val savedMovies = movieDao.getMovies()
            if(savedMovies.isEmpty()) {
                val movies = movieService.getPopularMovies(apiKey).results
                movieDao.addMovies(movies)
                emit(movies)
            } else {
                emit(savedMovies)
            }
        }.flowOn(Dispatchers.IO)
    }

    //15.03
    suspend fun fetchMoviesFromNetwork() {
        val movieDao: MovieDao = movieDatabase.movieDao()
        try {
            val popularMovies = movieService.getPopularMovies(apiKey)
            val moviesFetched = popularMovies.results
            movieDao.addMovies(moviesFetched)
        } catch (exception: Exception) {
            //Log.d("MovieRepository”, An error occurred: ${exception.message}")
            Log.d("MovieRepository", "An error occurred: ${exception.message}")
        }
    }


}