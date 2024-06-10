package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnExit = findViewById<Button>(R.id.btnExit2)
        val btnNext = findViewById<Button>(R.id.btnNext2)

        btnExit.setOnClickListener {
            finish() // Exit the app
        }

        btnNext.setOnClickListener {
            val intent = Intent(this, Intent::class.java)
            startActivity(intent)
        }
    }
}

