package com.example.trivia_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the factory method to
 * create an instance of this fragment.
 */
class QuizFragment : Fragment(), OnClickListener {

    private lateinit var count: TextView
    private lateinit var ques: TextView
    private lateinit var opt1: Button
    private lateinit var opt2: Button
    private lateinit var opt3: Button
    private lateinit var opt4: Button

    private lateinit var currentQues: Question
    private var score = 0

    private var currentQuesIndex = 0
    private val listOfQuestions = QuizHandler.getQuestion()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        count = view.findViewById(R.id.tvCount)
        ques = view.findViewById(R.id.tvQues)
        opt1 = view.findViewById(R.id.btnOp1)
        opt2 = view.findViewById(R.id.btnOp2)
        opt3 = view.findViewById(R.id.btnOp3)
        opt4 = view.findViewById(R.id.btnOp4)

        opt1.setOnClickListener(this)
        opt2.setOnClickListener(this)
        opt3.setOnClickListener(this)
        opt4.setOnClickListener(this)

        displayQuestion()

    }

    private fun displayQuestion() {
        if (currentQuesIndex >= listOfQuestions.size) {
            val bundle = Bundle()
            bundle.putInt("score", score)
            findNavController().navigate(R.id.action_quizFragment_to_resultFragment, bundle)
            return
        }
        currentQues = listOfQuestions[currentQuesIndex++]
        count.text = currentQuesIndex.toString()
        ques.text = currentQues.question
        opt1.text = currentQues.optionOne
        opt2.text = currentQues.optionTwo
        opt3.text = currentQues.optionThree
        opt4.text = currentQues.optionFour
    }

    override fun onClick(p0: View?) {
        val selectedQues = when (p0?.id) {
            R.id.btnOp1 -> currentQues.optionOne
            R.id.btnOp2 -> currentQues.optionTwo
            R.id.btnOp3 -> currentQues.optionThree
            else -> currentQues.optionFour
        }
        if (selectedQues == currentQues.answer) {
            score++
        }
        displayQuestion()
    }
}