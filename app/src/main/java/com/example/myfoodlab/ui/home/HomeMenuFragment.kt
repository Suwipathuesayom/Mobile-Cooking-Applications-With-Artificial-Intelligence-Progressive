package com.example.myfoodlab.ui.home


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentTransaction
import com.example.myfoodlab.CardMenu_Tomyumkung
import com.example.myfoodlab.R
import com.example.myfoodlab.ui.italianfood.ItalianFoodFragment
import com.example.myfoodlab.ui.japan.JapanFoodFragment
import com.example.myfoodlab.ui.koreafood.koreafoodFragment
import com.example.myfoodlab.ui.microwave_food.Microwave_FoodFragment
import com.example.myfoodlab.ui.thaifood.ThaifoodFragment
import com.example.myfoodlab.ui.topfood.TopFoodFragment
import com.example.myfoodlab.ui.topfood_clean.Topfood_CleanFragment
import com.example.myfoodlab.ui.topfood_korea.Topfood_KoreaFragment

class HomeMenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home_menu, container, false)



        // intent card category
        val koearFood = root.findViewById<ImageView>(R.id.imageKorean_Food)
        koearFood.setOnClickListener{
            val koreanFood = koreafoodFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.mainLayout,koreanFood)
            transaction.commit()

        }

        val thaiFood = root.findViewById<ImageView>(R.id.imageThai_Food)
        thaiFood.setOnClickListener{
            val thaifoodFragment = ThaifoodFragment()
            val tran : FragmentTransaction = requireFragmentManager().beginTransaction()
            tran.replace(R.id.mainLayout,thaifoodFragment)
            tran.commit()

        }

        val italianfood = root.findViewById<ImageView>(R.id.imageItalian_Food)
        italianfood.setOnClickListener {
            val italianfood = ItalianFoodFragment()
            val tran: FragmentTransaction = requireFragmentManager().beginTransaction()
            tran.replace(R.id.mainLayout, italianfood)
            tran.commit()

        }

        val japanfood = root.findViewById<ImageView>(R.id.imageJapan_Food)
        japanfood.setOnClickListener {
            val japanfood = JapanFoodFragment()
            val tran: FragmentTransaction = requireFragmentManager().beginTransaction()
            tran.replace(R.id.mainLayout, japanfood)
            tran.commit()

        }

        val topfood = root.findViewById<ImageView>(R.id.imageMenu_food)
        topfood.setOnClickListener {
            val topfood = TopFoodFragment()
            val tran: FragmentTransaction = requireFragmentManager().beginTransaction()
            tran.replace(R.id.mainLayout, topfood)
            tran.commit()

        }

        val topfood_clean = root.findViewById<ImageView>(R.id.imageMenu_Clean)
        topfood_clean.setOnClickListener {
            val topfood_clean = Topfood_CleanFragment()
            val tran: FragmentTransaction = requireFragmentManager().beginTransaction()
            tran.replace(R.id.mainLayout, topfood_clean)
            tran.commit()
        }

        val topfood_korea = root.findViewById<ImageView>(R.id.imageMenu_Korean)
        topfood_korea.setOnClickListener {
            val topfood_korea = Topfood_KoreaFragment()
            val tran: FragmentTransaction = requireFragmentManager().beginTransaction()
            tran.replace(R.id.mainLayout, topfood_korea)
            tran.commit()
        }

        val topfood_microwave = root.findViewById<ImageView>(R.id.imageMenu_microwave)
        topfood_microwave.setOnClickListener {
            val topfood_microwave = Microwave_FoodFragment()
            val tran: FragmentTransaction = requireFragmentManager().beginTransaction()
            tran.replace(R.id.mainLayout, topfood_microwave)
            tran.commit()
        }

        return root
    }
}

