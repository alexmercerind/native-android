package com.alexmercerind.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import kotlin.math.round


class MainActivity : AppCompatActivity() {
    private var tipPercent: Double = 0.2
    private var roundTheTip: Boolean = true
    private lateinit var costOfServiceEditText: EditText
    private lateinit var serviceQualityRadioGroup: RadioGroup
    private lateinit var calculateButton: Button
    private lateinit var roundTheTipSwitch: Switch
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        costOfServiceEditText = findViewById(R.id.costOfServiceEditText)
        serviceQualityRadioGroup = findViewById(R.id.serviceQualityRadioGroup)
        roundTheTipSwitch = findViewById(R.id.RoundTheTip)
        calculateButton = findViewById(R.id.Calculate)
        resultTextView = findViewById(R.id.Result)
        serviceQualityRadioGroup.check(R.id.Amazing)
        serviceQualityRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId) {
                R.id.Amazing -> {
                    tipPercent = 0.20
                }
                R.id.Good -> {
                    tipPercent = 0.18
                }
                R.id.OK -> {
                    tipPercent = 0.15
                }
            }
        }
        roundTheTipSwitch.setOnClickListener {
            roundTheTip =  roundTheTipSwitch.isChecked
        }
        calculateButton.setOnClickListener {
            if (roundTheTip) {
                resultTextView.text = (costOfServiceEditText.text.toString().toDouble() * tipPercent).toInt().toString()
            }
            else {
                resultTextView.text = (round(costOfServiceEditText.text.toString().toDouble() * tipPercent * 100.0) / 100.0).toString()
            }
        }
    }
}
