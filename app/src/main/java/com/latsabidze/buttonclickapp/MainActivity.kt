package com.latsabidze.buttonclickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TEXT_CONTENTS = "Text Content"

class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null
    private var numTimesClicked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()

        button.setOnClickListener {
            numTimesClicked += 1
            textView?.append("\n ${userInput.text}")
            textView?.append("\nღილაკზე შეხება მოხდა $numTimesClicked _ჯერ")
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState?.getString(TEXT_CONTENTS, "")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putString(TEXT_CONTENTS, textView?.text.toString())
    }
}
