package com.tutorial.holacolormyviews

import android.R.attr.y
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.alpha
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val redButton = findViewById<TextView>(R.id.red_button)
        val greenButton = findViewById<TextView>(R.id.green_button)
        val yellowButton = findViewById<TextView>(R.id.yellow_button)

        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, rootConstraintLayout,
                redButton, greenButton, yellowButton)
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        val rnd = Random()
        val color =
            Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        val inverseColor = getContrastColor(color)

        when (view.id) {
            // Boxes using Color class colors for the background

            R.id.box_one_text -> {
                view.setBackgroundColor(color)
                val textView = view as TextView
                textView.setTextColor(inverseColor)
//                view.setBackgroundResource(R.drawable.dice_1)
            }
            R.id.box_two_text -> {
                view.setBackgroundColor(color)
                val textView = view as TextView
                textView.setTextColor(inverseColor)
                view.setBackgroundResource(R.drawable.dice_2)
            }
            R.id.box_three_text -> {
                view.setBackgroundColor(color)
                val textView = view as TextView
                textView.setTextColor(inverseColor)
//                view.setBackgroundResource(R.drawable.dice_3)
            }
            R.id.box_four_text -> {
                view.setBackgroundColor(color)
                val textView = view as TextView
                textView.setTextColor(inverseColor)
//                view.setBackgroundResource(R.drawable.dice_4)
            }
            R.id.box_five_text -> {
                view.setBackgroundColor(color)
                val textView = view as TextView
                textView.setTextColor(inverseColor)
//                view.setBackgroundResource(R.drawable.dice_5)
            }
            // Boxes using custom colors for background
            R.id.red_button -> box_three_text.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> box_four_text.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> box_five_text.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(color)
//            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
//            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
//            R.id.box_three_text -> view.setBackgroundColor(Color.BLUE)
//            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
//            R.id.box_five_text -> view.setBackgroundColor(Color.BLUE)
//            else -> view.setBackgroundColor(Color.LTGRAY)
        }

    }

    private fun getContrastColor(color: Int): Int {
//        val yiq = (299 * color.getRed() + 587 * color.getGreen() + 114 * color.getBlue()) / 1000;
        val yiq = (299 * Color.red(color) + 587 * Color.green(color) + 114 * Color.blue(color)) / 1000;
        return if (yiq >= 128) Color.BLACK else Color.WHITE
    }
}
