package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivitySearchlistBinding

class searchlist : AppCompatActivity() {
    lateinit var binding: ActivitySearchlistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchlist)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_searchlist)


    }
}