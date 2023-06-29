package com.example.myfirstkotlinapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstkotlinapp.databinding.ActivitySubBinding

private lateinit var binding: ActivitySubBinding

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}