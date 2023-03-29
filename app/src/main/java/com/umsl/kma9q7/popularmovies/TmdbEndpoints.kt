package com.umsl.kma9q7.popularmovies

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbEndpoints {
    @GET("/3/movie/popular")
    fun getMovies(@Query("api_key") key: String): Call<PopularMovies>

    @GET("/3/person/popular")
    fun getPeople(@Query("api_key") key: String): Call<PopularPeople>

    @GET("/3/movie/upcoming")
    fun getUpcoming(@Query("api_key") key: String): Call<UpcomingMovies>
}