package com.softwareit.weather_custom_view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.softwareit.weather_custom_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}