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
        output.text = (view as Button).text
    }

    fun typeOperator(view: View) {
        output.text = (view as Button).text
    }

    fun clear(view: View) {
        output.text = "0"
    }

    fun calculate(view: View) {
        output.text = "result"
    }
}