/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.GameFragmentBinding

/**
 * Fragment where the game is played
 */
class GameFragment : Fragment() {

//    // The current word
//    private var word = ""
//
//    // The current score
//    private var score = 0
//
//    // The list of words - the front of the list is the next word to guess
//    private lateinit var wordList: MutableList<String>

    private lateinit var binding: GameFragmentBinding

    private lateinit var viewModel: GameViewModel

    ///////////////////////////////////////////////////////////////////////////
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.game_fragment,
                container,
                false
        )

        Log.i("GameFragment", "GameViewModel ViewModelProviders.of invoked...")
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        // Set the viewmodel for databinding - this allows the bound layout access
        // to all the data in the ViewModel
        binding.gameViewModel = viewModel

        // Specify the current activity as the lifecycle owner of the binding.
        // This is used so that the binding can observe LiveData updates
        binding.lifecycleOwner = this

//        /** Setting up LiveData observation relationship **/
//        viewModel.score.observe(this, Observer { newScore ->
//            binding.scoreText.text = newScore.toString()
//        })
//        /** Setting up LiveData observation relationship **/
//        viewModel.word.observe(this, Observer { newWord ->
//            binding.wordText.text = newWord
//        })

        // Observer for the Game finished event
        viewModel.eventGameFinish.observe(this, Observer<Boolean> { hasFinished ->
            if (hasFinished) gameFinished()
        })
//        resetList()
//        nextWord()
//
//        binding.correctButton.setOnClickListener { onCorrect() }
//        binding.skipButton.setOnClickListener { onSkip() }
//        binding.endGameButton.setOnClickListener { onEndGame() }

//        updateScoreText()
//        updateWordText()
        return binding.root

    }

//    /**
//     * Resets the list of words and randomizes the order
//     */
//    private fun resetList() {
//        wordList = mutableListOf(
//                "queen",
//                "hospital",
//                "basketball",
//                "cat",
//                "change",
//                "snail",
//                "soup",
//                "calendar",
//                "sad",
//                "desk",
//                "guitar",
//                "home",
//                "railway",
//                "zebra",
//                "jelly",
//                "car",
//                "crow",
//                "trade",
//                "bag",
//                "roll",
//                "bubble"
//        )
//        wordList.shuffle()
//    }

    /** Methods for buttons presses **/

//    private fun onSkip() {
////        if (!wordList.isEmpty()) {
////            score--
////        }
////        nextWord()
//        viewModel.onSkip()
////        updateWordText()
////        updateScoreText()
//    }
//
//    private fun onCorrect() {
////        if (!wordList.isEmpty()) {
////            score++
////        }
////        nextWord()
//        viewModel.onCorrect()
////        updateWordText()
////        updateScoreText()
//    }
//
//    private fun onEndGame() {
//        gameFinished()
//    }

    /**
     * Called when the game is finished
     */
    private fun gameFinished() {
        Toast.makeText(activity, "Game over...", Toast.LENGTH_SHORT).show()
        val action = GameFragmentDirections.actionGameToScore()
        //val score = viewModel.score.value?:0
        action.score = viewModel.score.value?:0
        NavHostFragment.findNavController(this).navigate(action)

        viewModel.onGameFinishComplete()
    }
//    /**
//     * Moves to the next word in the list
//     */
//    private fun nextWord() {
//        if (!wordList.isEmpty()) {
//            //Select and remove a word from the list
//            word = wordList.removeAt(0)
//        }
//        updateWordText()
//        updateScoreText()
//    }


//    /** Methods for updating the UI **/
//
//    private fun updateWordText() {
//        //binding.wordText.text = viewModel.word
//        binding.wordText.text = viewModel.word.value
//    }
//
//    private fun updateScoreText() {
//        //binding.scoreText.text = viewModel.score.toString()
//        binding.scoreText.text = viewModel.score.value.toString()
//    }
}
