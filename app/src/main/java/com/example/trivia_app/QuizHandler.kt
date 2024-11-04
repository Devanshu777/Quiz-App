package com.example.trivia_app

object QuizHandler {
    fun getQuestion():ArrayList<Question>{
        return arrayListOf(
            Question(
                "What is the capital of India?",
                "New Delhi",
                "Mumbai",
                "Kolkata",
                "Lucknow",
                "New Delhi"
            ),
            Question(
                "What is the Correct Spelling of number 4?",
                "for",
                "four",
                "fourt",
                "forty",
                "four"
            ),
            Question(
              "What is 2+2?",
                "2",
                "3",
                "4",
                "5",
                "4"
            ),
        )
    }
}