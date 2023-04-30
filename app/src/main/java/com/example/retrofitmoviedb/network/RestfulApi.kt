package com.example.retrofitmoviedb.network

import com.example.retrofitmoviedb.model.ResponseDataFilm
import com.example.retrofitmoviedb.model.ResultFilmPopular
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {

    @GET("movie/popular?api_key=dd42f3fa66fbe4c2e71096a7d64847c3&language=en-US&page=1")
    fun getAllFilmPopular() : Call<ResponseDataFilm>

}