package com.bignerdranch.android.test

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast

// Задание 3

lateinit var prefer: SharedPreferences
private val COLD_START = "ColdStart"
private var numStart = 0

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        prefer = getSharedPreferences("coldstart", Context.MODE_PRIVATE)

        if (prefer.contains(COLD_START)){
            numStart = prefer.getInt(COLD_START, 0)
        }
        numStart += 1
        prefer.edit().putInt(COLD_START, numStart).apply()

        if (numStart == 3){
            Toast.makeText(applicationContext, "Третий запуск приложения", Toast.LENGTH_LONG).show()
        }
    }

}