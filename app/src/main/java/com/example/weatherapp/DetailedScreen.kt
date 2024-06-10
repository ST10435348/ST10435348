package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_screen)

                val txtTemperatures = findViewById<TextView>(R.id.txtTemperatures)
                val txtHighLow = findViewById<TextView>(R.id.txtHighLow)
                val btnExit3 = findViewById<Button>(R.id.btnExit3)

                btnExit3.setOnClickListener {
                    finish()
                }

                val temperatures = intent.getStringArrayExtra("TEMPERATURES")?.map { it.toDoubleOrNull() ?: 0.0 } ?: emptyList()

                if (temperatures.isNotEmpty()) {
                    val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
                    val tempString = temperatures.mapIndexed { index, temp -> "${days[index]}: $temp" }.joinToString("\n")

                    val highest = temperatures.maxOrNull()
                    val lowest = temperatures.minOrNull()

                    txtTemperatures.text = "Temperatures:\n$tempString"
                    txtHighLow.text = "Highest: $highest\nLowest: $lowest"
                }
            }
        }