package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentPasswordlistBinding

class passwordlist : Fragment() {
    lateinit var binding: FragmentPasswordlistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment binding
        binding= FragmentPasswordlistBinding.inflate(inflater,container,false)


        return binding.root


    }

    companion object {

        @JvmStatic
        fun newInstance() = passwordlist()
    }
}