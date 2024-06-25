package com.she.hydrate

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Create spinner variables
        val activitySpinner = findViewById<Spinner>(R.id.activitySpinner)
        val genderSpinner = findViewById<Spinner>(R.id.genderSpinner)

        //Create an activity spinner object and a gender spinner object.
        val activitySpinnerObject = Spinners()
        activitySpinnerObject.setupActivitySpinner(activitySpinner)
        val genderSpinnerObject = Spinners()
        genderSpinnerObject.setupGenderSpinner(genderSpinner)

        // Retrieve the result label reference and reset it to the new amount.
        val resultLabel = findViewById<TextView>(R.id.resultLabel)
        val calculateButton = findViewById<Button>(R.id.calculateButton)

        // When the button is pressed, perform the calculation and reset the result label.
        calculateButton.setOnClickListener {
            //Retrieve the selected gender and activity from the spinners.
            var selectedActivity = activitySpinnerObject.getSelectedActivity(activitySpinner)
            var selectedGender = genderSpinnerObject.getSelectedGender(genderSpinner)

            // Check if the user is pregnant.
            var pregnant = findViewById<CheckBox>(R.id.pregnantCheckBox).isChecked

            // Get the age from the EditText.
            val ageEditText = findViewById<EditText>(R.id.ageEntryText)
            var age = ageEditText.text.toString().toIntOrNull()
            if (age == null) {
                age = 0
            }

            // Retrieve the height and convert feet to inches.
            val ftEditText = findViewById<EditText>(R.id.ftEntryText)
            var feet = ftEditText.text.toString().toIntOrNull()
            if (feet == null) {
                feet = 0
            }

            val inEditText = findViewById<EditText>(R.id.inEntryText)
            var inches = inEditText.text.toString().toIntOrNull()
            if (inches == null) {
                inches = 0
            }

            var height = (feet * 12) + inches

            // Retrieve weight
            val weightEntryText = findViewById<EditText>(R.id.weightEntryText)
            var weight = weightEntryText.text.toString().toIntOrNull()
            if (weight == null) {
                weight = 0
            }

            // Perform the calculation and reset the result label.
            waterCalculate(age, selectedGender, height, weight, selectedActivity, pregnant)
            resultLabel.text = waterOunces.toString()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.calculateButton)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}