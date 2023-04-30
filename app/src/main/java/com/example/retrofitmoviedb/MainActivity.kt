package com.example.retrofitmoviedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitmoviedb.adapter.FilmAdapter
import com.example.retrofitmoviedb.databinding.ActivityMainBinding
import com.example.retrofitmoviedb.model.ResponseDataFilm
import com.example.retrofitmoviedb.model.ResultFilmPopular
import com.example.retrofitmoviedb.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getFilmPopular()
    }

    private fun getFilmPopular() {
        RetrofitClient.instance.getAllFilmPopular()
            .enqueue(object : Callback<ResponseDataFilm> {
                override fun onResponse(
                    call: Call<ResponseDataFilm>,
                    response: Response<ResponseDataFilm>
                ) {
                    if(response.isSuccessful){
                        var data = response.body()
                        binding.rvFilm.layoutManager = GridLayoutManager(this@MainActivity, 2)
                        if (data != null) {
                            binding.rvFilm.adapter = FilmAdapter(data.resultFilmPopulars as List<ResultFilmPopular>)
                        }
                        Log.i("GET", response.body()?.resultFilmPopulars.toString())
                    }else{
                        Toast.makeText(this@MainActivity, "Failed load data", Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<ResponseDataFilm>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "", Toast.LENGTH_SHORT).show()
                    Log.e("GAGAL", "GAGAL")

                }

            })
    }
}