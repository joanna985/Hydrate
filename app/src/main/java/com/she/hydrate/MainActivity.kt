package com.she.hydrate

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Create spinner variables
        val activitySpinner = findViewById<Spinner>(R.id.activitySpinner)
        val genderSpinner = findViewById<Spinner>(R.id.genderSpinner)

        //Create ArrayAdapter for activitySpinner
        val activityOptions = arrayOf("Sedentary", "Lightly Active", "Moderately Active",
            "Very Active", "Extra Active")
        val activityAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,
            activityOptions)
        activityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        activitySpinner.adapter = activityAdapter

        //Create ArrayAdapter for genderSpinner
        val genderOptions = arrayOf("Male", "Female")
        val genderAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,
            genderOptions)
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.adapter = genderAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.calculateButton)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}