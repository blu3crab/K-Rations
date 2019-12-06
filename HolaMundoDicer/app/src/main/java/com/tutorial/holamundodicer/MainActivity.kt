package com.tutorial.holamundodicer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tossButton: Button = findViewById(R.id.btn_toss_dice)
        tossButton.setOnClickListener { tossDice() }
    }

    private fun tossDice() {
        val tossValueText: TextView = findViewById(R.id.tv_toss_value)
        val randomInt = Random().nextInt(6) + 1
        tossValueText.text = randomInt.toString()

        Toast.makeText(this, "Dice toss hits " + tossValueText.text, Toast.LENGTH_SHORT).show()

    }
}
