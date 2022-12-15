package com.example.lab3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3.Entity.Film
import com.example.lab3.Adapter.FilmAdapter
import com.example.lab3.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    lateinit var adapter: FilmAdapter
    lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initial()
    }

    private fun initial() {
        recyclerView = binding.rvFilm
        adapter = FilmAdapter(this)
        recyclerView.adapter = adapter
        adapter.setList(myFilm())

        adapter.setOnItemClickListener(object : FilmAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                when(position){
                    0 -> {
                        view!!.findNavController().navigate(R.id.action_FirstFragment_to_fight)
                    }
                    1 -> {
                        view!!.findNavController().navigate(R.id.action_FirstFragment_to_drive)
                    }
                    2 -> {
                      view!!.findNavController().navigate(R.id.action_FirstFragment_to_psycho)
                    }
                }
            }
        })

    }

    fun myFilm(): ArrayList<Film> {
        val dishList = ArrayList<Film>()

        val film_drive = Film("Drive", "https://m.media-amazon.com/images/I/51pc4UOfWwL.jpg")
        val film_american_psycho = Film(
            "American Psycho",
            "https://m.media-amazon.com/images/M/MV5BZTM2ZGJmNjQtN2UyOS00NjcxLWFjMDktMDE2NzMyNTZlZTBiXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX1000_.jpg"
        )
        val film_fight_club = Film(
            "Fight Club",
            "https://m.media-amazon.com/images/M/MV5BNDIzNDU0YzEtYzE5Ni00ZjlkLTk5ZjgtNjM3NWE4YzA3Nzk3XkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_.jpg"
        )
        dishList.add(film_fight_club)
        dishList.add(film_drive)
        dishList.add(film_american_psycho)
        return dishList
    }
}