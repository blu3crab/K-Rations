package com.tutorial.holamundodicer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*
///////////////////////////////////////////////////////////////////////////////
class MainActivity : AppCompatActivity() {

    lateinit var ivDice1Image : ImageView
    lateinit var ivDice2Image : ImageView

    lateinit var tvToss1Value: TextView
    lateinit var tvToss2Value: TextView

    ///////////////////////////////////////////////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toss1Button: Button = findViewById(R.id.btn_dice1)
        toss1Button.setOnClickListener { tossDice1() }
        val toss2Button: Button = findViewById(R.id.btn_dice2)
        toss2Button.setOnClickListener { tossDice2() }

        ivDice1Image = findViewById(R.id.dice1_image)
        ivDice2Image = findViewById(R.id.dice2_image)

        tvToss1Value = findViewById(R.id.tv_toss1_value)
        tvToss2Value = findViewById(R.id.tv_toss2_value)
    }

    private fun tossDice1() {
        //val tvToss1Value: TextView = findViewById(R.id.tv_toss1_value)
        val randomInt = Random().nextInt(6) + 1
        tvToss1Value.text = randomInt.toString()

        Toast.makeText(this, "Dice #1 toss hits " + tvToss1Value.text, Toast.LENGTH_SHORT).show()

        val drawableResource = mapIntToDiceImage(randomInt)
        //val dice1Image: ImageView = findViewById(R.id.dice1_image)
        ivDice1Image.setImageResource(drawableResource)
    }
    private fun tossDice2() {
        //val tvToss2Value: TextView = findViewById(R.id.tv_toss2_value)
        val randomInt = Random().nextInt(6) + 1
        tvToss2Value.text = randomInt.toString()

        Toast.makeText(this, "Dice #2 toss hits " + tvToss2Value.text, Toast.LENGTH_SHORT).show()

        val drawableResource = mapIntToDiceImage(randomInt)
        //val ivDice2Image: ImageView = findViewById(R.id.dice2_image)
        ivDice2Image.setImageResource(drawableResource)
    }
    ///////////////////////////////////////////////////////////////////////////////
    private fun mapIntToDiceImage(diceInt: Int): Int {
        val drawableResource = when (diceInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        return drawableResource
    }
///////////////////////////////////////////////////////////////////////////////
}
