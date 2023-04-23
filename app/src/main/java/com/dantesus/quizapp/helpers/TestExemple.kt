package com.dantesus.quizapp.helpers

import com.dantesus.quizapp.model.Answer
import com.dantesus.quizapp.model.Question
import com.dantesus.quizapp.model.Test


var answer1 = Answer(
    isCorrect = false,
    text = "тара"
)
var answer2 = Answer(
    isCorrect = false,
    text = "дмитрий нагиев"
)
var answer3 = Answer(
    isCorrect = true,
    text = "леон"
)

var question1 = Question(
    text = "какому персонажу радуются в бравл старс",
    answer = listOf(answer1, answer2, answer3)
)
 ////////////////////////////////////////////////

var question2 = Question(
    text = "С чего можно словить гарик?",
    answer =  listOf(
        Answer(
            isCorrect = false,
            text = "со стула"
        ),
        Answer(
            isCorrect = true,
            text = "с чарончика"
        ),
        Answer(
            isCorrect = false,
            text = "с кактуса"
        )
    )
)
////////////////////////////////////////////////

var question3 = Question(
    text = "что ест капибара?",
    answer =  listOf(
        Answer(
            isCorrect = true,
            text = "траву(марихуану)"
        ),
        Answer(
            isCorrect = false,
            text = "гарик"
        ),
        Answer(
            isCorrect = false,
            text = "fljkma"
        )
    )
)

val TestExemple = Test(
    score = 0,
    question = listOf(question1, question2, question3)

)