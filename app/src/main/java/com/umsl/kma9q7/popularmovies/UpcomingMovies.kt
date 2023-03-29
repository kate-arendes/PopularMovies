package com.umsl.kma9q7.popularmovies

data class UpcomingMovies(
    val results: List<UpcomingResult>

)

data class UpcomingResult (
    val original_title: String,
    val poster_path: String
){
    override fun toString(): String = original_title
}
