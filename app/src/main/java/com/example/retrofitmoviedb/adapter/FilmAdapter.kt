package com.example.retrofitmoviedb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitmoviedb.databinding.ItemFilmBinding
import com.example.retrofitmoviedb.model.ResponseDataFilm
import com.example.retrofitmoviedb.model.ResultFilmPopular


class FilmAdapter(private var listFilm : List<ResultFilmPopular>) : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemFilmBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmAdapter.ViewHolder {
        var view = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmAdapter.ViewHolder, position: Int) {
        holder.binding.tvTitle.text = listFilm[position].title
        holder.binding.tvDate.text = listFilm[position].releaseDate
        holder.binding.tvRating.text = listFilm[position].voteAverage.toString()

        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500${listFilm[position].posterPath}")
            .into(holder.binding.imgNews)
    }

    override fun getItemCount(): Int {
        return listFilm.size
    }
}