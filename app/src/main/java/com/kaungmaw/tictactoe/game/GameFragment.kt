package com.kaungmaw.tictactoe.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
                viewModel.isUserTurn = true
            }
        }

        viewModel.savedInputsLive.observe(viewLifecycleOwner) {
            Log.i("GameFragment", it.contentDeepToString())
            binding.ivSquare00.setBackgroundResource(
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
            viewModel.setValueOnIndex00(if (viewModel.isUserTurn) 'X' else 'O')
            viewModel.toggleTurns()
            Log.i("GameFragment", viewModel.savedInputs.contentDeepToString())
        }

        binding.square01.setOnClickListener {
            viewModel.setValueOnIndex01(if (viewModel.isUserTurn) 'X' else 'O')
            viewModel.toggleTurns()
            Log.i("GameFragment", viewModel.savedInputs.contentDeepToString())
        }

        binding.square02.setOnClickListener {
            viewModel.setValueOnIndex02(if (viewModel.isUserTurn) 'X' else 'O')
            viewModel.toggleTurns()
            Log.i("GameFragment", viewModel.savedInputs.contentDeepToString())
        }

        binding.square10.setOnClickListener {
            viewModel.setValueOnIndex10(if (viewModel.isUserTurn) 'X' else 'O')
            viewModel.toggleTurns()
            Log.i("GameFragment", viewModel.savedInputs.contentDeepToString())
        }

        binding.square11.setOnClickListener {
            viewModel.setValueOnIndex11(if (viewModel.isUserTurn) 'X' else 'O')
            viewModel.toggleTurns()
            Log.i("GameFragment", viewModel.savedInputs.contentDeepToString())
        }

        binding.square12.setOnClickListener {
            viewModel.setValueOnIndex12(if (viewModel.isUserTurn) 'X' else 'O')
            viewModel.toggleTurns()
            Log.i("GameFragment", viewModel.savedInputs.contentDeepToString())
        }

        binding.square20.setOnClickListener {
            viewModel.setValueOnIndex20(if (viewModel.isUserTurn) 'X' else 'O')
            viewModel.toggleTurns()
            Log.i("GameFragment", viewModel.savedInputs.contentDeepToString())
        }

        binding.square21.setOnClickListener {
            viewModel.setValueOnIndex21(if (viewModel.isUserTurn) 'X' else 'O')
            viewModel.toggleTurns()
            Log.i("GameFragment", viewModel.savedInputs.contentDeepToString())
        }

        binding.square22.setOnClickListener {
            viewModel.setValueOnIndex22(if (viewModel.isUserTurn) 'X' else 'O')
            viewModel.toggleTurns()
            Log.i("GameFragment", viewModel.savedInputs.contentDeepToString())
        }

    }

}