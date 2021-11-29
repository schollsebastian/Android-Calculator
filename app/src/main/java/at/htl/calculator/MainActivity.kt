package at.htl.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun typeNumber(view: View) {
        val button = view as Button
        val splitCalculation = output.text.split(" ")

        if (button.text != "." || !splitCalculation.last().contains('.')) {
            if (output.text == "0") {
                output.text = button.text
            } else {
                output.text = "${output.text}${button.text}"
            }
        }
    }

    fun typeOperator(view: View) {
        val button = view as Button

        if (output.text.last().isDigit()) {
            output.text = "${output.text} ${button.text} "
        } else if (button.text == "-") {
            output.text = "${output.text}${button.text}"
        }
    }

    fun clear(view: View) {
        output.text = "0"
    }

    fun calculate(view: View) {
        val splitCalculation = output.text.trimEnd().split(" ")
        var result = splitCalculation[0].toDouble()

        var i = 2
        while (i < splitCalculation.size) {
            when (splitCalculation[i - 1]) {
                "/" -> result /= splitCalculation[i].toDouble()
                "*" -> result *= splitCalculation[i].toDouble()
                "-" -> result -= splitCalculation[i].toDouble()
                "+" -> result += splitCalculation[i].toDouble()
            }

            i += 2
        }

        output.text = result.toString()
    }

    fun delete(view: View) {
        if (output.text.length == 1) {
            output.text = "0"
        } else if (output.text.last() == ' ') {
            output.text = output.text.substring(0, output.text.length - 3)
        } else {
            output.text = output.text.substring(0, output.text.length - 1)
        }
    }
}