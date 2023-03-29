package com.umsl.kma9q7.popularmovies

data class PopularMovies(
    val results: List<Result>
)

data class Result (
    val id: Int,
    val overview: String,
    val poster_path: String,
    val releaseDate: String,
    val title: String,
    val vote_average: Double,
    val voteCount: Int
)
