package com.example.homeforpaws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homeforpaws.databinding.ActivityWritePostBinding

class WritePostActivity : AppCompatActivity() {
    private lateinit var binding:ActivityWritePostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWritePostBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}