package com.example.lab3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.lab3.databinding.FragmentFightBinding

class Fight : Fragment() {

    lateinit var binding: FragmentFightBinding
    final val FIGHT_URL : String = "https://m.media-amazon.com/images/M/MV5BMTMzNDU3NDkwMF5BMl5BanBnXkFtZTYwMDc1Mzc3._V1_.jpg"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFightBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(view).load(FIGHT_URL).into(binding.fightImage)
        view.setOnClickListener {view -> view.findNavController().navigate(R.id.action_fight_to_FirstFragment)
    }
}}

