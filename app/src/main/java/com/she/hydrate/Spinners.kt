package com.she.hydrate

import android.widget.ArrayAdapter
import android.widget.Spinner


//This class is for the Activity and Gender "menu" spinners and for retrieving the selections.
class Spinners {

    fun setupActivitySpinner(activitySpinner: Spinner) {
        //Create ArrayAdapter for activitySpinner
        val activityOptions = arrayOf(
            "Sedentary", "Lightly Active", "Moderately Active",
            "Very Active", "Extra Active"
        )
        val activityAdapter = ArrayAdapter(
            activitySpinner.context, android.R.layout.simple_spinner_item,
            activityOptions
        )
        activityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        activitySpinner.adapter = activityAdapter
    }

    fun setupGenderSpinner(genderSpinner: Spinner) {
        //Create ArrayAdapter for genderSpinner
        val genderOptions = arrayOf("Male", "Female")
        val genderAdapter = ArrayAdapter(
            genderSpinner.context, android.R.layout.simple_spinner_item,
            genderOptions
        )
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.adapter = genderAdapter
    }

    fun getSelectedActivity(activitySpinner: Spinner): String {
        return activitySpinner.selectedItem.toString()
    }

    fun getSelectedGender(genderSpinner: Spinner): String {
        return genderSpinner.selectedItem.toString()
    }

}
