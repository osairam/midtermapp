package com.example.midtermapp1


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class CalculatorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)

        val firstNumberEditText = view.findViewById<EditText>(R.id.firstNumberEditText)
        val secondNumberEditText = view.findViewById<EditText>(R.id.secondNumberEditText)
        val resultTextView = view.findViewById<TextView>(R.id.resultTextView)

        val addButton = view.findViewById<Button>(R.id.addButton)
        val subtractButton = view.findViewById<Button>(R.id.subtractButton)
        val multiplyButton = view.findViewById<Button>(R.id.multiplyButton)
        val divideButton = view.findViewById<Button>(R.id.divideButton)

        val onClickListener = View.OnClickListener {
            val firstNumber = firstNumberEditText.text.toString().toDoubleOrNull()
            val secondNumber = secondNumberEditText.text.toString().toDoubleOrNull()

            if (firstNumber == null || secondNumber == null) {
                resultTextView.text = "Invalid input"
                return@OnClickListener
            }

            val result = when (it.id) {
                R.id.addButton -> firstNumber + secondNumber
                R.id.subtractButton -> firstNumber - secondNumber
                R.id.multiplyButton -> firstNumber * secondNumber
                R.id.divideButton -> {
                    if (secondNumber != 0.0) {
                        firstNumber / secondNumber
                    } else {
                        "Cannot divide by zero"
                    }
                }
                else -> "Unknown operation"
            }

            resultTextView.text = result.toString()
        }

        addButton.setOnClickListener(onClickListener)
        subtractButton.setOnClickListener(onClickListener)
        multiplyButton.setOnClickListener(onClickListener)
        divideButton.setOnClickListener(onClickListener)

        return view
    }
}
