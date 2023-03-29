package com.umsl.kma9q7.popularmovies

data class PopularPeople(
    val results: List<PeopleResult>
)

data class PeopleResult (
    val id: Int,
    val profile_path: String,
    val releaseDate: String,
    val name: String,
    val popularity: Double,
    val voteCount: Int
)