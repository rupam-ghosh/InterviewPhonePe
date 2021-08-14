package com.example.phonepeinterview

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.entity.Logo
import com.example.entity.RoundResult

class GameFragment : Fragment() {

    companion object {
        fun newInstance() = GameFragment()
    }

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.game_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        viewModel.getGameLiveData().observe(viewLifecycleOwner, Observer {
            println(it)
            // use game to draw the UI
        })
    }

    fun stopGame() {
        viewModel.stopGame()
    }

    fun startRound() {
        viewModel.startRound()
    }

    fun stopRound(result: HashMap<Logo, RoundResult>) {
        viewModel.stopRound(result)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.getGameLiveData().removeObservers(viewLifecycleOwner)
    }

}