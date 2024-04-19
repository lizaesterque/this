package com.example.finalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finalexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bucketBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, BucketListActivity::class.java)
            startActivity(intent)
            finish()
        }


        binding.addBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, ListItemActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}