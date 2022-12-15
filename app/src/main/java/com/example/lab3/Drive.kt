package com.example.lab3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.lab3.databinding.FragmentDriveBinding

class Drive : Fragment() {

    final var DRIVE_URL : String = "https://m.media-amazon.com/images/M/MV5BMTU4MjUyOTczOF5BMl5BanBnXkFtZTcwNTE0MjQyNg@@._V1_QL75_UX500_CR0,46,500,281_.jpg"

    lateinit var binding: FragmentDriveBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDriveBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(view).load(DRIVE_URL).into(binding.driveImage)
        view.setOnClickListener {view -> view.findNavController().navigate(R.id.action_drive_to_FirstFragment)
    }

}}