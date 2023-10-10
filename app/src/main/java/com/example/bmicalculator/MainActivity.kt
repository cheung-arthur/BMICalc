package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var btn: Button
    private lateinit var txtView: TextView
    private lateinit var heightFeet: EditText
    private lateinit var heightInches: EditText
    private lateinit var weight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.computeButton)
        txtView = findViewById(R.id.output)
        heightFeet = findViewById(R.id.heightInputFeet)
        heightInches = findViewById(R.id.heightInputInches)
        weight = findViewById(R.id.weightInput)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        btn.setOnClickListener { compute() }
    }

    private fun compute() {
        val feetValue = heightFeet.text.toString().toDoubleOrNull() ?: 0.0
        val inchesValue = heightInches.text.toString().toDoubleOrNull() ?: 0.0
        val weightValue = weight.text.toString().toDoubleOrNull() ?: 0.0
        val heightInInches = (feetValue * 12) + inchesValue
        val BMIasValue = 703*(weightValue/(heightInInches*heightInInches))
        val roundedBMI = String.format("%.1f", BMIasValue)

        txtView.text = "Your BMI: $roundedBMI"
    }
}
