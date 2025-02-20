package com.example.basic_calculator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var editTextAngka1: EditText
    private lateinit var editTextAngka2: EditText
    private lateinit var editTextOperator: EditText
    private lateinit var textViewHasil: TextView
    private lateinit var hasilButton: Button


    private fun initComponents() {
        editTextAngka1 = findViewById(R.id.editTextAngka1)
        editTextAngka2 = findViewById(R.id.editTextAngka2)
        editTextOperator = findViewById(R.id.editTextOperator)
        textViewHasil = findViewById(R.id.textViewHasil)
        hasilButton = findViewById(R.id.buttonHasil)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.calculator)
        initComponents()

        hasilButton.setOnClickListener {

            var value1 = editTextAngka1.text.toString()
            var finalValue1 = value1.toIntOrNull() ?: 0

            var value2 = editTextAngka2.text.toString()
            var finalValue2 = value2.toIntOrNull() ?: 0

            var operatorValue = editTextOperator.text.toString().trim()
            var hasilOperasi: Double = 0.0

            if (operatorValue.isEmpty()) {
                Log.e("main activity", "Input Operasi Null",)
                textViewHasil.text = "Perhatikan Kembali Input Operator"
                return@setOnClickListener
            }

            when (operatorValue[0]) {
                '+' -> hasilOperasi = (finalValue1 + finalValue2).toDouble()
                '-' -> hasilOperasi = (finalValue1 - finalValue2).toDouble()
                '*' -> hasilOperasi = (finalValue1 * finalValue2).toDouble()
                '/' -> {
                    if (finalValue2 == 0) {
                        Log.e("MainActivity", "Input bilangan 2 dibagi 0")
                        textViewHasil.text = "Tak Hingga"
                        return@setOnClickListener
                    } else {
                        hasilOperasi = (finalValue1 / finalValue2).toDouble()
                    }
                }

                '%' -> hasilOperasi = (finalValue1 % finalValue2).toDouble()
                else -> {
                    textViewHasil.text = "Perhatikan Input Yang Kamu Masukkan!!"
                    return@setOnClickListener
                }
            }
            textViewHasil.text = hasilOperasi.toString()
        }
    }
}

