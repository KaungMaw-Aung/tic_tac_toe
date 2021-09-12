package com.kaungmaw.tictactoe.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kaungmaw.tictactoe.R
import com.kaungmaw.tictactoe.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private val viewModel by viewModels<GameViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentGameBinding.inflate(inflater, container, false)
            .also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isGameStarted.observe(viewLifecycleOwner) {
            if (it) {
                viewModel.isPlayer1Turn = true
            }
        }

        viewModel.savedInputsLive.observe(viewLifecycleOwner) {
            Log.i("GameFragment", it.contentDeepToString())
            binding.ivSquare00.setImageResource(
                when (it[0][0]) {
                    'X' -> R.drawable.ic_cross
                    'O' -> R.drawable.ic_circle
                    else -> R.color.transparent
                }
            )
            binding.ivSquare01.setImageResource(
                when (it[0][1]) {
                    'X' -> R.drawable.ic_cross
                    'O' -> R.drawable.ic_circle
                    else -> R.color.transparent
                }
            )
            binding.ivSquare02.setImageResource(
                when (it[0][2]) {
                    'X' -> R.drawable.ic_cross
                    'O' -> R.drawable.ic_circle
                    else -> R.color.transparent
                }
            )
            binding.ivSquare10.setImageResource(
                when (it[1][0]) {
                    'X' -> R.drawable.ic_cross
                    'O' -> R.drawable.ic_circle
                    else -> R.color.transparent
                }
            )
            binding.ivSquare11.setImageResource(
                when (it[1][1]) {
                    'X' -> R.drawable.ic_cross
                    'O' -> R.drawable.ic_circle
                    else -> R.color.transparent
                }
            )
            binding.ivSquare12.setImageResource(
                when (it[1][2]) {
                    'X' -> R.drawable.ic_cross
                    'O' -> R.drawable.ic_circle
                    else -> R.color.transparent
                }
            )
            binding.ivSquare20.setImageResource(
                when (it[2][0]) {
                    'X' -> R.drawable.ic_cross
                    'O' -> R.drawable.ic_circle
                    else -> R.color.transparent
                }
            )
            binding.ivSquare21.setImageResource(
                when (it[2][1]) {
                    'X' -> R.drawable.ic_cross
                    'O' -> R.drawable.ic_circle
                    else -> R.color.transparent
                }
            )
            binding.ivSquare22.setImageResource(
                when (it[2][2]) {
                    'X' -> R.drawable.ic_cross
                    'O' -> R.drawable.ic_circle
                    else -> R.color.transparent
                }
            )
        }

        // getting click events from nine squares
        binding.square00.setOnClickListener {
            if (viewModel.savedInputs[0][0] == ' ') {
                viewModel.setValueOnIndex(0 to 0, if (viewModel.isPlayer1Turn) 'X' else 'O')

                if (viewModel.doesPlayerWinTheGame(viewModel.isPlayer1Turn)) {
                    navigateToGameResult()
                } else {
                    toggleTurn()
                }
            }
        }

        binding.square01.setOnClickListener {
            if (viewModel.savedInputs[0][1] == ' ') {
                viewModel.setValueOnIndex(0 to 1, if (viewModel.isPlayer1Turn) 'X' else 'O')

                if (viewModel.doesPlayerWinTheGame(viewModel.isPlayer1Turn)) {
                    navigateToGameResult()
                } else {
                    toggleTurn()
                }
            }
        }

        binding.square02.setOnClickListener {
            if (viewModel.savedInputs[0][2] == ' ') {
                viewModel.setValueOnIndex(0 to 2, if (viewModel.isPlayer1Turn) 'X' else 'O')

                if (viewModel.doesPlayerWinTheGame(viewModel.isPlayer1Turn)) {
                    navigateToGameResult()
                } else {
                    toggleTurn()
                }
            }
        }

        binding.square10.setOnClickListener {
            if (viewModel.savedInputs[1][0] == ' ') {
                viewModel.setValueOnIndex(1 to 0, if (viewModel.isPlayer1Turn) 'X' else 'O')

                if (viewModel.doesPlayerWinTheGame(viewModel.isPlayer1Turn)) {
                    navigateToGameResult()
                } else {
                    toggleTurn()
                }
            }
        }

        binding.square11.setOnClickListener {
            if (viewModel.savedInputs[1][1] == ' ') {
                viewModel.setValueOnIndex(1 to 1, if (viewModel.isPlayer1Turn) 'X' else 'O')

                if (viewModel.doesPlayerWinTheGame(viewModel.isPlayer1Turn)) {
                    navigateToGameResult()
                } else {
                    toggleTurn()
                }
            }
        }

        binding.square12.setOnClickListener {
            if (viewModel.savedInputs[1][2] == ' ') {
                viewModel.setValueOnIndex(1 to 2, if (viewModel.isPlayer1Turn) 'X' else 'O')

                if (viewModel.doesPlayerWinTheGame(viewModel.isPlayer1Turn)) {
                    navigateToGameResult()
                } else {
                    toggleTurn()
                }
            }
        }

        binding.square20.setOnClickListener {
            if (viewModel.savedInputs[2][0] == ' ') {
                viewModel.setValueOnIndex(2 to 0, if (viewModel.isPlayer1Turn) 'X' else 'O')

                if (viewModel.doesPlayerWinTheGame(viewModel.isPlayer1Turn)) {
                    navigateToGameResult()
                } else {
                    toggleTurn()
                }
            }
        }

        binding.square21.setOnClickListener {
            if (viewModel.savedInputs[2][1] == ' ') {
                viewModel.setValueOnIndex(2 to 1, if (viewModel.isPlayer1Turn) 'X' else 'O')

                if (viewModel.doesPlayerWinTheGame(viewModel.isPlayer1Turn)) {
                    navigateToGameResult()
                } else {
                    toggleTurn()
                }
            }
        }

        binding.square22.setOnClickListener {
            if (viewModel.savedInputs[2][2] == ' ') {
                viewModel.setValueOnIndex(2 to 2, if (viewModel.isPlayer1Turn) 'X' else 'O')

                if (viewModel.doesPlayerWinTheGame(viewModel.isPlayer1Turn)) {
                    navigateToGameResult()
                } else {
                    toggleTurn()
                }
            }
        }

        viewModel.clickedCountLive.observe(viewLifecycleOwner) {
            if (it == 9) {
                findNavController().navigate(GameFragmentDirections.toResultFragment("Draw"))
            }
        }

        viewModel.playerTurnLive.observe(viewLifecycleOwner) {
            binding.tvPlayerTurn.text = getString(R.string.player_turn, it)
        }

    }

    private fun navigateToGameResult() {
        findNavController().navigate(
            GameFragmentDirections.toResultFragment(
                if (viewModel.isPlayer1Turn) "Player One" else "Player Two"
            )
        )
    }

    private fun toggleTurn() {
        viewModel.toggleTurns()
        viewModel.playerTurnLive.value = if (viewModel.isPlayer1Turn) "Player One" else "Player Two"
    }

}