package com.tutorial.holaaboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.tutorial.holaaboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("GooberBoy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        //findViewById<Button>(R.id.btn_done).setOnClickListener
        binding.buttonDone.setOnClickListener {
            addNickname()
        }

        //findViewById<TextView>(R.id.tv_nickname).setOnClickListener
        binding.tvNickname.setOnClickListener {
            updateNickname()
        }
    }

    private fun addNickname() {
        // View -> binding.buttonDone
//        val editText = findViewById<EditText>(R.id.et_nickname)
//        val nicknameTextView = findViewById<TextView>(R.id.tv_nickname)

//        binding.tvNickname.text = binding.etNickname.text
//        binding.buttonDone.visibility = View.GONE
//        binding.etNickname.visibility = View.GONE
//        binding.tvNickname.visibility = View.VISIBLE
        binding.apply {
            //tvNickname.text = etNickname.text
            myName?.nickname = etNickname.text.toString()
            invalidateAll()
            buttonDone.visibility = View.GONE
            etNickname.visibility = View.GONE
            tvNickname.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.buttonDone.windowToken, 0)
    }

    private fun updateNickname () {
        // View -> binding.tvNickname
//        val editText = findViewById<EditText>(R.id.et_nickname)
//        val doneButton = findViewById<Button>(R.id.button_done)

        binding.etNickname.visibility = View.VISIBLE
        binding.buttonDone.visibility = View.VISIBLE
        binding.tvNickname.visibility = View.GONE

        // Set the focus to the edit text.
        binding.etNickname.requestFocus()
        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.etNickname, 0)
    }
}
