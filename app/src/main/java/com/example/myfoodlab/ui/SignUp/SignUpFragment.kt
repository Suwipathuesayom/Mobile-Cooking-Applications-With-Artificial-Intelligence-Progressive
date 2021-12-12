package com.example.myfoodlab.ui.SignUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myfoodlab.R


class SignUpFragment : Fragment() {

    lateinit var layout_constraint_SignUpWelcome: ConstraintLayout
    lateinit var txtLogin_Welcome: TextView
    lateinit var txtSkip_Welcome: TextView

    override fun onCreateView(


        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)

    }

}