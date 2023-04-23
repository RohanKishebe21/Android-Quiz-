package com.dantesus.quizapp.quizFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dantesus.quizapp.R
import com.dantesus.quizapp.helpers.dataManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class QuizFragment: Fragment() {
    @Inject
    lateinit var manager : dataManager
    var answer1: RadioButton?=null
    var answer2: RadioButton?=null
    var answer3: RadioButton?=null
    var questionText:TextView?=null
    var answerGroup: RadioGroup?=null
    var button: Button?=null
    var index: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val welcomeLabel =  view.findViewById<TextView>(R.id.welcome_text)
        welcomeLabel.text = getString(R.string.welcome_user, manager.userName)

         answer1 = view.findViewById(R.id.V1)
         answer2 = view.findViewById(R.id.V2)
         answer3 = view.findViewById(R.id.V3)
         questionText = view.findViewById(R.id.question_text)
         answerGroup = view.findViewById(R.id.radioGroup)
         button = view.findViewById(R.id.answer_button)

         button?. isEnabled = false
         button?.setOnClickListener {
           val question = manager.test.question[index]
           val correctIndex = question.answer.indexOfFirst {
               it.isCorrect == true
           }

           if(correctIndex == 0){
               if(answer1?.isChecked == true){
                   manager.test.score += 10
               }
           }else if (correctIndex == 1){
               if(answer2?.isChecked == true) {
                   manager.test.score += 10
               }
           }else if (correctIndex == 2){
               if(answer3?.isChecked == true) {
                   manager.test.score += 10
               }
           }


            index++
             if(index <= 2 ){
                 displayQuestion()
             }else {
                 findNavController().navigate(R.id.action_quizFragment_to_resultFragment)
             }
             answerGroup?.clearCheck()
         }


         answer1?.setOnClickListener {
             button?.isEnabled = true
         }
         answer2?.setOnClickListener {
             button?.isEnabled = true
         }
         answer3?.setOnClickListener {
             button?.isEnabled = true
         }
         displayQuestion()
    }
    private  fun displayQuestion() {
        val question = manager.test.question[index]
        questionText?.text = question.text
        answer1?.text = question.answer[0].text
        answer2?.text = question.answer[1].text
        answer3?.text = question.answer[2].text
    }
}