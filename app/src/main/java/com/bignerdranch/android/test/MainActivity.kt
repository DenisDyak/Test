package com.bignerdranch.android.test

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var result1: TextView
    private lateinit var vvod: TextInputEditText
    private lateinit var vvodButton: Button
    private lateinit var priceList: TextView
    private lateinit var discount: TextInputEditText
    private lateinit var offset: TextInputEditText
    private lateinit var readLength: TextInputEditText
    private lateinit var resultButton: Button
    private lateinit var result2: TextView
    private lateinit var price: MutableList<Int>
    private lateinit var price2: MutableList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result1 = findViewById(R.id.result1)
        vvod = findViewById(R.id.vvod)
        vvodButton = findViewById(R.id.vvod_button)
        priceList = findViewById(R.id.price_List)
        discount = findViewById(R.id.discount)
        offset = findViewById(R.id.offset)
        readLength = findViewById(R.id.readLength)
        resultButton = findViewById(R.id.result_button)
        result2 = findViewById(R.id.result2)


        // Задание 1
        val developer = Vacancy("Developer")
        val tester = Employee(7, developer)
        result1.text = tester.getid().toString()
        result1.append("\n" + tester.getVacancy())
        // Задание 1\\

        // Задание 2
        price = mutableListOf()
        price2 = mutableListOf()
        vvodButton.setOnClickListener {
            price.add(vvod.text.toString().toInt())
            priceList.text = getString(R.string.massiv_cen, price)
            vvod.setText("")
        }

        resultButton.setOnClickListener {
            try {
                decryptData(price, discount.text.toString().toInt(),
                                    offset.text.toString().toInt(),
                                    readLength.text.toString().toInt()).toString()
                result2.text = getString(R.string.itogo, price2)

            } catch (e: Exception) {
                Toast.makeText(applicationContext, "Введите верные данные", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun decryptData(price: MutableList<Int>, discount: Int, offset: Int, readLength: Int): MutableList<Int> {

        val price1 = price.subList(offset, readLength + offset)
        var x: Int
        price1.forEach {
            x = (it.toDouble() * (1 - (discount.toDouble() / 100))).toInt()
            price2.add(x)
        }
        return price2
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putIntArray("price", price.toIntArray())
        outState.putIntArray("price2", price2.toIntArray())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        price = savedInstanceState.getIntArray("price")!!.toMutableList()
        if (price.isNotEmpty())
        priceList.text = getString(R.string.massiv_cen, price)
        price2 = savedInstanceState.getIntArray("price2")!!.toMutableList()
        if (price2.isNotEmpty())
        result2.text = getString(R.string.itogo, price2)

    }
}