package com.she.hydrate

// In this file, the daily water consumption is calculated.
var waterOunces: Double = 0.0

// A method to calculate waterOunces based on the user's
// weight, activity, gender, pregnant, age, and height.
fun waterCalculate(age: Int, gender: String, height: Int, weight: Int,
                   activity: String, pregnant: Boolean) {

    waterOunces = weight * (2.0/3.0)

    if (activity == "Lightly Active") {
        waterOunces += 12
    } else if (activity == "Moderately Active") {
        waterOunces += 24
    } else if (activity == "Very Active") {
        waterOunces += 36
    } else if (activity == "Extra Active") {
        waterOunces += 48
    }

    if (gender == "Male") {
        waterOunces += 16
    } else if (gender == "Female") {
        waterOunces += 12
    }

    if (pregnant) {
        waterOunces += 24
    }

    if ((age >= 1) && (age <= 8)) {
        waterOunces += 8
    } else if ((age >= 9) && (age <= 18)) {
        waterOunces += 19
    } else if (age >= 56) {
        waterOunces += 8
    }

    if (height >= 60) {
        waterOunces += height - 60
    }

    waterOunces = "%.2f".format(waterOunces).toDouble()
}