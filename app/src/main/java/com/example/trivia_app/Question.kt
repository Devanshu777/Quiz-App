package com.example.trivia_app

data class Question(
    var question: String,
    var optionOne: String,
    var optionTwo: String,
    var optionThree: String,
    var optionFour: String,
    var answer: String
)
