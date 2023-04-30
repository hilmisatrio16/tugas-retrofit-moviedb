package com.example.retrofitmoviedb.model


import com.google.gson.annotations.SerializedName

data class ResponseDataFilm(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val resultFilmPopulars: List<ResultFilmPopular>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)