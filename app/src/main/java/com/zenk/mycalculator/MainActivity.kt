package com.zenk.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var tvInput: TextView? = null
    var lastNumeric : Boolean = false
    var lastDecimal : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)

    }

    fun onDigit(view: View)
    {
        tvInput?.append((view as Button).text)
        lastNumeric = true
        lastDecimal = false
    }

    fun onClear(view: View)
    {
        tvInput?.text = ""
    }

    fun onDecimalPoint(view: View)
    {
        //only allow one decimal point
        if(lastNumeric && !lastDecimal)
        {
            tvInput?.append(".")
            lastNumeric = false
            lastDecimal = true
        }
    }

    fun onOperator(view: View)
    {
        //let determines if tvInput.text exists.
        tvInput?.text?.let{
            if(lastNumeric && !isOperatorAdded(it.toString()))
            {
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDecimal = false
            }
        }

    }
    private fun isOperatorAdded(value : String) : Boolean
    {
        return if(value.startsWith("-"))
        {
            false
        }
        else
        {
            value.contains("/") || value.contains("*") || value.contains("+") || value.contains("-")

        }
    }
}