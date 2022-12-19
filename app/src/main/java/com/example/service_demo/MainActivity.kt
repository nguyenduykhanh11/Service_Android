package com.example.service_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.service_demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpEventStartService()
        setUpEventStopService()
    }

    private fun setUpEventStopService() {
        binding.btnStopService.setOnClickListener {
            val intentService = Intent(this@MainActivity, MyService::class.java)
            stopService(intentService)
            binding.pgbActiveStatus.visibility = View.GONE
        }
    }

    private fun setUpEventStartService() {
        binding.btnStartService.setOnClickListener {
            val intentService = Intent(this@MainActivity, MyService::class.java)
            startService(intentService)
            binding.pgbActiveStatus.visibility = View.VISIBLE
        }
    }
}