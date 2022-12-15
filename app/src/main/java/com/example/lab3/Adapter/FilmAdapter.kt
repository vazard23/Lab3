package com.example.lab3.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab3.Entity.Film
import com.example.lab3.FirstFragment
import com.example.lab3.R

class FilmAdapter(private val context: FirstFragment)
    : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>(){

    private var filmList = emptyList<Film>()
    private lateinit var clickListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        clickListener = listener
    }




    class FilmViewHolder(view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view){
        var film_pic:ImageView
        var textView: TextView = itemView.findViewById(R.id.tv_film_name)

        init {
            film_pic = itemView.findViewById(R.id.iv_film_pic)

            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film_layout, parent, false)
        return FilmViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tv_film_name).text = filmList[position].name
        Glide.with(context).load(filmList[position].pic_url).into(holder.film_pic)



    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    fun setList(list: List<Film>){
        filmList = list
        notifyDataSetChanged()
    }


}