package com.market.dynamicui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.market.dynamicui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        val navController = navHostFragment.navController

        binding.button1.setOnClickListener {
            navController.navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.button2.setOnClickListener {
            navController.navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

    }

}