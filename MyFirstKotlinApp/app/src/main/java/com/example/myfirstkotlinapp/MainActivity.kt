package com.example.myfirstkotlinapp

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.myfirstkotlinapp.databinding.ActivityMainBinding

private lateinit var binding:ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var count = 0
        binding.textView1.text = count.toString()
        binding.textView1.setTextSize(50F)

        binding.clickBtn.setOnClickListener{
            count++
            binding.textView1.text = count.toString()
            when(count){
                10 -> {
                    Toast.makeText(this@MainActivity,"10 click",Toast.LENGTH_SHORT).show()
                    binding.textView1.setTextColor(Color.BLUE)
                }
                20 -> {
                    Toast.makeText(this@MainActivity,"20 click",Toast.LENGTH_SHORT).show()
                    binding.textView1.setTextColor(Color.MAGENTA)
                }
                else ->{
                    binding.textView1.setTextColor(Color.BLACK)
                }
            }
        }
    }


}