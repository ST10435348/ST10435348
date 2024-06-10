package com.example.weatherapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

                    // Find views by ID
                    val edtMonday = findViewById<EditText>(R.id.edtMonday)
                    val edtTuesday = findViewById<EditText>(R.id.edtTuesday)
                    val edtWednesday = findViewById<EditText>(R.id.edtWednesday)
                    val edtThursday = findViewById<EditText>(R.id.edtThursday)
                    val edtFriday = findViewById<EditText>(R.id.edtFriday)
                    val edtSaturday = findViewById<EditText>(R.id.edtSaturday)
                    val edtSunday = findViewById<EditText>(R.id.edtSunday)

                    val btnExit2 = findViewById<Button>(R.id.btnExit2)
                    val btnNext2 = findViewById<Button>(R.id.btnNext2)
                    val btnCalc = findViewById<Button>(R.id.btnCalc)

                    btnExit2.setOnClickListener {
                        finish()
                    }

                    btnNext2.setOnClickListener {
                        val temperatures = arrayOf(
                            edtMonday.text.toString(),
                            edtTuesday.text.toString(),
                            edtWednesday.text.toString(),
                            edtThursday.text.toString(),
                            edtFriday.text.toString(),
                            edtSaturday.text.toString(),
                            edtSunday.text.toString()
                        )

                        val intent = Intent(this, SplashScreen::class.java).apply {
                            putExtra("TEMPERATURES", temperatures)
                        }
                        startActivity(intent)
                    }

                    btnCalc.setOnClickListener {
                        try {
                            val temps = arrayOf(
                                edtMonday.text.toString().toDouble(),
                                edtTuesday.text.toString().toDouble(),
                                edtWednesday.text.toString().toDouble(),
                                edtThursday.text.toString().toDouble(),
                                edtFriday.text.toString().toDouble(),
                                edtSaturday.text.toString().toDouble(),
                                edtSunday.text.toString().toDouble()
                            )

                            val average = temps.average()
                            Toast.makeText(this, "Average Temperature: $average", Toast.LENGTH_LONG).show()
                        } catch (e: NumberFormatException) {
                            Toast.makeText(this, "Please enter valid numbers for all days", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }