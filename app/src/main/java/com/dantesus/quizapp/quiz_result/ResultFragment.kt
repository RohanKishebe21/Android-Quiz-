package com.dantesus.quizapp.quiz_result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import com.dantesus.quizapp.R
import com.dantesus.quizapp.helpers.dataManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ResultFragment: Fragment() {

    @Inject
    lateinit var storage: dataManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val result_text = view.findViewById<TextView>(R.id.score_text)
        result_text.text = getString(R.string.test_result, storage.test.score)
        val button_restart = view.findViewById<Button>(R.id.button_restart)
        button_restart.setOnClickListener {
            storage.test.score = 0;
            findNavController().popBackStack(R.id.loginFragment, false)
        }

    }
}