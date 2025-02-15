package com.example.trivia_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {
    lateinit var score: TextView
    lateinit var backToMenu : Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        score = view.findViewById(R.id.tvScore)
        backToMenu = view.findViewById(R.id.btnToMenu)

        backToMenu.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_menuFragment)
        }

        score.text =arguments?.getInt("score").toString()
    }
}