package com.dantesus.quizapp.quizFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dantesus.quizapp.R
import com.dantesus.quizapp.helpers.dataManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class QuizFragment: Fragment() {
    @Inject
    lateinit var manager : dataManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

     fun OnViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val welcomeLabel =  view.findViewById<TextView>(R.id.welcome_text)
        welcomeLabel.text = getString(R.string.welcome_user, manager.userName)
    }
}