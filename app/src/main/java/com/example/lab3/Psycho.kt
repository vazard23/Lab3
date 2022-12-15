package com.example.lab3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.lab3.databinding.FragmentPsychoBinding

class Psycho : Fragment() {
    lateinit var binding: FragmentPsychoBinding
    final val PSYCHO_URL : String = "https://images.mubicdn.net/images/film/2032/cache-29968-1529996557/image-w1280.jpg?size=800x"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPsychoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(view).load(PSYCHO_URL).into(binding.psychoImage)
        view.setOnClickListener {view -> view.findNavController().navigate(R.id.action_psycho_to_FirstFragment)
    }

}}