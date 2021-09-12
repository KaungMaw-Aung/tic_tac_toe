package com.kaungmaw.tictactoe.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val _savedInputsLive = MutableLiveData<Array<CharArray>>()
    val savedInputsLive: LiveData<Array<CharArray>>
        get() = _savedInputsLive

    val savedInputs = arrayOf(
        charArrayOf(' ', ' ', ' '),
        charArrayOf(' ', ' ', ' '),
        charArrayOf(' ', ' ', ' ')
    )

    var isPlayer1Turn: Boolean = false
    var isPlayer2Turn: Boolean = false

    fun toggleTurns() {
        isPlayer1Turn = !isPlayer1Turn
        isPlayer2Turn = !isPlayer2Turn
    }

    private val _isGameStarted = MutableLiveData<Boolean>()
    val isGameStarted: LiveData<Boolean>
        get() = _isGameStarted

    val playerTurnLive = MutableLiveData<String>()

    // check if the player won the game
    fun doesPlayerWinTheGame(doCheckForUser: Boolean): Boolean {
        var result = false
        val mark = if (doCheckForUser) 'X' else 'O'

        if (savedInputs[0][0] == mark) {
            if (
                savedInputs[0][1] == mark && savedInputs[0][2] == mark ||
                savedInputs[1][0] == mark && savedInputs[2][0] == mark ||
                savedInputs[1][1] == mark && savedInputs[2][2] == mark
            ) {
                result = true
            }
        }

        if (savedInputs[0][1] == mark) {
            if (
                savedInputs[0][0] == mark && savedInputs[0][2] == mark ||
                savedInputs[1][1] == mark && savedInputs[2][1] == mark
            ) {
                result = true
            }
        }

        if (savedInputs[0][2] == mark) {
            if (
                savedInputs[0][0] == mark && savedInputs[0][1] == mark ||
                savedInputs[1][2] == mark && savedInputs[2][2] == mark ||
                savedInputs[1][1] == mark && savedInputs[2][0] == mark
            ) {
                result = true
            }
        }

        if (savedInputs[1][0] == mark) {
            if (
                savedInputs[0][0] == mark && savedInputs[2][0] == mark ||
                savedInputs[1][1] == mark && savedInputs[1][2] == mark
            ) {
                result = true
            }
        }

        if (savedInputs[1][1] == mark) {
            if (
                savedInputs[0][1] == mark && savedInputs[2][1] == mark ||
                savedInputs[1][0] == mark && savedInputs[1][2] == mark ||
                savedInputs[0][0] == mark && savedInputs[2][2] == mark ||
                savedInputs[0][2] == mark && savedInputs[2][0] == mark
            ) {
                result = true
            }
        }

        if (savedInputs[1][2] == mark) {
            if (
                savedInputs[0][2] == mark && savedInputs[2][2] == mark ||
                savedInputs[1][0] == mark && savedInputs[1][1] == mark
            ) {
                result = true
            }
        }

        if (savedInputs[2][0] == mark) {
            if (
                savedInputs[0][0] == mark && savedInputs[1][0] == mark ||
                savedInputs[2][2] == mark && savedInputs[2][1] == mark ||
                savedInputs[1][1] == mark && savedInputs[0][2] == mark
            ) {
                result = true
            }
        }

        if (savedInputs[2][1] == mark) {
            if (
                savedInputs[0][1] == mark && savedInputs[1][1] == mark ||
                savedInputs[2][0] == mark && savedInputs[2][2] == mark
            ) {
                result = true
            }
        }

        if (savedInputs[2][2] == mark) {
            if (
                savedInputs[2][0] == mark && savedInputs[2][1] == mark ||
                savedInputs[0][0] == mark && savedInputs[1][1] == mark ||
                savedInputs[0][2] == mark && savedInputs[1][2] == mark
            ) {
                result = true
            }
        }

        return result
    }

    private val _clickedCountLive = MutableLiveData(0)
    val clickedCountLive: LiveData<Int>
        get() = _clickedCountLive

    fun setValueOnIndex(index: Pair<Int, Int>, value: Char) {
        savedInputs[index.first][index.second] = value
        _savedInputsLive.value = savedInputs
        _clickedCountLive.value = _clickedCountLive.value?.plus(1)
    }

    init {
        _isGameStarted.value = true
        playerTurnLive.value = "Player One"
    }
}