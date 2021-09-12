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

    fun setValueOnIndex00(value: Char) {
        savedInputs[0][0] = value
        _savedInputsLive.value = savedInputs
    }

    fun setValueOnIndex01(value: Char) {
        savedInputs[0][1] = value
        _savedInputsLive.value = savedInputs
    }

    fun setValueOnIndex02(value: Char) {
        savedInputs[0][2] = value
        _savedInputsLive.value = savedInputs
    }

    fun setValueOnIndex10(value: Char) {
        savedInputs[1][0] = value
        _savedInputsLive.value = savedInputs
    }

    fun setValueOnIndex11(value: Char) {
        savedInputs[1][1] = value
        _savedInputsLive.value = savedInputs
    }

    fun setValueOnIndex12(value: Char) {
        savedInputs[1][2] = value
        _savedInputsLive.value = savedInputs
    }

    fun setValueOnIndex20(value: Char) {
        savedInputs[2][0] = value
        _savedInputsLive.value = savedInputs
    }

    fun setValueOnIndex21(value: Char) {
        savedInputs[2][1] = value
        _savedInputsLive.value = savedInputs
    }

    fun setValueOnIndex22(value: Char) {
        savedInputs[2][2] = value
        _savedInputsLive.value = savedInputs
    }

    init {
        _isGameStarted.value = true
    }
}